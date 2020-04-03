package com.harryai.algorithm.common.tree.factory;

import com.harryai.algorithm.common.tree.model.BinaryTreeNode;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author Harry
 * @since 2020/04/03 14:46
 **/
public class BinaryTreeFactory extends AbstractTreeFactory<BinaryTreeNode> {

    public static final int BINARY_TREE_MAXINUM_OF_NODE = 2;

    public BinaryTreeFactory(int deep) {
        super(deep, BINARY_TREE_MAXINUM_OF_NODE);
    }

    public BinaryTreeFactory(int deep, boolean randomChildRenCount) {
        super(deep, randomChildRenCount, BINARY_TREE_MAXINUM_OF_NODE);
    }

    @Override
    protected void processTreeNode(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        List<BinaryTreeNode> children = rootNode.getChildren();
        // if rootNode has no child node, stop processing.
        if (CollectionUtils.isEmpty(children)) {
            return;
        }
        // At this point, the rootNode has least one child node.
        rootNode.setLeft(children.get(0));
        if (children.size() > 1) {
            rootNode.setRight(children.get(1));
        }
        children.forEach(this::processTreeNode);
    }


    @Override
    protected BinaryTreeNode getTreeNode() {
        return new BinaryTreeNode();
    }
}
