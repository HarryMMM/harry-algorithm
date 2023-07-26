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
     * Solution number:2
     * Ideas:将n组括号进行组合（每个结果字符串的每个位置有两种可能‘(’或者‘)’），看总共有多少种组合方式
     * 相比我的solution 1 每次减少了4^2n种可能性，性能略有提升
     * Problem boundary: 字符生成结束（字符串生成到最后一位）
     * Problem pattern: 递归，问题和子问题
     * time complexity: 生成序列 O(2^2N)，底数2位每组括号有2个，2N为左右括号的总数
     * ，检查序列O(2N)，N为括号的组数，去掉常数为O(N), O(2^2n*n) ,
     * space complexity O(2N)，运算过程额外申请了2N的字符进行存储
     */
    class Solution {

        // solution 2：暴力，转换思路为，将n组括号进行组合（每个结果字符串的每个位置有两种可能‘(’或者‘)’），看总共有多少种组合方式
        // 相比我的solution 1 每次减少了4^2n种可能性，性能略有提升
        public List<String> generateParenthesis(int n) {
            List<String> combinations = new ArrayList<>();
            generateAll(new char[2 * n], 0, combinations);
            return new ArrayList<>(combinations);
        }

        /**
         * @param pos 当需要放置字符的位置
         * @param result 存储结果的列表
         */
        public void generateAll(char[] current, int pos, List<String> result) {
            // 表示生成结束，检查，如果合法则添加
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                // 1.生成在当前位置放置左括号的字符串
                current[pos] = '(';
                generateAll(current, pos + 1, result);
                // 2.生成在当前位置放置右括号的字符串
                current[pos] = ')';
                generateAll(current, pos + 1, result);
            }
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') {
                    ++balance;
                } else {
                    --balance;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
