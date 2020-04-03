package com.harryai.algorithm.common.tree.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Harry
 * @since 2020/04/03 12:37
 **/
public interface Node<T> extends Comparable<MultiWayTreeNode>, Serializable {
    List<T> getChildren();

}
