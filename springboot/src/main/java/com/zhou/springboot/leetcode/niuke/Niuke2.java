package com.zhou.springboot.leetcode.niuke;

import java.util.ArrayList;

@SuppressWarnings("all")
public class Niuke2 {

    //逆序对
    public static class Solution {

        public int count = 0;

        public int InversePairs(int[] array) {
            recursive(array, 0, array.length - 1);
            return count;
        }

        public void recursive(int[] array, int i, int j) {
            if (i == j) {
                return;
            }
            if ((i + 1) == j) {
                if (array[i] > array[j]) {
                    count++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                return;
            }
            //递归  [i,mid) , [mid,j]
            int mid = (i + j) / 2;
            recursive(array, i, mid - 1);
            recursive(array, mid, j);
            //递归统计完成后可以排序
            //            Arrays.sort(array, i, mid);
            //            Arrays.sort(array, mid, j + 1);//j or j+1

            int p1 = i;
            int p2 = mid - 1;
            for (; p1 < mid; p1++) {
                for (; p2 < j; p2++) {
                    if (array[p1] < array[p2 + 1]) {
                        //使得a[p2]>a[p1]
                        break;
                    }
                }
                count += (p2 - mid + 1);
            }
            merge(array, i, mid - 1, j);
        }

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

    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 0}; //7
        Solution s = new Solution();
        s.InversePairs(a);
        System.out.println(s.count);
    }


}
