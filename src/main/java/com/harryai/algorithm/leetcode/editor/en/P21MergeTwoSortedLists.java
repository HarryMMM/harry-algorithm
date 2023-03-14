//You are given the heads of two sorted linked lists list1 and list2. 
//
// Merge the two lists in a one sorted list. The list should be made by 
//splicing together the nodes of the first two lists. 
//
// Return the head of the merged linked list. 
//
// 
// Example 1: 
//
// 
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: list1 = [], list2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both list1 and list2 are sorted in non-decreasing order. 
// 
// Related Topics Linked List Recursion 👍 10807 👎 1007

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.common.linkedlist.ListNode;

//java:Merge Two Sorted Lists
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
//        P21MergeTwoSortedLists.ListNode ln1 = new P21MergeTwoSortedLists.ListNode(-9,
//                new P21MergeTwoSortedLists.ListNode(3));
//        P21MergeTwoSortedLists.ListNode ln2 = new P21MergeTwoSortedLists.ListNode(5,
//                new P21MergeTwoSortedLists.ListNode(7));
        ListNode ln1 =new ListNode(1,
                new ListNode(2, new ListNode(4)));
       ListNode ln2 = new ListNode(1,
              new  ListNode(3, new ListNode(4)));
        print(solution.mergeTwoLists(null, null));
        System.out.println();
        print(solution.mergeTwoLists(ln1, null));
        System.out.println();
        print(solution.mergeTwoLists(null, ln2));
        System.out.println();
        print(solution.mergeTwoLists(ln1, ln2));
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode ahead = new ListNode();
            ListNode cur = ahead;
            while (true) {
                if (list1 == null) {
                    cur.next = list2;
                    break;
                }
                if (list2 == null) {
                    cur.next = list1;
                    break;
                }
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            return ahead.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)


    public static void print(ListNode l) {
        if (l == null) {
            return;
        }
        do {
            System.out.print(l.val + ",");
        } while ((l = l.next) != null);
    }
}
