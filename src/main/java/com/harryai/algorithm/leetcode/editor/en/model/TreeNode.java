package com.harryai.algorithm.leetcode.editor.en.model;

/**
 * <p>
 *
 * <p>
 *
 * @author haorui.hao
 * @since 2023/03/05 13:22
 **/
public class TreeNode {
    public int val;
    public int index;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, int index) {
        this.val = val;
        this.index = index;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
