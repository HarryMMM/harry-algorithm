package com.harryai.algorithm.common.tree.utils;

import com.harryai.algorithm.Util.DataPrepareUtil;
import com.harryai.algorithm.common.tree.model.AbstractNode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Harry
 * @since 2020/04/03 16:31
 **/
public class TreeUtils {

    /**
     * 将树结构转换为list
     * 主要用于对树排序后，需要扁平化展示树数据
     *
     * @param tree 树
     * @return 树的平表
     */
    public static <T extends AbstractNode<T>> List<T> tree2FlatList(T tree) {
        List<T> res = new ArrayList<>();
        LinkedList<T> treeNodes = new LinkedList<>();
        treeNodes.add(tree);
        while (!treeNodes.isEmpty()) {
            T pop = treeNodes.pollFirst();
            res.add(pop);
            List<T> children = pop.getChildren();
            if (CollectionUtils.isEmpty(children)) {
                continue;
            }
            treeNodes.addAll(0, children);
        }
        return res;
    }

    /**
     * 输出树所有节点
     *
     * @param rootNode 树节点
     */
    public static <T extends AbstractNode<T>> void smartPrintTree(T rootNode) {
        LinkedList<T> queue = new LinkedList<>();
        queue.push(rootNode);
        while (!queue.isEmpty()) {
            T treeNode1 = queue.pollFirst();
            int level = treeNode1.getLevel();
            String space = StringUtils.EMPTY;
            if (level > 1) {
                space = DataPrepareUtil.preParespecifyString(" ", level);
            }
            System.out.println(space + treeNode1);
            List<T> children = treeNode1.getChildren();
            if (Objects.nonNull(children) && !children.isEmpty()) {
                queue.addAll(0, children);
            }
        }
    }

    //
}
