package com.sxb.algorithm.sort;

/**
 * 快速排序
 * @desc:
 * @author: poi
 * @date: 2020/3/22 23:20
 * @version: v1.0
 */
public class QuickSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    /**
     * 对 start, end 范围的元素进行快速排序
     * @param start
     * @param end
     */
    private void sort(int start, int end){
        if(end - start < 2){
            return;
        }

        // 确定轴点的位置
        int mid = pivotIndex(start, end);
        // 对子数组进行快速排序
        sort(start, mid);
        sort(mid + 1, end);
    }

    /**
     * 寻找数组中的轴点元素
     * @param start
     * @param end
     * @return 轴点元素的放置位置
     */
    private int pivotIndex(int start, int end){
        swap(start, (int) (start + Math.random() * (end - start)));


        // 备份start位置的轴点元素
        E pivot = array[start];
        // end指向最后一个元素
        end--;
        while(start < end){
            while(start < end){
                // 右边元素 > 轴点元素
                if(compare(pivot, array[end]) < 0){
                    end--;
                }else {
                    array[start++] = array[end];
                }
            }

            while(start < end){
                // 左边元素 < 轴点元素
                if(compare(pivot, array[start]) > 0){
                    start++;
                }else {
                    array[end--] = array[start];
                }
            }
        }
        // 将轴点元素放入最终的位置
        array[start] = pivot;
        return start;
    }
}
