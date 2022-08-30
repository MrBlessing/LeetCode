package com.bless.leetcode;

public class 回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x = x / 10;
        }
        return x == revertNum || x == revertNum / 10;
    }

    public static void main(String[] args) {
        回文数 o = new 回文数();
        System.out.println(o.isPalindrome(121));
    }
}
