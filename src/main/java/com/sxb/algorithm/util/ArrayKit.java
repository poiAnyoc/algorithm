package com.sxb.algorithm.util;

import java.util.Random;

/**
 * nextInt(10);
 * 数据的范围：[0,10) 包括0,不包括10
 * @desc:
 * @author: poi
 * @date: 2020/3/20 0:42
 * @version: v1.0
 */
public class ArrayKit {
    /**
     * 生成随机数组
     * @return
     */
    public static Integer[] randomArray(int arrayLength, int end){
        Integer[] array = new Integer[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(end);
        }

        return array;
    }

    /**
     * 复制数组元素
     * @param array
     * @return
     */
    public static Integer[] arrayCopy(Integer[] array){
        Integer[] copyArray = new Integer[array.length];
        System.arraycopy(array, 0, copyArray, 0, array.length);
        return copyArray;
    }

    /**
     * 是否是升序数组
     * @param array
     * @return
     */
    public static boolean isOrderAscArray(Integer[] array){
        return false;
    }
}
