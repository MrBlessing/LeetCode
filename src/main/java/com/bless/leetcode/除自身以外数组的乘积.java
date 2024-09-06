package com.bless.leetcode;

public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        // 先算左边的乘积
        answer[0] = 1;
        for (int i = 1; i < answer.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        // 再计算右边的乘积
        int r = 1;
        for (int j = answer.length - 2; j >= 0; j--) {
            r = r * nums[j + 1];
            answer[j] = answer[j] * r;
        }
        return answer;
    }
}
