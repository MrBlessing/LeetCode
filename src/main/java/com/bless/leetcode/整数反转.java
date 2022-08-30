package com.bless.leetcode;

public class 整数反转 {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        整数反转 o = new 整数反转();
        System.out.println(o.reverse(-123));
    }
}
