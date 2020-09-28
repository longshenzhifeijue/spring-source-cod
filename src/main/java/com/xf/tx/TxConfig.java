package com.xf.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author xf
 * @date 2020-09-24 17:42
 * @since 1.0.0
 *
 *
 *  声明式事物:
 *      环境搭建：
 *      1、导入相关依赖
 *              数据源、数据库驱动、spring-jdbc
 *      2、配置数据源、JdbcTemplate(工具操作数据)
 *      3、给方法配置Transactional
 *      4、开启事物@EnableTransactionManagement
 *      5、配置事物管理器控制事物(加在容器)
 *
 *  原理:
 *
 *  1) @EnableTransactionManagement注解会引用TransactionManagementConfigurationSelector组件,向容器导入
 *          导入两个组件:
 *              AutoProxyRegistrar注册bean
 *              ProxyTransactionManagementConfiguration
 *  2)AutoProxyRegistrar :
 *      给容器中注册一个InfrastructureAdvisorAutoProxyCreator组件
 *      InfrastructureAdvisorAutoProxyCreator:?
 *      利用后置处理器机制在对象创建以后,包装对象,返回一个代理对象(增强器) 代理对象执行方法利用拦截器链进行调用
 *
 *
 *      AnnotationAwareAspectJAutoProxyCreator组件(基本的增强器,自动代理创建组件,AOP的时候就是一个后置处理器)
 *
 *  3)ProxyTransactionManagementConfiguration做了什么 :
 *      1、给容器中注册增强器
 *          1)、事务增强器要用事务注解的信息,AnnotationTransactionAttributeSource
 *          2)、事务拦截器
 *              TransactionInterceptor保存事务属性信息,事务管理器;
 *              他是一个MethodInterceptor
 *              在目标方法执行的时候，
 *                  执行拦截器链
 *                  事务拦截器
 *                      1)、先获取事务相关属性
 *                      2)、再获取PlatformTransactionManager,如果事先没有指定任何TransactionManager,最终会从容器中获取一个PlatformTransactionManager
 *                      3)、执行目标方法
 *                          如果异常,利用事务管理器回滚操作 txInfo.getTransactionManager().rollback(txInfo.getTransactionStatus());
 *                          如果正常,利用事务管理器提交事务 txInfo.getTransactionManager().commit(txInfo.getTransactionStatus());
 *
 *
 *
 *
 *
 *
 *
 *
 */
@EnableTransactionManagement
@Configuration
@ComponentScan("com.xf.tx")
public class TxConfig {

    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource=new ComboPooledDataSource() ;

        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;

    }


    @Bean
    public PlatformTransactionManager platformTransactionManager()throws Exception{
       return new DataSourceTransactionManager(dataSource());
    }


}
