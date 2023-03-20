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
//        System.out.println(solution.convertToTitle(1));
        System.out.println(solution.convertToTitle(2147483647));
//        System.out.println(solution.convertToTitle(701));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuffer sb = new StringBuffer();
            while (columnNumber > 0) {
                // 余数为0需要从商退一位，这么计算不用退位了
                int re = (columnNumber - 1) % 26 + 1;
                // 使用ASCII取字母A-Z
                sb.append((char) ((re - 1) + 'A'));
                // 下一位需要计算的数是减去余数后除以26的商
                columnNumber = (columnNumber - re) / 26;
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
