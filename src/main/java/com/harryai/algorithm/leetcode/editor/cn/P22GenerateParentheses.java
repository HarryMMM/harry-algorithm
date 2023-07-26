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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//java:Generate Parentheses
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
//        System.out.println(solution.generateParenthesis(2));
//        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Character> a = new ArrayList<Character>(2) {{
            add('(');
            add(')');
        }};

        // solution 1：暴力，转换思路为，将2n个字符进行组合，看总共有多少种组合方式
        public List<String> generateParenthesis(int n) {
            List<Character> b = new ArrayList<>(2 * n);
            for (int i = 0; i < n; i++) {
                b.addAll(a);
            }
            Set<String> combinations = new HashSet<>();
            generateAll(new char[2 * n], 0, b, combinations);
            return new ArrayList<>(combinations);
        }

        /**
         *
         * @param current 存储生成字符串，因为有n组左右括号，所以，长度为2n
         * @param pos 当需要放置字符的位置
         * @param strs 需要组合的所有字符串
         * @param result 存储结果的列表
         */
        public void generateAll(char[] current, int pos, List<Character> strs, Set<String> result) {
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                for (Character str : strs) {
                    current[pos] = str;
                    generateAll(current, pos + 1, strs, result);
                }
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
