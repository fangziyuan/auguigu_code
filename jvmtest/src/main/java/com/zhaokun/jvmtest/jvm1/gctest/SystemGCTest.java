package com.zhaokun.jvmtest.jvm1.gctest;

public class SystemGCTest {

    public static void main(String[] args) {

        new SystemGCTest();
        System.gc();

        System.runFinalization();


    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("ιεδΊ finalize()");
    }
}
