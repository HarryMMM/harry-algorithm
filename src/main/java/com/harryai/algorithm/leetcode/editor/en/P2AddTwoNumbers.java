//You are given two non-empty linked lists representing two non-negative
//integers. The digits are stored in reverse order, and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
// Related Topics Linked List Math Recursion 👍 16000 👎 3427

//java:Add Two Numbers
package com.harryai.algorithm.leetcode.editor.en;

public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        ListNode l1 = new P2AddTwoNumbers().new ListNode(2);
        ListNode l11 = l1.next = new P2AddTwoNumbers().new ListNode(4);
        ListNode l12 = l11.next = new P2AddTwoNumbers().new ListNode(3);
        ListNode l2 = new P2AddTwoNumbers().new ListNode(5);
        ListNode l21 = l2.next = new P2AddTwoNumbers().new ListNode(6);
        ListNode l22 = l21.next = new P2AddTwoNumbers().new ListNode(4);
        ListNode l23 = l22.next = new P2AddTwoNumbers().new ListNode(5);


        ListNode listNode = solution.addTwoNumbers(l1, l2);
        do {
            System.out.println(listNode.val);
        } while ((listNode = listNode.next) != null);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode emptyNode = new ListNode();
            ListNode cur = emptyNode;
            int carry = 0;
            do {
                int a = l1 == null ? 0 : l1.val;
                int b = l2 == null ? 0 : l2.val;
                int sum = a + b + carry;
                carry = sum / 10;
                cur = (cur.next = new ListNode(sum % 10));
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            } while (l1 != null || l2 != null);
            if (carry>0) {
                cur.next = new ListNode(carry);
            }
            return emptyNode.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
