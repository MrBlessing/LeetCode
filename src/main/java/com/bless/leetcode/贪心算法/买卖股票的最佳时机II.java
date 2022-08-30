package com.bless.leetcode.贪心算法;

public class 买卖股票的最佳时机II {
    // 贪心算法，有上涨就卖出

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i != prices.length - 1 && prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }
}
