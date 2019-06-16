package com.harryai.algorithm.algorithm.sort;

import com.harryai.algorithm.Util.LogUtil;
import com.harryai.algorithm.Util.TreeNodePrepareUtil;
import com.harryai.algorithm.mode.TreeNode;
import org.apache.commons.lang3.SerializationUtils;

import java.util.*;

/**
 * @author harry
 * 对树结构进行排序
 * 结论： 递归排序比stack排序会慢一点
 */
public class TreeSort {
    private static TreeNode tree = TreeNodePrepareUtil.prepareTree(89);
    private Comparator<TreeNode> comparator = (a, b) -> a.getName().compareToIgnoreCase(b.getName());

    /**
     * 使用stack 对树进行排序
     *
     * @param tree
     */
    private static void sortTreeWithStack(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            List<TreeNode> children = pop.getChildren();
            if (children == null || children.isEmpty()) {
                continue;
            }
            Collections.sort(children);
            stack.addAll(children);
        }
    }

    /**
     * 递归排序树
     *
     * @param tree
     */
    private static void sortTreeWithRecursion(TreeNode tree) {

        if (tree == null) {
            throw new NullPointerException();
        }

        List<TreeNode> children = tree.getChildren();
        if (Objects.isNull(children) || children.isEmpty()) {

            return;
        }
        Collections.sort(children);
        children.forEach(treeNode -> sortTreeWithRecursion(treeNode));

    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        TreeNode clone = SerializationUtils.clone(tree);
        long cloneEnd = LogUtil.logCost("clone", start);
        sortTreeWithRecursion(tree);
        long recursionSort = LogUtil.logCost("recursion sort", cloneEnd);
        sortTreeWithStack(clone);
        long stack_sort = LogUtil.logCost("stack sort", recursionSort);
        List<TreeNode> treeNodes = TreeNodePrepareUtil.tree2FlatList(tree);
        LogUtil.logCost("tree to flat list", stack_sort);
        System.out.println("tree node size is : " + treeNodes.size());

//        TreeNodePrepareUtil.smartPrintTree(tree);

    }


}
