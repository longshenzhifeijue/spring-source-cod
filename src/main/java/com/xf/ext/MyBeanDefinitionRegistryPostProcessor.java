package com.xf.ext;

import com.xf.entity.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @author xf
 * @date 2020-09-28 10:33
 * @since 1.0.0
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {


    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor....bean的数量:" + configurableListableBeanFactory.getBeanDefinitionCount());

    }



    // BeanDefinitionRegistry Bean定义信息的保存中心,以后BeanFactory就是安装BeanDefinitionRegistry里面保存的每一个bean信息创建bean实例的
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        System.out.println("postProcessBeanDefinitionRegistry....bean的数量:" + beanDefinitionRegistry.getBeanDefinitionCount());

        // 第一种
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Blue.class);
        beanDefinitionRegistry.registerBeanDefinition("hello", rootBeanDefinition);

        // 第二种
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Blue.class);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("world", beanDefinition);


    }


}
