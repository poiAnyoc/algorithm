package com.sxb.algorithm.sort;

/**
 * 堆排序
 * @desc:
 * @author: poi
 * @date: 2020/3/19 22:42
 * @version: v1.0
 */
public class HeapSort extends Sort {
    private int heapSize;

    @Override
    protected void sort() {
        // 原地建堆
        heapSize = array.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }

        while (heapSize > 1){
            // swap堆顶元素和尾部元素
            swap(0, --heapSize);

            // 对0号位置siftDown操作
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        Integer element = array[index];

        int half = heapSize >> 1;
        // index必须是非叶子结点
        while(index < half){
            // 默认是左边和父节点比较
            int childIndex = (index << 1) + 1;
            Integer child = array[childIndex];

            int rightIndex = childIndex + 1;
            // 右子节点比左子节点大
            if(rightIndex < heapSize && compareElements(array[rightIndex], child) > 0){
                child = array[childIndex = rightIndex];
            }

            // 大于等于子节点
            if(compareElements(element, child) >= 0){
                break;
            }
            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }
}
