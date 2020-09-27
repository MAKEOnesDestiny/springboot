package com.zhou.springboot.leetcode.sort;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ShellSort {

    /**
     * 时间复杂度O(n1.3)~o(n2) 空间复杂度O(1) 不稳定
     */
    public static void shellSort(int[] a) {
        int j;
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int temp = a[i];
                for (j = i; j >= gap && temp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(Integer.MAX_VALUE);
        ai.incrementAndGet();
        System.out.println();


        int[] a = new int[]{34, 8, 64, 51, 32, 21};
        shellSort(a);
        System.out.println();
//        new ArrayList<>().stream().sorted()
    }

}
