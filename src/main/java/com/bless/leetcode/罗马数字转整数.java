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
        int prevalue = 0;
        for (int i=s.length()-1;i>=0;i--) {
            int curValue = map.get(s.charAt(i));
            if (curValue < prevalue) {
                res -= curValue;
            } else {
                res += curValue;
            }
            prevalue = curValue;
        }
        return res;
    }

    public static void main(String[] args) {
        罗马数字转整数 o = new 罗马数字转整数();
        System.out.println(o.romanToInt("LVIII"));
    }
}
