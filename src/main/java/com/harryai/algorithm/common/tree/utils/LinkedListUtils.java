package com.harryai.algorithm.common.tree.utils;

import com.harryai.algorithm.common.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * <p>
 *
 * @author haorui.hao
 * @since 2023/03/26 18:05
 **/
public class LinkedListUtils {
    public static ListNode array2LinkedList(Integer... integers) {
        ListNode pre = null;
        for (int i = integers.length - 1; i >= 0; i--) {
            pre = new ListNode(integers[i], pre);
        }
        return pre;
    }

    public static void print(ListNode node) {
        List<Integer> l = new ArrayList<>();
        while (node != null) {
            l.add(node.val);
            node = node.next;
        }
        System.out.println(l);
    }
}
