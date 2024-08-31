package com.bless.leetcode.二分查找;

import java.util.Arrays;
import java.util.Map;

public class 狒狒吃香蕉 {
//    public int minEatingSpeed(int[] piles, int h) {
//        int res = 0;
//        // 吃香蕉最大速度边界
//        int right = 1;
//        for (int n : piles) {
//            right = Math.max(right, n);
//        }
//        // 吃香蕉最小速度边界
//        int left = 1;
//        // 二分法寻找合适的速度
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            // 计算该速度下吃完香蕉需要花费的时间
//            int costTime = getCostTime(piles, mid);
//            // 吃香蕉超时
//            if (costTime > h) {
//                left = mid + 1;
//            } else {
//                // 速度在允许的范围内
//                // 因为mid符合题目要求的速度，所以不进行减一操作
//                right = mid;
//                res = mid;
//            }
//        }
//        return res == 0 ? left : res;
//    }
//
//    private int getCostTime(int[] piles, int speed) {
//        int costTime = 0;
//        for (int n : piles) {
//            costTime += n / speed + (n % speed == 0 ? 0 : 1);
//        }
//        return costTime;
//    }

    public static void main(String[] args) {
        狒狒吃香蕉 o = new 狒狒吃香蕉();
        System.out.println(o.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 0;
        int maxSpeed = 0;
        int bestSpeed = 0;
        for (int i : piles) {
            maxSpeed = Math.max(i, maxSpeed);
        }
        // 二分法查找最合适的速度
        while (minSpeed < maxSpeed) {
            bestSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
            // 计算吃完香蕉需要的时间
            int costTime = getCostTime(piles, bestSpeed);
            if (costTime > 5) {
                minSpeed = bestSpeed + 1;
            } else {
                maxSpeed = bestSpeed;
            }
        }
        return bestSpeed;
    }

    private int getCostTime(int[] piles, int speed) {
        int costTime = 0;
        for (int count : piles) {
            costTime += count % speed == 0 ? count / speed : count / speed + 1;
        }
        return costTime;
    }
}
