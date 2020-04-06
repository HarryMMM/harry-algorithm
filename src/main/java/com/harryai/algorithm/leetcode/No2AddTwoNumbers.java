package com.harryai.algorithm.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * @author Harry
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class No2AddTwoNumbers {

    public static void main(String[] args) {
        ListNode one1 = new ListNode(2);
        ListNode one2 = new ListNode(4);
        one1.next = one2;
        one2.next = new ListNode(3);

        ListNode two1 = new ListNode(5);
        ListNode two2 = new ListNode(6);
        two1.next = two2;
        two2.next = new ListNode(4);

        ListNode listNode = new No2AddTwoNumbers().addTwoNumbers(one1, two1);
        System.out.println(listNode.val);
        while ((listNode = listNode.next) != null) {
            System.out.println(listNode.val);
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode currentNode, result = new ListNode(-1);
        currentNode = result;
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            currentNode.next = new ListNode(carry % 10);
            carry = carry / 10;
            currentNode = currentNode.next;
        }
        return result.next;
    }


    // 性能不好
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<>();
        ListNode result = new ListNode(-1);
        ListNode currentNode = result;
        int sum;
        while (l1 != null || l2 != null || !stack.empty()) {

            if (Objects.nonNull(l1)) {
                stack.push(l1.val);
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)) {
                stack.push(l2.val);
                l2 = l2.next;
            }

            sum = 0;
            while (!stack.empty()) {
                sum += stack.pop();
            }
            if (sum >= 10) {
                currentNode.next = new ListNode(sum % 10);
                stack.push(1);
            } else {
                currentNode.next = new ListNode(sum);
            }

            currentNode = currentNode.next;
        }

        return result.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}