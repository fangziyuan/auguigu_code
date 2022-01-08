package com.zhaokun.jvmtest.jvm1.test10;

public class StringExer2 {

    public static void main(String[] args) {

        String s1 = new String("ab");
        s1.intern();
        String s2 = "ab";
        System.out.println(s1 == s2);

    }

}
