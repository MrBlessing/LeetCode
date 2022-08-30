package com.bless.leetcode;

public class 分割平衡字符串 {
    public int balancedStringSplit(String s) {
        int res = 0;
        int t = 0;
        for (char c : s.toCharArray()) {
            t += c == 'L' ? 1 : -1;
            if (t == 0) {
                res++;
            }
        }
        return res;
    }
}
