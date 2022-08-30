package com.bless.leetcode.状态机;

import java.util.HashMap;

public class 表示数值的字符串 {
    public boolean isNumber(String s) {
        String curState = "start";
        HashMap<String, String[]> state = new HashMap<>();
        state.put("start", new String[]{"start", "signed", "number", "dotNoNumber", "fail"});
        state.put("signed", new String[]{"fail", "fail", "number", "fail", "fail"});
        state.put("number", new String[]{"end", "fail", "number", "dot", "end"});
        state.put("dotNoNumber", new String[]{"fail", "fail", "decimal", "fail", "fail"});
        state.put("dot", new String[]{"fail", "fail", "decimal", "fail", "end"});
        state.put("decimal", new String[]{"end", "fail", "decimal", "fail", "end"});
        state.put("end", new String[]{"fail", "fail", "fail", "fail", "end"});
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                curState = state.get(curState)[0];
            } else if (c == '-' || c == '+') {
                curState = state.get(curState)[1];
            } else if (c >= '0' && c <= '9') {
                curState = state.get(curState)[2];
            } else if (c == '.') {
                curState = state.get(curState)[3];
            } else {
                return false;
            }
            if ("fail".equals(curState)) {
                return false;
            }
        }
        curState = state.get(curState)[4];
        return "end".equals(curState);
    }

    public static void main(String[] args) {
        表示数值的字符串 o = new 表示数值的字符串();
        o.isNumber("0");
    }
}
