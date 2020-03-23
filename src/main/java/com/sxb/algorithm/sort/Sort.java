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
public abstract class Sort<E extends Comparable<E>> implements Comparable<Sort<E>> {
    protected E[] array;
    private int compareCount;
    private int swapCount;
    private long time;
    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(E[] array){
        this.array = array;

        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    public int compareTo(Sort<E> o){
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
        return array[i].compareTo(array[j]);
    }

    protected int compare(E v1, E v2){
        compareCount++;
        return v1.compareTo(v2);
    }

    protected void swap(int i, int j){
        swapCount++;
        E temp = array[i];
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
        String stableStr = "稳定性：" + isStable() + "\t";
        String compareCountStr = "比较次数：" + numberString(compareCount) + "\t";
        String swapCountStr = "交换次数：" + numberString(swapCount) + "\t";
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)" + "\t";

        final StringBuilder sb = new StringBuilder();
        sb.append("【" + getClass().getSimpleName() + "】" + "\n");
//        if(array.length < 100){
//            sb.append("数组=").append(Arrays.toString(array) + "\n");
//        }
        sb.append(stableStr);
        sb.append(timeStr);
        sb.append(compareCountStr);
        sb.append(swapCountStr);
        sb.append("\n- - - - - - - - - - - - - - - - - - ");
        return sb.toString();
    }

    private boolean isStable(){
        User[] users = new User[20];
        for (int i = 0; i < users.length; i++) {
            users[i] = new User(i * 10, 10, "张三");
        }

        sort((E[]) users);
        for (int i = 1; i < users.length; i++) {
            int score = users[i].getScore();
            int preScore = users[i - 1].getScore();
            if(score != preScore + 10){
                return false;
            }
        }
        return true;
    }
}
