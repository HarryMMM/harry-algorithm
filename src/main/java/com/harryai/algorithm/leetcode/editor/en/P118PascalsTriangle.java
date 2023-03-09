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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//java:Pascal's Triangle
public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        Map<Integer,BigDecimal> map=new HashMap<>();
        System.out.println(solution.generate(1));
        System.out.println(solution.generate(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 使用C(n,m)计算，n为行号，m为列号。
        // 使用BigDecimal进行阶乘计算，否则n>20或者m>20计算的阶乘（Long类型）会溢出。
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list = new ArrayList<>();
            Map<Integer, BigDecimal> bigDecimalMap = new HashMap<>();
            for (int i = 0; i < numRows; i++) {
                int subSize = i + 1;
                List<Integer> sub = new ArrayList<>(subSize);
                for (int j = 0; j < subSize; j++) {
                    BigDecimal multiply = factorial(j, bigDecimalMap).multiply(factorial(i - j,
                            bigDecimalMap));
                    sub.add(factorial(i, bigDecimalMap).divide(multiply).intValue());
                }
                list.add(sub);
            }
            return list;
        }

        public BigDecimal factorial(int num, Map<Integer, BigDecimal> map) {
            if (num == 1||num==0) {
                return BigDecimal.ONE;
            }
            return map.computeIfAbsent(num, key -> factorial(num - 1, map).multiply(new BigDecimal(num)));
        }

//        public List<List<Integer>> generate(int numRows) {
//            List<List<Integer>> list = new ArrayList<>();
//            for (int i = 0; i < numRows; i++) {
//                int subSize = i + 1;
//                List<Integer> sub = new ArrayList<>(subSize);
//                for (int j = 0; j < subSize; j++) {
//                    if (j == 0 || j == subSize - 1) {
//                        sub.add(1);
//                    }
//                    else {
//                        List<Integer> integers = list.get(i - 1);
//                        sub.add(integers.get(j)+integers.get(j-1));
//                    }
//                }
//                list.add(sub);
//            }
//            return list;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
