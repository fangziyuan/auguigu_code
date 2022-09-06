package com.zhaokun.jvmtest.thread;

/**
 * @author zhaok
 * @Date 2022/3/5 10:45
 */
public class ThreadTest extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("run");
    }

    public static void main(String[] args) {
//        ThreadTest threadTest = new ThreadTest();
////        threadTest.start();
//        threadTest.run();
//        System.out.print("main");
        // main run
        // run main
        // main
        // run
        int i = 5;
        int j = 10;
        System.out.println(j);
        System.out.println(i + ~j);

    }

}