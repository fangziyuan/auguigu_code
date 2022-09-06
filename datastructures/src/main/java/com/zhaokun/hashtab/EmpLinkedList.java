package com.zhaokun.hashtab;

public class EmpLinkedList {

    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.getNext() == null) {
                break;
            }
            curEmp = curEmp.getNext();
        }
        curEmp.setNext(emp);
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第 " +(no +1)+" 链表为空");
            return;
        }
        System.out.println("第 "+(no +1)+" 链表信息为");
        Emp curEmp = head;
        while (true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.getNo(), curEmp.getName());
            if (curEmp.getNext() == null) {
                break;
            }
            curEmp = curEmp.getNext();
        }
        System.out.println();
    }

    public Emp findEmpByNo(int no) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.getNo() == no) {
                curEmp = head;
                break;
            }
            if (curEmp.getNext() == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.getNext();
        }
        return curEmp;
    }




}
