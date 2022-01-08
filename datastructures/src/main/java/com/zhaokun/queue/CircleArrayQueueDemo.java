package com.zhaokun.queue;


public class CircleArrayQueueDemo {

    public static void main(String[] args) {



    }

}

class CircleArray {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear+1) % maxSize == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            throw new RuntimeException("队列已满，不能加入数据");
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，不能取出数据");
            throw new RuntimeException("队列为空，不能取出数据");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public int showHead() {
        if (isEmpty()) {
            System.out.println("队列为空，不能取出数据");
            throw new RuntimeException("队列为空，不能取出数据");
        }
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
        }

        for (int i = front; i < getRealCount(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    public int getRealCount() {
        return (rear+maxSize-front) % maxSize;
    }

}