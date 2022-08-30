package com.bless.leetcode;

public class 交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        int last = 2;
        while (n > 1) {
            int cur = n % 2;
            if (last == cur) {
                return false;
            }
            last = cur;
            n = n / 2;
        }
        return last != n;
    }

    public static void main(String[] args) {
        交替位二进制数 o = new 交替位二进制数();
        System.out.println(o.hasAlternatingBits(4));
    }
}
