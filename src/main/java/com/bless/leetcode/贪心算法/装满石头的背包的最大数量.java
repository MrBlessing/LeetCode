package com.bless.leetcode.贪心算法;

import java.util.Arrays;

public class 装满石头的背包的最大数量 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int res = 0;
        int[] diff = new int[capacity.length];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        for (int j : diff) {
            // 如果剩余容积大于额外的石头，直接返回已满的背包数量
            if (j > additionalRocks) {
                return res;
            }
            additionalRocks -= j;
            res++;
        }
        return res;
    }
}
