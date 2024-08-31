package com.bless.leetcode.二分查找;

public class 旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    // 二分法找到转折点
    public int minArray2(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right -= 1;
            }
        }
        return numbers[right];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 37; j++) {
                System.out.printf("%-3d ",(int) (Math.random() * 30)+30);
            }
            System.out.println();
        }
    }
}
