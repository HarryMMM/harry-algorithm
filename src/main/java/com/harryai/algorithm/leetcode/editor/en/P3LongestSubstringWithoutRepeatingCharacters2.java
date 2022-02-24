//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 👍 21566 👎 961

package com.harryai.algorithm.leetcode.editor.en;

//java:Longest Substring Without Repeating Characters
public class P3LongestSubstringWithoutRepeatingCharacters2 {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters2().new Solution();
//        System.out.println(solution.lengthOfLongestSubstring(" "));
        System.out.println(solution.lengthOfLongestSubstring("bacadef"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // #1 定义两个游标，left和right.[left,right)为一个字符串S。一个记录字符串S是否用重复的数组int[] chars，ASCII有128个字符串，所以定义128长度
            // #2 使用right向字符串的右侧进行探索。如果没有重复的就一直探索。同时在chars中每个字符串出现的次数
            // #3 当发现重复字符S(right)时候，right停止探索。此时一同向右移动left游标，并将游标所处的字符的出现次数减一。
            // #4 left一直移动直到遇到左侧的重复字符S(left)的后一位，此时记录S的长度（如果比上一个结果大）。
            // #5 right继续探索，重复2-5，直到字符串检查完毕。
            int[] chars = new int[128];
            int left = 0;
            int right = 0;
            int res = 0;
            while (right < s.length()) {
                char r = s.charAt(right);
                chars[r]++;
                while (chars[r] > 1) {
                    char l = s.charAt(left);
                    chars[l]--;
                    left++;
                }
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
