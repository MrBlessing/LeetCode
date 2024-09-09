package com.bless.leetcode.树;

import java.util.*;

public class 填充每个节点的下一个右侧节点指针II {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        Queue<Node> nodeList = new LinkedList<>();
        if (root != null) {
            nodeList.offer(root);
        }
        while (!nodeList.isEmpty()) {
            Node pre = null;
            int n = nodeList.size();
            // 对当前层序的节点进行处理
            for (int i = 0; i < n; i++) {
                Node cur = nodeList.poll();
                if (cur.left != null) {
                    nodeList.offer(cur.left);
                }
                if (cur.right != null) {
                    nodeList.offer(cur.right);
                }
                if (i != 0) {
                    pre.next = cur;
                }
                pre = cur;
            }
        }
        return root;
    }
}
