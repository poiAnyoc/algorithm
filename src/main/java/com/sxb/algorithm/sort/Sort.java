package com.sxb.algorithm.sort;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 排序基类
 * @desc:
 * @author: poi
 * @date: 2020/3/19 23:00
 * @version: v1.0
 */
public abstract class Sort implements Comparable<Sort> {
    protected Integer[] array;
    private int compareCount;
    private int swapCount;
    private long time;
    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(Integer[] array){
        this.array = array;

        long begin = System.currentTimeMillis();
        sort();
        long end = System.currentTimeMillis();
        time = end - begin;
    }

    public int compareTo(Sort o){
        int r = (int) (time - o.time);
        if(r != 0){
            return r;
        }

        r = compareCount - o.compareCount;
        if(r != 0){
            return r;
        }
        return swapCount - o.swapCount;
    }

    protected abstract void sort();

    /**
     * 等于0  a[i] = a[j]
     * 小于0  a[i] < a[j]
     * 大于0  a[i] > a[j]
     * @param i
     * @param j
     * @return
     */
    protected int compare(int i, int j){
        compareCount++;
        return array[i] - array[j];
    }

    protected int compareElements(Integer v1, Integer v2){
        compareCount++;
        return v1 - v2;
    }

    protected void swap(int i, int j){
        swapCount++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private String numberString(int number){
        if(number < 10000){
            return "" + number;
        }

        if(number < 100000000){
            return fmt.format(number / 10000.0) + "万";
        }
        return fmt.format(number / 100000000.0) + "亿";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("【" + getClass().getSimpleName() + "】" + "\n");
        if(array.length < 100){
            sb.append("数组=").append(Arrays.toString(array) + "\n");
        }
        sb.append("比较次数=").append(compareCount + "  ");
        sb.append("交换次数=").append(swapCount + "   ");
        sb.append("耗时=").append((time / 1000) + "s(" + time + "ms)" + "\n");
        sb.append("- - - - - - - - - - - - - - - - - - ");
        return sb.toString();
    }
}
