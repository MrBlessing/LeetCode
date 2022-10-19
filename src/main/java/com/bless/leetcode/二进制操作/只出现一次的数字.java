package com.bless.leetcode.二进制操作;

public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            // 对数组中所有数字的第i位二进制进行求和
            // 求和的结果求余3就是目标数字的二进制
            for (int num : nums) {
                sum += ((num >> i) & 1);
            }
            // 每次都把目标数字的二进制放到该有的位置
            res = res | ((sum % 3) << i);
        }
        return res;
    }

    public static void main(String[] args) {
        new 只出现一次的数字().singleNumber(new int[]{2, 2, 3, 2});
    }
}
