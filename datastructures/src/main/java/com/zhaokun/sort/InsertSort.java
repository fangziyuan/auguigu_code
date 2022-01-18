package com.zhaokun.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 * @author zhaok
 */
public class InsertSort {

    /**
     * 插入式排序属于内部排序法，
     * 是对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的。
     */

    public static void main(String[] args) {

//        int[] arr = {101, 34, 119, 1, -1, 89};

        // 第一遍
        // 34 101 119 1 -1 89

        // 第二遍
        // 34 101 119 1 -1 89

        // 第三遍
        // 1 34 101 119 -1 89

        // 第四遍
        // -1 1 34 101 119 89

        // 第四遍
        // -1 1 34 89 101 119

        int max = 80000;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * max);
        }

        System.out.println("排序前");

        Date data1 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //调用插入排序算法
        insertSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {

            insertVal = arr[i];
            insertIndex = i -1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex +1] = insertVal;
            }

//            insertVal = arr[i];
//            insertIndex = i -1;
//            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//                arr[insertIndex + 1] = arr[insertIndex];
//                insertIndex--;
//            }
//            if (insertIndex + 1 != i) {
//                arr[insertIndex + 1] = insertVal;
//            }
        }
    }

}
