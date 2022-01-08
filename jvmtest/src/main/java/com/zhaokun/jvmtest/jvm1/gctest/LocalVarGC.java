package com.zhaokun.jvmtest.jvm1.gctest;


public class LocalVarGC {

    private static final Integer VALUE = 10 * 1024 * 1024;

    public void localvarGC1() {
        byte[] bytes = new byte[VALUE];
        System.gc();
    }

    public void localvarGC2() {
        byte[] bytes = new byte[VALUE];
        bytes = null;
        System.gc();
    }

    public void localvarGC3() {
        {
            byte[] bytes = new byte[VALUE];
        }
        System.gc();
    }

    public void localvarGC4() {
        {
            byte[] bytes = new byte[VALUE];
        }
        int value = 10;
        System.gc();
    }

    public void localvarGC5(){
        localvarGC1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalVarGC localVarGC = new LocalVarGC();
        localVarGC.localvarGC4();
    }

}
