package com.sxb.algorithm.datastructure.linear;

/**
 * @desc:
 * @author: poi
 * @date: 2020/3/24 23:28
 * @version: v1.0
 */
public class T {
    public static void main(String[] args) {
        // 循环双端队列
        testCirCleDeque();
        // 双端队列
        testCircleQueue();
        // 双端队列
        testDeQue();
        // 队列
        testQueue();
        // 栈
        testStack();
    }

    static void testCirCleDeque(){
        System.out.println("- - - - - - - - - CircleDeque start - - - - - - - -");
        CircleDeque<Integer> queue = new CircleDeque<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }
        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }

        queue.enQueueFront(11);
        queue.enQueueFront(12);
        System.out.println(queue);
        while (!queue.isEmpty()){
            System.out.println(queue.deQueueFront());
        }
        System.out.println("- - - - - - - - - CircleDeque end - - - - - - - - -");
    }

    static void testCircleQueue(){
        System.out.println("- - - - - - - - - CircleQueue start - - - - - - - -");
        CircleQueue<Integer> queue = new CircleQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        for (int i = 0; i < 5; i++) {
            queue.deQueue();
        }
        for (int i = 15; i < 20; i++) {
            queue.enQueue(i);
        }

        System.out.println(queue);
        while (!queue.isEmpty()){
            System.out.println(queue.deQueue());
        }
        System.out.println("- - - - - - - - - CircleQueue end - - - - - - - - -");
    }

    static void testDeQue(){
        System.out.println("- - - - - - - - - deque start - - - - - - - -");
        Deque<Integer> queue = new Deque<>();
        queue.enQueueFront(1);
        queue.enQueueFront(2);
        queue.enQueueRear(3);
        queue.enQueueRear(4);

        while (!queue.isEmpty()){
            System.out.println(queue.deQueueRear());
        }
        System.out.println("- - - - - - - - - deque end - - - - - - - - -");
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
