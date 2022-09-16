package com.bless.leetcode.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 组合总和 {

    int[] candidates;
    int target;
    List<List<Integer>> res;
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        this.res = new LinkedList<>();
        if (candidates == null || candidates.length < 1) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(0, 0);
        return res;
    }

    private void dfs(int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            dfs(i, sum + candidates[i]);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        组合总和 o = new 组合总和();
        System.out.println(o.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}