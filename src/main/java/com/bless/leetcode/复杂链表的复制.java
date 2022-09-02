package com.bless.leetcode;

import java.util.HashMap;

public class 复杂链表的复制 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newNodeHead = new Node(head.val);
        Node temp = newNodeHead;
        // 旧节点和新节点的映射
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, newNodeHead);
        while (head != null) {
            if (head.next != null) {
                // 建立新节点的同时，将新节点和旧节点进行映射
                if (map.containsKey(head.next)) {
                    temp.next = map.get(head.next);
                } else {
                    temp.next = new Node(head.next.val);
                    map.put(head.next, temp.next);
                }
            }
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    temp.random = map.get(head.random);
                } else {
                    temp.random = new Node(head.random.val);
                    map.put(head.random, temp.random);
                }
            }
            head = head.next;
            temp = temp.next;
        }
        return newNodeHead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;

        n2.next = n3;
        n2.random = n1;

        n3.next = n4;
        n3.random = n5;

        n4.next = n5;
        n4.random = n3;

        n5.random = n1;
        new 复杂链表的复制().copyRandomList(n1);
    }
}
