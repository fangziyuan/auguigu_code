package com.zhaokun.queue;

public class Queue8 {

    /**
     * 定义一个max表示共有多少个皇后
     */
    int max = 8;

    /**
     * 定义数组array ，保存皇后放置位置的结果，比如 arr = {0, 4, 7, 5, 2, 6, 1, 3};
     */
    int[] array = new int[max];

    /**
     *  多少种解法
     */
    static int count = 0;

    /**
     * 冲突多少次
     */
    static int judgeCount = 0;

    public static void main(String[] args) {

        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d 次", judgeCount);

    }

    private void check(int n) {
        if (n == max) {
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i;
            /**
             * 不冲突
             */
            if (judge(n)) {
                check(n+1);
            }
            // 如果冲突，就继续执行array[n] = i ,即将第n 个皇后，放置在本行得 后移一个位置
        }
    }

    /**
     * 查看当我们放置第n个皇后，就去检查该皇后是否和前面已经摆放的皇后冲突
     * @param n 表示第几个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 打印皇后摆放的位置
     */
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
