package com.harryai.algorithm.common.linkedlist;

/**
 * <p>
 *
 * <p>
 *
 * @author haorui.hao
 * @since 2023/03/14 22:00
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public ListNode(int val, ListNode listNode) {
        this.val = val;
        this.next = listNode;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
