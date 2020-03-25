package com.sxb.algorithm.datastructure.linear;

import java.util.Arrays;

/**
 * 循环双端队列
 * @desc:
 * @author: poi
 * @date: 2020/3/25 15:23
 * @version: v1.0
 */
public class CircleDeque<E> {
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 从队尾入队
     * @param element
     */
    public void enQueueRear(E element){
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    /**
     * 从队头入队
     * @param element
     */
    public void enQueueFront(E element){
        ensureCapacity(size + 1);

        front =  index(-1);
        elements[front] = element;
        size++;
    }

    /**
     * 从队头出队
     */
    public E deQueueFront(){
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    /**
     * 从队尾出队
     */
    public E deQueueRear(){
        int rearIndex = index(size - 1);
        E element = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return element;
    }

    /**
     * 清空
     */
    public void clear(){

    }

    /**
     * 获取队列的头元素
     * @return
     */
    public E front(){
        return elements[front];
    }

    /**
     * 获取队列的头元素
     * @return
     */
    public E rear(){
        return elements[index(size - 1)];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CircleDeque{");
        sb.append("front=").append(front);
        sb.append(", size=").append(size);
        sb.append(", capacity=").append(elements.length);
        sb.append(", elements=").append(Arrays.toString(elements));
        sb.append('}');
        return sb.toString();
    }

    private int index(int index){
        index += front;
        if(index < 0){
            return index + elements.length;
        }
        return index - (index >= elements.length ? elements.length : 0);
    }

    /**
     * 保证容量
     * ios 一般为1.6
     * java 一般为1.5
     * @param capacity
     */
    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if(oldCapacity >= capacity){
            return;
        }
        // 右移相当于1.5  / 2  新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        System.out.println(oldCapacity +"扩容为：" + newCapacity);
        front = 0;
    }
}
