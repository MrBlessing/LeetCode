package com.bless.leetcode;

import java.util.Arrays;

public class 找到和最大的长度为K的子序列 {
    public int[] maxSubsequence(int[] nums, int k) {
        // 取得多个最大值的下标
        int[] res = new int[k];
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            res[i] = nums[nums.length - 1 - i];
        }
        return res;
    }
}
