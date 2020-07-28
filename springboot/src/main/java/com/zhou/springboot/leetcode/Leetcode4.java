package com.zhou.springboot.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode4 {

    public static class QuickSort {

        public int partion(List<Integer> list, int low, int high) {
//            int length = list.size();
//            int maxNUm = Math.max(Math.max(list.get(0), list.get((0 + length - 1) / 2)), list.get(length - 1));
//            int pivotkey = Math.min(Math.max(list.get(0), list.get((0 + length - 1) / 2)), list.get(length - 1));
            int pivotkey = list.get(0);
            while (low < high) {
                while (low < high && list.get(high) > pivotkey) {
                    high--;
                }
                swap(list, low, high);
                while (low < high && list.get(low) < pivotkey) {
                    low++;
                }
                swap(list, low, high);

            }
            return low;
        }

        private void swap(List<Integer> list, int low, int high) {
            Integer temp = list.get(low);
            list.set(low, list.get(high));
            list.set(high, temp);
        }
    }

    //把数组排成最小的数
    static class Solution {
        public String minNumber(int[] nums) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add("" + nums[i]);
            }
            list.sort((o1, o2) -> {
               return (o1 + o2).compareTo(o2 + o1); //有重复计算
            });
            return String.join("",list);
        }

        private int getTop(int number) {
            return number == 0 ? 0 : number / (int) Math.pow(10, Math.floor(Math.log10(Math.abs(number))));
        }
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{3, 30, 34, 5, 9};
//        System.out.println(new Solution().minNumber(nums));
        System.out.println("30".compareTo("3"));
    }

}
