//Given an integer n, return true if it is a power of two. Otherwise, return 
//false. 
//
// An integer n is a power of two, if there exists an integer x such that n == 2
//ˣ. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 2⁰ = 1
// 
//
// Example 2: 
//
// 
//Input: n = 16
//Output: true
//Explanation: 2⁴ = 16
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you solve it without loops/recursion?
//
// Related Topics Math Bit Manipulation Recursion 👍 5099 👎 357

package com.harryai.algorithm.leetcode.editor.en;

//java:Power of Two
public class P231PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new P231PowerOfTwo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // n&-n 可以获取n最低位的1，因为符合题意的2的幂一定只有一个最低位1，
        // 所以，获取n最低位的1后和n比较，如果相等，表示n是2的幂
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & -n) == n;
        }


//        // 最大数的约束
//        public boolean isPowerOfTwo(int n) {
//            return n > 0 && (1 << 30) % n == 0;
//        }
        // 2的幂2进制表示法一定只有一个1，所以移除最低位的1后如果是0，表示是2的幂
//        public boolean isPowerOfTwo(int n) {
//            return n > 0 && (n & (n - 1)) == 0;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
