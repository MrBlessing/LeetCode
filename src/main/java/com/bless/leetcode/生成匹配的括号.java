package com.bless.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 生成匹配的括号 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", 3, 3);
        return result;
    }

    private void dfs(String str, int open, int close) {
        if (open == 0 && close == 0) {
            result.add(str);
            return;
        }
        if(open>close){
            return;
        }
        if (open > 0) {
            dfs(str + '(', open - 1, close);
        }
        if (close > 0)  {
            dfs(str + ')', open, close - 1);
        }
    }

    public static void main(String[] args) {
        生成匹配的括号 o = new 生成匹配的括号();
        System.out.println(o.generateParenthesis(3));
    }
}
