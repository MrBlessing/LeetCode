package com.bless.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        List<Integer> rows = new ArrayList<>();
        // 找到target所在的行
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                rows.add(i);
            }
        }
        // 在目标行中通过二分法查找对应的值
        for (int row : rows) {
            int[] temp = matrix[row];
            int left = 0;
            int right = temp.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (temp[mid] == target) {
                    return true;
                }
                if (temp[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    // 线性查找(从右上角开始查找)
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            }
            if (num > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        二维数组中的查找 o = new 二维数组中的查找();
        System.out.println(o.findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
    }
}
