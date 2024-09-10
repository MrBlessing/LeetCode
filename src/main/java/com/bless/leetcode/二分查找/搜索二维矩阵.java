package com.bless.leetcode.二分查找;

public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 先在第一列中进行二分查找
        int left = 0;
        int right = matrix.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 在left-1的行中进行筛选
        if (right < 0) {
            return false;
        }
        int row = left - 1;
        left = 0;
        right = matrix[row].length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
