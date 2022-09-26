package com.bless.leetcode.动态规划;


import java.util.Arrays;

public class n个骰子的点数 {
    public double[] dicesProbability(int n) {
        // best[i][j] 表示i个骰子摇出和为j的概率
        // 这里二维数组的长度取最大可能出现的点数和：骰子数量 * 6
        double[][] best = new double[n + 1][n * 6 + 1];
        // 1个骰子摇出来的6个数概率确定
        for (int i = 1; i <= 6; i++) {
            best[1][i] = 1D / 6D;
        }
        // 动态规划推导公式：best[n][x] = (best[n-1][x-1] + best[n-1][x-2]+ ... + best[n-1][x-6]) * 1/6;
        // best[n-1][x-1]表示第n次骰子摇出点数为1，要想总点数为n，第n-1次投出的点数和必须为x-1的概率。
        // *1/6表示第n次骰子摇出确定点数的概率
        for (int i = 2; i <= n; i++) {
            // i个骰子能摇出的点数和进行遍历
            for (int j = i; j <= i * 6; j++) {
                // 对第i个骰子摇出的点数进行遍历
                for (int k = 1; k <= 6; k++) {
                    if (j - k <= 0) {
                        break;
                    }
                    best[i][j] += best[i - 1][j - k];
                }
                best[i][j] = best[i][j] / 6D;
            }
        }
        return Arrays.copyOfRange(best[n], n, n * 6 + 1);
    }

    public static void main(String[] args) {
        double[] res = new n个骰子的点数().dicesProbability(2);
        System.out.println(res);
    }

}
