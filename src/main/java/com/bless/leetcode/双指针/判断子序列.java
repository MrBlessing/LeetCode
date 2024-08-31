package com.bless.leetcode.双指针;

import java.util.Objects;

public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int ps = 0;
        int pt = 0;
        if(Objects.equals(s, "")) return true;
        while (pt < t.length()) {
            if (t.charAt(pt) == s.charAt(ps)) {
                ps++;
            }
            if (ps >= s.length()) {
                return true;
            }
            pt++;
        }
        return false;
    }
}
