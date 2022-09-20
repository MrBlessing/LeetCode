package com.bless.leetcode.二进制操作;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class 数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        // 将所有数字进行异或处理 1异或1=0 0异或0=0 0异或1=1
        // 异或后的结果等于数据中两个不同数字异或后的结果
        // 0不影响异或后的结果
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        // 找出ret二进制中包含1的一个位置
        int m = 1;
        while ((m & ret) == 0) {
            // m向左移一位
            m = m << 1;
        }
        // ret中包含1，说明两个不相同的数xy必定在这一个位置上二进制不同
        // 可以根据这一个位置的不同来分组
        int x = 0, y = 0;
        for (int n : nums) {
            if ((n & m) == 0) {
                x ^= n;
            } else {
                y ^= n;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        System.out.println(2 << 2);
    }
}
