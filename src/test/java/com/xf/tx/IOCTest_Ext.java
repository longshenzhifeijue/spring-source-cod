package com.xf.tx;

import com.xf.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xf
 * @date 2020-09-27 16:14
 * @since 1.0.0
 */
public class IOCTest_Ext {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);

        // 发布的事件
        context.publishEvent(new ApplicationEvent("我发布的事件:") {
            @Override
            public String toString() {
                return super.toString();
            }
        });
        context.close();
    }
}
