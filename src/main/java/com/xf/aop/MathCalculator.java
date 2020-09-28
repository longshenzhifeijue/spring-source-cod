package com.xf.aop;

import org.springframework.stereotype.Component;

/**
 * @author xf
 * @date 2020-09-20 22:39
 * @since 1.0.0
 */
@Component
public class MathCalculator {

    public int div(int i, int j) {
        return i / j;
    }
}
