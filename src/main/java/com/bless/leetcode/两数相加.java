package com.bless.leetcode;

public class 两数相加 {
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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n = 0;
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while (n != 0 || (l1 != null && l2 != null)) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = n + v1 + v2;
            n = sum / 10;
            res.next = new ListNode(sum % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            res = res.next;
        }
        res.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a3 = new ListNode(3, null);
        ListNode a2 = new ListNode(4, a3);
        ListNode a1 = new ListNode(2, a2);

        ListNode b3 = new ListNode(4, null);
        ListNode b2 = new ListNode(6, b3);
        ListNode b1 = new ListNode(5, b2);

        两数相加 o = new 两数相加();
        System.out.println(o.addTwoNumbers(a1, b1));
    }
}
