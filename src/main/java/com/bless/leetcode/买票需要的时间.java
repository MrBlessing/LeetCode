package com.bless.leetcode;

public class 买票需要的时间 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        for (int i = 0; i < tickets.length; i++) {
            // 第k个人前面最多买tickets[k]张票
            if (i < k) {
                res += Math.min(tickets[i], tickets[k]);
            }
            // 第k个人前面最多买tickets[k]-1张票
            if (i > k) {
                res += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return res + tickets[k];
    }
}
