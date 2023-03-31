//Given the head of a singly linked list, reverse the list, and return the 
//reversed list. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. 
//Could you implement both? 
//
// Related Topics Linked List Recursion 👍 17257 👎 309

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.common.linkedlist.ListNode;
import com.harryai.algorithm.common.tree.utils.LinkedListUtils;

//java:Reverse Linked List
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        ListNode listNode = LinkedListUtils.array2LinkedList(1, 2, 3);
        LinkedListUtils.print(listNode);
        LinkedListUtils.print(solution.reverseList(listNode));
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
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                // 记录当前节点的下一个节点
                ListNode tmp = cur.next;
                // 把当前节点的下一个节点置为上一个节点（反转）
                cur.next = pre;
                // 将当前节点置为下一个节点
                pre = cur;
                // 将之前保存的下一个节点置为当前节点
                cur = tmp;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
