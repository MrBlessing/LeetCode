package com.bless.leetcode.贪心算法;

public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        // 过去出现的最低价格
        int minPrice = Integer.MAX_VALUE;
        // 最大收益
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                // 如果今天卖出，收益能否超过最大
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new 股票的最大利润().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
