//Given a binary tree, determine if it is height-balanced. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics Tree Depth-First Search Binary Tree 👍 8433 👎 476

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.leetcode.editor.en.model.TreeNode;
import com.harryai.algorithm.leetcode.editor.en.utils.BinaryTreeUtils;

//java:Balanced Binary Tree
public class P110BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P110BalancedBinaryTree().new Solution();
        Integer[] nums = {1, 2, 3, 4, 5, 6, null, 8};
        TreeNode treeNode = BinaryTreeUtils.arrays2Tree(nums);
        System.out.println(solution.isBalanced(treeNode));
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
        public boolean isBalanced(TreeNode root) {
            // 没有返回-1，则为平衡数
            return height(root) >=0;
        }

        private int height(TreeNode root) {
            // 空树，返回0
            if (root == null) {
                return 0;
            }

            int l = height(root.left);
            // 左子树不平衡，当前树不平衡
            if (l == -1) {
                return -1;
            }
            int r = height(root.right);
            // 右子树不平衡，当前数不平衡
            if (r == -1) {
                return -1;
            }
            // 左右子树树高差值大于1，当前数不平衡
            if (Math.abs(l - r) > 1) {
                return -1;
            }
            // 当前数平衡，返回树高
            return Math.max(l, r) + 1;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
