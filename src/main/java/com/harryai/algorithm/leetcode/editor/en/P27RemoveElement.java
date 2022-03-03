//Given an integer array nums and an integer val, remove all occurrences of val 
//in nums in-place. The relative order of the elements may be changed. 
//
// Since it is impossible to change the length of the array in some languages, 
//you must instead have the result be placed in the first part of the array nums. 
//More formally, if there are k elements after removing the duplicates, then the 
//first k elements of nums should hold the final result. It does not matter what 
//you leave beyond the first k elements. 
//
// Return k after placing the final result in the first k slots of nums. 
//
// Do not allocate extra space for another array. You must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// Custom Judge: 
//
// The judge will test your solution with the following code: 
//
// 
//int[] nums = [...]; // Input array
//int val = ...; // Value to remove
//int[] expectedNums = [...]; // The expected answer with correct length.
//                            // It is sorted with no values equaling val.
//
//int k = removeElement(nums, val); // Calls your implementation
//
//assert k == expectedNums.length;
//sort(nums, 0, k); // Sort the first k elements of nums
//for (int i = 0; i < actualLength; i++) {
//    assert nums[i] == expectedNums[i];
//}
// 
//
// If all assertions pass, then your solution will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]
//Explanation: Your function should return k = 2, with the first two elements 
//of nums being 2.
//It does not matter what you leave beyond the returned k (hence they are 
//underscores).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements 
//of nums containing 0, 0, 1, 3, and 4.
//Note that the five elements can be returned in any order.
//It does not matter what you leave beyond the returned k (hence they are 
//underscores).
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
// Related Topics Array Two Pointers 👍 3250 👎 4921

package com.harryai.algorithm.leetcode.editor.en;

import java.util.Arrays;

//java:Remove Element
public class P27RemoveElement {
    public static void main(String[] args) {
        Solution solution = new P27RemoveElement().new Solution();
        int val = 1;
//        int[] nums = new int[]{1};
//        int[] expectedNums = new int[]{1};
//        int[] nums = new int[]{1, 1, 1, 2, 3, 4, 4, 5, 6, 6};
//        int[] expectedNums = new int[]{2, 3, 4, 4, 5, 6, 6};
        int[] nums = new int[]{2, 3, 4, 1, 5};
        int[] expectedNums = new int[]{2, 3, 4, 5};
        int k = solution.removeElement(nums, val);
        Arrays.sort(nums, 0, k);
        if (k != expectedNums.length) {
            throw new RuntimeException("k = " + k + " error");
        }
        for (int i = 0; i < k; i++) {
            if (nums[i] != expectedNums[i]) {
                throw new RuntimeException("element error");
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            // #1 双指针，一头一尾部，头指针从0 -> nums.length ,尾指针反之
            // #2 先移动尾指针，直到找到一个不等一val的值。
            // #3 再移动头指针，直到找到一个slot(slot的值等于val)停止
            // #4 交换头指针和尾指针的元素
            // #5 继续移动头指针，如果头指针与尾指针相逢，则停止处理，并返回头指针的值
            // #6 否则重复#2->#6

//            int head = 0;
//            for (int tail = nums.length - 1; tail >= 0 && head <= tail; tail--) {
//                // 跳过等于val的值
//                if (nums[tail] == val) {
//                    continue;
//                }
//
//                // 找到可插入的slot
//                while (head <= tail) {
//                    if (nums[head] == val) {
//                        // 交换
//                        int tmp = nums[head];
//                        nums[head] = nums[tail];
//                        nums[tail] = tmp;
//                        break;
//                    }
//                    head++;
//                }
//            }
//            return head;

            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
