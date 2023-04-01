//Given an integer array nums and an integer k, return true if there are two 
//distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <
//= k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1
//Output: true
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// Related Topics Array Hash Table Sliding Window 👍 4680 👎 2563

package com.harryai.algorithm.leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

//java:Contains Duplicate II
public class P219ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new P219ContainsDuplicateIi().new Solution();
        solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>(k + 1);
            for (int i = 0; i < nums.length; i++) {
                // 如果set已经添加了k+1个元素，就需要每次移除一个(最早加入的)，
                // 保证首个元素和末尾元素下标的差值绝对值<=k
                // i > k 也可写为 i=k+1 或者 set.size()=k+1
                if (i > k) {
                    set.remove(nums[i - k - 1]);
                }
                // 添加元素，如果add返回false,表示在k的时间窗内有重复元素
                if (!set.add(nums[i])) {
                    return true;
                }
            }
            return false;
        }
//        public boolean containsNearbyDuplicate(int[] nums, int k) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                if (map.containsKey(nums[i])) {
//                    Integer idx = map.get(nums[i]);
//                    if (Math.abs(idx - i) <= k) {
//                        return true;
//                    }
//                }
//                map.put(nums[i], i);
//            }
//            return false;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
