package com.bless.leetcode.双指针;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int maxGap = 0;
        Set<Character> cs = new HashSet<>();
        // 右指针
        int j = 0;
        for (int i = 0; i < s.length() && j<s.length(); i++) {
            // 左指针向右移动一个
            if (i != 0) {
                cs.remove(s.charAt(i - 1));
            }
            for (; j < s.length() && !cs.contains(s.charAt(j)); j++) {
                cs.add(s.charAt(j));
            }
            maxGap = Math.max(maxGap, cs.size());
        }
        return maxGap;
    }

    public static void main(String[] args) {
        无重复字符的最长子串 o = new 无重复字符的最长子串();
        System.out.println(o.lengthOfLongestSubstring("dvdf"));
    }
}
