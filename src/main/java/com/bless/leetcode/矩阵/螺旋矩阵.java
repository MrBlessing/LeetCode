package com.bless.leetcode.矩阵;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rc = matrix.length;
        int cc = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int directionNum = 0;
        int[][] directionList = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] verify = new int[rc][cc];
        int row = 0;
        int col = 0;
        for (int i = 0; i < rc * cc; i++) {
            result.add(matrix[row][col]);
            verify[row][col] = 1;
            int[] direction = directionList[directionNum % 4];
            // 验证是否要更新方向
            if (row + direction[0] < 0 || row + direction[0] >= rc || col + direction[1] < 0 || col + direction[1] >= cc || verify[row + direction[0]][col + direction[1]] > 0) {
                directionNum++;
                direction = directionList[directionNum % 4];
            }
            row += direction[0];
            col += direction[1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new 螺旋矩阵().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }


}