package com.bless.leetcode.双指针;

public class 调整数组顺序使奇数位于偶数前面 {

    //  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
    //  并保证奇数和奇数，偶数和偶数之间的相对位置不变。
//    public int[] exchange(int[] nums) {
//        int[] res = new int[nums.length];
//        int left = 0;
//        int right = nums.length - 1;
//        for (int n : nums) {
//            if (n % 2 == 0) {
//                res[right] = n;
//                right--;
//            } else {
//                res[left] = n;
//                left++;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] nums = new 调整数组顺序使奇数位于偶数前面().exchange(new int[]{1, 2, 3, 4, 5});
        System.out.println(nums);
    }

    public int[] exchange(int[] nums) {
        int[] newNums = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            //从左扫描奇数
            if (nums[i] % 2 != 0) {
                newNums[left] = nums[i];
                left++;
            }
            // 从右扫描偶数
            if (nums[nums.length - 1 - i] % 2 == 0) {
                newNums[right] = nums[nums.length - 1 - i];
                right--;
            }
        }
        return newNums;
    }


}
