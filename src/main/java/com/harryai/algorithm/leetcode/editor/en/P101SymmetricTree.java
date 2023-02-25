//Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
// symmetric around its center). 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,2,3,4,4,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,null,3,null,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Could you solve it both recursively and iteratively? Related 
//Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 12293 👎 277

package com.harryai.algorithm.leetcode.editor.en;

//java:Symmetric Tree
public class P101SymmetricTree {
    public static void main(String[] args) {

        Solution solution = new P101SymmetricTree().new Solution();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null))
                , new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null)));
        solution.isSymmetric(treeNode);
    }

    public static class TreeNode {
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
        public boolean isSymmetric(TreeNode root) {
            return isSame(root.left, root.right);

        }

        public boolean isSame(TreeNode l, TreeNode r) {
            // 当前节点左右儿子相等，则比较他的左右子树
            if (l != null && r != null && l.val == r.val) {
                // 因为是镜像，所有左数的左儿子要和右树的右儿子比较，反之同理
                return isSame(l.left, r.right) && isSame(l.right, r.left);
            } else { // 否则，如果当前节点的左右儿子都为null,也表示相等，否则不相等
                return l == null && r == null;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
