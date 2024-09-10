package com.bless.leetcode.二分查找;

import com.bless.leetcode.贪心算法.股票的最大利润;

public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new 搜索插入位置().searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
