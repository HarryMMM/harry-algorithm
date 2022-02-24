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

import java.util.HashMap;
import java.util.Map;

//java:Longest Substring Without Repeating Characters
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
//        System.out.println(solution.lengthOfLongestSubstring(" "));
        System.out.println(solution.lengthOfLongestSubstring("bacadef"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 定义左右游标l和r, 使用Map存储r滑动过的字符串位置
            // r在滑动过程中，如果发现当前字符串cur与之前的重复。则将左游标移动到最左边重复字符串的下一个位置
            // 然后记录遇到重复前l和f之间的字符串个数（原有的和现有的哪个长取哪个）。
            // 如果没有遇到重复的，则滑动一个字符，记录一个长度
            int res = 0, n = s.length();
            Map<Character, Integer> map = new HashMap<>();
            for (int l = 0, r = 0; r < n; r++) {
                char cur = s.charAt(r);
                if (map.containsKey(cur)) {
                    l = Math.max(map.get(cur) + 1, l);
                }
                res = Math.max(res, r - l + 1);
                map.put(cur, r);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
