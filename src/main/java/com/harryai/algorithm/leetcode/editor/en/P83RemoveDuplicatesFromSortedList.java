//Given the head of a sorted linked list, delete all duplicates such that each 
//element appears only once. Return the linked list sorted as well. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,1,2]
//Output: [1,2]
// 
//
// Example 2: 
//
// 
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 300]. 
// -100 <= Node.val <= 100 
// The list is guaranteed to be sorted in ascending order. 
// 
// Related Topics Linked List 👍 6803 👎 240

package com.harryai.algorithm.leetcode.editor.en;

//java:Remove Duplicates from Sorted List
public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode c = solution.deleteDuplicates(l1);
        System.out.println(c.val);
        while (c.next != null) {
            c = c.next;
            System.out.println(c.val);
        }

    }

    public static class ListNode {
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode cur = head;
            while (cur.next != null) {
                // 比较当前节点和下一个节点，如果下一个节点重复，
                // 则删除下一个节点（将当前下下节点挂到当前节点的下一个节点）
                // 下一轮继续比较当前节点和下一个节点的值
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else { // 如果不重复，后移指针
                    cur = cur.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
