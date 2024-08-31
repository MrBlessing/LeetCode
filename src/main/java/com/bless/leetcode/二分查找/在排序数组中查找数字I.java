package com.bless.leetcode.二分查找;

public class 在排序数组中查找数字I {

//    public int search(int[] nums, int target) {
//        int res = 0;
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] < target) {
//                left = mid + 1;
//                continue;
//            }
//            if (nums[mid] > target) {
//                right = mid - 1;
//                continue;
//            }
//            // 如果mid位置的数字小于target 则在周围寻找相同的数字
//            if (nums[mid] == target) {
//                for (int i = mid - 1; i >= left && nums[i] == target; i--) {
//                    res++;
//                }
//                for (int i = mid + 1; i <= right && nums[i] == target; i++) {
//                    res++;
//                }
//                return res + 1;
//            }
//
//        }
//        return 0;
//    }


    public static void main(String[] args) {
        int res = new 在排序数组中查找数字I().search(new int[]{5, 7, 7, 8, 8, 10}, 10);
        System.out.println(res);
    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                res = 1;
                // 向左查找有没有相同的数字
                for (int i = mid - 1; nums[i] == target && i >= left; i--) {
                    res++;
                }
                // 向右查找有没有相同的数字
                for (int i = mid + 1; nums[i] == target && i <= right; i++) {
                    res++;
                }
            }
        }
        return res;
    }

}
