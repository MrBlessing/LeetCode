package com.bless.leetcode;

public class K次操作后最大化顶端元素 {
    public int maximumTop(int[] nums, int k) {

        if (nums.length == 1) {
            if (k % 2 == 0) {
                return nums[0];
            }
            return -1;
        }
        int max = 0;
        // 考虑当从nums数组中取出k次后，正好nums[k]是最大值
        for (int i = 0; i < Math.min(nums.length, k + 1); i++) {
            if (i != k - 1)
                max = Math.max(nums[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        K次操作后最大化顶端元素 o = new K次操作后最大化顶端元素();
        System.out.println(o.maximumTop(new int[]{35, 43, 23, 86, 23, 45, 84, 2, 18, 83, 79, 28, 54, 81, 12, 94, 14, 0, 0, 29, 94, 12, 13, 1, 48, 85, 22, 95, 24, 5, 73, 10, 96, 97, 72, 41, 52, 1, 91, 3, 20, 22, 41, 98, 70, 20, 52, 48, 91, 84, 16, 30, 27, 35, 69, 33, 67, 18, 4, 53, 86, 78, 26, 83, 13, 96, 29, 15, 34, 80, 16, 49}, 15));
    }
}
