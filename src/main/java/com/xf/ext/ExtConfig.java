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
 * 2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *      void postProcessBeanDefinitionRegistry();
 *      在所有bean信息将要被被加载,bean实例还未创建的
 *
 *      优先于BeanFactoryPostProcess执行
 *      利用BeanDefinitionRegistryPostProcessor给容器中再添加一些组件
 *          postProcessBeanDefinitionRegistry():第一种or第二种
 *
 *  原理:
 *       1)、IOC容器创建对象
 *       2)、refresh()->invokeBeanFactoryPostProcessors(beanFactory)
 *       3)、从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件,
 *              1、依次触发所有的postProcessBeanDefinitionRegistry()方法,就优先执行了
 *              2、再来触发postProcessBeanFactory()方法,在BeanFactoryPostProcessor
 *       4)、再来从容器中找到BeanFactoryPostProcessors组件,然后依次触发
 *
 *
 * 3、ApplicationListener:监听容器中发布的事件,事件驱动模型开发
 *      public interface ApplicationListener<E extends ApplicationEvent>
 *          监听ApplicationEvent及其下面自事件
 *
 *  步骤：
 *      1)、写一个监听器来监听某个事件(ApplicationEvent及其下面自事件)
 *
 *          @EnventListener注解方式
 *          原理:使用EventListenerMethodProcessor处理器解析@EnventListener注解
 *
 *
 *      2)、把监听器加到容器
 *      3)、只要容器中有事件发生的发布,我们就能监听到这个事件
 *              ContextRefreshedEvent:容器创建完成(所有bean都完全创 建,会发布这个事件);
 *              ContextClosedEvent:关闭容器会发布这个事件
 *      4)、发布事件:
 *                      context.publishEvent(new ApplicationEvent("我发布的事件:")
 *
 *  原理:
 *      ContextRefreshedEvent、com.xf.tx.IOCTest_Ext$1[source=我发布的事件:]、ContextClosedEvent
 *
 *  1、ContextRefreshedEvent事件
 *      1)、容器创建对象:refresh()
 *      2)、finishRefresh();容器刷新完成会发布ContextRefreshedEvent事件
 *  2、自己发布事件
 *  3、容器关闭会发布ContextClosedEvent事件
 *
 *
 *   【事件发布流程:】
 *      3)、publishEvent(new ContextRefreshedEvent(this));
 *                  1)获取事件的多播器(派发器):getApplicationEventMulticaster()
 *                  2)multicastEvent派发事件
 *                  3)获取所有的ApplicationListener
 *                  	for (ApplicationListener<?> listener : getApplicationListeners(event, type)) {
 *                  	1)如果有Executor,可以支持使用Executor执行异步派发
 *                  	  Executor executor = getTaskExecutor();
 *                  	2)否则,同步的方式直接执行listener方法,invokeListener(listener, event);
 *                     	  拿到listen回调 onApplicationEvent方法		listener.onApplicationEvent(event);
 *
 *    【事件多播器(派发器):】
 *          1)、容器创建对象:refresh();
 *          2)、initApplicationEventMulticaster();初始化ApplicationEventMulticaster;
 *              1)、先去容器中找有没有id="applicationEventMulticaster"的组件;
 *              2)、如果没有自己new一个	this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *                  并且加入到容器中 ,我们就可以在其他组件要派发事件,自动注入这个applicationEventMulticaster
 *
 *    【容器中有哪些监听器:】
 *          1)、容器创建对象:refresh();
 *          2)、registerListeners();
 *              从容器中拿到所有监听器,把他们注册到applicationEventMulticaster中;
 *              把监听器添加到派发器派发出去
 *              String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *              // 将listen注册到ApplicationEventMulticaster
 *              getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *
 *    【SmartInitializingSingleton原理:】->afterSingletonsInstantiated();
 *          1)、IOC容器创建对象并刷新容器
 *          2)、finishBeanFactoryInitialization(beanFactory);初始化剩下的单实例bean
 *              1)、先创建所有的单实例bean,getBean();方法创建
 *              2)、获取所有的单实例bean,判断是不是SmartInitializingSingleton类型,
 *                  如果是调用	smartSingleton.afterSingletonsInstantiated();
 *
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
