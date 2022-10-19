package com.bless.leetcode.二进制操作;

public class 前n个数字二进制中1的个数 {
    public int[] countBits(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if ((i & (1 << j)) != 0) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
