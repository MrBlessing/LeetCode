package com.bless.leetcode;

public class 删除链表的节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 删除第一个节点的情况
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode temp = head.next;
        while (temp != null) {
            if (temp.val == val) {
                pre.next = temp.next;
                break;
            }
            pre = temp;
            temp = temp.next;
        }
        return head;
    }
}
