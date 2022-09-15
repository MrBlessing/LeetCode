package com.bless.leetcode.二分查找;

public class 零到n中缺失的数字 {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new 零到n中缺失的数字().missingNumber(new int[]{0, 1, 3}));
    }
}
