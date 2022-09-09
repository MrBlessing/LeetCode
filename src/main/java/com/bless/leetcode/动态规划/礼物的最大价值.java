package com.bless.leetcode.动态规划;

public class 礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] best = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int maxValue = 0;
                // 从上面一个格子下来
                if (i - 1 >= 0) {
                    maxValue = Math.max(best[i - 1][j], maxValue);
                }
                // 从左边的格子过来
                if (j - 1 >= 0) {
                    maxValue = Math.max(best[i][j - 1], maxValue);
                }
                best[i][j] = grid[i][j] + maxValue;
            }
        }
        return best[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        new 礼物的最大价值().maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }
}
