package com.bless.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 峰与谷 {
    public void wiggleSort(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int left = 0, right = nums.length - 1; left <= right; left++, right--) {
            res.add(nums[right]);
            if (left != right) {
                res.add(nums[left]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res.get(i);
        }
    }

    public static void main(String[] args) {
        峰与谷 o = new 峰与谷();
        int[] temp = new int[]{5, 3, 1, 2, 3};
        o.wiggleSort(temp);
        System.out.println();
    }
}
