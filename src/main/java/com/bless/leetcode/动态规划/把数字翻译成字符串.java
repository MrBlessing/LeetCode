package com.bless.leetcode.动态规划;

public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] best = new int[str.length() + 1];
        best[0] = 1;
        best[1] = 1;
        for (int i = 2; i < str.length() + 1; i++) {
            String n = str.substring(i - 2, i);
            if (Integer.parseInt(n) > 25 || (n.length()==2 &&n.startsWith("0"))) {
                best[i] = best[i - 1];
            } else{
                best[i] = best[i - 1] + best[i - 2];
            }
        }
        return best[str.length()];
    }

    public static void main(String[] args) {
        System.out.println(new 把数字翻译成字符串().translateNum(506));

    }
}
