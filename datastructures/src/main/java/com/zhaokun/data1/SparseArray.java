package com.zhaokun.data1;

import java.io.*;
import java.util.Scanner;

public class SparseArray {

    public static void main(String[] args) throws IOException {

        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 1;

        System.out.println("原始的二维数组~");
        for (int[] ints : chessArr1) {
            for (int data : ints) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


        // 将二维数组 转 稀疏数组的思路
        // 1.先遍历二维数组 得到非0的数据的个数
        int sum = 0;

        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }

        System.out.println("sum = " + sum);

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[chessArr1.length-1].length;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
        writeToFile("map.data", sparseArr);

        sparseArr = readFile("map.data");

        // 将稀疏数组 ---》 恢复成 原始的二维数组
        /**
         * 1.先读取稀疏数组的第一行，根据第一行的数据，创建元素的二维数组
         * 2.在读取稀疏数组后几行的数据，并赋给 原始的二维数组即可
         */
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        System.out.println("初始化的数组");
//        print(chessArr2);
        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int i = 1; i < sparseArr.length; i++) {

            int n1 = sparseArr[i][0];
            int n2 = sparseArr[i][1];
            int n3 = sparseArr[i][2];
            chessArr2[n1][n2] = n3;
        }
//        for (int i = 0; i < sparseArr[0][2]; i++) {
//            num++;
//            int n1 = sparseArr[num][0];
//            int n2 = sparseArr[num][1];
//            int n3 = sparseArr[num][2];
//            chessArr2[n1][n2] = n3;
//        }
        print(chessArr2);

        /**
         * 11	11	3
         * 1	2	1
         * 2	3	2
         * 4	5	1
         */

    }

    public static int[][] readFile(String filename) {
        int[][] arr = new int[4][3];

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                for (int i = 0; i < arr.length; i++) {
                    String[] line = scanner.nextLine().split("\t");
                    for (int j = 0; j < line.length; j++) {
                        arr[i][j] = Integer.parseInt(line[j]);
                    }
                }

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return arr;
    }


    public static boolean writeToFile(String filename, int[][] Array){
        try {
            FileWriter fileWriter = new FileWriter(filename);
            for(int arr[]:Array){
                for(int value:arr){
                    fileWriter.write(value + "\t");
                }
                fileWriter.write("\n");

            }
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void print(int sparseArr[][]) {
        for (int[] ints : sparseArr) {
            for (int data : ints) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
