package com.bless.leetcode;

public class 翻转单词顺序 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        String res = "";
        for (int i = words.length-1; i >=0 ; i--) {
            if(!words[i].isEmpty()){
                res += " "+words[i].trim();
            }
        }
        return res.substring(1);
    }

    public static void main(String[] args) {
        String a = new 翻转单词顺序().reverseWords("a good   example");
        System.out.println(a);
    }
}
