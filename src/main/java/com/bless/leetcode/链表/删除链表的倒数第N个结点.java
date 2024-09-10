package com.bless.leetcode.链表;

public class 删除链表的倒数第N个结点 {

    public class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = new ListNode(0, head);
        ListNode leftNode = head;
        ListNode rightNode = head;
        for (int i = 0; rightNode.next != null; i++) {
            if (i >= n) {
                leftNode = leftNode.next;
            }
            rightNode = rightNode.next;
        }
        if (leftNode.next != null) {
            leftNode.next = leftNode.next.next;
        }
        return head.next;
    }
}
