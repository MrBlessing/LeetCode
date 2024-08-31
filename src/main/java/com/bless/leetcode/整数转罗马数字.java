package com.bless.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class 整数转罗马数字 {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < values.length; i++) {
            if (num / values[i] != 0) {
                String c = symbols[i];
                for (int j = 0; j < num / values[i]; j++) {
                    res.append(c);
                }
                num %= values[i];
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new 整数转罗马数字().intToRoman(3749));
    }
}
