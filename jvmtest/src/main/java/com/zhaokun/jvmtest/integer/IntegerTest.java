package com.zhaokun.jvmtest.integer;

public class IntegerTest {


    public static void main(String[] args) {

        Integer a = 127;
        Integer b = 127;
        System.out.println("127 == 127 = " + (a == b));

        Integer c = 128;
        Integer d = 128;
        System.out.println("128 == 128 = "+ (c == d));

        Integer e = 1000;
        Integer f = 1000;
        System.out.println("1000 == 1000 = " + (e == f));

        Integer g = 1001;
        Integer h = 1001;
        System.out.println("1001 == 1001 = " + (g == h));

        Integer i = 20000;
        Integer j = 20000;
        System.out.println("20000 == 20000 = " + (i == j));

    }

}
