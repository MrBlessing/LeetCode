package com.bless.leetcode.哈希表;

import java.util.*;

/**
 * @author Elvis
 * @since 10/10/2024
 */
public class 最长连续序列 {
    // 复杂度nlogn 不符合题目
//    public int longestConsecutive(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        Arrays.sort(nums);
//        int maxLen = 1;
//        int len = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i - 1] + 1 == nums[i]) {
//                len = len + 1;
//                maxLen = Math.max(maxLen, len);
//            } else if (nums[i - 1] + 1 != nums[i]) {
//                len = 1;
//            }
//        }
//        return maxLen;
//    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int len = 1;
                for (int i = 1; set.contains(num + i); i++) {
                    len += 1;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        new 最长连续序列().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    }
}
