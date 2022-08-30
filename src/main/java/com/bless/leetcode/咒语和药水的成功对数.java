package com.bless.leetcode;

import java.util.Arrays;

public class 咒语和药水的成功对数 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        // 二分法找到最最小满足条件的数字
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if ((long) potions[mid] * (long) spells[i] > success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = potions.length - left - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        咒语和药水的成功对数 o = new 咒语和药水的成功对数();
        System.out.println(o.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7));
    }
}
