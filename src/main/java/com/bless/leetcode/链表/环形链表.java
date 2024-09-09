package com.bless.leetcode.链表;




public class 环形链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (true) {
            if (head == null) {
                return false;
            }
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            if (low.next == null) {
                return false;
            }
            low = low.next;
            if (low == fast) {
                return true;
            }
        }
    }
}
