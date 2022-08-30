package com.bless.leetcode;

public class 数值的整数次方 {
    public double myPow(double x, int n) {
        return n < 0 ? 1 / pow(x, -n) : pow(x, n);
    }

    private double pow(double x, int n) {
        if(n==0){
            return 1;
        }
        double y = pow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        数值的整数次方 o = new 数值的整数次方();
        System.out.println(o.myPow(2, 5));
    }
}
