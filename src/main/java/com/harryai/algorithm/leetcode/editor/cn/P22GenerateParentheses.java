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
        System.out.println(solution.generateParenthesis(7));
//        System.out.println(solution.generateParenthesis(2));
//        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * topic: Generate Parentheses
     * Solution number:4
     * Ideas:
     * n种括号的组合一定是1组括号和n-1组括号的组合
     * 括号序列一定是这种格式:
     * 设求n组括号的组合，p+q=n-1，因为起始一个括号一定为 "(", 对应的")”括号位置为 2p+1则括号序列为：
     * "(" + p情况的括号序列 + ")" + q情况的序列
     * 所以，罗列p和q两种情况的括号序列并和 一组 ”()“ 进行组合
     * Problem boundary: 遍历完
     * Problem pattern: 动态规划，递归，
     * time complexity: O(4N/根N)
     * space complexity O(4N/根N)
     */
    class Solution {
        ArrayList[] cache = new ArrayList[100];

        public List<String> generateParenthesis(int n) {
            return generate(n);
        }

        private List<String> generate(int n) {
            // 如果有缓存，直接返回
            if (cache[n] != null) {
                return cache[n];
            }
            ArrayList<String> ans = new ArrayList<>();
            if (n == 0) {
                ans.add("");
            } else {
                // 总共有n组括号进行组合，依次计算0,1,2 ... n 组括号的序列
                for (int i = 0; i < n; i++) {
                    // 遍历p种情况的括号序列
                    for (String p : generate(i)) {
                        // 遍历q种情况的括号序列
                        for (String q : generate(n - i - 1)) {
                            ans.add("(" + p + ")" + q);
                        }
                    }
                }
            }
            cache[n] = ans;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
