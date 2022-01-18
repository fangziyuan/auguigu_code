package com.zhaokun.sort;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

/**
 * 选择排序
 * @author zhaok
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {1, -1, 20, 15, 89, 9};

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        System.out.println(Arrays.toString(arr));

    }


}
