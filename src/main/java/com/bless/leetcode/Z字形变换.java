package com.bless.leetcode;

import java.util.List;

public class Z字形变换 {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        String[] strings = new String[numRows];
        int index = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            strings[index] = strings[index] == null ? String.valueOf(c) : strings[index] + c;
            if(index == 0 || index == numRows -1) flag = - flag;
            index += flag;
        }
        return String.join("", strings);
    }

    public static void main(String[] args) {
        System.out.println(new Z字形变换().convert("PAYPALISHIRING", 3));
    }
}
