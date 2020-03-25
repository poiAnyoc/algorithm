package com.sxb.algorithm.datastructure.linear;

import java.util.LinkedList;
import java.util.List;

/**
 * 双端队列
 * @desc:
 * @author: poi
 * @date: 2020/3/25 11:31
 * @version: v1.0
 */
public class Deque<E> {
    private List<E> list = new LinkedList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * 从队尾入队
     * @param element
     */
    public void enQueueRear(E element){
        list.add(element);
    }

    /**
     * 从队头入队
     * @param element
     */
    public void enQueueFront(E element){
        list.add(0, element);
    }

    /**
     * 从队头出队
     */
    public E deQueueFront(){
        return list.remove(0);
    }

    /**
     * 从队尾出队
     */
    public E deQueueRear(){
        return list.remove(list.size() - 1);
    }

    /**
     * 清空
     */
    public void clear(){
        list.clear();
    }

    /**
     * 获取队列的头元素
     * @return
     */
    public E front(){
        return list.get(0);
    }

    /**
     * 获取队列的头元素
     * @return
     */
    public E rear(){
        return list.get(list.size() - 1);
    }
}
