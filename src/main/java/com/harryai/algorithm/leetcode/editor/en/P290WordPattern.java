//Given a pattern and a string s, find if s follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a 
//letter in pattern and a non-empty word in s. 
//
// 
// Example 1: 
//
// 
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length <= 300 
// pattern contains only lower-case English letters. 
// 1 <= s.length <= 3000 
// s contains only lowercase English letters and spaces ' '. 
// s does not contain any leading or trailing spaces. 
// All the words in s are separated by a single space. 
// 
//
// Related Topics Hash Table String 👍 6155 👎 730

package com.harryai.algorithm.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

//java:Word Pattern
public class P290WordPattern {
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] sArray = s.split(" ");
            if (sArray.length != pattern.length()) {
                return false;
            }
            Map<Character, String> ch2Str = new HashMap<>(sArray.length);
            Map<String, Character> str2Ch = new HashMap<>(sArray.length);
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                String str = sArray[i];
                if ((ch2Str.get(c) != null && !ch2Str.get(c).equals(str))) {
                    return false;
                }
                if ((str2Ch.get(str) != null && str2Ch.get(str) != c)) {
                    return false;
                }
                str2Ch.put(str, c);
                ch2Str.put(c, str);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
