package com.bless.leetcode.贪心算法;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        // 实时最远跳跃位置
        int maxCanJumpIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxCanJumpIndex) {
                return false;
            }
            // 更新最远能跳到的位置
            maxCanJumpIndex = Math.max(maxCanJumpIndex, nums[i] + i);
        }
        return true;
    }
}
