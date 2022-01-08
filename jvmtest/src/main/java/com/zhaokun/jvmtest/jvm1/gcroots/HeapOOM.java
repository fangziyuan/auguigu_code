package com.zhaokun.jvmtest.jvm1.gcroots;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    byte[] buffer = new byte[1 * 1024 * 1024];

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();

        int count = 0;
        try {
            while (true) {
                Thread.sleep(1000);
                list.add(new HeapOOM());
                count++;
            }
        } catch (Throwable e) {
            System.out.println("count = " + count);
            e.printStackTrace();
        }


    }

}
