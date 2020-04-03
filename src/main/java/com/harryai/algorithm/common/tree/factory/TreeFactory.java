package com.harryai.algorithm.common.tree.factory;

/**
 * @author Harry
 * @since 2020/04/03 14:45
 **/
public interface TreeFactory<T> {
    /**
     * 构建树
     * @return 树的根节点
     */
    T buildTree();
}
