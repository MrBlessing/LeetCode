package com.bless.leetcode;

public class 丢失的数字 {
    public int missingNumber(int[] nums) {
        int[] map = new int[10001];
        for (int num : nums) {
            map[num] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int numSum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            numSum = numSum + i - nums[i];
        }
        return numSum;
    }
}
