package com.harryai.algorithm.practicing.reverse;

import com.harryai.algorithm.common.tree.model.SimpleDataNode;

/**
 * @author Harry
 * @since 2020/04/14 22:17
 **/
public class ReverseLinkedList {
    public static void main(String[] args) {
        SimpleDataNode<Integer> four = new SimpleDataNode<>(4, null);
        SimpleDataNode<Integer> three = new SimpleDataNode<>(3, four);
        SimpleDataNode<Integer> two = new SimpleDataNode<>(2, three);
        SimpleDataNode<Integer> one = new SimpleDataNode<>(1, two);
        printLinkList(one);


        SimpleDataNode<Integer> head = reverseLinkedList(one);
        printLinkList(head);
    }

    private static void printLinkList(SimpleDataNode<Integer> head) {
        SimpleDataNode<Integer> tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static <T> SimpleDataNode<T> reverseLinkedList(SimpleDataNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        SimpleDataNode<T> p = null;
        SimpleDataNode<T> q = null;
        while (head != null) {
            q = head.next;
            head.next = p;
            p = head;
            head = q;
        }
        return p;
    }
}
