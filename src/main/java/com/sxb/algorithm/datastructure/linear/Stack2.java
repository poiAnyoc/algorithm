package com.sxb.algorithm.datastructure.linear;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: poi
 * @date: 2020/3/24 23:31
 * @version: v1.0
 */
public class Stack2<E> {
    private List<E> list = new ArrayList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * 清空栈
     */
    public void clear(){
        list.clear();
    }

    /**
     * 进栈
     * @param element
     */
    public void push(E element){
        list.add(element);
    }

    /**
     * 出栈
     * @return
     */
    public E pop(){
        return list.remove(size() - 1);
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public E top(){
        return list.get(size() - 1);
    }
}
