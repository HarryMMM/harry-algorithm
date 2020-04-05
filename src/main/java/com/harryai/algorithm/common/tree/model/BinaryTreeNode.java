package com.harryai.algorithm.common.tree.model;

/**
 * @author Harry
 * @since 2020/04/03 12:41
 **/
public class BinaryTreeNode extends AbstractNode<BinaryTreeNode> {
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }



    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "name='" + name + '\'' +
                '}' + "@" + Integer.toHexString(hashCode());
    }
}
