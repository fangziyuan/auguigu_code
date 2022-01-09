package com.zhaokun.linkedlist;

/**
 * 分析 双向链表的遍历，添加，修改，删除的操作思路===》代码实现
 * 1)  遍历 方和 单链表一样，只是可以向前，也可以向后查找
 * 2)  添加 (默认添加到双向链表的最后)
     * (1) 先找到双向链表的最后这个节点
     * (2) temp.next = newHeroNode
     * (3) newHeroNode.pre = temp;
 * 3)  修改 思路和 原来的单向链表一样.
 * 4)  删除
     * (1) 因为是双向链表，因此，我们可以实现自我删除某个节点
     * (2) 直接找到要删除的这个节点，比如 temp
     * (3) temp.pre.next = temp.next
     * (4) temp.next.pre = temp.pre;
 */

/**
 * @author zhaok
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试~");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add2(hero1);
        doubleLinkedList.add2(hero3);
        doubleLinkedList.add2(hero2);
        doubleLinkedList.add2(hero4);
        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();
        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();

    }

}



class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 2)  添加 (默认添加到双向链表的最后)
     *      * (1) 先找到双向链表的最后这个节点
     *      * (2) temp.next = newHeroNode
     *      * (3) newHeroNode.pre = temp;
     * @param newHeroNode
     */
    public void add(HeroNode2 newHeroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = newHeroNode;
        newHeroNode.pre = temp;
    }


    public void update(HeroNode2 newHeroNode) {
        HeroNode2 temp = head;
        if (temp.next == null) {
            System.out.println("队列为空~");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("修改的编号 %d 不存在", newHeroNode.no);
        }

    }

    /**
     * 从双向链表中删除一个节点,
     * 说明
     * 1 对于双向链表，我们可以直接找到要删除的这个节点
     * 2 找到后，自我删除即可
     * @param no
     */
    public void del(int no) {
        HeroNode2 temp = head;
        if (temp.next == null) {
            System.out.println("链表为空~");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    /**
     * 双向链表的第二种添加方式,
     * 按照编号顺序 [示意图]按照 单链表的顺序添加，稍作修改即可.
     */
    public void add2(HeroNode2 newHeroNode) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > newHeroNode.no) {
                break;
            } else if (temp.next.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("待插入的英雄编号 %d 已经有了，不能重复插入\n", newHeroNode.no);
        } else {

            newHeroNode.next = temp.next;
            temp.next = newHeroNode;
            newHeroNode.pre = temp;
            // temp.pre.next = temp.next;
            //            if (temp.next != null) {
            //                temp.next.pre = temp.pre;
            //            }
        }

    }



}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 pre;
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}