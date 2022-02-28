//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lower-case English letters. 
// 
// Related Topics String 👍 7086 👎 2828

package com.harryai.algorithm.leetcode.editor.en;

import java.util.Arrays;

//java:Longest Common Prefix
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
//        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
//        System.out.println(solution.longestCommonPrefix(new String[]{"dog"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"bfdsf", "abc", "ab", "a", "abcd"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int size = strs.length;
            if (strs.length == 1) {
                return strs[0];
            }
            // 排序后，只要第一个字符串和最后一个字符串能匹配到的前缀，其它的也一定能匹配到。
            Arrays.sort(strs);
            System.out.println(Arrays.toString(strs));
            int end = Math.min(strs[0].length(), strs[size - 1].length());
            int i = 0;
            while (i < end && strs[0].charAt(i) == strs[size - 1].charAt(i)) {
                i++;
            }
            return strs[0].substring(0, i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
