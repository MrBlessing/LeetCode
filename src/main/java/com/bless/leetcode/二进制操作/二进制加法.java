package com.bless.leetcode.二进制操作;

public class 二进制加法 {
    // 模拟进位法
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(a.length(), b.length());
        for (int i = 0; i < maxLength; i++) {
            int n1 = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int n2 = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sb.append((n1 + n2 + carry) % 2);
            carry = (n1 + n2 + carry) / 2;
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String res = new 二进制加法().addBinary("100", "100");
        System.out.println(res);
    }
}
