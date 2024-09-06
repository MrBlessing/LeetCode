package com.bless.leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;

public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int value = map.getOrDefault(c, 0);
            map.put(c, value + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            int value = map.getOrDefault(c, 0);
            if (value == 0) {
                return false;
            }
            map.put(c, value - 1);
        }
        return true;
    }
}
