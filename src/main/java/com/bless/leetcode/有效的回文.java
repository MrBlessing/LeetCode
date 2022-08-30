package com.bless.leetcode;

public class 有效的回文 {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (!isNormalChar(s.charAt(i)) && i < j) {
                i++;
            }
            while (!isNormalChar(s.charAt(j)) && i < j) {
                j--;
            }
            if (!s.substring(i, i + 1).equalsIgnoreCase(s.substring(j, j + 1)) && i < j) {
                return false;
            }
        }
        return true;
    }

    private boolean isNormalChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        有效的回文 o = new 有效的回文();
        String s = "race a car";
        System.out.println(o.isPalindrome(s));
    }
}
