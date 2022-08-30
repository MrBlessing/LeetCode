package com.bless.leetcode;

import java.util.*;

public class 和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            int tempSum = 0;
            for (int right = left; right < nums.length; right++) {
                tempSum += nums[right];
                if (tempSum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> sum = new HashMap<>();
        sum.put(0, 1);
        int tempSum = 0;
        int res = 0;
        for (int num : nums) {
            tempSum += num;
            if (sum.containsKey(tempSum - k)) {
                res += sum.get(tempSum - k);
            }
            sum.put(tempSum, sum.containsKey(tempSum) ? sum.get(tempSum) + 1 : 1);
        }
        return res;
    }


    public static void main(String[] args) {
        和为k的子数组 o = new 和为k的子数组();
        System.out.println(o.subarraySum2(new int[]{1, -1, 0}, 0));
    }
}
