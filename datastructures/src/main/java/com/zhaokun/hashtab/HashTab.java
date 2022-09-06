package com.zhaokun.hashtab;

import lombok.Data;

@Data
public class HashTab {

    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int empLinkedListNo = hashFun(emp.getNo());
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            if (empLinkedListArray.length == 0 || empLinkedListArray[i] == null) {
                System.out.println("数据为空");
                return;
            }
            empLinkedListArray[i].list(i);
        }
    }


    //根据输入的 id,查找雇员
    public void findEmpById(int id) {
    //使用散列函数确定到哪条链表查找
    int empLinkedListNO = hashFun(id);
    Emp emp = empLinkedListArray[empLinkedListNO].findEmpByNo(id);
    if(emp != null) {//找到
        System.out.printf("在第%d 条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
    }else{
        System.out.println("在哈希表中，没有找到该雇员~");
    }
    }

    private int hashFun(Integer no) {
        return no % size;
    }


}
