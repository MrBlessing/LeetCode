package com.bless.leetcode;

import java.util.*;

public class 二叉树每层的最大值 {
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

    /**
     * 广度遍历
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int maxNumPerLayer = Integer.MIN_VALUE;
            for (int n = q.size(); n > 0; n--) {
                TreeNode temp = q.poll();
                maxNumPerLayer = Math.max(temp.val, maxNumPerLayer);
                // 塞入下层的节点
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            res.add(maxNumPerLayer);
        }
        return res;
    }

    // 每层高度和最大值之间的映射
    Map<Integer, Integer> res = new HashMap<>();

    /**
     * 深度遍历
     * 深度遍历的过程中记住树的高度
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root, 0);
        return new ArrayList<>(res.values());
    }

    private void dfs(TreeNode root, int height) {

        if (res.containsKey(height)) {
            res.put(height, Math.max(res.get(height), root.val));
        } else {
            res.put(height, root.val);
        }
        if (root.left != null) {
            dfs(root.left, height + 1);
        }
        if (root.right != null) {
            dfs(root.right, height + 1);
        }
    }
}
