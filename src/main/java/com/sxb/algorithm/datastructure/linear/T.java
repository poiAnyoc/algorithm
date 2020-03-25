package com.sxb.algorithm.datastructure.linear;

/**
 * @desc:
 * @author: poi
 * @date: 2020/3/24 23:28
 * @version: v1.0
 */
public class T {
    public static void main(String[] args) {
        // 测试栈
        testStack();
        // 测试队列
        testQueue();

    }

    static void testQueue(){
        System.out.println("- - - - - - - - - queue start - - - - - - - -");
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        while (!queue.isEmpty()){
            System.out.println(queue.deQueue());
        }
        System.out.println("- - - - - - - - - queue end - - - - - - - - -");
    }

    /**
     * 测试栈
     */
    static void testStack(){
        System.out.println("- - - - - - - - - stack start - - - - - - - -");
        Stack<Integer> stack = new Stack<>();
        Stack2<Integer> stack2 = new Stack2<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println("- - - - - - - - - stack end - - - - - - - - -");
    }
}
