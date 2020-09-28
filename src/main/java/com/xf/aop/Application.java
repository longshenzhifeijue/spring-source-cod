package com.xf.aop;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xf
 * @date 2020-09-22 18:28
 * @since 1.0.0
 */
public class Application {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
    }
}
