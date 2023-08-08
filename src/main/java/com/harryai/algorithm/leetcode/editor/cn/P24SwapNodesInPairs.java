//Given a linked list, swap every two adjacent nodes and return its head. You 
//must solve the problem without modifying the values in the list's nodes (i.e., 
//only nodes themselves may be changed.) 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1949 👎 0

package com.harryai.algorithm.leetcode.editor.cn;

import com.harryai.algorithm.common.linkedlist.ListNode;
import com.harryai.algorithm.common.tree.utils.LinkedListUtils;

//java:Swap Nodes in Pairs
public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
        ListNode listNode = LinkedListUtils.array2LinkedList(1, 2, 3, 4, 5);
        System.out.println("first->");
        LinkedListUtils.print(listNode);
        ListNode listNode1 = solution.swapPairs(listNode);
        System.out.println("res->");
        LinkedListUtils.print(listNode1);
    }
    /**
     * topic: Swap Nodes in Pairs
     * Solution number: 1
     * Ideas: 链表，因为两表两个节点交换后会需要重新维护3个关联关系，所以使用三指针（PRE,L,R）。
     * 1. 使用虚拟头节点dummy(next=链表头节点)，将指针PRE指向dummy
     * 2. 遍历，检查边界，边界有效，L往后移动一步（PRE.NEXT），R移动到L的后继节点(PRE.NEXT.NEXT)，否则结束返回结果
     * 3. 交换两个节点，并维护三个关联关系（ l.next = r.next;r.next = l;  pre.next = r;）
     * 4. PRE向后移动到下一组要交换的节点的前序节点（pre=pre.next.next）
     * 4. 继续2到3步骤，直到结束
     * Problem boundary: 遍历到链表结束 pre.next != null && pre.next.next != null
     * Problem pattern: 链表，三指针
     * time complexity: O(L) L为链表长度
     * space complexity: O(1) 不需要额外控件
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
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode pre = dummy;
            ListNode l;
            ListNode r;

            while (pre.next != null && pre.next.next != null) {
                // 左右分别向后走一步
                l = pre.next;
                r = l.next;

                // 交换
                l.next = r.next;
                r.next = l;
                pre.next = r;

                // PRE节点向后走一步
                pre = pre.next.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
