package com.zhaokun.linkedlist;

public class Josepfu {

    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(10,20,125);

    }


}


class CircleSingleLinkedList {

    /**
     * 创建一个first节点，当前没有编号
     */
    private Boy first = null;

    /**
     * 添加一个小孩节点，构成一个环形的链表
     */
    public void addBoy(int nums) {
        // 数据校验
        if (nums < 1) {
            System.out.println("nums 的值不正确");
            return;
        }
        Boy curBoy = null;

        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                // 构成环
                first.setNext(first) ;
                // 让curBoy 指向第一个小孩
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }

        Boy curBody = first;

        while (true) {
            System.out.printf("小孩 的编号 %d\n", curBody.getNo());
            if (curBody.getNext() == first) {
                break;
            }
            // curBoy后移
            curBody = curBody.getNext();
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n", first.getNo());
    }


}

/**
 * 创建一个boy类，表示一个节点
 */
class Boy {

    /**
     * 编号
     */
    private int no;
    /**
     * 指向下一个节点，默认为null
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
