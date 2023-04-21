//Given an array nums containing n distinct numbers in the range [0, n], return 
//the only number in the range that is missing from the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,0,1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range 
//[0,3]. 2 is the missing number in the range since it does not appear in nums.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1]
//Output: 2
//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range 
//[0,2]. 2 is the missing number in the range since it does not appear in nums.
// 
//
// Example 3: 
//
// 
//Input: nums = [9,6,4,2,3,5,7,0,1]
//Output: 8
//Explanation: n = 9 since there are 9 numbers, so all numbers are in the range 
//[0,9]. 8 is the missing number in the range since it does not appear in nums.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁴ 
// 0 <= nums[i] <= n 
// All the numbers of nums are unique. 
// 
//
// 
// Follow up: Could you implement a solution using only O(1) extra space 
//complexity and O(n) runtime complexity? 
//
// Related Topics Array Hash Table Math Binary Search Bit Manipulation Sorting ?
//? 9215 👎 3091

package com.harryai.algorithm.leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

//java:Missing Number
public class P268MissingNumber {
    public static void main(String[] args) {
        Solution solution = new P268MissingNumber().new Solution();
        System.out.println(solution.missingNumber(new int[]{0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // hash
        public int missingNumber(int[] nums) {
            Set<Integer> a = new HashSet<>();
            for (int num : nums) {
                a.add(num);
            }
            for (int i = 0; i <= nums.length; i++) {
                if (!a.contains(i)) {
                    return i;
                }
            }
            return -1;
        }
        // 数学
//        public int missingNumber(int[] nums) {
//            int res=0;
//            for (int i = 0; i <= nums.length; i++) {
//                res += i;
//            }
//            for (int num : nums) {
//                res-=num;
//            }
//            return res;
//        }
        // traverse
//        public int missingNumber(int[] nums) {
//            Arrays.sort(nums);
//            for (int i = 0; i < nums.length; i++) {
//                int num = nums[i];
//                if (num != i) {
//                    return i;
//                }
//            }
//            return nums.length;
//        }

        // the bit operation
//        public int missingNumber(int[] nums) {
//            int a = 0;
//            for (int i = 0; i <= nums.length; i++) {
//                a^=i;
//            }
//            for (int num : nums) {
//                a^=num;
//            }
//            return a;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
