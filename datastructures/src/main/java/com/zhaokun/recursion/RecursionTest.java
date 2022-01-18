package com.zhaokun.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        test(4);
    }

    public static void test(int n) {
        if (n > 2) {
            test(n-1);
        }

        System.out.println(n);
    }






    // 2
    public static void test2(int n) {
        if (n > 2) {
            test2(n -1);
        } else {
            System.out.println(n);
        }
    }

}
