//Given the head of a singly linked list, return true if it is a palindrome or 
//false otherwise. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in 
//O(n) time and 
//O(1) space?
//
// Related Topics Linked List Two Pointers Stack Recursion 👍 13672 👎 749

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.common.linkedlist.ListNode;
import com.harryai.algorithm.common.tree.utils.LinkedListUtils;

//java:Palindrome Linked List
public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        ListNode listNode = LinkedListUtils.array2LinkedList(1, 2, 2, 1);
        System.out.println(solution.isPalindrome(listNode));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        ListNode frontPoint;

        public boolean isPalindrome(ListNode head) {
            frontPoint = head;
            return check(frontPoint);
        }

        private boolean check(ListNode current) {
            if (current != null) {
                if (!check(current.next)) {
                    return false;
                }
                if (frontPoint.val != current.val) {
                    return false;
                }
                frontPoint = frontPoint.next;
            }
            // 执行到链表尾部后的空节点，或相等时，会执行这步骤
            return true;
        }


//        public boolean isPalindrome(ListNode head) {
//
//            // #1 使用快慢指针找前半部分和后半部分
//            ListNode flow = head;
//            ListNode fast = head.next;
//            while (fast != null && fast.next != null) {
//                flow = flow.next;
//                fast = fast.next.next;
//            }
//
//            ListNode leftPart = head;
//            // 找到后半部分并反转以便后续比较
//            ListNode rightPart = flow.next = reverse(flow.next);
//            // #3 比较
//            boolean res = true;
//            while (rightPart != null) {
//                if (rightPart.val != leftPart.val) {
//                    res = false;
//                    break;
//                }
//                leftPart = leftPart.next;
//                rightPart = rightPart.next;
//            }
//            // #4 恢复反转的链表
//            flow.next = reverse(flow.next);
//            // #5 返回结果
//            return res;
//        }
//
//        private ListNode reverse(ListNode node) {
//            ListNode pre = null;
//            while (node != null) {
//                ListNode next = node.next;
//                node.next = pre;
//                pre = node;
//                node = next;
//            }
//            return pre;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
