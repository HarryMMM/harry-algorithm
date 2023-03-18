//Given the root of a binary tree, return the preorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
//
// Related Topics Stack Tree Depth-First Search Binary Tree 👍 6558 👎 173

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.common.tree.model.TreeNode;
import com.harryai.algorithm.common.tree.utils.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//java:Binary Tree Preorder Traversal
public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
        System.out.println(solution.preorderTraversal(BinaryTreeUtils.arrays2Tree(new Integer[]{1, 4, 3, 2})));
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> a = new ArrayList<>();
            // Save current node so that its right subtree can be taken out.
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            // If cur or stack is not empty ,it means that the binary tree
            // has not been traversal yet.
            while (cur != null || !stack.isEmpty()) {
                // If cur is not empty ,continue to traverse its left subtree
                // and push it into stack so that its right can be taken out.
                if (cur != null) {
                    a.add(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                } else { // if cur is empty but stack is not empty,
                    // take its parent node from stack,then traverse
                    // the right subtree of its parent node
                    cur = stack.pop().right;
                }

            }
            // return results
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
