package com.bless.leetcode.滑动窗口;

public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int p1 = 0;
        int p2 = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (p2 != nums.length) {
            sum += nums[p2];
            while (sum >= target) {
                minLen = Math.min(minLen, p2 - p1 + 1);
                sum -= nums[p1];
                p1++;
            }
            p2++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(new 长度最小的子数组().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
