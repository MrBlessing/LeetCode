package com.bless.leetcode;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            s.push(num);
            // 栈第一个数字是否是与弹出序列第一个数字匹配
            while (!s.isEmpty() && s.peek() == popped[i]) {
                s.pop();
                i++;
            }
        }
        return s.isEmpty();
    }
}