package com.bless.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 对称二叉树 {

    // Definition for a binary tree node.
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

    // 层序遍历
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (t == null) {
                    nums[i] = 101;
                    continue;
                }
                nums[i] = t.val;
                queue.offer(t.left);
                queue.offer(t.right);
            }
            // 比较是否是回文
            for (int left = 0, right = size - 1; left < right; left--, right++) {
                if (nums[left] != nums[right]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 递归
    public boolean isSymmetric2(TreeNode root) {
        dfs(root.left, root.right);
        return true;
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val &&
                dfs(left.left, right.right) &&
                dfs(left.right, right.left);
    }
}
