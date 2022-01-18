package com.zhaokun.stack;

public class Calculator {

    public void main(String[] args) {

        String expression = "7*2*2-5+1-5+3-4";
        // 创建两个栈，数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义需要 的相关变量
        // 用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            ch = expression.substring(index, index+1).charAt(0);
            if (operStack.isOper(ch)) {
                // 判断当前的符号是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,
                    // 就需要从数栈中 pop 出两个数,

                    //在从符号栈中 pop 出一个符号，进行运算，将得到结果，
                    // 入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        // 把运算的结果如数栈
                        numStack.push(res);
                        // 然后将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                //如果是数，则直接入数栈
                //numStack.push(ch - 48); //? "1+3" '1' => 1
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向 expression 的表达式的 index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接
                //处理多位数
                keepNum += ch;
                //如果 ch 已经是 expression 的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                //注意是看后一位，不是 index++
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                    //如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
                    numStack.push(Integer.parseInt(keepNum));
                    //重要的!!!!!!, keepNum 清空
                        keepNum = "";
                    }
            }
        }
            //让 index + 1, 并判断是否扫描到 expression 最后.
            index++;
            if (index >= expression.length()) {
                break;
            }



    }

}


class ArrayStack2 {
    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组，数组模拟栈，数据就放在该数组
     */
    private int[] stack;

    /**
     * top 表示栈顶，初始化-1
     */
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 增加一个方法，可以返回当前栈顶的值, 但是不是真正的 pop
     *
     * @return
     */
    public int peek() {
        return stack[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }

        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！");
        }

        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);

        }
    }

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(int val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }

}

}