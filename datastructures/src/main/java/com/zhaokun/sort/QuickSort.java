package com.zhaokun.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 快速排序
 * @author zhaok
 */
public class QuickSort {

    public static void main(String[] args) {

//        int[] arr = {9, 10, 1, 20, 99, 4};
//        quickSort(arr, 0 ,arr.length - 1);
//        System.out.println(Arrays.toString(arr));

        int max = 8;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        Date data1 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

//        shellSort(arr);
        quickSort(arr, 0 , arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }


    public static void quickSort(int[] arr, int left, int right) {

        // 左下标
        int l = left;
        // 右下标
        int r = right;
        // 中轴数
        int pivot = arr[(left + right) / 2 ];
        // 临时变量，作为交换时使用
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果 l >= r 说明 pivot 的左右两的值，已经按照左边全部是
            //小于等于 pivot 值，右边全部是大于等于 pivot 值
            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r -= 1;
            }

            if (arr[r] == pivot) {
                l += 1;
            }

        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }


    }


}
