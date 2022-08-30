package com.bless.leetcode;

public class 将整数转换为两个无零整数的和 {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            int t = n - i;
            if (!String.valueOf(n).contains("0")) {
                return new int[]{i, t};
            }
        }
        return new int[0];
    }
}
