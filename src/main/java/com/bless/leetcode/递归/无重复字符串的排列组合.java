package com.bless.leetcode.递归;

import java.util.ArrayList;
import java.util.List;

public class 无重复字符串的排列组合 {

    List<String> res = new ArrayList<>();
    String s;
    public String[] permutation(String s) {
        this.s = s;
        dfs("");
        return res.toArray(new String[0]);
    }

    private void dfs(String str) {
        if (str.length() >= s.length()) {
            res.add(str);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if (!str.contains(c)) {
                dfs(str + c);
            }
        }
    }

    public static void main(String[] args) {
        无重复字符串的排列组合 o = new 无重复字符串的排列组合();
        System.out.println(o.permutation("abc"));
    }
}
