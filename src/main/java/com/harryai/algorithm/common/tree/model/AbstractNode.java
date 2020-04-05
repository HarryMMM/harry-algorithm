package com.harryai.algorithm.common.tree.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry
 * @since 2020/04/03 12:39
 **/
public abstract class AbstractNode<T extends AbstractNode> implements Node<T> {
    protected T parent;
    protected String id;
    protected String name;
    protected String parentId;
    protected List<T> children = new ArrayList<>();
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getParentId() {
        return parentId;
    }

    public T getParent() {
        return parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(MultiWayTreeNode o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<T> getChildren() {
        return children;
    }

    public void addChild(T child) {
        if (child != null) {
            children.add(child);
        }
    }


    public void addParent(T parent) {
        if (parent != null) {
            this.parent = parent;
            this.parentId = parent.id;
        }
    }

    @Override
    public String toString() {
        return "AbstractNode{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", level=" + level +
                '}';
    }
}
