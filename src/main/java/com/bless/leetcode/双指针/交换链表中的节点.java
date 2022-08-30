package com.bless.leetcode.双指针;


import java.util.List;
import java.util.Stack;

public class 交换链表中的节点 {

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

    // 暴力解法
    public ListNode swapNodes(ListNode head, int k) {
        ListNode l1 = null, l2 = null;
        int count = 0;
        ListNode t = head;
        // 找出第k个元素
        while (t != null) {
            count++;
            if (count == k) {
                l1 = t;
            }
            t = t.next;
        }
        // 找出倒数第k个元素
        t = head;
        while (t != null) {
            if (count == k) {
                l2 = t;
            }
            count--;
            t = t.next;
        }
        // 交换节点的值
        int temp = l1.val;
        l1.val = l2.val;
        l2.val = temp;
        return head;
    }

    // 双指针解法
    public ListNode swapNodes1(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        ListNode l1 = null;
        int count = 0;
        while (right != null) {
            count++;
            if (count == k) {
                l1 = right;
            }
            // 左指针跟右指针保持k的距离
            if (count > k) {
                left = left.next;
            }
            right = right.next;
        }
        // 交换节点的值
        int temp = l1.val;
        l1.val = left.val;
        left.val = temp;
        return head;
    }
}
