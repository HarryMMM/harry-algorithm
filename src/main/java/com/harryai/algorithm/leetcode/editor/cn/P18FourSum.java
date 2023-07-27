//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1689 👎 0

package com.harryai.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:4Sum
public class P18FourSum {
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{0, 0, 0, 0}, 1));
//        System.out.println(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
//        System.out.println(solution.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }

    /**
     * topic:4Sum
     * Solution number: 1
     * Ideas: 排序后，枚举四元组
     * Problem boundary: 1. 和要在Integer范围内 2. 迭代所有可能 3. nums长度要大于4
     * Problem pattern: 迭代，组合
     * time complexity: O(n^3) n为数组长度, 枚举四元组时间复杂度为O(n^3)，排序复杂度O(n*logn),所以O(n^3+n*logn) -> O(n^3)
     * space complexity O(n)
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return res;
            }
            Arrays.sort(nums);
            int length = nums.length;
            // i < length - 3 是因为后三个数不需要i来枚举
            for (int i = 0; i < length - 3; i++) {
                // 跳过重复
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int a = nums[i];
                // 剪枝：检查最小的四个数相加是否大于target，如果大于，任何四元组都大于直接结束
                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }

                //  剪枝：检查a和最大的3个数相加是否越界，后移第一个数
                if ((long) a + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                // j < length - 2 是因为后2个数不需要j来枚举
                for (int j = i + 1; j < length - 2; j++) {
                    // 跳过重复
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int b = nums[j];
                    // 剪枝：检查最小的四个数相加是否大于target，如果大于，则剩下两个数无论取什么都大于target
                    if ((long) a + b + nums[j + 1] + nums[i + 2] > target) {
                        break;
                    }

                    //  剪枝：检查a、b和最大的2个数相加是否小于target,如果小于则后移b，左移第一个数
                    if ((long) a + b + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    int l = j + 1;
                    int r = length - 1;
                    while (l < length && l < r) {
                        int c = nums[l];
                        int d = nums[r];
                        int sum = a + b + c + d;
                        if (sum == target) {
                            // 添加结果
                            List<Integer> ans = new ArrayList<>();
                            ans.add(a);
                            ans.add(b);
                            ans.add(c);
                            ans.add(d);
                            res.add(ans);
                            // 找到答案后，检查c是否有重复，重复指针后移，避免重复答案
                            while (l + 1 < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            // 找到答案后，检查d是否有重复，重复指针后移，避免重复答案
                            while (r + 1 < length && nums[r] == nums[r + 1]) {
                                r--;
                            }
                            r--;
                            l++;
                            // 因为有排序所以和大，右指针向左
                        } else if (sum > target) {
                            r--;
                            // 因为有排序所以和小，左指针向右
                        } else {
                            l++;
                        }
                    }
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
