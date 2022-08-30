package com.bless.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 排除重复
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // 如果连续的三个数字之和大于0 则没有进行下去的必要了
            if (nums.length - i > 2 && nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            for (int j = i + 1, k = nums.length - 1; j < nums.length && k > j; j++) {
                // 排除重复
                if (j != i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                // 找到k值的合适位置
                while (nums[i] + nums[j] + nums[k] > 0 && k > j) {
                    k--;
                }
                if (k <= j) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        三数之和 o = new 三数之和();
        System.out.println(o.threeSum(new int[]{1, 2, -2, -1}));
    }
}
