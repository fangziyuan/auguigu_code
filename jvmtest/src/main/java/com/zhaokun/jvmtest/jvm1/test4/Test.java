package com.zhaokun.jvmtest.jvm1.test4;

public class Test {

    static {
        int i = 0;
        System.out.println(i);
    }

    static int i = 1;


    public static void main(String[] args) {
        Test test = new Test();
    }
}
