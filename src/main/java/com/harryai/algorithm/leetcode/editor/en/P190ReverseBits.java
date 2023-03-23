//Reverse bits of a given 32 bits unsigned integer. 
//
// Note: 
//
// 
// Note that in some languages, such as Java, there is no unsigned integer type.
// In this case, both input and output will be given as a signed integer type. 
//They should not affect your implementation, as the integer's internal binary 
//representation is the same, whether it is signed or unsigned. 
// In Java, the compiler represents the signed integers using 2's complement 
//notation. Therefore, in Example 2 above, the input represents the signed integer -3
// and the output represents the signed integer -1073741825. 
// 
//
// 
// Example 1: 
//
// 
//Input: n = 00000010100101000001111010011100
//Output:    964176192 (00111001011110000010100101000000)
//Explanation: The input binary string 00000010100101000001111010011100 
//represents the unsigned integer 43261596, so return 964176192 which its binary 
//representation is 00111001011110000010100101000000.
// 
//
// Example 2: 
//
// 
//Input: n = 11111111111111111111111111111101
//Output:   3221225471 (10111111111111111111111111111111)
//Explanation: The input binary string 11111111111111111111111111111101 
//represents the unsigned integer 4294967293, so return 3221225471 which its binary 
//representation is 10111111111111111111111111111111.
// 
//
// 
// Constraints: 
//
// 
// The input must be a binary string of length 32 
// 
//
// 
// Follow up: If this function is called many times, how would you optimize it? 
//
//
// Related Topics Divide and Conquer Bit Manipulation 👍 4232 👎 1103

package com.harryai.algorithm.leetcode.editor.en;

//java:Reverse Bits
public class P190ReverseBits {
    public static void main(String[] args) {
        Solution solution = new P190ReverseBits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        private static final int M1 = 0x55555555; // 01010101010101010101010101010101
        private static final int M2 = 0x33333333; // 00110011001100110011001100110011
        private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
        private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

        // 位分治。int一共32位，思路：
        // 1). 奇偶交换
        // 2). 2位一组交换
        // 3). 4位一组交换
        // 4). 8位一组交换
        // 5). 16位一组交换
        public int reverseBits(int n) {
            // 1). 奇偶交换
            // 提取奇数位，并变为新的偶数位
            // 1.1 n>>>1 奇变偶（从左往右，最高位当做奇数位）
            // 1.2 &M1 使用M1将新的奇数位置为0（此时的奇数位为原偶数位，已经无用了)
            // 提取偶数位，并变为新的奇数位
            // 1.3 n & M1 ，将奇数位置为0
            // 1.4 << 1 偶变奇
            n = n >>> 1 & M1 | (n & M1) << 1;

            // 2). 2位一组交换,逻辑同第一步
            n = n >>> 2 & M2 | (n & M2) << 2;

            // 3). 4位一组交换,逻辑同第一步
            n = n >>> 4 & M4 | (n & M4) << 4;

            // 4). 8位一组交换,逻辑同第一步
            n = n >>> 8 & M8 | (n & M8) << 8;

            // 5). 16位一组交换,逻辑同第一步
            return n >>> 16 | n << 16;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
