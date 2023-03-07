//Given the root of a binary tree and an integer targetSum, return true if the 
//tree has a root-to-leaf path such that adding up all the values along the path 
//equals targetSum. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//Output: true
//Explanation: The root-to-leaf path with the target sum is shown.
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3], targetSum = 5
//Output: false
//Explanation: There two root-to-leaf paths in the tree:
//(1 --> 2): The sum is 3.
//(1 --> 3): The sum is 4.
//There is no root-to-leaf path with sum = 5.
// 
//
// Example 3: 
//
// 
//Input: root = [], targetSum = 0
//Output: false
//Explanation: Since the tree is empty, there are no root-to-leaf paths.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 79
//64 👎 919

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.leetcode.editor.en.model.TreeNode;
import com.harryai.algorithm.leetcode.editor.en.utils.BinaryTreeUtils;

//java:Path Sum
public class P112PathSum {
    public static void main(String[] args) {
        Solution solution = new P112PathSum().new Solution();
        TreeNode node = BinaryTreeUtils.arrays2Tree(new Integer[]{1, 2, 3});
        System.out.println(solution.hasPathSum(node, 3));
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            // 叶子节点，判断结果
            if (root.right == null && root.left == null) {
                return targetSum == root.val;
            }
            // 不是叶子节点，当前根节点至少有一个子树。只要有一个子树，都不能计算结果，需要继续递归
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
