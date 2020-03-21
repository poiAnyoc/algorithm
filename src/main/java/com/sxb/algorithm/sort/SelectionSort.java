package com.sxb.algorithm.sort;

import com.sxb.algorithm.util.DataChecker;

/**
 * 选择排序
 * @desc:
 * @author: poi
 * @date: 2020/3/19 21:57
 * @version: v1.0
 */
public class SelectionSort<E extends Comparable<E>> extends Sort<E> {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{12, 7, 9, 4, 1, 8, 213, 23};

        testSort(array);
        DataChecker.checkArray(array);
    }

    @Override
    protected void sort() {
        for (int i = array.length - 1 ; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if(compare(maxIndex, j) < 0){
                    maxIndex = j;
                }
            }

            swap(maxIndex, i);
        }
    }

    private static void testSort(Integer[] array) {
        for (int i = array.length - 1 ; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if(array[maxIndex] < array[j]){
                    maxIndex = j;
                }
            }

            int temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }
}
