package com.bless.leetcode;

public class 替换后的最长重复字符 {
    public int characterReplacement(String s, int k) {
        int[] set = new int[26];
        // 区间内重复最多的字符数量
        int maxSize = 0;
        int left = 0, right = 0;
        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            // 统计在区间内每个大写字符出现的次数
            set[c - 'A']++;
            maxSize = Math.max(set[c - 'A'], maxSize);
            // 区间长度(right-left+1)-区间内重复最多的字符 = 可被替换的字符
            if (right - left + 1 - maxSize > k) {
                set[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        替换后的最长重复字符 o = new 替换后的最长重复字符();
        System.out.println(o.characterReplacement("AABABB",1));
    }
}
