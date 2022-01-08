package com.zhaokun.jvmtest.jvm1.test2;

public class NotInitialization {


    /**
     * 上述代码运行之后，也没有输出“ConstClass init!”，
     * 这是因为虽然在Java源码中引用了ConstClass类中的常量HELLOWORLD，
     * 但其实在编译阶段通过常量传播优化，已经将此常量的值“hello world”
     * 存储到了NotInitialization类的常量池中，以后NotInitialization
     * 对常量ConstClass.HELLOWORLD的引用实际都被转化为NotInitialization
     * 类对自身常量池的引用了。也就是说，实际上NotInitialization的Class
     * 文件之中并没有ConstClass类的符号引用入口，这两个类在编译成Class之后
     * 就不存在任何联系了。
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(ConstClass.HELLO_WORLD);

    }

}
