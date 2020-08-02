package com.zhou.springboot.leetcode;

import com.zhou.springboot.leetcode.Leetcode7.Solution;

public class HeapSort {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static void heapSort(Integer[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) { // 从a.length/2开始，因为这些节点都是有子节点的节点
            precDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            precDown(a, 0, i);
        }
    }

    private static void precDown(Integer[] a, int i, int n) {
        int child;
        Integer temp;
        for (temp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) //
                child++;
            if (temp.compareTo(a[child]) < 0)
                a[i] = a[child];
            else
                break;
        }
        a[i] = temp;
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static void swap(Integer[] a, int i, int j) {
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
//        Integer[] is = new Integer[]{1, 2, 3, 4, 5};
        Integer[] is = new Integer[]{97, 53, 41, 58, 31, 26, 59};
//        Integer[] is = new Integer[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        heapSort(is);
        System.out.println();
    }

}
