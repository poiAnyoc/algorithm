package com.sxb.algorithm.sort;

import com.sxb.algorithm.util.ArrayKit;

import java.util.Arrays;

/**
 * 测试排序类
 * @desc:
 * @author: poi
 * @date: 2020/3/21 0:00
 * @version: v1.0
 */
public class T {
    public static void main(String[] args) {
        Integer[] array = ArrayKit.randomArray(10000, 199);
//		new BubbleSort().sort(array);

        // 指定泛型 Integer
        testSort(array,
                new BubbleSort(),
                new SelectionSort(),
                new HeapSort(),
                new InsertionSort()
        );
    }

    static void testSort(Integer[] array, Sort... sorts){
        for (Sort sort : sorts) {
            Integer[] copyArray = new Integer[array.length];
            System.arraycopy(array, 0, copyArray, 0, array.length);
            sort.sort(copyArray);
        }

        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}
