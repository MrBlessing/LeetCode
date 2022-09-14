package com.bless.leetcode;

public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        int[] map = new int[25];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        for (char c : s.toCharArray()) {
            if (map[c] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
