package com.sxb.algorithm.sort;

/**
 * @desc:
 * @author: poi
 * @date: 2020/3/22 20:41
 * @version: v1.0
 */
public class MergeSort<E extends Comparable<E>> extends Sort<E> {
    private E[] leftArray;

    @Override
    protected void sort() {
        leftArray = (E[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    /**
     * 对 [start end) 范围内进行归并排序
     * @param start
     * @param end
     */
    private void sort(int start, int end){
        if(end - start < 2){
            return;
        }

        int mid = (start + end) >> 1;
        sort(start, mid);
        sort(mid, end);
        merge(start, mid, end);
    }

    /**
     * 将 start mid  mid end 范围合并成最后一个序列
     * @param start
     * @param mid
     * @param end
     */
    private void merge(int start, int mid, int end) {
        int ai = start;
        int li = 0, le = mid - start;// 左侧数组
        int ri = mid, re = end;// 右侧数组

        for (int i = li; i < le; i++) {
            leftArray[i] = array[start + i];
        }

        // 左边数组还未结束
        while(li < le){
            if(ri < re && compare(array[ri], leftArray[li]) < 0){
                array[ai++] = array[ri++];// 拷贝右侧数组到array中
            }else {
                array[ai++] = leftArray[li++];// 拷贝左侧数组到array中
            }
        }
    }
}
