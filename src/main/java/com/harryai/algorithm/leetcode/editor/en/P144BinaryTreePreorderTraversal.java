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
            // if root is null,return an empty list.
            if (root == null) {
                return a;
            }
            // The purpose of the storage node is to retrieve the right subtree
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            while (cur != null) {
                // record current node
                a.add(cur.val);
                // if the left subtree of current node is not null,
                // save the current node into the stack so that the right subtree
                // can be retrieved.
                if (cur.left != null) {
                    stack.push(cur);
                    cur = cur.left;
                    // If the right subtree is not null ,set it as the current tree
                } else if (cur.right != null) {
                    cur = cur.right;
                } else {
                    // If the stack is not empty ,pop up a non-null node and set it as the current node .
                    // Otherwise,set the current node to null.
                    cur = null;
                    while (!stack.isEmpty()) {
                        TreeNode pop = stack.pop();
                        cur = pop.right;
                        if (cur != null) {
                            break;
                        }
                    }
                }
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
