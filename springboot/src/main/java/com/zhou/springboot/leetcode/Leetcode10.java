package com.zhou.springboot.leetcode;

@SuppressWarnings("all  ")
public class Leetcode10 {

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
     * x) { val = x; } }
     */

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    //    输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    //    输出: 6
    //    解释: 节点 2 和节点 8 的最近公共祖先是 6。
    class Solution {

        /**
         * difficult
         *
         * @param root
         * @param p
         * @param q
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val) {
                return root;
            }
            TreeNode leftFound = lowestCommonAncestor(root.left, p, q);
            TreeNode rightFound = lowestCommonAncestor(root.right, p, q);
            if (leftFound != null && rightFound != null) {
                return root;
            } else {
                return leftFound != null ? leftFound : rightFound;
            }
        }

    }

    //difficult!!!!
    //1~n中1出现的数字
    static class Solution2 {

        public int countDigitOne(int n) {
            long count = 0;
            long pow = 1;
            while (n / pow > 0) {
                long cur = n / pow % 10;
                long high = n / (10 * pow);
                long low = n - (n / pow) * pow;
                if (cur == 0) {
                    count += high * pow;
                } else if (cur == 1) {
                    count = count + high * pow + low + 1;
                } else {
                    count = count + (high + 1) * pow;
                }
                pow = 10 * pow;
            }
            return (int) count;
        }
    }

    //数组中重复的数字
    //    输入：
    //            [2, 3, 1, 0, 2, 5, 3]
    //    输出：2 或 3
    static class Solution3 {

        public int findRepeatNumber(int[] nums) {
            recursive(nums, 0, nums.length - 1);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums[i + 1]) {
                    return nums[i];
                }
            }
            return 0;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public int partition(int[] nums, int begin, int end) {
            int mid = begin;
            swap(nums, begin, end);
            for (int i = begin; i < end; i++) {
                if (nums[i] < nums[end]) {
                    swap(nums, mid, i);
                    mid++;
                }
            }
            swap(nums, mid, end);
            return mid;
        }

        public void recursive(int[] nums, int begin, int end) {
            int i = partition(nums, begin, end);
            if (begin < i) {
                recursive(nums, begin, i - 1);
            }
            if (i < end) {
                recursive(nums, i + 1, end);
            }
        }

    }

    public static void main(String[] args) {
        //        System.out.println(new Solution2().countDigitOne(12));
        //        int[] a = new int[]{2, 3, 1, 0, 2, 5, 3};
        int[] a = new int[]{3, 1, 2, 3};
        new Solution3().findRepeatNumber(a);
        System.out.println();
    }

}
