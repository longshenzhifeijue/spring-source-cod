package com.xf.aop;

import org.aspectj.lang.annotation.*;

/**
 * @author xf
 * @date 2020-09-20 22:40
 * @since 1.0.0
 */
@Aspect
public class LogAspects {


    @Pointcut("execution(public int com.luxury.MathCalculator.*(..))")
    public void  pointCut(){

    }

    @Before("pointCut()")
    public void logStart() {
        System.out.println("除法运行。。。。参数是{}");
    }


    @After("com.luxury.LogAspects.pointCut()")
    public void logEnd() {
        System.out.println("除法结束");
    }


    @AfterReturning("pointCut()")
    public void logReturn() {
        System.out.println("除法正常运行。。。。结果是{}");
    }


    @AfterThrowing("pointCut()")
    public void logException() {
        System.out.println("除法异常。。。。异常信息是{}");
    }
}
