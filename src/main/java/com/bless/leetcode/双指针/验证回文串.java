package com.bless.leetcode.双指针;

public class 验证回文串 {
    public boolean isPalindrome(String s) {
        // 去除字符串中的特殊字符
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z')||(c >= '0' && c <= '9')) {
                sb.append(c);
            }
            if ((c >= 'A' && c <= 'Z')) {
                sb.append(Character.toChars(c+32));
            }
        }
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 验证回文串().isPalindrome("0P"));
    }
}
