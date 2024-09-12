package com.bless.leetcode.链表;

public class 旋转链表 {

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

    public ListNode rotateRight(ListNode head, int k) {
        // 计算链表的长度
        ListNode index = head;
        int count = 0;
        while (index != null) {
            count++;
            index = index.next;
        }
        if(count==0){
            return head;
        }
        // 双指针找到需要处理的位置
        head = new ListNode(0, head);
        ListNode left = head.next;
        ListNode right = head.next;
        // 让right先跑k%count个节点
        for (int i = 0; i < k % count; i++) {
            right = right.next;
        }
        while (right.next != null) {
            // right 和 left指针一起跑
            right = right.next;
            left = left.next;
        }
        // 开始处理旋转操作
        right.next = head.next;
        head.next = left.next;
        left.next = null;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new 旋转链表().rotateRight(head, 2);
    }
}
