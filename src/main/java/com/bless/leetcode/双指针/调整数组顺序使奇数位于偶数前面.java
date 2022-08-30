package com.bless.leetcode.双指针;

public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int n : nums) {
            if (n % 2 == 0) {
                res[right] = n;
                right--;
            } else {
                res[left] = n;
                left++;
            }
        }
        return res;
    }
}
