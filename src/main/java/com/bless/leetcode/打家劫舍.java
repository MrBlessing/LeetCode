package com.bless.leetcode;

public class 打家劫舍 {
    // best数组表示当前nums数组长度下能抢到的最大钱数
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] best = new int[nums.length];
        best[0] = nums[0];
        best[1] = Math.max(nums[0], nums[1]);
        // best[i] = Max(nums[i]+best[i-2],best[i-1])
        // nums[i]+best[i-2]表示打劫第i个房子
        // best[i-1]表示不打劫第i个房子
        for (int i = 2; i < nums.length; i++) {
            best[i] = Math.max(nums[i] + best[i - 2], best[i - 1]);
        }
        return best[best.length - 1];
    }
}
