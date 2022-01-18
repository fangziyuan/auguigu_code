package com.zhaokun.stack;

import lombok.Data;

import java.util.Scanner;

/**
 * @author zhaok
 */
public class ArrayStackDemo {

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();

            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }

        System.out.println("程序退出~~~");
    }

}


@Data
class ArrayStack {

    private int top = -1;
    private int[] stack;
    private int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {
        return stack.length == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空~");
        }
        int value = stack[top];
        top--;
        return value;
    }

}