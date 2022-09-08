package com.bless.leetcode;

public class 把数组排成最小的数 {
    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : nums) {
            stringBuilder.append(n);
        }
        return stringBuilder.toString();
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        while (l < r) {
            // 右侧指针先跑
            while (l < r && (nums[r] + String.valueOf(nums[left])).compareTo(String.valueOf(nums[left]) + nums[r]) >= 0) {
                r--;
            }
            // 左侧指针
            while (l < r && (nums[l] + String.valueOf(nums[left])).compareTo(String.valueOf(nums[left]) + nums[l]) <= 0) {
                l++;
            }
            // 左右交换位置
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        // l == r 将基准值和中间值互换
        int temp = nums[left];
        nums[left] = nums[l];
        nums[l] = temp;
        quickSort(nums, left, l - 1);
        quickSort(nums, r + 1, right);
    }

    public static void main(String[] args) {
        把数组排成最小的数 o = new 把数组排成最小的数();
        System.out.println(o.minNumber(new int[]{1,1,1}));
    }
}
