package com.bless.leetcode.区间;

import java.util.ArrayList;
import java.util.List;

public class 汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            StringBuffer range = new StringBuffer(Integer.toString(nums[i]));
            // 寻找不连续的数字
            boolean change = i < nums.length - 1 && nums[i + 1] - nums[i] == 1;
            while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            if (change) {
                range.append("->");
                range.append(nums[i]);
            }
            ranges.add(range.toString());
        }
        return ranges;
    }
}
