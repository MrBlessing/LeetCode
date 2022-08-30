package com.bless.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class 单词长度的最大乘积 {
    public int maxProduct(String[] words) {
        int maxLengthMulti = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (containSameChar(words[i], words[j])) {
                    maxLengthMulti = Math.max(words[i].length() * words[j].length(), maxLengthMulti);
                }
            }
        }
        return maxLengthMulti;
    }

    private boolean containSameChar(String s1, String s2) {
        String minLength = s1.length() > s2.length() ? s2 : s1;
        String maxLength = s1.length() > s2.length() ? s1 : s2;
        for (int i = 0; i < minLength.length(); i++) {
            if (maxLength.contains(minLength.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 位运算
     * @param words
     * @return
     */
    private int maxProduct2(String[] words) {
        int[] mask = new int[words.length];
        for (int i = 0; i < mask.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mask[i] = mask[i] | 1 << (words[i].charAt(j));
            }
        }
        int maxLengthMulti = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    maxLengthMulti = Math.max(words[i].length() * words[j].length(), maxLengthMulti);
                }
            }
        }

        return maxLengthMulti;
    }

    public static void main(String[] args) {
        单词长度的最大乘积 o = new 单词长度的最大乘积();
        System.out.println(o.maxProduct(new String[]{"eae", "ea", "aaf", "bda", "fcf", "dc", "ac", "ce", "cefde", "dabae"}));
    }
}
