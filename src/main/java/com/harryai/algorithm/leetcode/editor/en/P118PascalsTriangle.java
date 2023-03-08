//Given an integer numRows, return the first numRows of Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
//
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics Array Dynamic Programming 👍 9402 👎 306

package com.harryai.algorithm.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

//java:Pascal's Triangle
public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        System.out.println(solution.generate(1));
        System.out.println(solution.generate(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                int subSize = i + 1;
                List<Integer> sub = new ArrayList<>(subSize);
                for (int j = 0; j < subSize; j++) {
                    if (j == 0 || j == subSize - 1) {
                        sub.add(1);
                    }
                    else {
                        List<Integer> integers = list.get(i - 1);
                        sub.add(integers.get(j)+integers.get(j-1));
                    }
                }
                list.add(sub);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
