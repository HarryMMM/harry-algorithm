//Given an integer rowIndex, return the rowIndexᵗʰ (0-indexed) row of the
//Pascal's triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly
//above it as shown:
//
//
// Example 1:
// Input: rowIndex = 3
//Output: [1,3,3,1]
// Example 2:
// Input: rowIndex = 0
//Output: [1]
// Example 3:
// Input: rowIndex = 1
//Output: [1,1]
//
//
// Constraints:
//
//
// 0 <= rowIndex <= 33
//
//
//
// Follow up: Could you optimize your algorithm to use only O(rowIndex) extra
//space?
// Related Topics Array Dynamic Programming 👍 3602 👎 294

package com.harryai.algorithm.leetcode.editor.en;


import java.util.ArrayList;
import java.util.List;

//java:Pascal's Triangle II
public class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 按相邻组合数关系求解 C(n,m) =C(n,m-1)*(n-m+1)/m
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i <= rowIndex; i++) {
                row.add((int)((long)row.get(i - 1) * (rowIndex - i + 1) / i));
            }
            return row;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
