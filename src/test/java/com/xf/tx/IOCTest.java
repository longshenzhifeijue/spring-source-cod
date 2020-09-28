package com.xf.tx;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author xf
 * @date 2020-09-26 17:32
 * @since 1.0.0
 */
public class IOCTest {


    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.insertUser();
        context.close();
    }

    @Test
    public void  test02(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(TxConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName名称+:"+beanDefinitionName);
        }
    }
}
