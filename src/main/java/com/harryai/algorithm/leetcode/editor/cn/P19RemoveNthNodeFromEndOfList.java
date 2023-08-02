//Given the head of a linked list, remove the nᵗʰ node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
//
// Related Topics 链表 双指针 👍 2614 👎 0

package com.harryai.algorithm.leetcode.editor.cn;

import com.harryai.algorithm.common.linkedlist.ListNode;
import com.harryai.algorithm.common.tree.utils.LinkedListUtils;

//java:Remove Nth Node From End of List
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        ListNode head = LinkedListUtils.array2LinkedList(1, 2, 3, 4, 5);
        LinkedListUtils.print(head);
        LinkedListUtils.print(solution.removeNthFromEnd(head, 5));
    }
    /**
     * topic: Remove Nth Node From End of List
     * Solution number: 1
     * Ideas: 快慢双指针 ，快指针（fast）比慢指针(slow)慢N步，当快指针到达尾结点（fast.next==null）时，
     * 满指针的下一个即为要删除的节点，则slow.next=slow.next.next。
     * 另外，做一个虚拟节点。以处理N=链表长度时正好删除头节点的情况（fast==null）。
     * Problem boundary: 快指针的后继节点为null
     * Problem pattern: 快慢双指针
     * time complexity: O(N)
     * space complexity:0(1)
     */
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode virtualHeadNode = new ListNode();
            virtualHeadNode.next = head;

            // 让快慢指针均指向头节点
            ListNode fast = virtualHeadNode, slow = virtualHeadNode;

            // 挪动快慢指针，让快指针快慢指针N步
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            while (fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }

            // 删除节点
            slow.next=slow.next.next;
            return virtualHeadNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
