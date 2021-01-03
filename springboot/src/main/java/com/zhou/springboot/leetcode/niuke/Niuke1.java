package com.zhou.springboot.leetcode.niuke;

//给出一个转动过的有序数组，你事先不知道该数组转动了多少
//(例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
//在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
//假设数组中不存在重复项。
public class Niuke1 {

    public static void main(String[] args) {
        int[] A = new int[]{228, 234, 235, 236, 238, 239, 240, 241, 242, 243, 245, 248, 250, 253, 256, 257, 258, 260,
                261, 262, 263, 264,
                266, 268, 271, 272, 275, 276, 279, 280, 281, 282, 283, 284, 285, 287, 289, 291, 294, 295, 1, 6, 7, 8, 9,
                10, 11, 13, 14, 15, 17,
                18, 19, 20, 21, 22, 23, 25, 28, 30, 31, 36, 41, 43, 46, 48, 51, 52, 53, 54, 58, 59, 60, 62, 64, 66, 68,
                72, 73, 77, 85, 86, 89, 92, 94
                , 95, 97, 98, 101, 105, 108, 112, 116, 118, 120, 121, 122, 124, 125, 127, 128, 129, 130, 131, 132, 135,
                137, 139, 140, 142, 145, 147, 149, 152, 154, 156, 157, 158, 159, 168, 169, 170, 171, 172, 176, 178, 182,
                185, 188, 190, 195, 200, 201, 202, 203, 204, 206, 208, 210, 212, 216, 219, 224, 226};
        System.out.println(new Solution().search(A, 266));
    }

    public static class Solution {

        /**
         * @param A      int整型一维数组
         * @param target int整型
         * @return int整型
         */
        public int search(int[] A, int target) {
            int m = 0;
            int n = A.length - 1;
            if (m == n) {
                if (A[m] == target) {
                    return m;
                }
                return -1;
            }
            return recursive(m, n, A, target);
        }

        public int recursive(int m, int n, int[] A, int target) {
            int mid = (m + n) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (m + 1 == n) {
                if (A[n] == target) {
                    return n;
                }
                //不存在
                return -1;
            }
            if (A[m] <= A[mid] && target <= A[mid] && target >= A[m]) {
                //左边连续并且target在范围内
                n = mid;
            }else if(A[n] >= A[mid] && target >= A[mid] && target <= A[n]) {
                //右边连续并且target在范围内
                m = mid;
            } else if(A[m] > A[mid]) {
                //左边不连续，那么右边一定连续
                n = mid;
            }else{
                m = mid;
            }
            return recursive(m, n, A, target);
        }
    }

}
