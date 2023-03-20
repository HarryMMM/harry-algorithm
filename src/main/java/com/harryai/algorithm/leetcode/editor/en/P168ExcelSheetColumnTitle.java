//Given an integer columnNumber, return its corresponding column title as it 
//appears in an Excel sheet. 
//
// For example: 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
// Example 1: 
//
// 
//Input: columnNumber = 1
//Output: "A"
// 
//
// Example 2: 
//
// 
//Input: columnNumber = 28
//Output: "AB"
// 
//
// Example 3: 
//
// 
//Input: columnNumber = 701
//Output: "ZY"
// 
//
// 
// Constraints: 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
//
// Related Topics Math String 👍 3658 👎 525

package com.harryai.algorithm.leetcode.editor.en;

//java:Excel Sheet Column Title
public class P168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
        System.out.println(solution.convertToTitle(1));
        System.out.println(solution.convertToTitle(28));
        System.out.println(solution.convertToTitle(701));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            String[] dict = {"A", "B", "C", "D", "E", "F", "G",
                    "H", "I", "J", "K", "L", "M", "N",
                    "O", "P", "Q", "R", "S", "T", "U",
                    "V", "W", "X", "Y", "Z"};
            int length = dict.length;
            int quotient = columnNumber / length;
            int remainder = columnNumber % length;
            StringBuilder res = new StringBuilder();
            // if the quotient or remainder is not 0
            // we need to continue processing,
            while (quotient > 0 || remainder > 0) {
                String subStr;
                // if remainder is 0,take the string Z,and
                // the quotient needs to abdicate.
                if (remainder == 0) {
                    // take string Z
                    subStr = dict[length - 1];
                    remainder = (quotient - 1) % length;
                    quotient = (quotient - 1) / length;
                } else {
                    subStr = dict[remainder - 1];
                    remainder = (quotient) % length;
                    quotient = (quotient) / length;
                }
                res.insert(0, subStr);
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
