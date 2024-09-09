package com.bless.leetcode.树;

public class 路径总和 {

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

    boolean res;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        res = false;
        dfs(root, 0, targetSum);
        return res;
    }

    public void dfs(TreeNode node, int sum, int targetSum) {
        // 到达叶子节点
        if (node == null) {
            return;
        }
        sum += node.val;
        if (node.left == null && node.right == null && sum == targetSum) {
            res = true;
        }
        dfs(node.left, sum , targetSum);
        dfs(node.right, sum , targetSum);
    }


}