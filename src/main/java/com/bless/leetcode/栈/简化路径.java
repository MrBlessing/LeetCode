package com.bless.leetcode.栈;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class 简化路径 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] list = path.split("/");
        for (String s : list) {
            if (s.isEmpty() || ".".equals(s)) {
                continue;
            } else if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        System.out.println(new 简化路径().simplifyPath("/home//foo"));
    }
}
