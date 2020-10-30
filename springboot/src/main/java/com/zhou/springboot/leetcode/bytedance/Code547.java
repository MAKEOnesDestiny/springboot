package com.zhou.springboot.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//执行用时：
//19 ms
//, 在所有 Java 提交中击败了
//5.22%
//的用户
//内存消耗：
//39.1 MB
//, 在所有 Java 提交中击败了
//95.88%
//的用户
public class Code547 {

    //班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
    //
    //给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
    static class Solution {

        public int findCircleNum(int[][] M) {
            List<Set<Integer>> res = new ArrayList<>();
            int n = M[0].length;
            for (int i = 0; i < n; i++) {
                Set<Integer> has = null;
                Set<Integer> single = new HashSet<>();
                for (int j = i; j < n; j++) {
                    if (M[i][j] == 1) {
                        single.add(j);
                        List<Integer> delete = new ArrayList<>();
                        for (int k = 0; k < res.size(); k++) {
                            Set<Integer> ss = res.get(k);
                            if (ss.contains(j)) {
                                single.addAll(ss);
                                delete.add(k);
                            }
                        }
                        delete.stream().forEach((t) -> {
                            res.remove(t.intValue());
                        });
                    }
                }
                res.add(single);
            }
            return res.size();
        }
    }

    public static void main(String[] args) {
        //        int[][] m = new int[][]{{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,
        //                0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
        int[][] m = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(new Solution().findCircleNum(m));
    }

}
