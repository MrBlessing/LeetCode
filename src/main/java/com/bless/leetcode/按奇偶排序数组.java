package com.bless.leetcode;

import java.util.LinkedList;

public class 按奇偶排序数组 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 0) {
                res[left++] = num;
            } else {
                res[right--] = num;
            }
        }
        return res;
    }
}
