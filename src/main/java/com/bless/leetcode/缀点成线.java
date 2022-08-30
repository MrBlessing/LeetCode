package com.bless.leetcode;

public class 缀点成线 {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int i = 1; i < coordinates.length; i++) {
            // 根据斜率公式推导: (x2-x1)/(y2-y1) = (xn-x1)/(yn-y1) ==>
            // (x2-x1)*(yn-y1) = (y2-y1)*(xn-x1)
            if ((x2 - x1) * (coordinates[i][1] - y1) != (y2 - y1) * (coordinates[i][0] - x1)) {
                return false;
            }
        }
        return true;
    }
}
