package com.bless.leetcode.树;


import java.util.*;

public class 对称二叉树 {
    public static class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 放入所有节点的子节点
            int[] nums = new int[queue.size()];
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    nums[i] = 101;
                    continue;
                }
                nums[i] = node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
            // 遍历当前层的节点，使用双指针判断是否是镜像
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] != nums[right]) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, null, new TreeNode(3));
        root.right = new TreeNode(2, null, new TreeNode(3));
        new 对称二叉树().isSymmetric(root);
    }
}
