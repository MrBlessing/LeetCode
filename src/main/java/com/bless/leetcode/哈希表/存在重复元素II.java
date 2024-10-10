package com.bless.leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Elvis
 * @since 10/10/2024
 */
public class 存在重复元素II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
