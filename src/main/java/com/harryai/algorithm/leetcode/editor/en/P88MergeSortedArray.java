//You are given two integer arrays nums1 and nums2, sorted in non-decreasing 
//order, and two integers m and n, representing the number of elements in nums1 and 
//nums2 respectively. 
//
// Merge nums1 and nums2 into a single array sorted in non-decreasing order. 
//
// The final sorted array should not be returned by the function, but instead 
//be stored inside the array nums1. To accommodate this, nums1 has a length of m + 
//n, where the first m elements denote the elements that should be merged, and the 
//last n elements are set to 0 and should be ignored. nums2 has a length of n. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming 
//from nums1.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there 
//to ensure the merge result can fit in nums1.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(m + n) time? 
// Related Topics Array Two Pointers Sorting 👍 9425 👎 881

package com.harryai.algorithm.leetcode.editor.en;

import java.util.Arrays;

//java:Merge Sorted Array
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        int[] nums1 = {3, 5, 7, 0, 0};
        int[] nums2 = {1, 8};
        solution.merge(nums1, 3, nums2, 2);
        System.out.println(Arrays.toString(nums1));
        int[] nums3 = {3, 5, 7, 0, 0};
        int[] nums4 = {7, 8};
        solution.merge(nums3, 3, nums4, 2);
        System.out.println(Arrays.toString(nums3));
        int[] nums5 = {3, 5, 7};
        int[] nums6 = null;
        solution.merge(nums5, 3, nums6, 0);
        System.out.println(Arrays.toString(nums5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // nums2 没有内容，直接结束
            if (n == 0) {
                return;
            }
            // 记录nums1元素的指针
            int i = m - 1;
            // 记录nums2元素的指针
            int j = n - 1;
            // 记录最大元素要存放的位置
            int c = nums1.length - 1;
            while (true) {
                // nums2全部移动到nums1,结束
                if (j < 0) {
                    break;
                } else if (i < 0) { // nums2还有元素，但是nums1已经全部挪完,继续把nums2的元素依次添加到nums1
                    nums1[c--] = nums2[j--];
                } else { // nums1和nums2都没挪完，比大小，大的先往nums1的c位置放
                    // nums1[i]大于nums2[j]才挪动
                    if (nums1[i] > nums2[j]) {
                        nums1[c--] = nums1[i--];
                    } else { // nums2[j]大于等于nums[i]都挪动(这里的等于目的是相等时优先挪动nums2的元素)
                        nums1[c--] = nums2[j--];
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
