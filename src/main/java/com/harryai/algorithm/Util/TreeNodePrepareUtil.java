package com.harryai.algorithm.Util;

import com.harryai.algorithm.mode.algorithm.TreeNode;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TreeNodePrepareUtil {
    // treeNode id random SEED
    public static final int SEED = 10000;
    // treeNode name length
    public static final int TREE_NODE_LENGTH = 5;
    public static final int MAX_LEVEL = 90000;
    private static final Map<Integer, List<TreeNode>> DATA = new ConcurrentHashMap<>();
    private static final Map<String, TreeNode> ALL_TREE_NODES = new ConcurrentHashMap<>();

    public static TreeNode prepareTree(int levels) {
        return buildTree(prepareTreeNodesList(levels));
    }

    /**
     * 生成树list,此时是无序状态
     * @param level
     * @return
     */
    public static List<TreeNode> prepareTreeNodesList(int level) {
        List<TreeNode> treeNodesList = new ArrayList<>();
        if (level < 1 || level > MAX_LEVEL) {
            throw new IllegalArgumentException("Illegal tree level -> " + level);
        }
        for (int i = 1; i <= level; i++) {
            DATA.put(i, prepareTreeNodeOfLevel(i));
        }
        DATA.values().forEach(e -> treeNodesList.addAll(e));
        return treeNodesList;
    }

    /**
     * 生成树的某层节点，并添加父id
     *
     * @param level 树的层级
     * @return 当前层级树的节点
     */
    public static List<TreeNode> prepareTreeNodeOfLevel(int level) {
        List<TreeNode> treeNodes = new ArrayList<>();
        // the node count of current level
        int count = level * level;
        // generate tree node names
        List<String> treeNodeNames = DataPrepareUtil.prepareStringData(count, TREE_NODE_LENGTH);
        // get treeNodes of parent level
        List<TreeNode> parentTreeNodes = DATA.get(level - 1);

        treeNodeNames.forEach(treeNodeName -> {
            String parentId = StringUtils.EMPTY;
            // 如果不为空，表示有父节点。
            if (Objects.nonNull(parentTreeNodes) && !parentTreeNodes.isEmpty()) {
                int size = parentTreeNodes.size();
                TreeNode parentNode = parentTreeNodes.get(RandomUtil.prepareInt(size));
                parentId = parentNode.getId();
            }
            treeNodes.add(prepareTreeNode(treeNodeName, parentId, level));
        });

        return treeNodes;

    }

    /**
     * 生成一个treeNode
     *
     * @param name     树节点的名字
     * @param parentId 树节点的父id
     * @return 返回生成的节点
     */
    public static TreeNode prepareTreeNode(String name, String parentId, int level) {
        TreeNode treeNode = new TreeNode();
        treeNode.setName(name);
        treeNode.setParentId(parentId);
        treeNode.setLevel(level);
        treeNode.setId(String.format("%s_%s", name, RandomUtil.prepareInt(SEED)));
        // 将生成的treeNode存储在map中，供后续查找。
        ALL_TREE_NODES.put(treeNode.getId(), treeNode);
        return treeNode;
    }


    // 将树节点构建成树结构
    public static TreeNode buildTree(List<TreeNode> treeNodeList) {
        List<TreeNode> treeNodes = new ArrayList<>();

        treeNodeList.forEach(
                treeNode -> {
                    if (StringUtils.isEmpty(treeNode.getParentId())) {
                        treeNodes.add(treeNode);
                    } else {
                        ALL_TREE_NODES.get(treeNode.getParentId()).getChildren().add(treeNode);
                    }
                }
        );

        return treeNodes.get(0);
    }

    /**
     * 输出树所有节点
     * @param treeNode
     */
    public static void smartPrintTree(TreeNode treeNode) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(treeNode);
        while (!queue.isEmpty()) {
            TreeNode treeNode1 = queue.pollFirst();
            int level = treeNode1.getLevel();
            String space = StringUtils.EMPTY;
            if (level > 1) {
                space = DataPrepareUtil.preParespecifyString(" ", level);
            }
            System.out.println(space + treeNode1);
            List<TreeNode> children = treeNode1.getChildren();
            if (Objects.nonNull(children) && !children.isEmpty()) {
                queue.addAll(0, children);
            }

        }
    }

    /**
     * 将树结构转换为list
     * 主要用于对树排序后，需要扁平化展示树数据
     * @param tree
     * @return
     */
    public static List<TreeNode> tree2FlatList(TreeNode tree) {
        List<TreeNode> res = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(tree);
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pollFirst();
            res.add(pop);
            List<TreeNode> children = pop.getChildren();
            if (Objects.isNull(children) && children.isEmpty()) {
                continue;
            }
            treeNodes.addAll(0, children);
        }
        return res;
    }
}
