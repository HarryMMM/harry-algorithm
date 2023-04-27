//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 24873 👎 1460

package com.harryai.algorithm.leetcode.editor.en;

//java:Longest Palindromic Substring
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 动态规划，图解详见com.harryai.algorithm.leetcode.editor.en.doc.xmind.P5.png
        public String longestPalindrome(String s) {
            if (s.length() < 2) {
                return s;
            }
            int begin = 0;
            int maxLen = 1;
            char[] chars = s.toCharArray();
            int length = chars.length;
            boolean[][] dp = new boolean[length][length];
            // 初始化,可以不要
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }
            // 外for遍历j,竖向填充dp表格.
            // 因为S{i...j}是否是回文依赖的是子串S{i+1...j-1}在它的左下角
            // 竖向填充以便把依赖的子串都计算了。
            for (int j = 1; j < length; j++) {
                for (int i = 0; i < length; i++) {
                    // 如果chars[i]与chars[j]相等 并且
                    // 子串小于2即1个字符，必然是回文（(j-1)-(i-1)+1<2=>j-i<3）或者
                    // 子串在dp中记录的是回文
                    if (chars[i] == chars[j] && (j - i < 3 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            begin = i;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }

//        // 中心扩散(遍历s,已每个字符作为中点，向左向右找最长回文字符串)
//        public String longestPalindrome(String s) {
//            if (s.length() < 2) {
//                return s;
//            }
//            int begin = 0;
//            int maxLen = 1;
//            char[] chars = s.toCharArray();
//            int length = chars.length;
//            for (int i = 0; i < length - 1; i++) {
//                int oddLen = explain(chars, i, i);
//                int evenLen = explain(chars, i, i + 1);
//                int tmpLen = Math.max(oddLen, evenLen);
//                if (tmpLen > maxLen) {
//                    maxLen = tmpLen;
//                    begin = i - (maxLen - 1) / 2;
//                }
//            }
//            return s.substring(begin, begin + maxLen);
//        }
//
//        private int explain(char[] chars, int i, int j) {
//            int length = chars.length;
//            while (i >= 0 && j < length) {
//                if (chars[i] == chars[j]) {
//                    i--;
//                    j++;
//                } else {
//                    break;
//                }
//            }
//            return j - i - 1;
//        }

        // 暴力解法
//        public String longestPalindrome(String s) {
//            if (s.length() < 2) {
//                return s;
//            }
//            int begin = 0;
//            int maxLen = 1;
//            char[] chars = s.toCharArray();
//            int length = chars.length;
//            for (int i = 0; i < length - 1; i++) {
//                for (int j = i + 1; j < length; j++) {
//                    int currentStrLength = j - i + 1;
//                    if (currentStrLength > maxLen && isPalindrome(chars, i, j)) {
//                        begin = i;
//                        maxLen = currentStrLength;
//                    }
//                }
//            }
//            return s.substring(begin, begin + maxLen );
//        }
//
//        private boolean isPalindrome(char[] chars, int i, int j) {
//            while (i < j) {
//                if (chars[i++] != chars[j--]) {
//                    return false;
//                }
//            }
//            return true;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
