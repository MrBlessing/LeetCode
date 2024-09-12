package com.bless.leetcode.链表;

public class 删除排序链表中的重复元素II {

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode index = head;
        int repeatValue = -101;
        // 给头节点加上一个虚假的头
        head = new ListNode(-101, head);
        ListNode pre = head;
        while (index != null) {
            // 判断是否有重复值
            if (index.next != null && index.val == index.next.val) {
                repeatValue = index.val;
            }
            // 判断该节点是否删除
            if (index.val == repeatValue) {
                pre.next = index.next;
            } else {
                pre = index;
            }
            // 进入下一个节点
            index = index.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        new 删除排序链表中的重复元素II().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))));
    }
}
//
//
//1 2 3 3 4 4 5
