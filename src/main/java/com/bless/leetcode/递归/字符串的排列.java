package com.bless.leetcode.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 字符串的排列 {
    List<String> res = new ArrayList<>();
    boolean[] verify;

    public String[] permutation(String s) {
        verify = new boolean[s.length()];
        // 字符串排序
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        s = new String(cs);
        // 递归查找
        dfs(s, "");
        System.out.println(res);
        return res.toArray(new String[]{});
    }

    private void dfs(String str, String temp) {
        if (str.length() == temp.length()) {
            res.add(temp);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!verify[i]) {
                String c = str.substring(i, i + 1);
                // 去重
                if (i != str.length() - 1 && c.equals(str.substring(i + 1, i + 2)) && !verify[i+1]) {
                    continue;
                }
                verify[i] = true;
                dfs(str, temp + c);
                verify[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        字符串的排列 o = new 字符串的排列();
        o.permutation("aac");
    }

}
