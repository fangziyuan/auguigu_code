package com.zhaokun.linkedlist;

public class SingleLinkedListDemo {

    /**
     * 链表是以节点的方式存储，链式存储
     * 每个节点包含data域，next域：指向下一个节点
     * 如图：发现链表的各个节点不一定是连续存储的
     * 链表分带头节点的链表和没有头节点的链表，根据实际的需求来确定
     * <p>
     * 1）、添加 创建
     * 1、先创建一个
     */

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        System.out.println("修改前的信息~");
        singleLinkedList.list();
//        System.out.println("修改后的信息~");
//        HeroNode newHeroNode = new HeroNode(2,"小卢", "玉麒麟~~");
//        singleLinkedList.update(newHeroNode);
//        singleLinkedList.list();
//
//        singleLinkedList.del(1);
//        System.out.println("删除后的信息");
//        singleLinkedList.list();
//        singleLinkedList.del(4);
//
//        System.out.println("删除后的信息");
//        singleLinkedList.list();
//        System.out.printf("有效的节点个数%d", getLength(singleLinkedList.getHead()));
//
//        HeroNode lastNode = findLastNode(singleLinkedList.getHead(), 1);
//        System.out.println(lastNode);

        reverseShow(singleLinkedList.getHead());
        System.out.println("反转后的列表");
        singleLinkedList.list();
    }

    // 方法：获取到单链表的节点的个数（如果是带头节点的链表，需要不统计头节点）
    /**
     * 返回单链表的有效节点个数 -- 新浪的面试题
     * @param head 链表的头节点
     * @return 返回的是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    // 查找单链表中的倒数第K个节点【新浪面试题】
    // 思路
    // 1. 编写一个方法，接收head节点，同时接收一个index
    // 2. index 表示是倒数第index 个节点
    // 3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    // 4. 得到size后，我们从链表的第一个开始遍历（size-index）个，就可以得到
    public static HeroNode findLastNode(HeroNode heroNode, int index) {
        // 判断如果链表为空，返回null
        if (heroNode.next == null) {
            return null;
        }
        int size = getLength(heroNode);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = heroNode.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    public static void reverseShow(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        /**
         * 思路
         * 1. 先定义一个节点 reverseHead = new HeroNode();
         * 2. 从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
         * 3. 原来的链表的head.next = reverseHead.next
         */
        // 定义个辅助的指针（变量），帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"", "");
        while (cur != null) {
            // 先暂时保存当前节点的下一个节点，因为后面需要使用
            next = cur.next;
            // 将cur 的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            // 将cur 连接到新的链表上
            reverseHead.next = cur;
            // 让cur 后移
            cur = next;
        }
        // 将head的next 指向reverseHead.next,实现单链表的反转
        head.next = reverseHead.next;
    }

}

// 定义SingleLinkedList
class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }
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

    // 修改节点的信息，根据no编号来修改，即no编号不能改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        // 找到需要修改的节点，根据no编号
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
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
            System.out.printf("没有找到 编号 %d 的信息", newHeroNode.no);
        }

    }

    public void del(int no) {
        // 找到需要修改的节点，根据no编号
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 的编号不存在", no);
        }

    }

    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点 不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            // 将temp后移
            temp = temp.next;
        }
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true; // 编号存在
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的这个英雄的编号 %d 已经存在，不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

}


class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; //指向下一个node

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }


}