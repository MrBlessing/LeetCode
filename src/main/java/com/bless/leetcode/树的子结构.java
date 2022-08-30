package com.bless.leetcode;

public class 树的子结构 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 如果有一个树为null，则A不包含B树
        if (A == null || B == null) {
            return false;
        }
        return isContain(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isContain(TreeNode A, TreeNode B) {
        // B树为null则表示B树比较完成
        if (B == null) {
            return true;
        }
        // B树不为null A树为null 则A树不包含B树
        if (A == null) {
            return false;
        }
        // 节点比较
        if (A.val != B.val) {
            return false;
        }
        return isContain(A.left, B.left) && isContain(A.right, B.right);
    }
}
