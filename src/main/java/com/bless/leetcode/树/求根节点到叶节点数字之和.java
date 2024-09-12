package com.bless.leetcode.树;

import java.util.ArrayList;
import java.util.List;

public class 求根节点到叶节点数字之和 {
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

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        int sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        return sum;
    }

    List<Integer> values = new ArrayList<>();

    private void dfs(TreeNode root, String value) {
        if (root == null) {
            return;
        }
        // 判断是否是叶子节点
        if (root.left == null && root.right == null) {
            values.add(Integer.valueOf(value + root.val));
        } else {
            dfs(root.left, value + root.val);
            dfs(root.right, value + root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        new 求根节点到叶节点数字之和().sumNumbers(treeNode);
    }
}
