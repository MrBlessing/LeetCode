package com.bless.leetcode;

import java.util.Stack;

public class 包含min函数的栈 {
    class MinStack {
        Stack<Integer> s;
        Stack<Integer> minNum;

        public MinStack() {
            s = new Stack<>();
            minNum = new Stack<>();
            minNum.push(Integer.MIN_VALUE);
        }

        public void push(int x) {
            s.push(x);
            minNum.push(Math.min(x, minNum.peek()));
        }

        public void pop() {
            s.pop();
            minNum.pop();
        }

        public int top() {
            return s.peek();
        }

        public int min() {
            return minNum.peek();
        }
    }

}
