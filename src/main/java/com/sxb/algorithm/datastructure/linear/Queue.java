package com.sxb.algorithm.datastructure.linear;

import java.util.LinkedList;
import java.util.List;

/**
 * 队列
 * @desc:
 * @author: poi
 * @date: 2020/3/25 10:31
 * @version: v1.0
 */
public class Queue<E> {
    private List<E> list = new LinkedList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * 清空
     */
    public void clear(){
        list.clear();
    }

    /**
     * 入队
     * @param element
     */
    public void enQueue(E element){
        list.add(element);
    }

    /**
     * 出队
     * @return
     */
    public E deQueue(){
        return list.remove(0);
    }

    /**
     * 获取队列的头元素
     * @return
     */
    public E front(){
        return list.get(0);
    }
}
