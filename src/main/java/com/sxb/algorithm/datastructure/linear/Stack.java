package com.sxb.algorithm.datastructure.linear;

import java.util.ArrayList;

/**
 * 栈 直接继承不建议  不纠结LinkedList还是arrayList
 * @desc:
 * @author: poi
 * @date: 2020/3/24 23:23
 * @version: v1.0
 */
public class Stack<E> extends ArrayList<E> {

    /**
     * 进栈
     * @param element
     */
    public void push(E element){
        add(element);
    }

    /**
     * 出栈
     * @return
     */
    public E pop(){
        return remove(size() - 1);
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public E top(){
        return get(size() - 1);
    }
}
