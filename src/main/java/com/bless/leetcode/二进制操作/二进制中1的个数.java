package com.bless.leetcode.二进制操作;

public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1 << i) != 0) {
                count++;
            }
        }
        return count;
    }
}
