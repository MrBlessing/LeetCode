package com.bless.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class 反转字符串中的单词 {
    public String reverseWords(String s) {
        Deque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length() ; i++) {
            char c;
            StringBuilder builder = new StringBuilder();
            while (i < s.length() && (c = s.charAt(i)) != ' ') {
                builder.append(c);
                i++;
            }
            if (builder.length() > 0) {
                queue.addFirst(builder.toString());
            }
        }
        return String.join(" ",queue);
    }

    public static void main(String[] args) {
        System.out.println(new 反转字符串中的单词().reverseWords("   the       sky is blue   "));
    }
}
