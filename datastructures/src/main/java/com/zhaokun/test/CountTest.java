package com.zhaokun.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

public class CountTest {

    static List<PriceMagnificationDTO> priceMagnificationMap = new ArrayList<>();
    // 倍率
    static Stack<String> magnificationStack = new Stack<>();
    // 价格
    static Stack<String> priceStack = new Stack<>();
    public static void main(String[] args) throws IOException {

        String afterPrice = "";
        String magnificationValue = "1";
        boolean loop = true;
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        while (loop) {
            System.out.println("1 添加价格计算倍率");
            System.out.println("2 显示价格计算倍率");
            System.out.println("3 退出");
            System.out.println("请输入操作编号：\n");
            String type = scanner.readLine();
            switch (type) {
                case "1":
                    System.out.println("请输入调价后的价格:\n");
                    afterPrice = scanner.readLine();
                    countPriceByAfter(afterPrice, magnificationValue);
                    break;
                case "2":
                    printPrice(priceMagnificationMap);
                    break;
                case "3":
                    scanner.close();
                    loop = false;
                    System.out.println("再见！");
                    break;
                default:
                    break;

            }
        }
    }

    private static void countPriceByAfter(String afterPrice, String magnificationValue) {
        if (!priceMagnificationMap.isEmpty()) {
            String magnificationPeek = magnificationStack.peek();
            String curPrice = priceStack.peek();
            int comparePrice = PriceUtil.comparePrice(curPrice, afterPrice);
            int abs = Math.abs(comparePrice);
            if (abs == 0) {
                priceMagnificationMap.add(new PriceMagnificationDTO(afterPrice, magnificationValue));
                priceStack.push(afterPrice);
                magnificationStack.push(magnificationValue);
            } else {
                String oper = PriceUtil.oper(curPrice, afterPrice);
                System.out.println(oper);
                magnificationValue = getMagnificationValue(magnificationPeek, oper, abs);
                priceMagnificationMap.add(new PriceMagnificationDTO(afterPrice, magnificationValue));
                priceStack.push(afterPrice);
                magnificationStack.push(magnificationValue);
            }
        } else {
            priceMagnificationMap.add(new PriceMagnificationDTO(afterPrice, magnificationValue));
            priceStack.push(afterPrice);
            magnificationStack.push(magnificationValue);
        }
        System.out.println("添加价格成功");
    }

    public static void printPrice(List<PriceMagnificationDTO> list) {
        if (list.isEmpty()) {
            System.out.println("数据为空！");
            return;
        }
        System.out.println("价格 \t\t,倍率 \t ");
        for (PriceMagnificationDTO dto : list) {
            String s = dto.getAfterPrice();
            String value = dto.getMagnificationValue();
            System.out.printf("%s\t\t,%s\t\t \n", s, value);
        }
    }
    public static String getMagnificationValue(String magnificationPeek, String oper, int abs) {
        String magnification = PriceUtil.getMagnification(abs);
        String res = "";
        BigDecimal bigDecimal1 = new BigDecimal(magnificationPeek);
        BigDecimal bigDecimal2 = new BigDecimal(magnification);
        if ("*".equals(oper)) {
            res = bigDecimal1.multiply(bigDecimal2).toString();
        } else if ("/".equals(oper)) {
            res = bigDecimal1.divide(bigDecimal2, 7, BigDecimal.ROUND_HALF_UP).toString();
        }
        return String.valueOf(res);
    }

}
