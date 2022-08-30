package com.bless.leetcode;

import java.util.Arrays;

public class 划分数组使最大差为K {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - nums[left] > k) {
                res += 1;
                left = i;
            }
        }
        return res;
    }
}
