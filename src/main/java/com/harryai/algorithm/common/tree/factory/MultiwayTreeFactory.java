package com.harryai.algorithm.common.tree.factory;

import com.harryai.algorithm.common.tree.model.MultiWayTreeNode;

/**
 * @author Harry
 * @since 2020/04/03 14:46
 **/
public class MultiwayTreeFactory extends AbstractTreeFactory<MultiWayTreeNode> {


    public MultiwayTreeFactory(int deep, int countOfChildren) {
        super(deep, countOfChildren);
    }

    public MultiwayTreeFactory(int deep, boolean randomChildRenCount,int randomChildRenCountSeed) {
        super(deep, randomChildRenCount,randomChildRenCountSeed);
    }

    @Override
    protected MultiWayTreeNode getTreeNode() {
        return new MultiWayTreeNode();
    }
}
