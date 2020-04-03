package com.harryai.algorithm;

import com.harryai.algorithm.common.tree.factory.BinaryTreeFactory;
import com.harryai.algorithm.common.tree.factory.MultiwayTreeFactory;
import com.harryai.algorithm.common.tree.model.BinaryTreeNode;
import com.harryai.algorithm.common.tree.model.MultiWayTreeNode;
import com.harryai.algorithm.common.tree.utils.TreeUtils;
import org.junit.Test;

/**
 * @author Harry
 * @since 2020/04/03 16:12
 **/
public class TreeTest {
    @Test
    public void testBinaryTree(){
        BinaryTreeFactory binaryTreeFactory = new BinaryTreeFactory(3,true);
        BinaryTreeNode binaryTreeNode = binaryTreeFactory.buildTree();
        TreeUtils.smartPrintTree(binaryTreeNode);
    }

    @Test
    public void testNaryTree(){
        MultiwayTreeFactory multiwayTreeFactory =new MultiwayTreeFactory(3,true,3);
        MultiWayTreeNode multiwayTreeNode = multiwayTreeFactory.buildTree();
        TreeUtils.smartPrintTree(multiwayTreeNode);
    }
}
