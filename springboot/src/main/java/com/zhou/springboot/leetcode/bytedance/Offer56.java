package com.zhou.springboot.leetcode.bytedance;

import java.util.ArrayList;

public class Offer56 {

    public static class Interval {

        int start;
        int end;

        Interval() { start = 0; end = 0; }

        Interval(int s, int e) { start = s; end = e; }
    }

    public static class Solution {

        public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
            intervals.sort((t1, t2) -> {
                return t1.start - t2.start;
            });
            ArrayList<Interval> res = new ArrayList<Interval>();
            Interval last = null;
            for (int i = 0; i < intervals.size(); i++) {
                if (last == null) {
                    last = intervals.get(i);
                } else {
                    Interval n = intervals.get(i);
                    if (last.end < n.start) {
                        res.add(last);
                        last = n;
                    } else {
                        last = new Interval(last.start, n.end);
                    }
                }
            }
            if (last != null) {
                res.add(last);
            }
            return res;
        }
    }

    //[[10,30],[20,60],[80,100],[150,180]]
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>() {{
            add(new Interval(10, 30));
            add(new Interval(20, 60));
            add(new Interval(80, 100));
            add(new Interval(150, 180));
        }};
        new Solution().merge(intervals).stream().forEach((t) -> {
            System.out.println(t.start + "," + t.end);
        });
    }

}
