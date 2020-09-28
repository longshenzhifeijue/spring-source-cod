package com.xf.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author xf
 * @date 2020-09-20 22:42
 * @since 1.0.0
 */
public class IOCTest_AOP {

    public static void main(String[] args) {

            AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
            MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
            int div = mathCalculator.div(10, 2);
            applicationContext.close();

    }


}
