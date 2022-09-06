package com.zhaokun.jvmtest.java1;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaok
 * @Date 2022/5/20 09:35
 */
public class CollectionsTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("7");
        list.add("4");
        list.add("8");
        list.add("3");
        list.add("9");

        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        System.out.println("=========================");
        System.out.println(Collections.binarySearch(list, "8"));
// 测试结果：[3, 4, 7, 8, 9]



    }

    @Test
    public void test_binarySearch() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");

        int idx = Collections.binarySearch(list, "5");
        System.out.println("二分查找：" + idx);

        Collections.shuffle(list);
        System.out.println(list);

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
    }

    @Test
    public void testIntern() {
        String str_1 = new String("ab");
        String str_2 = new String("ab");
        String str_3 = "ab";

        System.out.println(str_1 == str_2);
        System.out.println(str_1 == str_2.intern());
        System.out.println(str_1.intern() == str_2.intern());
        System.out.println(str_1 == str_3);
        System.out.println(str_1.intern() == str_3);

    }


}