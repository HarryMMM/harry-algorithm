//Given the root of a binary tree, return the postorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [3,2,1]
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
// The number of the nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively?
//
// Related Topics Stack Tree Depth-First Search Binary Tree 👍 5702 👎 168

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.common.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//java:Binary Tree Postorder Traversal
public class P145BinaryTreePostorderTraversal{
    public static void main(String[] args){
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        // 1. 如果根节不为null,点把根节点入栈,并把左子树置为根节点（优先处理左子树）
        // 2. 继续判断根节点是为null,如果为null，从栈中取出一个节点。
        // 3. 因为栈中的节点的要么没有左子树，要么左子树已经处理过了。
        // 所以直接判断取出的节点是否有右子树如果取出的节点没有右子树或者又子树已经处理过了（左子树之前也处理过了，），
        // 则将取出的节点记录到结果中。并将取出的节点置为上一个已处理过的节点，并且根节点置为null.并继续从栈中取出节点
        // 4. 如果取出的节点有右子树，当前节点入栈。把右子树置为根节点。下一步循环继续优先处理左子树。。。重复1-4
        //
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.right == null | root.right == pre) {
                    list.add(root.val);
                    pre = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
