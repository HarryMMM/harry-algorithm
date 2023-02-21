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
        System.out.println(solution.climbStairs(44));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            int p = 0;
            int q = 0;
            int r = 1;
            for (int i = 1; i <= n; i++) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }

        public int calc(int n, int[] aa) {
            if (aa[n-1]!=0) {
                return aa[n-1];
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int i = calc(n - 1, aa) + calc(n - 2, aa);
            aa[n-1] = i;
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
