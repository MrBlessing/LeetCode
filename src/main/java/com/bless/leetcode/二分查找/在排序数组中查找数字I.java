package com.bless.leetcode.二分查找;

public class 在排序数组中查找数字I {
    // nums为升序
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (nums[mid] == target) {
                    int count = 1;
                    // 找到目标值，则在目标值附近查找
                    for (int i = mid - 1; i >= 0 && target == nums[i]; i--) {
                        count++;
                    }
                    for (int i = mid + 1; i < nums.length && target == nums[i]; i++) {
                        count++;
                    }
                    return count;
                }
                right = mid - 1;
            }
        }
        return 0;
    }
}
