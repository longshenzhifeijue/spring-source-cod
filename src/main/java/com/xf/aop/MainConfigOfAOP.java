package com.xf.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xf
 * @date 2020-09-20 22:37
 * @since 1.0.0
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {



    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }


    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
