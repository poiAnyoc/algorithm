package com.sxb.algorithm.sort;

/**
 * https://www.cnblogs.com/ll409546297/p/10956960.html
 * sort方法是 抽象出来的方法  减少不必要的代码
 * @desc:
 * @author: poi
 * @date: 2020/3/17 0:34
 * @version: v1.0
 */
public class BubbleSort<E extends Comparable<E>> extends Sort<E> {
    public static void main(String[] args) {
        int[] array = new int[]{12, 7, 9, 4, 1, 8, 213, 23};

        testSort2(array);

        print(array);
    }

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 1; i <= end; i++) {
                if(compare(i, i - 1) < 0){
                    swap(i, i - 1);
                }
            }
        }
    }

    private static void testSort1(int[] array){
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 1; i <= end; i++) {
                if(array[i] < array[i - 1]){
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static void testSort2(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // 数组已经是有序
    private static void optimizeSort1(int[] array){
        for (int end = array.length - 1; end > 0; end--) {
            boolean sorted = true;
            for (int i = 1; i <= end; i++) {
                if(array[i] < array[i - 1]){
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;

                    sorted = false;
                }
            }

            if(sorted){
                break;
            }
        }
    }

    // 数组尾部局部是有序
    private static void optimizeSort2(int[] array){
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int i = 1; i <= end; i++) {
                if(array[i] < array[i - 1]){
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;

                    sortedIndex = i;
                }
            }

            end = sortedIndex;
        }
    }

    private static void print(int[] array){
        for (int i = 0, len = array.length; i < len; i++) {
            System.out.print(array[i] + "，");
        }
    }
}
