package com.harryai.algorithm.common.tree.utils;

import com.harryai.algorithm.utlis.DataPrepareUtil;
import com.harryai.algorithm.utlis.RandomUtil;
import com.harryai.algorithm.common.tree.model.AbstractNode;
import com.harryai.algorithm.common.tree.model.BinaryTreeNode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author Harry
 * @since 2020/04/03 16:31
 **/
public class TreeUtils {

    /**
     * 前序遍历二叉树
     *
     * @param binaryTreeNode 二叉树根节点
     * @param consumer 遍历的动作
     */
    public static void preOrderTraversal(BinaryTreeNode binaryTreeNode, Consumer<BinaryTreeNode> consumer) {
        if (binaryTreeNode == null) {
            return;
        }
        consumer.accept(binaryTreeNode);
        preOrderTraversal(binaryTreeNode.getLeft(), consumer);
        preOrderTraversal(binaryTreeNode.getRight(), consumer);
    }

    /**
     * In-order traversal binary tree
     *
     * @param binaryTreeNode root node of binary tree
     * @param consumer Traversal action
     */
    public static void inOrderTraversalStack(BinaryTreeNode binaryTreeNode, Consumer<BinaryTreeNode> consumer) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        BinaryTreeNode currentNode = binaryTreeNode;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            } else {
                BinaryTreeNode pop = stack.pop();
                consumer.accept(pop);
                currentNode = pop.getRight();
            }
        }
    }

    /**
     * pre-order traversal binary tree
     *
     * @param binaryTreeNode root node of binary tree
     * @param consumer Traversal action
     */
    public static void preOrderTraversalStack(BinaryTreeNode binaryTreeNode, Consumer<BinaryTreeNode> consumer) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        BinaryTreeNode currentNode = binaryTreeNode;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                consumer.accept(currentNode);
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            } else {
                BinaryTreeNode pop = stack.pop();
                currentNode = pop.getRight();
            }
        }
    }

    /**
     * Post-order traversal binary tree
     *
     * @param binaryTreeNode root node of binary tree
     * @param consumer Traversal action
     */
    public static void postOrderTraversalStack(BinaryTreeNode binaryTreeNode, Consumer<BinaryTreeNode> consumer) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        stack.push(binaryTreeNode);
        LinkedList<BinaryTreeNode> ret = new LinkedList<>();
        while (!stack.isEmpty()) {
            BinaryTreeNode pop = stack.pop();
            if (pop != null) {
                ret.addFirst(pop);
                stack.push(pop.getLeft());
                stack.push(pop.getRight());
            }
        }
        ret.forEach(consumer);
    }

    /**
     * 中序遍历二叉树
     *
     * @param binaryTreeNode 二叉树根节点
     * @param consumer 遍历的动作
     */
    public static void inOrderTraversal(BinaryTreeNode binaryTreeNode, Consumer<BinaryTreeNode> consumer) {
        if (binaryTreeNode == null) {
            return;
        }
        inOrderTraversal(binaryTreeNode.getLeft(), consumer);
        consumer.accept(binaryTreeNode);
        inOrderTraversal(binaryTreeNode.getRight(), consumer);
    }

    /**
     * 后序遍历二叉树
     *
     * @param binaryTreeNode 二叉树根节点
     * @param consumer 遍历的动作
     */
    public static void postOrderTraversal(BinaryTreeNode binaryTreeNode, Consumer<BinaryTreeNode> consumer) {
        if (binaryTreeNode == null) {
            return;
        }
        postOrderTraversal(binaryTreeNode.getLeft(), consumer);
        postOrderTraversal(binaryTreeNode.getRight(), consumer);
        consumer.accept(binaryTreeNode);
    }

    /**
     * Level Traversal
     *
     * @param binaryTreeNode binary root node
     * @param consumer action
     */
    public static void levelTraversal(BinaryTreeNode binaryTreeNode, Consumer<BinaryTreeNode> consumer) {
        if (binaryTreeNode == null) {
            return;
        }
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(binaryTreeNode);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            consumer.accept(node);
            BinaryTreeNode left = node.getLeft();

            if (left != null) {
               queue.offer(left);
            }
            BinaryTreeNode right = node.getRight();
            if (right != null) {
                queue.offer(right);
            }
        }
    }


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

    /**
     * calculate the depth of the binary tree
     *
     * @param root the root node of binary tree
     * @return the depth of the binary thee
     */
    public static int calculateBinaryDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculateBinaryDepth(root.getLeft());
        int right = calculateBinaryDepth(root.getRight());
        return Math.max(left, right) + 1;
    }

    public static BinaryTreeNode copyBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode left = copyBinaryTree(root.getLeft());
        BinaryTreeNode right = copyBinaryTree(root.getRight());
        return getNewBinaryTreeNode(root, left, right);

    }

    /**
     * Create a binary using an extended sequence of character beds
     *
     * @param parent 父节点
     * @param str extended sequence of character beds
     * @return binary three
     */
    public static BinaryTreeNode creatBinaryTree(BinaryTreeNode parent, LinkedList<String> str) {
        String name = str.pop();
        if (" ".equals(name)) {
            return null;
        }
        BinaryTreeNode root = initNewNode(parent, name);
        BinaryTreeNode left = creatBinaryTree(root, str);
        root.setLeft(left);
        root.addChild(left);
        BinaryTreeNode right = creatBinaryTree(root, str);
        root.setRight(right);
        root.addChild(right);
        return root;
    }

    /**
     * create a binary three using the given pre-order sequence and in-order sequence
     *
     * @param parent parent node
     * @param perOrderStr pre-order sequence
     * @param inOrderStr in-order sequence
     * @param preIndex the position of the root node in the pre-order sequence of the current binary tree
     * @param inIndex the position of the root node in the in-order sequence of the current binary tree
     * @param eleTotalCount the total number of nodes in the current tree nodes
     * @return the root node of current tree
     */
    public static BinaryTreeNode createBinaryTreeWithPreOrderAndInOrder(BinaryTreeNode parent, String[] perOrderStr,
                                                                        String[] inOrderStr,
                                                                        int preIndex, int inIndex, int eleTotalCount) {
        if (eleTotalCount < 1) {
            return null;
        }
        String name = perOrderStr[preIndex];
        BinaryTreeNode root = initNewNode(parent, name);
        int indexOfRootInInOrderStr = search(inOrderStr, name);
        if (indexOfRootInInOrderStr < 0) {
            throw new IllegalArgumentException("Illegal in-order str");
        }
        if (indexOfRootInInOrderStr != inIndex) {
            BinaryTreeNode left = createBinaryTreeWithPreOrderAndInOrder(root, perOrderStr, inOrderStr, preIndex + 1, inIndex,
                    indexOfRootInInOrderStr - inIndex);
            root.setLeft(left);
            root.addChild(left);
        }
        if (indexOfRootInInOrderStr != inIndex + eleTotalCount + 1) {
            BinaryTreeNode right = createBinaryTreeWithPreOrderAndInOrder(root, perOrderStr, inOrderStr,
                    // 当前节点【右子树根节点】在pre-order中的位置应当为【当前节点在pre-order中的位置（preIndex）
                    // 加
                    // 当前节点左子树节点个数(indexOfRootInInOrderStr - inIndex)
                    // 再加 1】
                    preIndex + 1 + (indexOfRootInInOrderStr - inIndex),
                    // 当前节点【右子树根节】点在in-order中的位置应当为【当前节点在in-order中的位置（indexOfRootInInOrderStr）
                    // 加 1】
                    indexOfRootInInOrderStr + 1,
                    // 当前节点右子树的节点总个数为 【以当前节点为根的树节点的个数（eleTotalCount）
                    // 减去
                    // 当前节点左子树节点的个数(indexOfRootInInOrderStr - inIndex)】
                    // 再减 1
                    eleTotalCount - (indexOfRootInInOrderStr - inIndex) - 1);
            root.setRight(right);
            root.addChild(right);
        }
        return root;
    }

    /**
     * A rough algorithm for finding the location of a specified value from an array
     *
     * @param arr 数组
     * @param key 指定值
     * @return
     */
    private static int search(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private static BinaryTreeNode initNewNode(BinaryTreeNode parent, String name) {
        BinaryTreeNode root = new BinaryTreeNode();
        root.setId(name + "_" + RandomUtil.prepareInt(10000));
        root.setName(name);
        root.addParent(parent);
        if (parent != null) {
            root.setLevel(parent.getLevel() + 1);
        } else {
            root.setLevel(1);
        }
        return root;
    }

    private static BinaryTreeNode getNewBinaryTreeNode(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right) {
        BinaryTreeNode newRoot = new BinaryTreeNode();
        newRoot.setLeft(left);
        newRoot.setRight(right);
        newRoot.setLevel(root.getLevel());
        newRoot.setName(root.getName());
        newRoot.setId(root.getId());
        newRoot.addParent(newRoot.getParent());
        newRoot.addChild(left);
        newRoot.addChild(right);
        return newRoot;
    }

}
