//Given an integer array nums where the elements are sorted in ascending order, 
//convert it to a height-balanced binary search tree. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3]
//Output: [3,1]
//Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is sorted in a strictly increasing order. 
// 
// Related Topics Array Divide and Conquer Tree Binary Search Tree Binary Tree ?
//? 9128 👎 462

package com.harryai.algorithm.leetcode.editor.en;

//java:Convert Sorted Array to Binary Search Tree
public class P108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
            if (r < l) {
                return null;
            }
            int mid = (r - l) / 2 + l;
            TreeNode root = new TreeNode(nums[mid], null, null);
            root.left = sortedArrayToBST(nums, l, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, r);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
