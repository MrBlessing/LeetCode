package com.bless.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String prefix = strs[0];
        for (String s : strs) {
            prefix = compare(prefix, s);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    private String compare(String prefix, String s) {
        int minLength = Math.min(prefix.length(), s.length());
        String result = "";
        for (int i = 0; i < minLength; i++) {
            if (prefix.charAt(i) == s.charAt(i)) {
                result += prefix.charAt(i);
            } else {
                return result;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        最长公共前缀 o = new 最长公共前缀();
        System.out.println(o.longestCommonPrefix(new String[]{"cir", "car"}));
    }
}