package com.bless.leetcode;

public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean start = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
               start = true;
               len++;
            }else if(start){
                break;
            }
        }
        return len;
    }
}
