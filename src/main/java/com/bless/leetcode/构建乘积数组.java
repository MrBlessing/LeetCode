package com.bless.leetcode;

public class 构建乘积数组 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[]{};
        }
        int[] res = new int[a.length];
        // leftMulti[i] 表示i左边所有数字的乘积
        // rightMulti[i] 表示i右边所有数字的乘积
        int[] leftMulti = new int[a.length];
        int[] rightMulti = new int[a.length];
        leftMulti[0] = 1;
        // 计算a[i]左边所有数字的乘积
        for (int i = 1; i < leftMulti.length; i++) {
            leftMulti[i] = leftMulti[i - 1] * a[i - 1];
        }
        // 计算a[i]右边所有数字的乘积
        rightMulti[rightMulti.length - 1] = 1;
        for (int i = rightMulti.length - 2; i >= 0; i--) {
            rightMulti[i] = rightMulti[i + 1] * a[i + 1];
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = leftMulti[i] * rightMulti[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 构建乘积数组().constructArr(new int[]{1, 2, 3, 4, 5}));
    }
}