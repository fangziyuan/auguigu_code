package com.zhaokun.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 *
 * @author zhaok
 */
public class BinarySearch {

    public static void main(String[] args) {

//        int[] arr = { 1, 8, 10, 89,1000,1000, 1234 };
//        int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
//        System.out.println("resIndex=" + resIndex);

        int[] arr = { 1, 8, 10, 89, 1000, 1000, 1000, 1234 };
        List<Integer> resIndex = binarySearch2(arr, 0, arr.length - 1, 1001);
        System.out.println("resIndex=" + resIndex);

    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal< midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal< midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid-1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;
            }

            temp = mid + 1;
            while(true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            resIndexList.add(mid);
            return resIndexList;
        }
    }

}
