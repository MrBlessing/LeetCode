package com.bless.leetcode;

public class 用Rand7实现Rand10 {
    /**
     * 1   2   3   4   5   6   7
     * 1    1   2   4   4   5   6   7
     * 2    8   9   10  11  12  13  14
     * 3    15  16  17  18  19  20  21
     * 4    22  23  24  25  26  27  28
     * 5    29  30  31  32  33  34  35
     * 6    36  37  38  39  40  *   *
     * 7    *   *   *   *   *   *   *
     *
     * @return
     */
    public int rand10() {
        int n = 0;
        // 为了尽可能减少拒绝的频率，取前40位
        do {
//            int row = rand7();
//            int col = rand7();
//            n = col + (row - 1) * 7;
        } while (n > 40);
        // n的范围是[1-40]
        // (n-1)%10的范围是[0-9]
        return 1 + (n - 1) % 10;
    }
}
