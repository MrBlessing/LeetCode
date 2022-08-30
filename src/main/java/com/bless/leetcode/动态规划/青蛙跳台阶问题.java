package com.bless.leetcode.动态规划;

public class 青蛙跳台阶问题 {
    public int numWays(int n) {
        if (n <= 2) {
            return n==0?1:n;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 跳一步来到i
            res[i] = (res[i - 1]+res[i - 2])%1000000007;
        }
        return res[n];
    }
}
