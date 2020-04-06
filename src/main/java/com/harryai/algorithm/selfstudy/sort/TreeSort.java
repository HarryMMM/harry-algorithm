package com.harryai.algorithm.selfstudy.sort;

import com.harryai.algorithm.utlis.LogUtil;
import com.harryai.algorithm.common.tree.factory.MultiwayTreeFactory;
import com.harryai.algorithm.common.tree.model.MultiWayTreeNode;
import com.harryai.algorithm.common.tree.utils.TreeUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.util.*;

/**
 * @author harry
 * 对树结构进行排序
 * 结论： 递归排序比stack排序会慢一点
 */
public class TreeSort {
    private static MultiWayTreeNode tree = new MultiwayTreeFactory(5,5).buildTree();
    private Comparator<MultiWayTreeNode> comparator = (a, b) -> a.getName().compareToIgnoreCase(b.getName());

    /**
     * 使用stack 对树进行排序
     *
     * @param tree
     */
    private static void sortTreeWithStack(MultiWayTreeNode tree) {
        Stack<MultiWayTreeNode> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            MultiWayTreeNode pop = stack.pop();
            List<MultiWayTreeNode> children = pop.getChildren();
            if (children == null || children.isEmpty()) {
                continue;
            }
            Collections.sort(children);
            stack.addAll(children);
        }
    }
    private static void sortTreeWithStack1(MultiWayTreeNode tree) {
        Stack<MultiWayTreeNode> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            MultiWayTreeNode pop = stack.pop();
            List<MultiWayTreeNode> children = pop.getChildren();
            if (children == null || children.isEmpty()) {
                continue;
            }
            QuickSort.sort(children,0,children.size()-1);
            stack.addAll(children);
        }
    }

    /**
     * 递归排序树
     *
     * @param tree
     */
    private static void sortTreeWithRecursion(MultiWayTreeNode tree) {

        if (tree == null) {
            throw new NullPointerException();
        }

        List<MultiWayTreeNode> children = tree.getChildren();
        if (Objects.isNull(children) || children.isEmpty()) {

            return;
        }
        Collections.sort(children);
        children.forEach(treeNode -> sortTreeWithRecursion(treeNode));

    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        MultiWayTreeNode clone = SerializationUtils.clone(tree);
        long cloneEnd = LogUtil.logCost("clone", start);
        sortTreeWithStack1(tree);
        long quickSort = LogUtil.logCost("quick sort", cloneEnd);
        sortTreeWithStack(clone);
        long stack_sort = LogUtil.logCost("stack sort", quickSort);
        List<MultiWayTreeNode> treeNodes = TreeUtils.tree2FlatList(tree);
        LogUtil.logCost("tree to flat list", stack_sort);
        System.out.println("tree node size is : " + treeNodes.size());

//        TreeNodePrepareUtil.smartPrintTree(tree);

    }


}
