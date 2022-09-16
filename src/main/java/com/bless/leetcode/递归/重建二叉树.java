package com.bless.leetcode.递归;

import java.util.HashMap;

public class 重建二叉树 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, Integer> inOrderMap = new HashMap<>();


    // 前序遍历：[根节点,[左子树的前序遍历],[右子树的前序遍历]]
    // 中序遍历：[[左子树的中序遍历],根节点,[右子树的中序遍历]]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 将中序遍历的节点放入到map中，便于查找根节点的位置
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        // 递归重建二叉树
        return dfs(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int preorderStartIndex, int preorderEndIndex, int inorderStartIndex, int inorderEndIndex) {
        if (preorderStartIndex > preorderEndIndex || inorderStartIndex > inorderEndIndex) {
            return null;
        }
        // 前序遍历的第一个节点是根结点
        TreeNode root = new TreeNode(preorder[preorderStartIndex]);
        // 找到中序遍历中节点的位置
        int inorderRootIndex = inOrderMap.get(root.val);
        // 获取左子树和右子树的长度
        int leftTreeLength = inorderRootIndex - inorderStartIndex;
        int rightTreeLength = inorderEndIndex - inorderRootIndex;
        root.left = dfs(preorder, inorder, preorderStartIndex + 1, preorderStartIndex + leftTreeLength, inorderRootIndex - leftTreeLength, inorderRootIndex - 1);
        root.right = dfs(preorder, inorder, preorderEndIndex + 1 - rightTreeLength, preorderEndIndex, inorderRootIndex + 1, inorderRootIndex + rightTreeLength);
        return root;
    }

    public static void main(String[] args) {
        重建二叉树 o = new 重建二叉树();
        o.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
