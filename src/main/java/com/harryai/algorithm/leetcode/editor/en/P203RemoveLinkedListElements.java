//Given the head of a linked list and an integer val, remove all the nodes of 
//the linked list that has Node.val == val, and return the new head. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,6,3,4,5,6], val = 6
//Output: [1,2,3,4,5]
// 
//
// Example 2: 
//
// 
//Input: head = [], val = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [7,7,7,7], val = 7
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 10⁴]. 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics Linked List Recursion 👍 6954 👎 204

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.common.linkedlist.ListNode;
import com.harryai.algorithm.common.tree.utils.LinkedListUtils;

//java:Remove Linked List Elements
public class P203RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
        ListNode listNode = LinkedListUtils.array2LinkedList(1, 2, 6, 3, 4, 5, 6);
        LinkedListUtils.print(listNode);
        solution.removeElements(listNode, 6);
        LinkedListUtils.print(listNode);

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
        public ListNode removeElements(ListNode head, int val) {
            ListNode falseHead = new ListNode(-1, head);
            ListNode cur = falseHead;
            while (cur.next != null) {
                // 如果当前节点的下个节点的值等于给定的值，删除
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else { // 否则，移动指针
                    cur = cur.next;
                }
            }
            return falseHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
