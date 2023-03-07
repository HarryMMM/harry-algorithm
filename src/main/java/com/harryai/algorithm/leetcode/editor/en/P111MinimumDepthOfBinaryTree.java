//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the 
//root node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁵]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 54
//70 👎 1089

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.leetcode.editor.en.model.TreeNode;
import com.harryai.algorithm.leetcode.editor.en.utils.BinaryTreeUtils;

//java:Minimum Depth of Binary Tree
public class P111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
        TreeNode node = BinaryTreeUtils.arrays2Tree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6});
        System.out.println(solution.minDepth(node));
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
        public int minDepth(TreeNode root) {
            return calc(root);
        }

        private int calc(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = calc(root.left);
            int m = calc(root.right);
            return root.left == null || root.right == null ? l + m + 1 : Math.min(l, m) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
