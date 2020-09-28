package com.xf.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author xf
 * @date 2020-09-27 16:09
 * @since 1.0.0
 */
@Component
public class MyBeanFactoryPostProcess implements BeanFactoryPostProcessor {


    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcess...postProcessor");
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("当前beanFactory中有:"+beanDefinitionCount+"个bean");
        System.out.println("当前beanFactory中有:"+ Arrays.asList(beanDefinitionNames) +"个bean");
    }
}
