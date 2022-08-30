package com.bless.leetcode;

public class 最大升序子数组和 {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int front = 0;
        int later = 0;
        while (later < nums.length - 1) {
            int sum = 0;
            for (front = later; front < nums.length; front++) {
                if (front != later && nums[front - 1] >= nums[front]) {
                    break;
                }
                sum += nums[front];
            }
            maxSum = Math.max(sum, maxSum);
            // 移动后指针的位置
            later = front;
        }
        return maxSum;
    }
}
