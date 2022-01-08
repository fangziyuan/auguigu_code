package com.zhaokun.jvmtest.jvm1.test1;

public class ConstClass {

    static {
        System.out.println("constClass init!");
    }

    public static final String HELLOWORLD = "hello world";


}

