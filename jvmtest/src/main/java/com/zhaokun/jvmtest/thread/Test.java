package com.zhaokun.jvmtest.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    private static int j = 0;

    private static Boolean methodB(int k) {
        j += k;
        return true;
    }

    public static void methodA(int i) {
        boolean b;
        b = i < 10 | methodB(4);
        b = i < 10 || methodB(8);

    }

    public static void main(String args[]) {
//        Map map = new ConcurrentHashMap();
//        System.out.println(map.put("1", 1));
//        System.out.println(map.put("1", 2));
//
//        String a = "a";
//        String b = "a";
//        a.compareTo(b)

        methodA(0);
        System.out.println(j);
        // 12
        // 4
        // 8
        // 0
    }
}