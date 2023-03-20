//Given a string columnTitle that represents the column title as appears in an 
//Excel sheet, return its corresponding column number. 
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
//Input: columnTitle = "A"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: columnTitle = "AB"
//Output: 28
// 
//
// Example 3: 
//
// 
//Input: columnTitle = "ZY"
//Output: 701
// 
//
// 
// Constraints: 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle consists only of uppercase English letters. 
// columnTitle is in the range ["A", "FXSHRXW"]. 
// 
//
// Related Topics Math String 👍 4095 👎 326

package com.harryai.algorithm.leetcode.editor.en;

//java:Excel Sheet Column Number
public class P171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new P171ExcelSheetColumnNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 26进制转10进制 当前n位的值*26^n: 比如AB -> 1*26^1+2*26^0
        public int titleToNumber(String columnTitle) {
            // 列序号
            int num = 0;
            // 代表26的n次方
            int multiple = 1;
            for (int i = columnTitle.length() - 1; i >= 0; i--) {
                // 求N位的值，利用ASCII
                int nValue = columnTitle.charAt(i) - 'A' + 1;
                num += nValue * multiple;
                multiple *= 26;
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
