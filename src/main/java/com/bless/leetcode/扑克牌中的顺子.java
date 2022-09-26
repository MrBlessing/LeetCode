package com.bless.leetcode;

import java.util.Arrays;

public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        // 除零以外最小值的位置
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                minIndex++;
            } else {
                // 不允许重复
                if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
                    return false;
                }
            }
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[minIndex] < 5;
    }
}
