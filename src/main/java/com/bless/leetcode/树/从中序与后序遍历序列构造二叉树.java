package com.bless.leetcode.树;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树 {


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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 中序[[左子树]根节点[右子树]]
        // 后序[[左子树][右子树]根节点]
        // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(inorderMap, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode dfs(Map<Integer, Integer> inorderMap, int[] postorder, int inorderStartIndex, int inorderEndIndex, int postorderStartIndex, int postorderEndIndex) {
        if (inorderStartIndex > inorderEndIndex || postorderStartIndex > postorderEndIndex) {
            return null;
        }
        // 后序遍历的最后一个节点就是根节点
        TreeNode root = new TreeNode(postorder[postorderEndIndex]);
        // 中序遍历中根节点的位置
        int inorderRootIndex = inorderMap.get(root.val);
        // 左子树的长度
        int leftTreeLen = inorderRootIndex - inorderStartIndex;
        // 右子树的长度
        int rightTreeLen = inorderEndIndex - inorderRootIndex;
        // 构造左子树
        root.left = dfs(inorderMap, postorder, inorderRootIndex - leftTreeLen, inorderRootIndex - 1, postorderStartIndex, postorderStartIndex + leftTreeLen - 1);
        root.right = dfs(inorderMap, postorder, inorderRootIndex + 1, inorderRootIndex + rightTreeLen, postorderEndIndex - rightTreeLen, postorderEndIndex - 1);
        return root;
    }

    public static void main(String[] args) {
        new 从中序与后序遍历序列构造二叉树().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}
