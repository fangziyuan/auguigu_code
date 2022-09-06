package com.zhaokun.search;

/**
 * 二分查找
 *
 * @author zhaok
 */
public class SeqSearch {

    public static void main(String[] args) {

        int[] arr = { 1, 9, 11, -1, 34, 89 };
        int i = seqSearch(arr, 90);
        if (i == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("下标为 " + i);
        }

    }


    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


}
