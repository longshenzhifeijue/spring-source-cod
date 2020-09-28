package com.xf.tx;

import com.xf.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xf
 * @date 2020-09-27 16:14
 * @since 1.0.0
 */
public class IOCExt {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ExtConfig.class);
        context.close();
    }
}
