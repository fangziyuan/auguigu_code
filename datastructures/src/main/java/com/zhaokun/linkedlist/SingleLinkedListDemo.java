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
        System.out.println("修改后的信息~");
        HeroNode newHeroNode = new HeroNode(2,"小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.list();

        singleLinkedList.del(1);
        System.out.println("删除后的信息");
        singleLinkedList.list();
        singleLinkedList.del(5);
        singleLinkedList.del(2);
        singleLinkedList.del(3);
        singleLinkedList.del(4);

        System.out.println("删除后的信息");
        singleLinkedList.list();
    }


}

// 定义SingleLinkedList
class SingleLinkedList {
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