package com.zhou.springboot.leetcode;

public class InsertSort {

    /**
     * 时间复杂度平均 O(n2) 时间复杂度最差 O(n2) 稳定 空间复杂度 O(1) 当数组基本上已经排序时较好
     */
    //asc sort
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    //更好的办法
    public static void insertSort2(int[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (j = i; j > 0 && a[j - 1] > temp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{34, 8, 64, 51, 32, 21};
        insertSort2(a);
        System.out.println();
    }

}
