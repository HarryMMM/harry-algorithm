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


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//java:Pascal's Triangle II
public class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // C(n,m)法，使用阶乘算得
        public List<Integer> getRow(int rowIndex) {
            int rowNum = rowIndex + 1;
            List<Integer> l = new ArrayList<>();
            Map<Integer, BigDecimal> map = new HashMap<>(rowIndex);
            for (int columnIndex = 0; columnIndex < rowNum; columnIndex++) {
                BigDecimal multiply =
                        factorial(columnIndex, map).multiply(factorial(rowIndex - columnIndex,
                                map));
                l.add(factorial(rowIndex,map).divide(multiply).intValue());
            }
            return l;
        }
        public  BigDecimal factorial(int num, Map<Integer, BigDecimal> map) {
            if (num == 1||num==0) {
                return BigDecimal.ONE;
            }
            return map.computeIfAbsent(num, key -> factorial(num - 1, map).multiply(new BigDecimal(num)));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
