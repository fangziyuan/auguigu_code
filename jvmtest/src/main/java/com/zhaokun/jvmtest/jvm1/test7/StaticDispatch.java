package com.zhaokun.jvmtest.jvm1.test7;

public class StaticDispatch {

    static abstract class Human{

    }
    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human human) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man human) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman human) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);


    }
}
