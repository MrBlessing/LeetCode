package com.bless.leetcode;

import java.util.HashMap;

public class 字符串转换整数 {
    public int myAtoi(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        long result = 0L;
        // 正负号的标志
        int flag = 1;
        // 去除前置空格
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length()) {
            return 0;
        }
        // 取正负号
        switch (s.charAt(index)) {
            case '-':
                flag = -1;
                index++;
                break;
            case '+':
                index++;
                break;
            default:
                break;
        }
        // 读取所有数字字符
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            // 非数字字符
            if (c > '9' || c < '0') {
                break;
            }
            result = result * 10L + c - '0';
            // 溢出检查
            if (result * flag > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * flag < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) result * flag;
    }

    public static void main(String[] args) {
        字符串转换整数 o = new 字符串转换整数();
        System.out.println(o.myAtoi2("9223372036854775808"));
    }

    /**
     * 状态机解决
     *
     * @param s
     * @return
     */
    public int myAtoi2(String s) {
        HashMap<String, String[]> table = new HashMap<>();
        table.put("start", new String[]{"start", "signed", "number", "end"});
        table.put("signed", new String[]{"end", "end", "number", "end"});
        table.put("number", new String[]{"end", "end", "number", "end"});
        table.put("end", new String[]{"end", "end", "end", "end"});
        // 当前的状态
        String curStation = "start";
        // 符号标志
        int signFlag = 1;
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                curStation = table.get(curStation)[0];
            } else if (c == '-' || c == '+') {
                curStation = table.get(curStation)[1];
            } else if (c <= '9' && c >= '0') {
                curStation = table.get(curStation)[2];
            } else {
                curStation = table.get(curStation)[3];
            }
            if ("number".equals(curStation)) {
                result =  result * 10 + c - '0';
                if (result * signFlag > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (result * signFlag < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            if ("signed".equals(curStation)) {
                signFlag = c == '-' ? -1 : 1;
            }
        }
        return (int)result * signFlag;
    }
}
