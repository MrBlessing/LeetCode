package com.bless.leetcode.动态规划;

public class 连续子数组的最大和 {
    // 最直观的动态规划
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[][] sum = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i][i] = nums[i];
            max = Math.max(max, sum[i][i]);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                sum[i][j] = sum[i][j + 1] + nums[j];
                max = Math.max(max, sum[i][j]);
            }
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre = 0;
        for (int n : nums) {
            pre = Math.max(pre + n, n);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
