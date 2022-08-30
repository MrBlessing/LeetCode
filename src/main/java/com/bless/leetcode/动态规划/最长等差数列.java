package com.bless.leetcode.动态规划;

public class 最长等差数列 {
    public int longestArithSeqLength(int[] nums) {
        // 记录最长的等差数组个数
        int maxLength = 0;
        // best[i][j]表示nums[i]前差为j的元素数量
        int[][] best = new int[nums.length][1001];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 计算第i个数前所有数的差值
                // nums[n]的取值范围是[0-500]，所以防止索引出现负值加上500
                int diff = nums[j] - nums[i] + 500;
                // 从第j个数到第i个数
                best[i][diff] = best[j][diff] + 1;
                maxLength = Math.max(best[i][diff], maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        最长等差数列 o = new 最长等差数列();
        System.out.println(o.longestArithSeqLength(new int[]{3, 6, 9, 12}));
    }
}
