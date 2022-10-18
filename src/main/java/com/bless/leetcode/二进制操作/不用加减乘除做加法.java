package com.bless.leetcode.二进制操作;

public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        // 进位 = a & b << 1;
        // 不进位相加的结果 = a 异或 b
        // a + b = 进位 + 不进位相加的结果
        // 不断的循环，直到carry = 0
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
