//Given an array nums of size n, return the majority element. 
//
// The majority element is the element that appears more than ⌊n / 2⌋ times. 
//You may assume that the majority element always exists in the array. 
//
// 
// Example 1: 
// Input: nums = [3,2,3]
//Output: 3
// 
// Example 2: 
// Input: nums = [2,2,1,1,1,2,2]
//Output: 2
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//Follow-up: Could you solve the problem in linear time and in 
//O(1) space?
//
// Related Topics Array Hash Table Divide and Conquer Sorting Counting 👍 14069 
//👎 435

package com.harryai.algorithm.leetcode.editor.en;

import java.util.Arrays;

//java:Majority Element
public class P169MajorityElement {
    public static void main(String[] args) {
        Solution solution = new P169MajorityElement().new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int maxCount = 1;
            int maxNumber = nums[0];
            int curCount = 1;
            int curNum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 遍历到的数字不是正在计数的数字
                if (nums[i] != curNum) {
                    // 重置计数
                    curCount = 1;
                    curNum = nums[i];
                } else {
                    curCount++;
                }
                // 比较下正在计数的数字的数量是否比之前记录的数字数量大
                if (curCount > maxCount) {
                    maxCount = curCount;
                    maxNumber = curNum;
                }
            }
            return maxNumber;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
