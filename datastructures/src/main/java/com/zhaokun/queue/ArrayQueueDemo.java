package com.zhaokun.queue;

public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(4);
    }


}
class ArrayQueue {
    // 表示数组的最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 该数据用于存放数据，模拟队列
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.front = -1;
        // 指向队列头部，分析出front是指向队列头的前一个位置
        this.rear = -1;
        // 指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return this.rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        this.rear++;
        arr[this.rear] = n;
    }

    public int getQueue() {
        // 判断是否空
        if (isEmpty()) {
            System.out.println("队列空，不能获取数据");
            throw new RuntimeException("队列空，不能获取数据");
        }

        // front 后移
        this.front++;
        return arr[this.front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
        }

        for (int i : arr) {
            System.out.printf("arr[%d]=%d\n", i);
        }
    }

    // 显示队列的头数据，注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[this.front + 1];
    }

    // 问题分析并优化
    // 1.目前数组使用一次就不能用，没有达到复用的效果
    // 2.将这个数组使用算法，改进成一个环形的队列 取模 %

}
