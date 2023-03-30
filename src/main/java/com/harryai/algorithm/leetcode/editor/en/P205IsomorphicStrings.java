//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings s and t are isomorphic if the characters in s can be replaced to 
//get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same 
//character, but a character may map to itself. 
//
// 
// Example 1: 
// Input: s = "egg", t = "add"
//Output: true
// 
// Example 2: 
// Input: s = "foo", t = "bar"
//Output: false
// 
// Example 3: 
// Input: s = "paper", t = "title"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s and t consist of any valid ascii character. 
// 
//
// Related Topics Hash Table String 👍 6427 👎 1373

package com.harryai.algorithm.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

//java:Isomorphic Strings
public class P205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> sm = new HashMap<>();
            Map<Character, Character> tm = new HashMap<>();
            for (int i = s.length() - 1; i >= 0; i--) {
                char s1 = s.charAt(i);
                char t1 = t.charAt(i);
                // 假设已经包含当前映射，但映射的字符却不等于本次将要映射的字符，则表示不符合映射规则
                if (sm.containsKey(s1) && sm.get(s1) != t1
                        || tm.containsKey(t1) && tm.get(t1) != s1) {
                    return false;
                }
                sm.put(s1, t1);
                tm.put(t1, s1);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
