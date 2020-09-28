package com.xf.entity;

import org.springframework.context.annotation.Bean;

/**
 * @author xf
 * @date 2020-09-27 16:18
 * @since 1.0.0
 */
public class Blue {

    public Blue() {
        System.out.println("blue....constructor");
    }

    public void init() {
        System.out.println("blue...init");
    }

    public void detory() {
        System.out.println("blue...detory...");
    }
}
