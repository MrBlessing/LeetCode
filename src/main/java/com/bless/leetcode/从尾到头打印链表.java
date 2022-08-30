package com.bless.leetcode;

import java.util.Stack;

public class 从尾到头打印链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            s.push(temp.val);
            temp = temp.next;
        }
        int[] res = new int[s.size()];
        for (int i = 0; !s.isEmpty(); i++) {
            res[i] = s.pop();
        }
        return res;
    }
}
