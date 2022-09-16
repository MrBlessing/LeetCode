package com.bless.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int cv = map.get(s.charAt(i));
            if (i != s.length() - 1) {
                int cl = map.get(s.charAt(i + 1));
                if (cl > cv) {
                    cv = -cv;
                }
            }
            res += cv;
        }
        return res;
    }

    public static void main(String[] args) {
        罗马数字转整数 o = new 罗马数字转整数();
        System.out.println(o.romanToInt("IVIII"));
    }
}
