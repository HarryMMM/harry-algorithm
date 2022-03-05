//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if 
//needle is not part of haystack. 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great 
//question to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty 
//string. This is consistent to C's strstr() and Java's indexOf(). 
//
// 
// Example 1: 
// Input: haystack = "hello", needle = "ll"
//Output: 2
// Example 2: 
// Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// Example 3: 
// Input: haystack = "", needle = ""
//Output: 0
// 
// 
// Constraints: 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack and needle consist of only lower-case English characters. 
// 
// Related Topics Two Pointers String String Matching 👍 3651 👎 3414

package com.harryai.algorithm.leetcode.editor.en;

//java:Implement strStr()
public class P28ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
//        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("hello", "ll"));
//        System.out.println(solution.strStr("", ""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 将needle在haystack上滑动，如果滑动到当前位置的haystack的子串的首尾字母和needle相同，
        // 则开始比较子串所有的字母是否和needle相同，如果相同。返回子串开始索引。
        public int strStr(String haystack, String needle) {
            int m = haystack.length();
            int n = needle.length();
            if (n == 0) {
                return 0;
            }
            for (int i = 0; i <= m - n; i++) {
                // 检查首尾字母是否相同
                if (haystack.charAt(i) != needle.charAt(0) && haystack.charAt(i + n - 1) != needle.charAt(n - 1)) {
                    continue;
                }
                int j = 0;
                for (; j < n; j++) {
                    // 如果不相同，不再继续比较
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                // 如果j和n相同，表示所有的字符都比较过且相同。
                if (n == j) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
