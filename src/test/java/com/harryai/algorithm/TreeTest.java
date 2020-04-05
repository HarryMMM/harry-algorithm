package com.harryai.algorithm;

import com.harryai.algorithm.common.tree.factory.BinaryTreeFactory;
import com.harryai.algorithm.common.tree.factory.MultiwayTreeFactory;
import com.harryai.algorithm.common.tree.model.BinaryTreeNode;
import com.harryai.algorithm.common.tree.model.MultiWayTreeNode;
import com.harryai.algorithm.common.tree.utils.TreeUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/**
 * @author Harry
 * @since 2020/04/03 16:12
 **/
public class TreeTest {
    @Test
    public void testBinaryTree() {
        BinaryTreeFactory binaryTreeFactory = new BinaryTreeFactory(3, true);
        BinaryTreeNode binaryTreeNode = binaryTreeFactory.buildTree();
        TreeUtils.smartPrintTree(binaryTreeNode);
    }

    @Test
    public void testNaryTree() {
        MultiwayTreeFactory multiwayTreeFactory = new MultiwayTreeFactory(3, true, 3);
        MultiWayTreeNode multiwayTreeNode = multiwayTreeFactory.buildTree();
        TreeUtils.smartPrintTree(multiwayTreeNode);
    }

    @Test
    public void testOrder() {
        BinaryTreeNode a = initBinaryTree();
        TreeUtils.smartPrintTree(a);
        System.out.println("-----------------------------------");
        Consumer<BinaryTreeNode> consumer = node -> {
            if (node != null) {
                System.out.println(node);
            }
        };
        System.out.println("-----------------------------------");
//        TreeUtils.preOrderStack(a, consumer);
        System.out.println("-----------------------------------");
//        TreeUtils.inOrderStack(a, consumer);
        System.out.println("-----------------------------------");
        TreeUtils.postOrderTraversalStack(a, consumer);
    }

    private BinaryTreeNode initBinaryTree() {
        BinaryTreeNode a = ne("A");
        a.setLevel(1);
        BinaryTreeNode b = ne("B");
        b.setLevel(2);
        BinaryTreeNode c = ne("C");
        c.setLevel(2);
        a.setLeft(b);
        a.setRight(c);
        a.addChild(b);
        a.addChild(c);
        BinaryTreeNode d = ne("D");
        d.setLevel(3);
        BinaryTreeNode e = ne("E");
        e.setLevel(3);
        b.setLeft(d);
        b.setRight(e);
        b.addChild(d);
        b.addChild(e);
        BinaryTreeNode f = ne("F");
        f.setLevel(3);
        c.setRight(f);
        c.addChild(f);
        BinaryTreeNode g = ne("G");
        g.setLevel(4);
        d.setLeft(g);
        d.addChild(g);
        return a;
    }

    BinaryTreeNode ne(String name) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
        binaryTreeNode.setName(name);
        return binaryTreeNode;
    }

    @Test
    public void countLeaf() {
        AtomicInteger count = new AtomicInteger();
        TreeUtils.preOrderTraversal(initBinaryTree(), e -> {
            if (e.getRight() == null && e.getLeft() == null) {
                count.getAndIncrement();
            }
        });
        System.out.println(count.get());
    }
    @Test
    public void findNode() {
        String nodeName="e";
        AtomicReference<BinaryTreeNode> node=new AtomicReference<>();
        TreeUtils.preOrderTraversal(initBinaryTree(), e -> {
            if (nodeName.equalsIgnoreCase(e.getName())) {
                node.set(e);
            }
        });
        System.out.println(node);
    }
    @Test
    public void binaryDeep() {
        System.out.println(TreeUtils.calculateBinaryDepth(initBinaryTree()));
    }
    @Test
    public void copyBinaryTree() {
        BinaryTreeNode node = initBinaryTree();
        BinaryTreeNode newTree = TreeUtils.copyBinaryTree(node);
        TreeUtils.smartPrintTree(node);
        System.out.println("-----------------------------------");
        TreeUtils.smartPrintTree(newTree);
    }
    @Test
    public void createBinaryTree() {
        String preString="AB C  D  ";
        LinkedList<String> str = new LinkedList<>(Arrays.asList(preString.split("")));
        BinaryTreeNode newTree = TreeUtils.creatBinaryTree(null,str);
        TreeUtils.smartPrintTree(newTree);
    }
    @Test
    public void createBinaryTreeWithPreOrderAndInOrder() {
        String[] preString="ABECD".split("");
        String []inString="EBCAD".split("");
        BinaryTreeNode newTree = TreeUtils.createBinaryTreeWithPreOrderAndInOrder(null,preString,inString,0,0,
                preString.length);
        TreeUtils.smartPrintTree(newTree);
        TreeUtils.levelTraversal(newTree,System.out::println);
    }

}
