//Given a string s consisting of some words separated by some number of spaces, 
//return the length of the last word in the string. 
//
// A word is a maximal substring consisting of non-space characters only. 
//
// 
// Example 1: 
//
// 
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
// 
//
// Example 2: 
//
// 
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
// 
//
// Example 3: 
//
// 
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of only English letters and spaces ' '. 
// There will be at least one word in s. 
// 
// Related Topics String 👍 957 👎 77

package com.harryai.algorithm.leetcode.editor.en;

//java:Length of Last Word
public class P58LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("hello word"));
        System.out.println(solution.lengthOfLastWord("hello word   "));
        System.out.println(solution.lengthOfLastWord(" fly me to the moon  "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            int count = 0;
            boolean isEndSpace = true;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == ' ') {
                    if (!isEndSpace) {
                        return count;
                    }
                } else {
                    isEndSpace = false;
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
