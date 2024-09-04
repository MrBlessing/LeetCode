package com.bless.leetcode.矩阵;

public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int[] zeroRow = new int[matrix.length];
        int[] zeroCol = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow[i] = 1;
                    zeroCol[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroRow[i] == 1 || zeroCol[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
