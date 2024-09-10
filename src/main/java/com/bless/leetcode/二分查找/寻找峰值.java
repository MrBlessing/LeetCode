package com.bless.leetcode.二分查找;

public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int leftValue = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int rightValue = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];
            if (nums[mid] >= leftValue && nums[mid] >= rightValue) {
                return mid;
            } else if (nums[mid] < leftValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(new 寻找峰值().findPeakElement(new int[]{3, 4, 3, 2, 1}));
    }
}
