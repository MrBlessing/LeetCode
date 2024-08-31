package com.bless.leetcode.状态机;

import java.util.HashMap;
import java.util.Map;

public class 把字符串转换成整数 {
    public int strToInt(String str) {
        long res = 0;
        int sign = 1;
        String[] start = {"start", "signed", "number", "fail"};
        String[] signed = {"fail", "fail", "number", "fail"};
        String[] number = {"end", "end", "number", "end"};
        String[] end = {"end", "end", "end", "end"};
        Map<String, String[]> state = new HashMap<>();
        state.put("start", start);
        state.put("signed", signed);
        state.put("number", number);
        state.put("end", end);
        String currentState = "start";
        for (char c : str.toCharArray()) {
            if (' ' == c) {
                currentState = state.get(currentState)[0];
            } else if ('-' == c || '+' == c) {
                currentState = state.get(currentState)[1];
            } else if (c >= '0' && c <= '9') {
                currentState = state.get(currentState)[2];
            } else {
                currentState = state.get(currentState)[3];
            }
            if ("number".equals(currentState)) {
                res = res * 10 + (c - '0');
            }
            if ("signed".equals(currentState)) {
                sign = c == '-' ? -1 : 1;
            }
            if ("fail".equals(currentState)) {
                return 0;
            }
        }
        return sign * (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new 把字符串转换成整数().strToInt("9223372036854775808"));
    }
}
