//Given the root of a binary tree, return all root-to-leaf paths in any order. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,5]
//Output: ["1->2->5","1->3"]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: ["1"]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics String Backtracking Tree Depth-First Search Binary Tree 👍 561
//9 👎 242

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.common.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//java:Binary Tree Paths
public class P257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
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
        // recursion
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> pathRes = new ArrayList<>();
            Queue<TreeNode> nodes = new LinkedList<>();
            Queue<String> paths = new LinkedList<>();
            nodes.offer(root);
            paths.offer(String.valueOf(root.val));
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.poll();
                String path = paths.poll();
                if (node.right == null && node.left == null) {
                    pathRes.add(path);
                }
                if (node.left != null) {
                    nodes.offer(node.left);
                    paths.offer(path + "->" + node.left.val);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                    paths.offer(path + "->" + node.right.val);
                }
            }
            return pathRes;
        }

//        // recursion
//        public List<String> binaryTreePaths(TreeNode root) {
//            ArrayList<String> strings = new ArrayList<>();
//            path(root, "" + root.val, strings);
//            return strings;
//        }
//
//        private void path(TreeNode root, String s, ArrayList<String> strings) {
//            // 如果是叶子节点,添加路径并返回
//            if (root.left == null && root.right == null) {
//                strings.add(s);
//                return;
//            }
//            if (root.left != null) {
//                path(root.left, s + "->" + root.left.val, strings);
//            }
//            if (root.right != null) {
//                path(root.right, s + "->" + root.right.val, strings);
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
