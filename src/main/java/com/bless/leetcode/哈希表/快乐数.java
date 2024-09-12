package com.bless.leetcode.哈希表;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 快乐数 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
    }

    public static void main(String[] args) {
        new 快乐数().isHappy(19);
    }
}
