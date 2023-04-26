//Given an integer array nums, handle multiple queries of the following type:
//
//
// Calculate the sum of the elements of nums between indices left and right
//inclusive where left <= right.
//
//
// Implement the NumArray class:
//
//
// NumArray(int[] nums) Initializes the object with the integer array nums.
// int sumRange(int left, int right) Returns the sum of the elements of nums
//between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... +
//nums[right]).
//
//
//
// Example 1:
//
//
//Input
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//Output
//[null, 1, -1, -3]
//
//Explanation
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
//numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
//numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁴
// -10⁵ <= nums[i] <= 10⁵
// 0 <= left <= right < nums.length
// At most 10⁴ calls will be made to sumRange.
//
//
// Related Topics Array Design Prefix Sum 👍 2725 👎 1801

package com.harryai.algorithm.leetcode.editor.en;

//java:Range Sum Query - Immutable
public class P303RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] a = {-2, 0, 3, -5, 2, -1};
        NumArray solution = new P303RangeSumQueryImmutable().new NumArray(a);
        System.out.println(solution.sumRange(0, 2));
        System.out.println(solution.sumRange(2, 5));
        System.out.println(solution.sumRange(0, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        private int[] sums;

        // 前缀和
        public NumArray(int[] nums) {
            sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
//        public NumArray(int[] nums) {
//            this.nums = nums;
//        }
//
//        public int sumRange(int left, int right) {
//            int res = nums[left++];
//            while (left <= right) {
//                res +=(left == right ? nums[left++] : nums[left++] + nums[right--]);
//            }
//            return res;
//        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
