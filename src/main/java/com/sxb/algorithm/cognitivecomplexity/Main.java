package com.sxb.algorithm.cognitivecomplexity;

import com.sxb.algorithm.util.TimeTool;

/**
 * 经典算法：斐波那契数
 * @desc:
 * @author: poi
 * @date: 2020/3/12 0:27
 * @version: v1.0
 */
public class Main {
    /**
     * 0 1 2 3 4 5 6 7
     * 0 1 1 2 3 5 8 13...
     * @param n
     * @return
     */
    static int fib(int n){
        if(n <= 1){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibNew(int n){
        if(n <= 1){
            return n;
        }

        int first = 0;
        int second = first;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    static int fibNew1(int n){
        if(n <= 1){
            return n;
        }

        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            second += first;
            first = second - first;
        }
        return second;
    }

    public static void main(String[] args) {
        TimeTool.check("fibNew", new TimeTool.Task(){
            public void execute() {
                System.out.println(fibNew(100));
            }
        });
    }

    public static void test1(int n){
        // 1
        if(n > 10){
            System.out.println("n > 10");
        }else if(n > 5){
            System.out.println("n > 5");
        }else {
            System.out.println("n <= 5");
        }

        // 1 + 4 + 4 + 4
        for (int i = 0; i < 5; i++) {
            System.out.println(".....");
        }
        // 14
        // O(1)
    }

    public static void test2(int n){
        if(n > 10){
            System.out.println("n > 10");
        }else if(n > 5){
            System.out.println("n > 5");
        }else {
            System.out.println("n <= 5");
        }

        // 1 + n + n + n
        for (int i = 0; i < n; i++) {
            System.out.println(".....");
        }
        // 1 + 3n
        //O(n)
    }

    public static void test3(int n){
        // 1 + n + n + n * (1 + 3n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("......");
            }
        }
        // 1 + 3n + 3n^2
        // O(n^2)
    }

    public static void test4(int n){
        // 1 + n + n + n * (1 + 45)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.println("......");
            }
        }
        // 1 + 48n
        //O(n)
    }

    public static void test5(int n){
        // n = 8    第一次4   第二次2   第三次1
        // n = 8 = 2^3
        // n = 16 = 2^4
        // 3 = log2(8)
        // 4 = log2(16)
        while ((n = n / 2) > 0){
            System.out.println("......");
        }
        // 执行次数 = log2(n)
        // O(logn)
    }

    public static void test6(int n){
        while ((n = n / 5) > 0){
            System.out.println("......");
        }
        // 执行次数 = log5(n)
        // O(logn)
    }

    public static void test7(int n){
        // 1 + n + 1
        //i += i     i = i * 2
        // n = 1 * 2 * 2 * 2
        // log2(n)
        for (int i = 1; i < n; i += i) {
            // 1 + 3n
            for (int j = 0; j < n; j++) {
                System.out.println("......");
            }
        }
        // 1 + 2*log2(n) + log2(n) * (1 + 3n)
        // 1 + 3*log2(n) + 2 * nlog2(n)

        // O(logn + nlogn)
        // O(nlogn)
    }

    public static void test8(int n, int k){
        // O(n + k)
        for (int i = 0; i < n; i++) {
            System.out.println(".....");
        }
        for (int i = 0; i < k; i++) {
            System.out.println(".....");
        }
    }

    public static void test10(int n){
        // O(n)
        int a = 10;
        int b = 20;
        int c = a + b;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + c);
        }
    }
}
