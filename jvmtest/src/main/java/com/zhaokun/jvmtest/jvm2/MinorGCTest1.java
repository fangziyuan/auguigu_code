package com.zhaokun.jvmtest.jvm2;

public class MinorGCTest1 {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        /**
         * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
         * -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
         */
        byte[] allocation;
        allocation = new byte[4 * _1MB]; // 直接分配到老年代

    }

}
