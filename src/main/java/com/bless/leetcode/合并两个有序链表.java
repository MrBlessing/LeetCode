package com.bless.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class 合并两个有序链表 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            } else {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
        }
        temp.next = list1 == null ? list2 : list1;
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        }

        list2.next = mergeTwoLists2(list1, list2.next);
        return list2;

    }

    public static void main(String[] args) {
        合并两个有序链表 o = new 合并两个有序链表();
        ListNode a1 = new ListNode(5, null);
        ListNode a2 = new ListNode(3, a1);
        ListNode a3 = new ListNode(1, a2);

        ListNode b1 = new ListNode(6, null);
        ListNode b2 = new ListNode(4, b1);
        ListNode b3 = new ListNode(2, b2);

        ListNode r = o.mergeTwoLists2(a3, b3);
        System.out.println(r);
    }

}
