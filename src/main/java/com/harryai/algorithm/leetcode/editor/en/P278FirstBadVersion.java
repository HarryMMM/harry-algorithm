//You are a product manager and currently leading a team to develop a new 
//product. Unfortunately, the latest version of your product fails the quality check. 
//Since each version is developed based on the previous version, all the versions 
//after a bad version are also bad. 
//
// Suppose you have n versions [1, 2, ..., n] and you want to find out the 
//first bad one, which causes all the following ones to be bad. 
//
// You are given an API bool isBadVersion(version) which returns whether 
//version is bad. Implement a function to find the first bad version. You should 
//minimize the number of calls to the API. 
//
// 
// Example 1: 
//
// 
//Input: n = 5, bad = 4
//Output: 4
//Explanation:
//call isBadVersion(3) -> false
//call isBadVersion(5) -> true
//call isBadVersion(4) -> true
//Then 4 is the first bad version.
// 
//
// Example 2: 
//
// 
//Input: n = 1, bad = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= bad <= n <= 2³¹ - 1 
// 
//
// Related Topics Binary Search Interactive 👍 7425 👎 2975

package com.harryai.algorithm.leetcode.editor.en;

//java:First Bad Version
public class P278FirstBadVersion {
    private static int bad;
    public static void main(String[] args) {
        Solution solution = new P278FirstBadVersion().new Solution();
        bad=1;
        System.out.println(solution.firstBadVersion(3));

    }
    public class VersionControl{
        protected  boolean isBadVersion(int v){
            return v>=bad;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int res = -1;
            int l = 1;
            int r = n;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                // 如果是，往前找还有没有更早的版本
                if (isBadVersion(mid)) {
                    res = mid;
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
