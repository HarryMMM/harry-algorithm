package com.harryai.algorithm.common.tree.model;

/**
 * @author Harry
 * @since 2020/04/14 22:20
 **/
public class SimpleDataNode<T> extends AbstractDataNode<T> {
    public SimpleDataNode(T data, SimpleDataNode<T> next) {
        super(data, next);
    }
}
