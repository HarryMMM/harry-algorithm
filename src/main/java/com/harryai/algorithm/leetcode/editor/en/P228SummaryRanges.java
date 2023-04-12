//You are given a sorted unique integer array nums. 
//
// A range [a,b] is the set of all integers from a to b (inclusive). 
//
// Return the smallest sorted list of ranges that cover all the numbers in the 
//array exactly. That is, each element of nums is covered by exactly one of the 
//ranges, and there is no integer x such that x is in one of the ranges but not in 
//nums. 
//
// Each range [a,b] in the list should be output as: 
//
// 
// "a->b" if a != b 
// "a" if a == b 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: The ranges are:
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// Example 2: 
//
// 
//Input: nums = [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: The ranges are:
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// All the values of nums are unique. 
// nums is sorted in ascending order. 
// 
//
// Related Topics Array 👍 2575 👎 1381

package com.harryai.algorithm.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

//java:Summary Ranges
public class P228SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new P228SummaryRanges().new Solution();
        System.out.println(solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> r = new ArrayList<>();
            StringBuilder sb=new StringBuilder(3);
            for (int i = 0; i < nums.length; ) {
                int low = i;
                i++;
                while (i < nums.length && nums[i] == nums[i - 1] + 1) {
                    i++;
                }
                int high = i - 1;
                sb.append(nums[low]);
                if (low < high) {
                    sb.append("->").append(nums[high]);
                }
                r.add(sb.toString());
                sb.setLength(0);
            }
            return r;
        }
//        public List<String> summaryRanges(int[] nums) {
//            List<String> r = new ArrayList<>();
//            if (nums == null) {
//                return r;
//            }
//            // 记录区间起点
//            Integer start = null;
//            // 记录区间终点
//            Integer end = null;
//            for (int i = 0; i < nums.length; i++) {
//                int num = nums[i];
//                // 如果起点为null，将起点和终点都置为当前数
//                if (start == null) {
//                    start = end = num;
//                    continue;
//                }
//                // 起点和终点有值，判断当前数是不是上终点的连续数，如果是，重置终点为当前数
//                if (num == end + 1) {
//                    end = num;
//                } else { // 如果不连续，记录start->end的区间，并将当前数置为起点和终点
//                    r.add(start.equals(end) ? start + "" : start + "->" + end);
//                    start = end = null;
//                    //重新遍历当前数
//                    i--;
//                }
//            }
//            // 记录最后的数
//            if (start != null && end != null) {
//                r.add(start.equals(end) ? start + "" : start + "->" + end);
//            }
//            return r;
//
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
