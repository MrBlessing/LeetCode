package com.bless.leetcode;

public class 顺时针打印矩阵 {
    /**
     * 固定方向来遍历
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[][] verify = new int[rowNum][colNum];
        int[] res = new int[rowNum * colNum];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curDirection = 0;
        int curRow = 0, curCol = 0;
        for (int i = 0; i < rowNum * colNum; i++) {
            res[i] = matrix[curRow][curCol];
            verify[curRow][curCol] = 1;
            // 计算方向
            int nextRow = curRow + directions[curDirection][0];
            int nextCol = curCol + directions[curDirection][1];
            // 验证方向是否可行
            if (nextRow >= rowNum || nextRow < 0 || nextCol >= colNum || nextCol < 0 || verify[nextRow][nextCol] == 1) {
                curDirection = (curDirection + 1) % 4;
            }
            curRow += directions[curDirection][0];
            curCol += directions[curDirection][1];
        }
        return res;
    }

    /**
     * @param matrix
     * @return
     */
    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[] res = new int[rowNum * colNum];
        int resIndex = 0;
        // 左上角坐标 
        int[] upperLeft = {0, 0};
        // 右下角坐标
        int[] lowerRight = {rowNum - 1, colNum - 1};
        // 顺时针遍历数组
        while (true) {
            // 向右走
            for (int col = upperLeft[1]; col <= lowerRight[1]; col++) {
                res[resIndex] = matrix[upperLeft[0]][col];
                resIndex++;
            }
            // 向下走
            for (int row = upperLeft[0] + 1; row <= lowerRight[0]; row++) {
                res[resIndex] = matrix[row][lowerRight[1]];
                resIndex++;
            }
            // 不在同一行才可以往左走
            if (upperLeft[0] < lowerRight[0]) {
                // 向左走
                for (int col = lowerRight[1] - 1; col >= upperLeft[1]; col--) {
                    res[resIndex] = matrix[lowerRight[0]][col];
                    resIndex++;
                }
            }
            // 不在同一列才可以往上走
            if (upperLeft[1] < lowerRight[1]) {
                // 向上走
                for (int row = lowerRight[0] - 1; row > upperLeft[1]; row--) {
                    res[resIndex] = matrix[row][upperLeft[1]];
                    resIndex++;
                }
            }

            // 移动左上角和右下角的位置
            upperLeft[0]++;
            upperLeft[1]++;
            lowerRight[0]--;
            lowerRight[1]--;
            // 如果左上角和右下角的位置不合理表示顺时针遍历完成
            if (upperLeft[0] > lowerRight[0] || upperLeft[1] > lowerRight[1]) {
                return res;
            }
        }
    }

    public static void main(String[] args) {
        顺时针打印矩阵 o = new 顺时针打印矩阵();
        System.out.println(o.spiralOrder2(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

}