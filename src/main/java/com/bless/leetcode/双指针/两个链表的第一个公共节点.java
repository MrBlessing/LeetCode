package com.bless.leetcode.双指针;

import java.util.HashSet;
import java.util.Set;

public class 两个链表的第一个公共节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Hash集合
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!set.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    // 双指针
//    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
//        ListNode n1 = headA;
//        ListNode n2 = headB;
//        while (n1 != n2) {
//            n1 = n1 == null ? headB : n1.next;
//            n2 = n2 == null ? headA : n2.next;
//        }
//        return n1;
//    }

    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }
}
