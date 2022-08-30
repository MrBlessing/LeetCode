package com.bless.leetcode;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int maxCanJumpIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxCanJumpIndex) {
                return false;
            }
            maxCanJumpIndex = Math.max(maxCanJumpIndex, nums[i] + i);
        }
        return true;
    }
}
