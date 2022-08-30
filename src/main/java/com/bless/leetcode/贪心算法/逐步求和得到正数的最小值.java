package com.bless.leetcode.贪心算法;

public class 逐步求和得到正数的最小值 {
    public int minStartValue(int[] nums) {
        int res = 0;
        int sum = 1;
        for (int num : nums) {
            sum += num;
            if (sum < 1) {
                res = Math.max(res, 1 - sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        逐步求和得到正数的最小值 o = new 逐步求和得到正数的最小值();
        System.out.println(o.minStartValue(new int[]{-3,2,-3,4,2}));
    }
}
