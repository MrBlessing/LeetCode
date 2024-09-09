package com.bless.leetcode.树;

public class 二叉树展开为链表 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode index = new TreeNode();

    public void flatten(TreeNode root) {
        TreeNode head = index;
        dfs(root);
        root = head.right;
    }


    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        index.right = new TreeNode(node.val);
        index = index.right;
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(5, null, new TreeNode(6));
        new 二叉树展开为链表().flatten(root);
    }
}
