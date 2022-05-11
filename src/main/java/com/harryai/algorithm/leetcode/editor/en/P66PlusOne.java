//You are given a large integer represented as an integer array digits, where 
//each digits[i] is the iᵗʰ digit of the integer. The digits are ordered from most 
//significant to least significant in left-to-right order. The large integer does 
//not contain any leading 0's. 
//
// Increment the large integer by one and return the resulting array of digits. 
//
//
// 
// Example 1: 
//
// 
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
// 
//
// Example 2: 
//
// 
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
// 
//
// Example 3: 
//
// 
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].
// 
//
// 
// Constraints: 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// digits does not contain any leading 0's. 
// 
// Related Topics Array Math 👍 4137 👎 4126

package com.harryai.algorithm.leetcode.editor.en;

import java.util.Arrays;

//java:Plus One
public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
//        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
//        System.out.println(Arrays.toString(solution.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9,9})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
//            if (digits == null) {
//                return new int[0];
//            }
//            int carry = 0;
//            for (int i = digits.length - 1; i >= 0; i--) {
//                int plusNum = i == digits.length - 1 ? 1 : 0;
//                int sum = digits[i] + plusNum+carry;
//                digits[i] = sum % 10;
//                carry = sum >= 10 ? 1 : 0;
//            }
//            if (carry == 1) {
//                int[] res = new int[digits.length + 1];
//                res[0] = carry;
//                System.arraycopy(digits, 0, res, 1, digits.length);
//                return res;
//            }
//            return digits;
//        }
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) {
                    return digits;
                }
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
