package com.zhaokun.jvmtest.jvm1.test9;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void increace() {
        atomicInteger.incrementAndGet();
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increace();

                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(atomicInteger);

    }


}
