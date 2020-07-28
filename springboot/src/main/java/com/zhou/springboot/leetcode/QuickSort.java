package com.zhou.springboot.leetcode;

public class QuickSort {

    //快速排序
    //时间复杂度 O(nlogn)~O(n)
    void quicksort(Integer[] a, int left, int right) {
        if ((right - left) > 3) {
            Integer pivot = median3(a, left, right);
            int i = left;
            int j = right - 1;
            while (true) {
                while (a[++i] < pivot) {
                }
                while (a[--j] > pivot) {
                }
                if (i < j) swap(a, i, j);
                else break;
            }
            swap(a, i, right - 1);
            quicksort(a, left, i - 1);
            quicksort(a, i + 1, right);
        } else {
            //do insert sorting
            insertSort(a, left, right);
        }

    }

    private int median3(Integer[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[left].compareTo(a[center]) > 0) {
            swap(a, left, center);
        }
        if (a[left].compareTo(a[right]) > 0) {
            swap(a, left, right);
        }
        if (a[center].compareTo(a[right]) > 0) {
            swap(a, center, right);
        }
        swap(a, center, right - 1);
        return a[right - 1];
    }

    private void swap(Integer[] list, int low, int high) {
        Integer temp = list[low];
        try {
            list[low] = list[high];
        } catch (Exception e) {
            System.out.println();
        }
        list[high] = temp;
    }

    private void insertSort(Integer[] a, int left, int right) {
        for (int i = left + 1; i < right + 1; i++) {
            int p = i;
            int temp = a[p];
            int j;
            for (j = p; j > 0 && temp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{50, 10, 90, 30, 70, 40, 80, 60, 20};
        new QuickSort().quicksort(a, 0, 8);
//        new QuickSort().insertSort(a,0,1);
        System.out.println();
    }

}
