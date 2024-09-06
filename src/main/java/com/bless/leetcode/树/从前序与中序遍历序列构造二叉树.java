package com.bless.leetcode.树;

import com.bless.leetcode.递归.重建二叉树;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        // 前序遍历：[根节点,[左子树的前序遍历],[右子树的前序遍历]]
        // 中序遍历：[[左子树的中序遍历],根节点,[右子树的中序遍历]]
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(preorder, inorderMap, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, Map<Integer, Integer> inorderMap, int preorderStartIndex, int preorderEndIndex, int inorderStartIndex, int inorderEndIndex) {
        if (preorderStartIndex > preorderEndIndex || inorderStartIndex > inorderEndIndex) {
            return null;
        }
        // 前序遍历的首个节点就是根节点
        TreeNode root = new TreeNode(preorder[preorderStartIndex]);
        // 在中序遍历中找到根节点的位置
        int inorderRootIndex = inorderMap.get(root.val);
        // 左子树的长度
        int leftTreeLen = inorderRootIndex - inorderStartIndex;
        // 右子树的长度
        int rightTreeLen = inorderEndIndex - inorderRootIndex;
        // 构造左子树
        root.left = dfs(preorder, inorderMap, preorderStartIndex + 1, preorderStartIndex + leftTreeLen , inorderRootIndex - leftTreeLen, inorderRootIndex - 1);
        // 构造右子树
        root.right = dfs(preorder, inorderMap, preorderStartIndex + leftTreeLen + 1, preorderStartIndex + leftTreeLen + rightTreeLen, inorderRootIndex + 1, inorderRootIndex + rightTreeLen);
        return root;
    }

    public static void main(String[] args) {
        从前序与中序遍历序列构造二叉树 o = new 从前序与中序遍历序列构造二叉树();
        o.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
