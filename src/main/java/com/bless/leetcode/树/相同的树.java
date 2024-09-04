package com.bless.leetcode.树;

public class 相同的树 {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSame = false;
        if (p != null && q != null) {
            isSame = p.val == q.val;
        } else {
            return p == q;
        }
        return isSame && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
