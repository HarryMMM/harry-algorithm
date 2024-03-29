//Given an integer array nums, return true if any value appears at least twice 
//in the array, and return false if every element is distinct. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,1]
//Output: true
// 
// Example 2: 
// Input: nums = [1,2,3,4]
//Output: false
// 
// Example 3: 
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array Hash Table Sorting 👍 8740 👎 1123

package com.harryai.algorithm.leetcode.editor.en;

import java.util.Arrays;

//java:Contains Duplicate
public class P217ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new P217ContainsDuplicate().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }
//        public boolean containsDuplicate(int[] nums) {
//            Set<Integer> set=new HashSet<>();
//            for (int num : nums) {
//                if (set.contains(num)){
//                    return true;
//                }
//                set.add(num);
//            }
//            return false;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
