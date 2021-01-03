package com.zhou.springboot.leetcode.sort;

/**
 * 归并排序
 * 平均时间复杂度O(nlogn)
 * 最差时间复杂度O(nlogn)
 * 稳定的排序
 * 需要线性附加内存
 */
@SuppressWarnings("all")
public class MergeSort {

    public void sort(int[] a, int left, int right) {
        int mid = (left + right) / 2;  //left<=mid<right
        if (left < right) {
            //递归sort，出来的数组是有序的
            sort(a, left, mid);
            sort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
        //do nothing if left = right
    }

    //在这个方法里面,mid是在左边区间的
    public void merge(int[] a, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }
        //复制回去
        for (int l = 0; l < k; l++) {
            a[l + left] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{50, 10, 90, 30, 70, 40, 80, 60, 20};
        new MergeSort().sort(a, 0, a.length - 1);
        System.out.println();
    }

}
