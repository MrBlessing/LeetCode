package com.bless.leetcode.区间;

import java.util.*;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0];
            int R = interval[1];
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                // 比较大小的原因是可能当前区间属于上个区间的子集
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }

    public static void main(String[] args) {
        new 合并区间().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
