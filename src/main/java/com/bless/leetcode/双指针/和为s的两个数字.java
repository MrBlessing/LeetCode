package com.bless.leetcode.双指针;

import java.util.HashMap;

public class 和为s的两个数字 {
    // HashMap解决
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return new int[]{map.get(num), num};
            }
            map.put(target - num, num);

        }
        return new int[]{};
    }

    // 双指针解决
    public int[] twoSum2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        new 和为s的两个数字().twoSum2(new int[]{2, 7, 11, 15}, 9);
    }
}
