package com.bless.leetcode.滑动窗口;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {
//    public int lengthOfLongestSubstring(String s) {
//        int maxLen = 0;
//        Deque<Character> cl = new ArrayDeque<>();
//        for (int i = 0; i != s.length(); i++) {
//            while (cl.contains(s.charAt(i))) {
//                cl.removeFirst();
//            }
//            cl.addLast(s.charAt(i));
//            maxLen = Math.max(maxLen, cl.size());
//        }
//        return maxLen;
//    }

    public int lengthOfLongestSubstring(String s) {
        int p1 = 0;
        int p2 = 0;
        int maxLen = 0;
        Set<Character> occ = new HashSet<Character>();
        while (p2 != s.length()) {
            while (occ.contains(s.charAt(p2))) {
                occ.remove(s.charAt(p1));
                p1++;
            }
            occ.add(s.charAt(p2));
            p2++;
            maxLen = Math.max(maxLen, occ.size());
        }
        return maxLen;
    }
}
