package com.xf.ext;

import com.xf.entity.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xf
 * @date 2020-09-27 16:04
 * @since 1.0.0
 * <p>
 *
 *
 * 扩展原理:
 * BeanPostProcessor: bean后置处理器,bean创建对象初始化前后进行拦截工作的
 *
 * 1、BeanFactoryPostProcessor: beanFactory的后置处理器
 *      在BeanFactory标准初始化之后调用,来定制和修改BeanFactory的内容
 *      所有的bean定义已经保存加载到beanFactory,但是bean的实例还未创建
 *
 *
 * BeanFactoryPostProcessor原理
 * 1)、ioc容器创建对象
 * 2)、invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessor
 *      如何找到所有BeanFactoryPostProcessors并执行他们的方法
 *              1)、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件,并执行他们的方法
 *              2)、在初始化创建日他组件前面执行
 *
 *
 *
 *
 *
 */
@ComponentScan("com.xf.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Blue blue() {
        return new Blue();
    }

}
