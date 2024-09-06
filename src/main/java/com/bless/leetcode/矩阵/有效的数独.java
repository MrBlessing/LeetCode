package com.bless.leetcode.矩阵;

public class 有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] miniSudoku = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    row[i][index]++;
                    col[j][index]++;
                    miniSudoku[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || col[j][index] > 1 || miniSudoku[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
