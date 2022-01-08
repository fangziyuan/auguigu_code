package com.zhaokun.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat...constructor...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat..destroy...");
    }
}
