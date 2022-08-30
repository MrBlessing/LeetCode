package com.bless.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> cs = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case ')': {
                    if (cs.isEmpty() || cs.pop() != '(') {
                        return false;
                    }
                    break;
                }
                case ']': {
                    if (cs.isEmpty() || cs.pop() != '[') {
                        return false;
                    }
                    break;
                }
                case '}': {
                    if (cs.isEmpty() || cs.pop() != '{') {
                        return false;
                    }
                    break;
                }
                default:
                    cs.push(c);
            }
        }
        return cs.size() == 0;
    }

    public static void main(String[] args) {
        有效的括号 o = new 有效的括号();
        System.out.println(o.isValid("([)]"));
    }
}
