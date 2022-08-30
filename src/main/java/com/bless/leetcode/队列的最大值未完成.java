package com.bless.leetcode;

public class 队列的最大值未完成 {
    static class MaxQueue {

        // 存储数据的数组
        int[] values = new int[10000];
        // 存储数组的起始位置和结束位置
        int start = 0;
        int end = 0;
        // 存储的最大值
        int maxValue = Integer.MIN_VALUE;

        public MaxQueue() {

        }

        public int max_value() {
            // 如果是最大值被删掉的情况,需要重新找到最大值
            if (start < end) {
                if (maxValue == Integer.MIN_VALUE) {
                    for (int i = start; i < end; i++) {
                        maxValue = Math.max(maxValue, values[i]);
                    }
                }
                return maxValue;
            }
            return -1;
        }

        public void push_back(int value) {
            values[end++] = value;
            maxValue = Math.max(value, maxValue);
        }

        public int pop_front() {
            if (start < end) {
                int t = values[start++];
                if (maxValue == t) {
                    maxValue = Integer.MIN_VALUE;
                }
                return t;
            }
            return -1;
        }
    }
}
