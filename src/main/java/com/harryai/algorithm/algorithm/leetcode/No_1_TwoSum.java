package com.harryai.algorithm.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class No_1_TwoSum {

    public static void main(String[] args) {
        int[] ints = new No_1_TwoSum().twoSum(new int[]{3, 2, 4}, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) { // j要等于i+1,因为不和自己相加。
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    i = len; // 使外层循环也结束
                    break;
                }
            }
        }
        return index;
    }

    // 此方法借助map，来实现。体现了解决问题加中间层的方法。值得学习
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 将数值以key: number  value:index 的方式存入map
        for (int i = 0; i < nums.length; map.put(nums[i], i++))
            // 如果遍历到目标值与当前元素的差值在map中，则将差值的下标从map中去取出，和当前元素的下标一起返回。
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
        return new int[]{0, 0};
    }
}
