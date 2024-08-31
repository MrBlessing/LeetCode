package com.bless.leetcode;

import java.util.ArrayList;

public class 打印从1到最大的n位数 {
    ArrayList<String> res = new ArrayList<>();
    int n;

    public String[] printNumbers(int n) {
        this.n = n;
        dfs(0, "");
        return res.toArray(new String[]{});
    }

    private void dfs(int layer, String num) {
        if (n == layer) {
            if (!"".equals(num)) {
                res.add(num);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            dfs(layer + 1, ("".equals(num) && i == 0) ? "" : num + i);
        }
    }

    public static void main(String[] args) {
        打印从1到最大的n位数 o = new 打印从1到最大的n位数();
        o.printNumbers(3);
    }
}
