package com.sxb.algorithm.sort;

/**
 * 二分查找
 * @desc:
 * @author: poi
 * @date: 2020/3/21 22:41
 * @version: v1.0
 */
public class BinarySearch {

    /**
     * 存在多个值 不确定返回哪个
     * 查找value 在有序数组中为位置
     * @param array
     * @param value
     * @return
     */
    public static int indexOf(int[] array, int value){
        if(array.length == 0){
            return -1;
        }

        int begin = 0;
        int end = array.length;
        while(begin < end){
            int mid = (begin + end) >> 1;
            if(value < array[mid]){
                end = mid;
            }else if(value > array[mid]){
                begin = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找value在有序数组中待插入的位置
     * @param array
     * @param value
     * @return
     */
    public static int search(int[] array, int value){
        if(array.length == 0){
            return -1;
        }

        int begin = 0;
        int end = array.length;
        while(begin < end){
            int mid = (begin + end) >> 1;
            if(value < array[mid]){
                end = mid;
            }else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
