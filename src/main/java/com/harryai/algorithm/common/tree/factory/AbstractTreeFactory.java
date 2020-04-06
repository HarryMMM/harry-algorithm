package com.harryai.algorithm.common.tree.factory;

import com.harryai.algorithm.utlis.DataPrepareUtil;
import com.harryai.algorithm.utlis.RandomUtil;
import com.harryai.algorithm.common.tree.model.AbstractNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Harry
 */
public abstract class AbstractTreeFactory<T extends AbstractNode<T>> implements TreeFactory<T> {
    /**
     * treeNode id random SEED
     */
    public static final int SEED = 10000;
    /**
     * treeNode name length
     */
    public static final int TREE_NODE_NAME_LENGTH = 5;
    public static final int MAX_LEVEL = 90000;
    public static final int MINIMUM_NUMBER_OF_NODES_PER_LAYER = 1;
    protected static final int ROOT_LEAVE = 1;
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTreeFactory.class);
    /**
     * Store the all layers of three.
     * key ： the level of layer
     * value: the nodes of layer
     */
    protected Map<Integer, List<T>> data = new ConcurrentHashMap<>();
    /**
     * Store the all nodes of three.
     * key ： the id of node
     * value: the node
     */
    protected Map<String, T> allTreeNodes = new ConcurrentHashMap<>();
    protected int deep;
    protected int countOfChildren;
    protected boolean randomChildRenCount;
    protected int randomChildRenCountSeed;

    public AbstractTreeFactory(int deep, int countOfChildren) {
        this.deep = deep;
        this.countOfChildren = countOfChildren;
    }

    public AbstractTreeFactory(int deep, boolean randomChildRenCount, int randomChildRenCountSeed) {
        this.deep = deep;
        this.randomChildRenCount = randomChildRenCount;
        this.randomChildRenCountSeed = randomChildRenCountSeed;
    }

    @Override
    public T buildTree() {
        generateTreeNodes();
        T rootNode = data.get(ROOT_LEAVE).get(0);
        processTreeNode(rootNode);
        return rootNode;

    }

    /**
     * 生成树list,此时是无序状态
     */
    private void generateTreeNodes() {
        if (deep < 1 || deep > MAX_LEVEL) {
            throw new IllegalArgumentException("Illegal tree deep -> " + deep);
        }
        for (int indexOfLayer = 1; indexOfLayer <= deep; indexOfLayer++) {
            data.put(indexOfLayer, generateLayer(indexOfLayer));
        }
    }

    /**
     * deal node of tree
     *
     * @param rootNode the root node of tree
     */
    protected void processTreeNode(T rootNode) {
    }

    /**
     * 生成树的某层节点，并为节点建立父子关系
     *
     * @param indexOfLayer 树的层级
     * @return 当前层级树的节点
     */
    private List<T> generateLayer(int indexOfLayer) {
        List<T> treeNodes = new ArrayList<>();
        // if the indexOfLayer is the index of first layer,
        // only generate a root node;
        if (indexOfLayer == 1) {
            treeNodes.add(generateOneNode(null));
            return treeNodes;
        }

        // If the value of "childrenCount" less then MINIMUM_NUMBER_OF_NODES_PER_LAYER,
        //  assign "childrenCount" to {indexOfLayer * indexOfLayer}
        if (countOfChildren < MINIMUM_NUMBER_OF_NODES_PER_LAYER) {
            countOfChildren = indexOfLayer * indexOfLayer;
        }

        // get treeNodes of parent indexOfLayer
        List<T> parentTreeNodes = data.get(indexOfLayer - 1);
        for (T parentTreeNode : parentTreeNodes) {
            generateChildren(parentTreeNode, treeNodes);
        }
        return treeNodes;

    }

    /**
     * generate one tree Node
     *
     * @param parent parent node i
     * @return return the newly generated node
     */
    private T generateOneNode(T parent) {
        String name = DataPrepareUtil.prepareOneStringString(TREE_NODE_NAME_LENGTH);
        T treeNode = getTreeNode();
        treeNode.setName(name);
        // not the root node of the tree
        if (parent != null) {
            treeNode.addParent(parent);
            parent.addChild(treeNode);
            treeNode.setLevel(parent.getLevel() + 1);
        } else {
            treeNode.setLevel(1);
        }
        treeNode.setId(String.format("%s_%s", name, RandomUtil.prepareInt(SEED)));
        // Store the generated treeNode in a map for subsequent lookups。
        allTreeNodes.put(treeNode.getId(), treeNode);
        return treeNode;
    }

    /**
     * generate children node fo parent node
     *
     * @param parent    parent node
     * @param treeNodes a list that  store all nodes of current layer
     */
    private void generateChildren(T parent, List<T> treeNodes) {
        if (randomChildRenCount) {
            countOfChildren = RandomUtil.prepareInt(0, randomChildRenCountSeed + 1);
        }
        for (int i = 0; i < countOfChildren; i++) {
            treeNodes.add(generateOneNode(parent));
        }
    }

    /**
     * get tree node
     *
     * @return tree node
     */
    protected abstract T getTreeNode();
}
