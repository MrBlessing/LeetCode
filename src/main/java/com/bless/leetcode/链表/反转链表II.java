package com.bless.leetcode.链表;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 反转链表II {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >= right) return head;
        Stack<ListNode> stack = new Stack<>();
        // 临时的头节点
        head = new ListNode(0, head);
        ListNode pre = head;
        ListNode index = head.next;
        for (int i = 1; i <= right; i++) {
            if (i < left) {
                pre = index;
            } else {
                stack.push(index);
            }
            index = index.next;
        }
        // 将原先的节点倒转放回
        while (!stack.isEmpty()) {
            pre.next = stack.pop();
            pre = pre.next;
        }
        pre.next = index;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2));
        new 反转链表II().reverseBetween(root, 1, 2);
    }
}
