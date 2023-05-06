//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
//of rows like this: (you may want to display this pattern in a fixed font for 
//better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a 
//number of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
//
// Related Topics String 👍 6088 👎 12182

package com.harryai.algorithm.leetcode.editor.en;

//java:Zigzag Conversion
public class P6ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new P6ZigzagConversion().new Solution();
        String origin = "PAYPALISHIRING";
        String res = "PAHNAPLSIIGYIR";

        String res2 = solution.convert(origin, 3);
        System.out.println(res2);
        System.out.println(res.equals(res2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 优化，压缩空间
        public String convert(String s, int numRows) {

            /****************** 字符串转换成Z型 *******************/
            // 字符个数
            int n = s.length();
            // 行数
            int r = numRows;
            // 如果只有1列或者1行，结果是原字符串
            if (r == 1 || r >= n) {
                return s;
            }

            // 每个周期的字符个数
            int t = r + r - 2;
            // 每个周期的列数所占的列数
            int singleCycleC = 1 + r - 2;
            // 总共需要的列数(最后一周期如果不是完整周期，也算作完整周期，
            // 所以使用（n+t-1）来除t,这是一个计算技巧，因为加的是完整周期-1，假设本来能整除，商不变，加的数为余数
            // 假设不能整除，加的数正好凑够整除（+1），商不会超)
            int c = (n + t - 1) / t * singleCycleC;

            StringBuilder[] a = new StringBuilder[r];
            for (int i = 0; i < a.length; i++) {
                a[i] = new StringBuilder();
            }
            for (int i = 0, x = 0; i < n; i++) {
                // 存入
                a[x].append(s.charAt(i));
                // 先向下移动，如果当前字符串求得
                // 的x坐标小于向下的最大坐标（x坐标从0开始，最大坐标为r-1）
                if (i % t < r - 1) {
                    x++;
                } else { // 否则向上移动
                    x--;
                }
            }
            /***************** 读取字符串 ******************/
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.length; i++) {
                sb.append(a[i]);
            }
            return sb.toString();
        }
//        public String convert(String s, int numRows) {
//
//            /****************** 字符串转换成Z型 *******************/
//            // 字符个数
//            int n = s.length();
//            // 行数
//            int r = numRows;
//            // 如果只有1列或者1行，结果是原字符串
//            if (r == 1 || r >= n) {
//                return s;
//            }
//
//            // 每个周期的字符个数
//            int t = r + r - 2;
//            // 每个周期的列数所占的列数
//            int singleCycleC = 1 + r - 2;
//            // 总共需要的列数(最后一周期如果不是完整周期，也算作完整周期，
//            // 所以使用（n+t-1）来除t,这是一个计算技巧，因为加的是完整周期-1，假设本来能整除，商不变，加的数为余数
//            // 假设不能整除，加的数正好凑够整除（+1），商不会超)
//            int c = (n + t - 1) / t * singleCycleC;
//
//            char[][] a = new char[r][c];
//            for (int i = 0, x = 0, y = 0; i < n; i++) {
//                // 存入
//                a[x][y] = s.charAt(i);
//                // 先向下移动，如果当前字符串求得
//                // 的x坐标小于向下的最大坐标（x坐标从0开始，最大坐标为r-1）
//                if (i % t < r - 1) {
//                    x++;
//                } else { // 否则向右上移动
//                    x--;
//                    y++;
//                }
//            }
//            /***************** 读取字符串 ******************/
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < a.length; i++) {
//                char[] b = a[i];
//                for (int j = 0; j < b.length; j++) {
//                    char charStr = b[j];
//                    if (charStr != 0) {
//                        sb.append(charStr);
//                    }
//                }
//            }
//            return sb.toString();
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
