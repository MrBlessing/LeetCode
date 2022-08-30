package com.bless.leetcode;

public class 去除重复字母没做出来 {
    public String removeDuplicateLetters(String s) {
        int[] remove = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    remove[i] = 1;
                    break;
                }
            }
        }
        // 重新生成字符串
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (remove[i] == 0) {
                res = res + s.charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        去除重复字母没做出来 o = new 去除重复字母没做出来();
        System.out.println(o.removeDuplicateLetters("bcabc"));
    }
}
