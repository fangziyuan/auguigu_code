package com.zhaokun.test;

import java.util.HashMap;
import java.util.Map;

public class PriceUtil {

    public static Map<String, Integer> PRICE_MAP = new HashMap<>();

    public static int comparePrice(String num1, String num2) {
        float num1f = Float.parseFloat(num1);
        float num2f = Float.parseFloat(num2);
        num1 = String.format("%.1f", num1f);
        num2 = String.format("%.1f", num2f);
        num1 = num1.substring(0,num1.indexOf(".")+2);
        num2 = num2.substring(0,num2.indexOf(".")+2);
        return getAreaNum(num1) - getAreaNum(num2);
    }

    /**
     * 0.1 = 1
     * 0.5 = 2
     * 0.9 = 2
     * 1.0 = 3
     * 1.5 = 4
     * 1.9 = 4
     * 2.0 = 5
     * @param num1
     * @return
     */
    public static int getAreaNum(String num1) {
        String num2 = num1.substring(0,num1.indexOf("."));
        String num3 = "0" + num1.substring(num1.indexOf("."));
        int value = 0;
        int n1 = Integer.parseInt(num2) * 2;
        int n2 = Float.compare(Float.parseFloat(num3), 0.5f) >= 0 ? 2 : 1;
        value = n1 + n2;
        return value;
    }

    public static String getMagnification(Integer num) {
        if (num == 1) {
            return "1.2";
        } else if (num == 2) {
            return "1.8";
        } else if (num >= 3) {
            return "2.2";
        }

        return "1";
    }

    // 2.5 2.9
    public static String oper(String num1, String num2) {
        return num1.compareTo(num2) > 0 ? "*" : "/";
    }

}
