package com.bless.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 丑数 {
    public int nthUglyNumber(int n) {
        // 去重
        Set<Long> set = new HashSet<>();
        // 小顶堆排序丑数
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);
        long cur = 0L;
        for (int i = 0; i < n; i++) {
            cur = queue.poll();
            for (int j : new int[]{2, 3, 5}) {
                // 如果不存在该数，则加入小堆顶
                if (set.add(j * cur)) {
                    queue.offer(j * cur);
                }
            }
        }
        return (int)cur;
    }
}
