//Write a function that takes the binary representation of an unsigned integer 
//and returns the number of '1' bits it has (also known as the Hamming weight). 
//
// Note: 
//
// 
// Note that in some languages, such as Java, there is no unsigned integer type.
// In this case, the input will be given as a signed integer type. It should not 
//affect your implementation, as the integer's internal binary representation is 
//the same, whether it is signed or unsigned. 
// In Java, the compiler represents the signed integers using 2's complement 
//notation. Therefore, in Example 3, the input represents the signed integer. -3. 
// 
//
// 
// Example 1: 
//
// 
//Input: n = 00000000000000000000000000001011
//Output: 3
//Explanation: The input binary string 00000000000000000000000000001011 has a 
//total of three '1' bits.
// 
//
// Example 2: 
//
// 
//Input: n = 00000000000000000000000010000000
//Output: 1
//Explanation: The input binary string 00000000000000000000000010000000 has a 
//total of one '1' bit.
// 
//
// Example 3: 
//
// 
//Input: n = 11111111111111111111111111111101
//Output: 31
//Explanation: The input binary string 11111111111111111111111111111101 has a 
//total of thirty one '1' bits.
// 
//
// 
// Constraints: 
//
// 
// The input must be a binary string of length 32. 
// 
//
// 
//Follow up: If this function is called many times, how would you optimize it?
//
// Related Topics Divide and Conquer Bit Manipulation 👍 5154 👎 1098

package com.harryai.algorithm.leetcode.editor.en;

//java:Number of 1 Bits
public class P191NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new P191NumberOf1Bits().new Solution();
        System.out.println(solution.hammingWeight(11));
//        System.out.println(solution.hammingWeight(128));
//        System.out.println(solution.hammingWeight(-3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            // solution 2
            int count = 0;
            while (n != 0) {
                n &= n - 1;
                count++;
            }
            return count;

            // solution 1
//            int count = 0;
//            for (int i = 0; i < 32; i++) {
//                // 1. 依次将n的其它位置为0，除当前位 。
//                // 2. 两种结果：n==0则表示当前位为0；n!=0表示当前位不为0，此时计数+1
//                int i1 = n & (1 << i);
//                if (i1 != 0) {
//                    count++;
//                }
//            }
//            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
