package com.zhaokun.sort;

import cn.hutool.core.date.DateUtil;

import java.util.Arrays;

/**
 * @author zhaok
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * 时间复杂度O(n^2)
     * @param args
     */
    public static void main(String[] args) {
//        int max = 80000;
        int max = 8;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        String now = DateUtil.now();
        System.out.println(now);
        bubbleSort(arr);
        now = DateUtil.now();
        System.out.println(now);
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr) {
        int temp;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

    }

}
