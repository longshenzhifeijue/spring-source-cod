package com.xf.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xf
 * @date 2020-09-28 11:07
 * @since 1.0.0
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    // 当容器中发布此事件之后,方法触发

    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件:" + event);
    }
}
