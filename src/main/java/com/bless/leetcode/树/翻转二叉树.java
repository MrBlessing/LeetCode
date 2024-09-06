package com.bless.leetcode.树;

import java.util.*;

public class 翻转二叉树 {
    public class TreeNode {
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

    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        if (root != null) {
            treeNodes.add(root);
        }
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.remove();
            // 镜像左右的树
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                treeNodes.add(node.left);
            }
            if (node.right != null) {
                treeNodes.add(node.right);
            }
        }
        return root;
    }
}
