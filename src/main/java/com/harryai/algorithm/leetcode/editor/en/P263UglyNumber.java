//An ugly number is a positive integer whose prime factors are limited to 2, 3, 
//and 5. 
//
// Given an integer n, return true if n is an ugly number. 
//
// 
// Example 1: 
//
// 
//Input: n = 6
//Output: true
//Explanation: 6 = 2 × 3
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 1 has no prime factors, therefore all of its prime factors are 
//limited to 2, 3, and 5.
// 
//
// Example 3: 
//
// 
//Input: n = 14
//Output: false
//Explanation: 14 is not ugly since it includes the prime factor 7.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// Related Topics Math 👍 2794 👎 1500

package com.harryai.algorithm.leetcode.editor.en;

//java:Ugly Number
public class P263UglyNumber {
    public static void main(String[] args) {
        Solution solution = new P263UglyNumber().new Solution();
        solution.isUgly(0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int n) {
            int[] aa = {2, 3, 5};
            for (int i : aa) {
                while (n > 0 && n % i == 0) {
                    n /= i;
                }
            }
            return n == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
