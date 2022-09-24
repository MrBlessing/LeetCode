package com.bless.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (right > left) {
            // 求和公式 n(a1+an)/2
            int sum = (right + 1 - left) * (right + left) / 2;
            if (sum < target) {
                right++;
            } else if (sum > target) {
                left++;
            } else {
                int[] temp = new int[right + 1 - left];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                res.add(temp);
                left++;
            }
        }
        // 数组转换
        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
