package com.bless.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/0on3uN
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 复原IP {

    List<String> ips = new ArrayList<>();

    String[] ipSegment = new String[4];

    String str;

    public List<String> restoreIpAddresses(String s) {
        // ip的长度在4-12之间
        if (s.length() > 12 || s.length() < 4) {
            return new ArrayList<>();
        }
        // 深度遍历
        str = s;
        dfs(0, 0);
        return ips;
    }

    private void dfs(int startPos, int division) {
        if (division == 4) {
            if (startPos == str.length()) {
                ips.add(String.join(".", ipSegment));
            }
            return;
        }

        // 字符串遍历完成 但是没有超过4段
        if (startPos == str.length()) {
            return;
        }

        if (str.charAt(startPos) == '0') {
            ipSegment[division] = "0";
            dfs(startPos + 1, division + 1);
            return;
        }

        int num = 0;
        for (int i = startPos; i < str.length(); i++) {
            num = num * 10 + (str.charAt(i) - '0');
            if (num < 256) {
                ipSegment[division] = String.valueOf(num);
                dfs(i + 1, division + 1);
            }
        }
    }
}

