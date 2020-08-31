package com.zhou.springboot.leetcode;

public class HeapSortTest {

    //堆排序
    //不稳定
    //o(nlogn)
    public static void heapSort(int[] is) {
        //构建初始堆
        for (int i = is.length / 2 - 1; i >= 0; i--) {
            precDown(is, i, is.length);
        }
        for (int i = is.length - 1; i > 0; i--) {
            swap(is, 0, i);
            precDown(is, 0, i);
        }
    }

    //往下找，找到最大的放到最上面
    public static void precDown(int[] is, int i, int n) {
        int temp = is[i];
        int child;
        for (; leftChild(i) < n; i = child) {
            child = leftChild(i);
            //????child!=n-1
            if (child != n-1 && is[child + 1] > is[child]) {
                child++;
            }
            if (is[child] > temp) {
                is[i] = is[child];
            } else {
                break;
            }
        }
        is[i] = temp;
    }

    public static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] is = new int[]{97, 53, 41, 58, 31, 26, 59};
        heapSort(is);
        System.out.println();
    }


}
