package com.bless.leetcode;

public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    // 不使用子串函数
    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }
}
