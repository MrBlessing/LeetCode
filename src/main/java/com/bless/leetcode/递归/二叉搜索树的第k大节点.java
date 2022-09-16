package com.bless.leetcode.递归;

public class 二叉搜索树的第k大节点 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int k = 0;
    Integer res = null;
    boolean isCount = false;
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null || res != null) {
            // 到达最右节点开始计数
            isCount = true;
            return;
        }
        dfs(root.right);
        if (isCount) {
            count++;
        }
        if (count == k) {
            res = root.val;
        }
        dfs(root.left);
    }
}
