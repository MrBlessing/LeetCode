package com.bless.leetcode;

public class 二叉搜索树与双向链表 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node head = new Node(-1);
    private Node list = head;
    private Node pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        // 设置最后一个未完成的节点
        list.right = head.right;
        list.left = pre;
        // 设置第一个节点的前驱节点
        head.right.left = list;
        return head.right;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        // 将当前列表设置为后继
        list.right = root;
        // 将pre节点设置为前驱
        list.left = pre;
        // 保存下一个节点的前驱节点
        pre = list;
        list = root;
        dfs(root.right);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n4.left = n2;
        n4.right = n5;

        n2.left = n1;
        n2.right = n3;

        二叉搜索树与双向链表 o = new 二叉搜索树与双向链表();
        o.treeToDoublyList(n4);
    }
}