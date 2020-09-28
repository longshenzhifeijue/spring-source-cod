package com.xf.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author xf
 * @date 2020-09-28 15:56
 * @since 1.0.0
 */
@Service
public class UserService {

    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent applicationEvent) {
        System.out.println("UserService...监听到的事件:" + applicationEvent);

    }
}
