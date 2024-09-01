package com.bless.leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
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
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            // 排除重复
//            if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
//                continue;
//            }
//            // 如果连续的三个数字之和大于0 则没有进行下去的必要
//            if (i < nums.length - 2 && nums[i] + nums[i + 1] + nums[i + 2] > 0) {
//                break;
//            }
//            // 双指针查找合适的数字
//            for (int j = i,k=nums.length-1; j < k; j++) {
//                // 排除重复
//                if (j != k - 1 && nums[i] == nums[i + 1]) {
//                    continue;
//                }
//                while (j<k&&nums[i]+nums[j]+nums[k]>0){
//                    k--;
//                }
//                if(j>k){
//                    continue;
//                }
//
//            }
//        }
//        return result;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            //去重
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                //去重
                if (left != i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                    left++;
                    continue;
                }
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        三数之和 o = new 三数之和();
        System.out.println(o.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
