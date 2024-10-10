package com.bless.leetcode.树;

import java.util.*;

/**
 * @author Elvis
 * @since 10/10/2024
 */
public class 二叉树的锯齿形层序遍历 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        int direction = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if(direction == 1) {
                        list.addLast(node.val);
                    }else {
                        list.addFirst(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            direction *= -1;
            res.add(new LinkedList<>(list));
        }
        return res;
    }
}
