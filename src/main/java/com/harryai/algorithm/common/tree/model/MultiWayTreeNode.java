package com.harryai.algorithm.common.tree.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Harry
 * @since 2020/04/03 12:37
 **/
public class MultiWayTreeNode extends AbstractTreeNode<MultiWayTreeNode> {


    @Override
    public int compareTo(MultiWayTreeNode o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MultiWayTreeNode that = (MultiWayTreeNode) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }


    @Override
    public String toString() {
        return "MultiWayTreeNode{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
