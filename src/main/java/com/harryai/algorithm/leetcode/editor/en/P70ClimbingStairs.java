//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can 
//you climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics Math Dynamic Programming Memoization 👍 17086 👎 527

package com.harryai.algorithm.leetcode.editor.en;

//java:Climbing Stairs
public class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(0));
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
