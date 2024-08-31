package com.bless.leetcode;

public class 求1到n的和 {
    public int sumNums(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    // 递归法（不使用判断语句）
    public int sumNums2(int n) {
        // 当n==0的时候会发生短路
        boolean flag = n > 0 && (n += sumNums2(n - 1)) > 0;
        return n;
    }
}
