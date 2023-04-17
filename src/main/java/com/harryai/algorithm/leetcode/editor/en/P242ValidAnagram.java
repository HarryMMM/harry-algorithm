//Given two strings s and t, return true if t is an anagram of s, and false 
//otherwise. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: s = "anagram", t = "nagaram"
//Output: true
// 
// Example 2: 
// Input: s = "rat", t = "car"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you 
//adapt your solution to such a case? 
//
// Related Topics Hash Table String Sorting 👍 8730 👎 282

package com.harryai.algorithm.leetcode.editor.en;

//java:Valid Anagram
public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        System.out.println(solution.isAnagram("rat", "car"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] table = new int[26];
            for (int i = 0; i < s.length(); i++) {
                table[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                int res = --table[t.charAt(i) - 'a'];
                if (res < 0) {
                    return false;
                }
            }
            return true;
        }
//        // sort
//        public boolean isAnagram(String s, String t) {
//            if (s.length() != t.length()) {
//                return false;
//            }
//            char[] split = s.toCharArray();
//            Arrays.sort(split);
//            char[] split2 = t.toCharArray();
//            Arrays.sort(split2);
//            for (int i = 0; i < split.length; i++) {
//                if (split[i] != (split2[i])) {
//                    return false;
//                }
//            }
//            return true;
//        }


        // 使用map存储并计数s中的字符， 然后遍历t的字符，从map中减去，如果最后map为空，则表示是anagram
//        public boolean isAnagram(String s, String t) {
//            if (s.length() != t.length()) {
//                return false;
//            }
//            Map<Character, Long> collect = new HashMap<>();
//            for (int i = 0; i < s.length(); i++) {
//                collect.compute(s.charAt(i), (k, v) -> v == null ? 1 : v+1);
//            }
//            for (int i = 0; i < t.length(); i++) {
//                collect.computeIfPresent(t.charAt(i), (key, oldValue) -> {
//                    long newValue = oldValue - 1;
//                    if (newValue == 0) {
//                        return null;
//                    }
//                    return newValue;
//                });
//            }
//            return collect.isEmpty();
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
