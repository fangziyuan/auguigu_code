package com.zhaokun.jvmtest.jvm2;

import org.junit.Test;

public class MinorGCTest2 {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3;
        // 什么时间进入老年代决定与XX:MaxTenuringThreshold设置
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];

    }


}
