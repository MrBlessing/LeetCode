package com.bless.leetcode;

public class 圆圈中最后剩下的数字 {
    // 模拟删除法
    public int lastRemaining(int n, int m) {
        boolean[] deleted = new boolean[n];
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            // 找到需要删除的数字
            int size = m;
            int deleteIndex = start;
            while (size != 0) {
                if (!deleted[deleteIndex]) {
                    size--;
                }
                if (size != 0) {
                    deleteIndex = (deleteIndex + 1) % n;
                }
            }
            // 删除掉数字
            deleted[deleteIndex] = true;
            // 找到下次开始的起始点
            start = (deleteIndex + 1) % n;
            while (deleted[start]) {
                start = (start + 1) % n;
            }
        }
        for (int i = 0; i < deleted.length; i++) {
            if (!deleted[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new 圆圈中最后剩下的数字().lastRemaining(9, 3));
    }
}
