package com.bless.leetcode;

import java.util.*;

/**
 * 给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class 分割回文子字符串 {

    private String str;
    List<List<String>> subStr = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    public String[][] partition(String s) {
        str = s;
        dfs(0);
        String[][] result = new String[subStr.size()][];
        for (int i = 0; i < subStr.size(); i++) {
            String[] line = new String[subStr.get(i).size()];
            subStr.get(i).toArray(line);
            result[i] = line;
        }
        return result;
    }

    private void dfs(int index) {
        if (index == str.length()) {
            subStr.add(new ArrayList<>(temp));
            return;
        }
        String line = "";
        for (int i = index; i < str.length(); i++) {
            line += str.charAt(i);
            if (isPalindrome(line)) {
                temp.add(line);
                dfs(i + 1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        分割回文子字符串 o = new 分割回文子字符串();
        System.out.println(o.partition("cbbbcc"));
    }
}
