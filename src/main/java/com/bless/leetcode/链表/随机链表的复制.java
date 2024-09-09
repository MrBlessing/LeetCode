package com.bless.leetcode.链表;

import java.util.HashMap;
import java.util.Map;

public class 随机链表的复制 {
    class Node {
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
        Map<Node, Integer> map1 = new HashMap<>();
        Map<Integer, Node> map2 = new HashMap<>();
        Node res = new Node(0);
        Node resHead = res;
        // 先复制主链表
        Node temp = head;
        for (int i = 0; temp != null; i++) {
            map1.put(temp, i);
            res.next = new Node(temp.val);
            map2.put(i, res.next);
            temp = temp.next;
            res = res.next;
        }
        // 复制随机节点
        temp = head;
        res = resHead.next;
        while (temp != null) {
            if (temp.random != null) {
                int index = map1.get(temp.random);
                res.random = map2.get(index);
            }
            temp = temp.next;
            res = res.next;
        }
        return resHead.next;
    }
}
