package com.bless.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class 腐烂的橘子 {

    public int orangesRotting(int[][] grid) {
        // 数组的长宽
        int height = grid.length;
        int length = grid[0].length;
        // 新鲜橘子的个数
        int freshNum = 0;
        // 橘子腐败的时间
        int depth = 0;
        Queue<int[]> queue = new LinkedList<>();
        // 存储所有的腐烂橘子的坐标
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshNum++;
                }
            }
        }
        // 逐层遍历所有的腐烂橘子
        while (!queue.isEmpty() && freshNum > 0) {
            depth++;
            // 腐烂一圈
            for (int len = queue.size(); len > 0; len--) {
                int[] xy = queue.poll();
                int h = xy[0];
                int l = xy[1];
                // 上
                if (h - 1 >= 0 && grid[h - 1][l] == 1) {
                    freshNum--;
                    queue.offer(new int[]{h - 1, l});
                    grid[h - 1][l] = 2;
                }
                // 下
                if (h + 1 < height && grid[h + 1][l] == 1) {
                    freshNum--;
                    queue.offer(new int[]{h + 1, l});
                    grid[h + 1][l] = 2;
                }
                // 左
                if (l - 1 >= 0 && grid[h][l - 1] == 1) {
                    freshNum--;
                    queue.offer(new int[]{h, l - 1});
                    grid[h][l - 1] = 2;
                }
                // 右
                if (l + 1 < length && grid[h][l + 1] == 1) {
                    freshNum--;
                    queue.offer(new int[]{h, l + 1});
                    grid[h][l + 1] = 2;
                }
            }

        }
        return freshNum == 0 ? depth : -1;
    }

    public static void main(String[] args) {
        腐烂的橘子 o = new 腐烂的橘子();
        o.orangesRotting(new int[][]{{0}});
    }
}