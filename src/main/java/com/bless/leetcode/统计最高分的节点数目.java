package com.bless.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 统计最高分的节点数目 {
    // 最大分数
    int maxScore = 0;
    // 最大分数数量
    int maxScoreNum = 0;
    // 子节点列表
    List<Integer>[] child;
    // 节点个数
    int nodeNum = 0;

    public int countHighestScoreNodes(int[] parents) {
        child = new ArrayList[parents.length];
        nodeNum = parents.length;
        // 将父节点列表转换为子节点列表
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] != -1) {
                if (child[parents[i]] == null) {
                    child[parents[i]] = new ArrayList<>();
                }
                child[parents[i]].add(i);
            }
        }
        // 深度遍历所有节点
        dfs(0);
        return maxScoreNum;
    }

    /**
     * 深度遍历所有节点，返回值是子节点大小
     *
     * @param node 节点
     * @return 子节点大小
     */
    private int dfs(int node) {
        List<Integer> nodeChild = child[node];
        // 子节点大小
        int nodeChildSize = 1;
        // 子节点分数
        int nodeChildScore = 1;
        for (int i = 0; nodeChild != null && i < nodeChild.size(); i++) {
            int size = dfs(nodeChild.get(i));
            nodeChildSize += size;
            nodeChildScore *= size;
        }
        if (node != 0) {
            // 乘以除去子节点树之外的树的大小
            nodeChildScore *= nodeNum - nodeChildSize;
        }
        // 判断是否是最大分数
        if (nodeChildScore == maxScore) {
            maxScoreNum++;
        } else if (nodeChildScore > maxScore) {
            maxScore = nodeChildScore;
            maxScoreNum = 1;
        }
        // 返回以当前节点所有叶子节点的大小
        return nodeChildSize;
    }

}
