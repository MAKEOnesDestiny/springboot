package com.zhou.springboot.leetcode.sort;

import java.util.Random;

public class QuickSort2 {

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int partition(int[] a, int start, int end) {
        int index = new Random().nextInt(end - start + 1) + start;
        swap(a, index, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (a[i] < a[end]) {
                small++;
                swap(a, small, i);
            }
        }
        small++;
        swap(a, small, end);
        return small;
    }

    public void quicksort(int[] a, int start, int end) {
        int q = partition(a, start, end);
        if (q > start) {
            quicksort(a, start, q - 1);
        }
        if (q < end) {
            quicksort(a, q + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{50, 10, 90, 30, 70, 40, 80, 60, 20};
        new QuickSort2().quicksort(a, 0, a.length - 1);
        System.out.println();
    }


}
