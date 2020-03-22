package com.sxb.algorithm.sort;

/**
 * 插入排序
 * @desc:
 * @author: poi
 * @date: 2020/3/21 21:36
 * @version: v1.0
 */
public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int start = 1; start < array.length; start++) {
            int current = start;
            while (current > 0 && compare(current, current - 1) < 0) {
                swap(current, current - 1);
                current--;
            }
        }
//        optimizeSort1(array);
//        optimizeSort2(array);
    }

    /**
     * 优化插入排序
     * @param array
     */
    private void optimizeSort1(E[] array){
        for (int start = 1; start < array.length; start++) {
            int current = start;
            E currentValue = array[current];
            while (current > 0 && compare(currentValue, array[current - 1]) < 0) {
                array[current] = array[current - 1];
                current--;
            }
            array[current] = currentValue;
        }
    }

    /**
     * 二分查找来优化插入排序
     * @param array
     */
    private void optimizeSort2(E[] array){
        for (int start = 1; start < array.length; start++) {
            E value = array[start];
            int insertIndex = search(start);
            // 挪动数组元素 [insertIndex, begin)
            for (int i = start; i > insertIndex ; i--) {
                array[i] = array[i - 1];
            }
            array[insertIndex] = value;
        }
    }

    /**
     * 已经排好序的数组 区间是[0, index)
     * @param index
     * @return
     */
    private int search(int index){
        int begin = 0;
        int end = index;
        while(begin < end){
            int mid = (begin + end) >> 1;
            if(compare(array[index], array[mid]) < 0){
                end = mid;
            }else {
                begin = mid + 1;
            }
        }

        return begin;
    }
}
