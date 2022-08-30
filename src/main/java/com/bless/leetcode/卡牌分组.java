package com.bless.leetcode;

import java.util.HashMap;

public class 卡牌分组 {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : deck) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        // max和min存在非1的最大公约数
        int pre = 0;
        for (int t : map.values()) {
            if (pre == 0) {
                pre = t;
                continue;
            }
            pre = gcd(t, pre);
        }
        return pre > 1;
    }

    // 计算最大公约数
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        卡牌分组 o = new 卡牌分组();
        System.out.println(o.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
    }
}