package com.zhaokun.jvmtest.jvm1.gcroots;

public class CanReliveObj {

    public static CanReliveObj canReliveObj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类重写的finalize() 方法");
        canReliveObj = this;

    }

    public static void main(String[] args) {

        try {

            canReliveObj = new CanReliveObj();
            // 对象第一次成功解救了自己
            canReliveObj = null;
            System.gc();
            System.out.println("第1次 gc");
            Thread.sleep(2000);
            if (canReliveObj == null) {
                System.out.println("canReliveObj is dead");
            } else {
                System.out.println("canReliveObj is still alive");
            }
            System.out.println("第2次 gc");
            canReliveObj = null;
            System.gc();
            Thread.sleep(2000);
            if (canReliveObj == null) {
                System.out.println("canReliveObj is dead");
            } else {
                System.out.println("canReliveObj is still alive");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
