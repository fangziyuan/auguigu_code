package com.zhaokun.jvmtest.jvm1.test10;

public class StringExer1 {

    public static void main(String[] args) {

        String x = "ab";
        String s = new String("a") + new String("b");
        String s2 = s.intern();

        System.out.println(s2 == x);
        System.out.println(s == x);

    }

}
