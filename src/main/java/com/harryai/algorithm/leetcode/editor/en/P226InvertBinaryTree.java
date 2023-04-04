//Given the root of a binary tree, invert the tree, and return its root.
//
//
// Example 1:
//
//
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
//
//
// Example 2:
//
//
//Input: root = [2,1,3]
//Output: [2,3,1]
//
//
// Example 3:
//
//
//Input: root = []
//Output: []
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
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 11
//924 👎 168

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.common.tree.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//java:Invert Binary Tree
public class P226InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P226InvertBinaryTree().new Solution();
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
        // queue (Breadth-First)
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            // 所有节点一次入栈，颠倒顺序
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode pop = queue.poll();
                TreeNode l = pop.left;
                TreeNode r = pop.right;
                pop.left = r;
                pop.right = l;
                if (l != null) {
                    queue.offer(l);
                }
                if (r != null) {
                    queue.offer(r);
                }
            }
            return root;
        }
//        // stack (Depth-First)
//        public TreeNode invertTree(TreeNode root) {
//            if (root == null) {
//                return root;
//            }
//            // 所有节点一次入栈，颠倒顺序
//            Deque<TreeNode> stack = new LinkedList<>();
//            stack.push(root);
//            while (!stack.isEmpty()) {
//                TreeNode pop = stack.pop();
//                TreeNode l = pop.left;
//                TreeNode r = pop.right;
//                pop.left = r;
//                pop.right = l;
//                if (l != null) {
//                    stack.push(l);
//                }
//                if (r != null) {
//                    stack.push(r);
//                }
//            }
//            return root;
//        }
//        // recursion
//        public TreeNode invertTree(TreeNode root) {
//            if (root == null) {
//                return root;
//            }
//            TreeNode l = root.left;
//            TreeNode r = root.right;
//            root.left = r;
//            root.right = l;
//            invertTree(l);
//            invertTree(r);
//            return root;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
