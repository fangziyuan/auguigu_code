package com.zhaokun.exec.linkedlist;

import org.springframework.util.StringUtils;

public class SingleLinkedList {



}


class SingleLinked {

    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void update(HeroNode heroNode) {
        if (heroNode.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next.no.equals(heroNode.no)) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            if (StringUtils.hasLength(heroNode.name)) {
                temp.name = heroNode.name;
            }
            if (StringUtils.hasLength(heroNode.nickName)) {
                temp.nickName = head.nickName;
            }
        } else{
            System.out.printf("没有找到 %d 编号", heroNode.no);
        }
    }

    public void del(int no) {

        if (head.next == null) {
            System.out.println("链表为空~");
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 1, 3, 5, 0
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 的编号不存在", no);
        }

    }

    public void reverse(HeroNode heroNode) {
        if (heroNode.next == null || heroNode.next.next == null) {
            return;
        }

        HeroNode curNode = heroNode.next;
        HeroNode next = null;
        HeroNode reverseNode = new HeroNode(0 ,"", "");
        while (curNode != null) {
            next = curNode.next;
            curNode.next = reverseNode.next;
            reverseNode.next = curNode;
            curNode = next;
        }
        head.next = reverseNode.next;
    }



}

class HeroNode {

    public Integer no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode() {
    }

    public HeroNode(Integer no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

}