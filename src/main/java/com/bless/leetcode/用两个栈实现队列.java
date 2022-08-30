package com.bless.leetcode;

import java.util.Stack;

public class 用两个栈实现队列 {
    class CQueue {

        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();


        public CQueue() {

        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.isEmpty() ? -1 : out.pop();
        }
    }
}
