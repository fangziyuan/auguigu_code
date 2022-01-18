package com.zhaokun.stack;

import lombok.Data;

public class LinkedStackDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Link link=new Link();
        link.push("第一个");
        link.push("第二个");
        link.push("第三个");
        link.push("第四个");
        System.out.println(link.isEmpty());
        System.out.println(link.size());
        System.out.println(link.pop());
        System.out.println(link.peak());
        System.out.println(link.size());
    }
}

class Link {

    Node head = null;
    public Link() {
        head = new Node();
    }

    public void push(Object data) {
        Node node = new Node(data);
        node.setNext(head.getNext());
        head.setNext(node);
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    public Object pop() {
        Object item = null;
        if (isEmpty()) {
            System.out.println("该栈为空");
        }
        item = head.getNext().getData();
        head.setNext(head.getNext().getNext());
        return item;
    }

    /**
     * 堆栈大小
     * @return
     */
    public int size() {
        int len = 0;
        Node pNode = head;
        while (pNode.getNext() != null) {
            len++;
            pNode = pNode.getNext();

        }
        return len;
    }

    //读取堆栈元素
    public Object peak() {
        Object item=null;
        if(isEmpty()) {
            System.out.println("该栈为空");
            return item;
        }
        item=head.getNext().getData();
        return item;
    }

}


@Data
class Node {
    private Object data;
    private Node next;

    public Node() {
        this.data = null;
        this.next = null;
    }

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }


}