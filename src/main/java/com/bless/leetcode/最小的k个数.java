package com.bless.leetcode;

import java.util.PriorityQueue;

public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        // 大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        // 将后面的数字放入堆中
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                // 将前k个数字放入大顶堆中
                priorityQueue.offer(arr[i]);
            } else {
                // 将后面的数字有选择性的放入到堆中
                if (arr[i] < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(arr[i]);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}
