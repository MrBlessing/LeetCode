package com.bless.leetcode.回溯;

public class 矩阵中的路径 {

    char[][] board;
    String word;
    boolean[][] flag;

    boolean res = false;

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        this.board = board;
        this.word = word;
        this.flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j]) {
                    flag[i][j] = true;
                    dfs(1, i, j);
                    flag[i][j] = false;
                }
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int wordIndex, int row, int col) {
        if (wordIndex == word.length()) {
            res = true;
        }
        // 如果找到单词，跳过后面的遍历
        if (res) {
            return true;
        }
        // 遍历上下左右的点
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] xy : directions) {
            int i = row + xy[0];
            int j = col + xy[1];
            // 边界限定
            if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                // 未访问过该节点
                if (!flag[i][j]) {
                    // 节点值匹配
                    if (word.charAt(wordIndex) == board[i][j]) {
                        flag[row][col] = true;
                        res = dfs(wordIndex + 1, i, j);
                        flag[row][col] = false;
                    }
                }
            }
        }
        return res;
    }

}
// 朴素解法
//class Solution {
//    char[][] board;
//    String word;
//    boolean[][] flag;
//    boolean res = false;
//
//    public boolean exist(char[][] board, String word) {
//        int row = board.length;
//        int col = board[0].length;
//        this.board = board;
//        this.word = word;
//        this.flag = new boolean[row][col];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                // 找到第一个子字母
//                if (word.charAt(0) == board[i][j]) {
//                    flag[i][j] = true;
//                    dfs(1, i, j);
//                    flag[i][j] = false;
//                    if(res){
//                        return true;
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    private void dfs(int wordIndex, int row, int col) {
//        if (wordIndex == word.length()) {
//            res = true;
//        }
//        if (res) {
//            return;
//        }
//        char c = word.charAt(wordIndex);
//        // 上
//        if ((row - 1 >= 0 && c == board[row - 1][col]) && !flag[row - 1][col]) {
//            flag[row - 1][col] = true;
//            dfs(wordIndex + 1, row - 1, col);
//            flag[row - 1][col] = false;
//        }
//        // 下
//        if (row + 1 < board.length && c == board[row + 1][col] && !flag[row + 1][col]) {
//            flag[row + 1][col] = true;
//            dfs(wordIndex + 1, row + 1, col);
//            flag[row + 1][col] = false;
//        }
//        // 左
//        if (col - 1 >= 0 && c == board[row][col - 1] && !flag[row][col - 1]) {
//            flag[row][col - 1] = true;
//            dfs(wordIndex + 1, row, col - 1);
//            flag[row][col - 1] = false;
//        }
//        // 右
//        if (col + 1 < board[0].length && c == board[row][col + 1] && !flag[row][col + 1]) {
//            flag[row][col + 1] = true;
//            dfs(wordIndex + 1, row, col + 1);
//            flag[row][col + 1] = false;
//        }
//    }
//}