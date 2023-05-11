//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 5932 👎 0

package com.harryai.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 先确定firstNumb和secondNum,再确定thirdNum。secondNum和thirdNum使用双指针确定
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            // 确定firstNum
            for (int firstIdx = 0; firstIdx < n; firstIdx++) {
                int firstNum = nums[firstIdx];
                // 如果和上一个数有重复，就不用再找了。
                if (firstIdx != 0 && firstNum == nums[firstIdx - 1]) {
                    continue;
                }
                int twoSumTarget = -firstNum;
                // 确定第二个数
                for (int secondIdx = firstIdx + 1, thirdIdx = n - 1; secondIdx < n; secondIdx++) {
                    int secondNum = nums[secondIdx];
                    if (secondIdx != firstIdx + 1 && secondNum == nums[secondIdx - 1]) {
                        continue;
                    }
                    // 第三个数加第二个数如果过大，则
                    while (secondIdx < thirdIdx && secondNum + nums[thirdIdx] > twoSumTarget) {
                        thirdIdx--;
                    }
                    // 指针重合，结束
                    if (secondIdx == thirdIdx) {
                        break;
                    }
                    // 相等，加入结果
                    if (secondNum + nums[thirdIdx] == twoSumTarget) {
                        List<Integer> sub = new ArrayList<>();
                        sub.add(firstNum);
                        sub.add(secondNum);
                        sub.add(nums[thirdIdx]);
                        res.add(sub);
                    }
                }
            }
            return res;
        }
        // 三数之和简化为二数之和
//        public List<List<Integer>> threeSum(int[] nums) {
//            Arrays.sort(nums);
//            int n = nums.length;
//            List<List<Integer>> res = new ArrayList<>();
//            for (int firstIdx = 0; firstIdx < n; firstIdx++) {
//                int firstNum = nums[firstIdx];
//                // 如果和上一个数有重复，就不用再找了。
//                if (firstIdx != 0 && firstNum == nums[firstIdx - 1]) {
//                    continue;
//                }
//                int twoSumTarget = -firstNum;
//                //
//                int secondIdx = firstIdx + 1, thirdIdx = n-1;
//                while (secondIdx < thirdIdx) {
//                    int secondNum = nums[secondIdx];
//                    int thirdNum = nums[thirdIdx];
//                    int twoSum = secondNum + thirdNum;
//                    // 如果和目标值相同,记录
//                    if (twoSum == twoSumTarget) {
//                        List<Integer> sub = new ArrayList<>();
//                        sub.add(firstNum);
//                        sub.add(secondNum);
//                        sub.add(thirdNum);
//                        res.add(sub);
//                        // 跳过重复的第二个数
//                        while (secondIdx < thirdIdx && nums[secondIdx] == nums[secondIdx + 1]) {
//                            secondIdx++;
//                        }
//
//                        // 跳过重复的第三个数
//                        while (secondIdx < thirdIdx && nums[thirdIdx] == nums[thirdIdx - 1]) {
//                            thirdIdx--;
//                        }
//                        // 继续看下一组是否满足
//                        secondIdx++;
//                        thirdIdx--;
//
//                    } else if (twoSum > twoSumTarget) { // 如何两数之和大于目标值，由于数组有序，第三个数需要变小
//                        thirdIdx--;
//                    } else { // 如何两数之和小于目标值，由于数组有序，第二个数需要变大
//                        secondIdx++;
//                    }
//                }
//            }
//            return res;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
