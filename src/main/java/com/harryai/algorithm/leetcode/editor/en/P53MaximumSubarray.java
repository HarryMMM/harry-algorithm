//Given an integer array nums, find the contiguous subarray (containing at 
//least one number) which has the largest sum and return its sum. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another 
//solution using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 👍 20422 👎 1001

package com.harryai.algorithm.leetcode.editor.en;

//java:Maximum Subarray
public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {1, 2, -1, 4, -10};
        int[] nums = {-4, 1, 4};
//        System.out.println(solution.maxSubArray(null));
//        System.out.println(solution.maxSubArray(new int[]{2}));
        System.out.println(solution.maxSubArray(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            // please see : https://blog.csdn.net/linhuanmars/article/details/21314059
//            int res = Integer.MIN_VALUE, curSum = 0;
//            for (int num : nums) {
//                // 比较 当前sum与数组当前数的和curSum 及 数组当前的数num 大小。
//                // 如果num大，抛弃子数组之和curSum，以num为子数组第一个数字
//                curSum = Math.max(curSum + num, num);
//                // 比较当前总和，如果当前总和小于原结果，保留原结果，否则使用新结果（旧子数组之和或者新子数组）
//                res = Math.max(res, curSum);
//            }
//            return res;

            if (nums == null) {
                return 0;
            }
            int sum = Integer.MIN_VALUE, subSum = 0;
            for (int num : nums) {
                subSum += num;
                // 如果之前都是负数，可能相加小于num。即子
                if (subSum < num) {
                    subSum = num;
                }
                sum = Math.max(subSum, sum);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//public class Solution {
//    public int maxSubArray(int[] nums) {
//        if (nums.length == 0) return 0;
//        return helper(nums, 0, nums.length - 1);
//    }
//    public int helper(int[] nums, int left, int right) {
//        if (left >= right) return nums[left];
//        int mid = left + (right - left) / 2;
//        int lmax = helper(nums, left, mid - 1);
//        int rmax = helper(nums, mid + 1, right);
//        int mmax = nums[mid], t = mmax;
//        for (int i = mid - 1; i >= left; --i) {
//            t += nums[i];
//            mmax = Math.max(mmax, t);
//        }
//        t = mmax;
//        for (int i = mid + 1; i <= right; ++i) {
//            t += nums[i];
//            mmax = Math.max(mmax, t);
//        }
//        return Math.max(mmax, Math.max(lmax, rmax));
//    }
//}