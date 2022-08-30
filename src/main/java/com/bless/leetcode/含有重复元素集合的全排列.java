package com.bless.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 含有重复元素集合的全排列 {

    //
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int[] verify;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        verify = new int[nums.length];
        dfs();
        return res;
    }

    private void dfs() {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && verify[i - 1] == 1) {
                break;
            }
            if (verify[i] == 0) {
                temp.add(nums[i]);
                verify[i] = 1;
                dfs();
                verify[i] = 0;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        含有重复元素集合的全排列 o = new 含有重复元素集合的全排列();
        System.out.println(o.permuteUnique(new int[]{1, 1, 1}));
    }
}
