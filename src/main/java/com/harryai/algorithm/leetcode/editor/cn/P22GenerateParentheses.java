//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3303 👎 0

package com.harryai.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:Generate Parentheses
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
//        System.out.println(solution.generateParenthesis(2));
//        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * topic: Generate Parentheses
     * Solution number:3
     * Ideas:回溯+剪枝，在生成过程中判断字符串序列是否有效。规则
     * 1. 左括号大于0时才继续拼左括号
     * 2. 右括号大于左括号时才拼接右括号（因为有效的括号一定是先有左括号，再有右括号）
     * Problem boundary: 字符生成结束（字符串生成到最后一位）
     * Problem pattern: 递归，问题和子问题
     * time complexity: O(4N/根N) 与
     * space complexity O(4N/根N)
     */
    class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> combinations = new ArrayList<>();
            generateAll(new char[2 * n], 0, combinations,n,n);
            return new ArrayList<>(combinations);
        }

        /**
         * @param pos 当需要放置字符的位置
         * @param result 存储结果的列表
         */
        public void generateAll(char[] current, int pos, List<String> result, int l, int r) {
            // 表示生成结束，检查，如果合法则添加
            if (pos == current.length) {
                result.add(new String(current));
            } else {
                // 1.当还有左括号时，生成在当前位置放置左括号的字符串
                if (l > 0) {
                    current[pos] = '(';
                    generateAll(current, pos + 1, result, l - 1, r);
                }
                // 2.当右括号数量大于左括号数量时,生成在当前位置放置右括号的字符串
                if (r > l) {
                    current[pos] = ')';
                    generateAll(current, pos + 1, result, l, r - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
