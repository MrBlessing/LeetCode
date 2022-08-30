package com.bless.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 将字符串拆分为若干长度为k的组 {
    public String[] divideString(String s, int k, char fill) {
        // 计算分组的数量
        int count = s.length() % k == 0 ? s.length() / k : s.length() / k + 1;
        String[] res = new String[count];
        for (int i = 0; i < count; i++) {
            if ((i + 1) * k > s.length()) {
                res[i] = s.substring(i * k);
                // 填充字段
                for (int j = res[i].length(); j < k; j++) {
                    res[i] += fill;
                }
            } else {
                res[i] = s.substring(i * k, Math.min(s.length(), (i + 1) * k));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        将字符串拆分为若干长度为k的组 o = new 将字符串拆分为若干长度为k的组();
        o.divideString("abcdefghi", 4, 'x');
    }
}
