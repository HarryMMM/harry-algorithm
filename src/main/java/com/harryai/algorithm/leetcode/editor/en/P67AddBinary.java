//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
// Related Topics Math String Bit Manipulation Simulation 👍 6253 👎 661

package com.harryai.algorithm.leetcode.editor.en;

//java:Add Binary
/**
 * 第一次做的时候做错的
 * 1. 两个字符串不等长时，剩余未计算的字符串未和carry计算就拼到计算结果上了 -》 应该和carry计算后再拼接
 * 2. 计算结果拼接的顺序是反的。 -》 应该每一个新的结果位都往结果的前面拼接
 * 3. loop 和 beLooped 取到了同样的值。 -》 以后类似的问题记得 一个是 >= 号 ，一个是 < 号。
 */
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
        System.out.println(solution.addBinary("1", "10"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            String loop = a.length() >= b.length() ? a : b;
            String beLooped = a.length() < b.length() ? a : b;
            int diff = loop.length() - beLooped.length();
            char carry = '0';
            StringBuilder res = new StringBuilder();
            int index;
            for (index = loop.length() - 1; index >= 0; index--) {
                char curRes;
                // beLooped计算完后就停止
                if (index - diff < 0) {
                    //
                    break;
                }
                char s1 = loop.charAt(index);
                char s2 = beLooped.charAt(index - diff);
                int count = count(s1, s2, carry);
                if (count == 3) {
                    curRes = '1';
                    carry = '1';
                } else if (count == 2) {
                    curRes = '0';
                    carry = '1';
                } else if (count == 1) {
                    curRes = '1';
                    carry = '0';
                } else {
                    curRes = '0';
                    carry = '0';
                }
                res.insert(0,curRes);
            }
            // 检查loop是还有剩余
            if (carry == '0' && diff == 0) {
                return res.toString();
            } else if (carry != '0' && diff == 0) {
                return res.insert(0, carry).toString();
            } else if (carry == '0' && diff != 0) {
                return res.insert(0, loop.substring(0, diff)).toString();
            } else {
                return res.insert(0, addBinary(loop.substring(0, diff), String.valueOf(carry))).toString();
            }
        }

        private int count(char s1, char s2, char carry) {
            int c = 0;
            if (s1 == '1') {
                c++;
            }
            if (s2 == '1') {
                c++;
            }
            if (carry == '1') {
                c++;
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
