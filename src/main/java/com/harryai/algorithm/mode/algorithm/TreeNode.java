package com.harryai.algorithm.mode.algorithm;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data()
@ToString(exclude = {"children"})
@EqualsAndHashCode(of = {"id"})
public class TreeNode implements Comparable<TreeNode>, Serializable {
    private String id;
    private String name;
    private String parentId;
    private int level;
    private List<TreeNode> children = new ArrayList<>();

    @Override
    public int compareTo(TreeNode o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
}
