package com.bless.leetcode.递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉搜索树的最近公共祖先 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        // 寻找某个节点的二叉搜索树路径
        List<TreeNode> pathP = getTreePath(root, p.val);
        List<TreeNode> pathQ = getTreePath(root, q.val);
        // 寻找路径中最大序号的公共节点
        for (int i = 0; i < Math.min(pathP.size(), pathQ.size()); i++) {
            if (pathP.get(i).val == pathQ.get(i).val) {
                res = pathP.get(i);
            }
        }
        return res;
    }

    private List<TreeNode> getTreePath(TreeNode root, int target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode temp = root;
        while (temp != null) {
            path.add(temp);
            if (temp.val == target) {
                break;
            } else if (temp.val < target) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return path;
    }

    // 数组转为树
    public TreeNode arrayToTree(Integer[] array) {
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < array.length; i = i + 2) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                if (array[i] != null) {
                    temp.left = new TreeNode(array[i]);
                } else {
                    temp.left = null;
                }
                if (array[i+1] != null) {
                    temp.right = new TreeNode(array[i+1]);
                } else {
                    temp.right = null;
                }
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        二叉搜索树的最近公共祖先 o = new 二叉搜索树的最近公共祖先();
        TreeNode root = o.arrayToTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        o.lowestCommonAncestor(root,root.left,root.left.right);
    }
}
