//Given an integer array nums, move all 0's to the end of it while maintaining 
//the relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// 
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done?
//
// Related Topics Array Two Pointers 👍 13378 👎 341

package com.harryai.algorithm.leetcode.editor.en;

import java.util.Arrays;

//java:Move Zeroes
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双指针
        // 1. 都指向第一个数字
        // 2. 如果左右指针指向的是0，则左指针保持不动，移动右指针，找非0.
        // 3. 如果左右指针指向的数值不为0，则和左指针交换，两个指针都后移。
        // 4. 循环2~3
        public void moveZeroes(int[] nums) {
            int n = nums.length, l = 0, r = 0;
            while (r < n) {
                if (nums[r] != 0) {
                    int tmp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = tmp;
                    l++;
                }
                r++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
