//Given a non-negative integer x, return the square root of x rounded down to 
//the nearest integer. The returned integer should be non-negative as well. 
//
// You must not use any built-in exponent function or operator. 
//
// 
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python. 
// 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down 
//to the nearest integer, 2 is returned.
// 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics Math Binary Search 👍 5861 👎 3867

package com.harryai.algorithm.leetcode.editor.en;

//java:Sqrt(x)
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
//        for (int i=0;i <= 10000;i++){
//            System.out.println("x="+i);
//            System.out.println(solution.mySqrt(i));
//        }
        System.out.println(solution.mySqrt(2147483647));
    }

    //leetcode submit region begin(Prohibit modification and deletion) 12345678
    class Solution {
        public int mySqrt(int x) {
            int l = 1;
            int r = x;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                // 正好等于，返回
                if (mid  == x / mid) {
                    return mid;
                    // mid平方小于x，向右查找
                } else if (mid < x / mid) {
                    l = mid + 1;
                } else { // mid平方大于x,向左查找
                    r = mid - 1;
                }
            }
            // 否则返回最接近的的平方根（为什么r是最接近的平方根？？？）
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
