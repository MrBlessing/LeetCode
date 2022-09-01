package com.bless.leetcode.递归;

import java.util.ArrayList;
import java.util.List;


public class 二叉树中和为某一值的路径 {
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

    private final List<List<Integer>> res = new ArrayList<>();
    private final List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root != null) {
            dfs(root, 0, target);
        }
        return res;
    }

    private void dfs(TreeNode root, int sum, int target) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (sum + root.val == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
        }
        // 遍历左子树
        dfs(root.left, sum + root.val, target);
        // 遍历右子树
        dfs(root.right, sum + root.val, target);
        temp.remove(temp.size() - 1);
    }

//    public List<List<Integer>> pathSum(TreeNode root, int target) {
//        if (root != null) {
//            temp.add(root.val);
//            dfs(root, root.val, target);
//        }
//        return res;
//    }
//    private void dfs(TreeNode root, int sum, int target) {
//        if (root.left== null && root.right== null && sum == target) {
//            res.add(new ArrayList<>(temp));
//            return;
//        }
//        // 遍历左子树
//        if (root.left != null) {
//            temp.add(root.left.val);
//            dfs(root.left, sum + root.left.val, target);
//            temp.remove(temp.size() - 1);
//        }
//        // 遍历右子树
//        if (root.right != null) {
//            temp.add(root.right.val);
//            dfs(root.right, sum + root.right.val, target);
//            temp.remove(temp.size() - 1);
//        }
//    }
}
