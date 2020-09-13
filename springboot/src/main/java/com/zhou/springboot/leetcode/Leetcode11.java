package com.zhou.springboot.leetcode;

@SuppressWarnings("all")
public class Leetcode11 {


    //输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
    class SolutionLowEffective {

        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            int m = 0;
            for (int i = m; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        res[0] = nums[i];
                        res[1] = nums[j];
                        return res;
                    }
                }
            }
            //impossible
            return res;
        }
    }

    //输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
    //时间复杂度O(n)
    class Solution1 {

        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            int min = 0;
            int max = nums.length - 1;
            while (true) {
                if (nums[min] + nums[max] == target) {
                    res[0] = nums[min];
                    res[1] = nums[max];
                    return res;
                }
                if (nums[min] + nums[max] > target) {
                    max--;
                } else {
                    min++;
                }
            }
        }
    }


    //剑指 Offer 53 - I. 在排序数组中查找数字 I
    //利用二分法
    static class Solution2 {

        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int count = 0;
            int min = 0;
            int max = nums.length - 1;
            int mid = (min + max) / 2;
            while (nums[mid] != target) {
                if (mid == min || mid == max) {
                    break;
                }
                if (nums[mid] > target) {
                    max = mid;
                }
                if (nums[mid] < target) {
                    min = mid;
                }
                mid = (min + max) / 2;
            }
            if (nums[mid] == target) {
                count++;
            }
            for (int i = mid + 1; i <= max; i++) {
                if (nums[i] == target) {
                    count++;
                } else {
                    break;
                }
            }
            for (int i = mid - 1; i >= min; i--) {
                if (nums[i] == target) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

    }

    //一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    static class Solution3 {

        public int missingNumber(int[] nums) {
            int min = 0;
            int max = nums.length - 1;
            int mid = (min + max) / 2;
            while (min + 1 < max) {
                if (nums[mid] == mid) {
                    min = mid;
                } else {
                    max = mid;
                }
                mid = (min + max) / 2;
            }
            if (nums[nums.length - 1] == nums.length - 1) {
                return nums.length;
            }
            return nums[mid] == mid ? mid + 1 : mid;
        }
    }

    //更加简洁的写法
    static class Solution31 {

        public int missingNumber(int[] nums) {
            if (nums[nums.length - 1] == nums.length - 1) {
                return nums.length;
            }
            int min = 0;
            int max = nums.length - 1;
            int mid = (min + max) / 2;
            while (min <= max) {
                if (nums[mid] == mid) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
                mid = (min + max) / 2;
            }
            return min;
        }
    }


    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    //剑指 Offer 22. 链表中倒数第k个节点
    class Solution {

        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode first = null;
            int count = 0;
            while (head != null) {
                if (first == null) {
                    first = head;
                }
                if (count < k) {
                    count++;
                } else {
                    first = first.next;
                }
                head = head.next;
            }
            return first;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }

}

















