package com.bless.leetcode.递归;

public class 二叉搜索树的后序遍历序列 {
    // 后序遍历：[[左子树],[右子树],根节点]
    // 二叉搜索树: 左子树 < 根节点 < 右子树
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        // 根节点的位置
        int root = j;
        // 统计左子树的结束位置
        int left = i;
        while (postorder[left] < postorder[root]) left++;
        // 统计右子树的结束位置
        int right = left;
        while (postorder[right] > postorder[root]) right++;
        return right == root && verify(postorder, i, left - 1) && verify(postorder, left, right - 1);
    }
}
