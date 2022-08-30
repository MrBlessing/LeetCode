package com.bless.leetcode;

public class 使字符串平衡的最小交换次数 {
    public int minSwaps(String s) {
        // 记录左括号在右括号之前出现的次数
        int ex = 0;
        // 记录左括号出现的次数
        int leftCount = 0;
        for (char c : s.toCharArray()) {
            if (']' == c) {
                if (leftCount == 0) {
                    ex++;
                } else {
                    // 出现一个右括号就消灭一个左括号
                    leftCount--;
                }
            } else {
                leftCount++;
            }
        }
        // 本题关键： 出左括号在右括号之前出现的次数+1 除以2等于调整的次数
        return (ex + 1) / 2;
    }

    public static void main(String[] args) {
        使字符串平衡的最小交换次数 o = new 使字符串平衡的最小交换次数();
        System.out.println(o.minSwaps("][]["));
    }
}
