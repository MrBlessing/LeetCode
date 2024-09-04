package com.bless.leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;

public class 同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if ((m1.containsKey(c1) && m1.get(c1) != c2) || (m2.containsKey(c2) && m2.get(c2) != c1)) {
                return false;
            }
            m1.put(c1, c2);
            m2.put(c2, c1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 同构字符串().isIsomorphic("badc", "baba"));
    }
}
