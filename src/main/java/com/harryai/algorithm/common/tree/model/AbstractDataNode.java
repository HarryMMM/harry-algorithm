package com.harryai.algorithm.common.tree.model;

/**
 * @author Harry
 * @since 2020/04/14 22:19
 **/
public abstract class AbstractDataNode<T> implements Node<T> {
    public T data;
    public SimpleDataNode<T> next;

    public AbstractDataNode(T data, SimpleDataNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "AbstractDataNode{" +
                "data=" + data +
                '}';
    }
}
