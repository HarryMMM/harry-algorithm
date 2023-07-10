//Given an integer array nums of length n and an integer target, find three 
//integers in nums such that the sum is closest to target. 
//
// Return the sum of the three integers. 
//
// You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 500 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1385 👎 0

package com.harryai.algorithm.leetcode.editor.cn;

import java.util.Arrays;

//java:3Sum Closest
public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
//        int[] nums = {-100, -98, -2, -1};
        int[] nums = {0, 1, 2};
        System.out.println(solution.threeSumClosest(nums, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int res = Integer.MAX_VALUE;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];
                int pb = i + 1;
                int pc = nums.length - 1;
                while (pb < pc) {
                    int b = nums[pb];
                    int c = nums[pc];
                    int sum = a + b + c;
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                    if (sum == target) {
                        return sum;
                    } else if (sum >= target) {
                        int pc0 = pc - 1;
                        // 跳过重复
                        while (pb < pc0 && nums[pc0] == nums[pc]) {
                            pc0--;
                        }
                        pc = pc0;
                    } else {
                        int pb0 = pb + 1;
                        // 跳过重复
                        while (pb0 < pc && nums[pb0] == nums[pb]) {
                            pb0++;
                        }
                        pb = pb0;
                    }
                }
            }
            return res;
        }
    }
//    class Solution {
//        public int threeSumClosest(int[] nums, int target) {
//            int diff = Integer.MAX_VALUE;
//            int res = Integer.MAX_VALUE;
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    for (int x = j + 1; x < nums.length; x++) {
//                        int newRes = nums[i] + nums[j] + nums[x];
//                        int newDiff = Math.abs(newRes - target);
//                        if (newDiff < diff) {
//                            diff =newDiff;
//                            res = newRes;
//                        }
//                    }
//                }
//            }
//            return res;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}
