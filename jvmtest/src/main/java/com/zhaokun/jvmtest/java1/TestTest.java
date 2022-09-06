package com.zhaokun.jvmtest.java1;

import java.text.NumberFormat;

/**
 * Java中在数字前自动补零方法
 */
public class TestTest {
    public static void main(String[] args) {
        //方法一
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        System.out.println(String.format("%04d", 10000));

        //方法二
        System.out.println(geFourNumber(10));
    }

    /**
     * 数字前面自动补零
     * @param number 数字
     * @return
     */
    public static String geFourNumber(int number){
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(4);
        formatter.setGroupingUsed(false);
        return formatter.format(number);
    }
}
