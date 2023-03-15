//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
//
// Related Topics Two Pointers String 👍 6267 👎 6765

package com.harryai.algorithm.leetcode.editor.en;

import java.util.Locale;

//java:Valid Palindrome
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("0P"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int forwardIdx = 0;
            int backwardIdx = s.length() - 1;
            char forward;
            char backward;
            // 前后指针不相遇就继续比较。如果相遇（forwardIdx>=backwardIdx）,表示是回文。
            while (backwardIdx > forwardIdx) {
                forward = s.charAt(forwardIdx);
                backward = s.charAt(backwardIdx);
                // 如果不是字母或者字符，继续往后遍历
                if (!isAlphanumeric(forward)) {
                    forwardIdx++;
                    continue;
                }
                // 如果不是字母或者字符，继续往前遍历
                if (!isAlphanumeric(backward)) {
                    backwardIdx--;
                    continue;
                }
                // 是字母或者字符，转小写后比较,不一样直接false
                // 否则，移动指针
                if (!eq(forward, backward)) {
                    return false;
                }
                backwardIdx--;
                forwardIdx++;
            }
            return true;
        }

        public boolean isAlphanumeric(char c) {
            return (char) 48 <= c && c <= (char) 57
                    || (char) 65 <= c && c <= (char) 90
                    || (char) 97 <= c && c <= (char) 122;

        }

        public boolean eq(char f, char b) {
            return Character.toLowerCase(f)!=Character.toLowerCase(b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
