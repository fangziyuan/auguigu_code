package com.zhaokun.jvmtest.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhaok
 * @Date 2022/3/18 14:26
 */
public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        annotationConfigApplicationContext.publishEvent(new MyApplicationEvent("xxx"));
        annotationConfigApplicationContext.close();

    }

}