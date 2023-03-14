//Given the head of a linked list, return the node where the cycle begins. If 
//there is no cycle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to (0
//-indexed). It is -1 if there is no cycle. Note that pos is not passed as a 
//parameter. 
//
// Do not modify the linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the 
//second node.
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the 
//first node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
// Related Topics Hash Table Linked List Two Pointers 👍 11213 👎 821

package com.harryai.algorithm.leetcode.editor.en;

import com.harryai.algorithm.common.linkedlist.ListNode;

//java:Linked List Cycle II
public class P142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
        // [3,2,0,-4]
        ListNode a4 = new ListNode(-4);
        ListNode a3 = new ListNode(0, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(3, a2);
        a4.next = a2;
        solution.detectCycle(a1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     * 使用快（fast,每次1步）slow（slow每次2步）；
     * 假设【链表起始点】到[环起点]的距离为a,[环起点]到[fast和slow相遇点]的距离为b,
     * [fast和slow相遇点]到[环起点]的距离为c,fast和slow相遇时fast已经绕了环n圈，则得出：
     * slow走了 a+b的距离，fast走了a+n(b+c)+b,因为fast走的距离是slow的两倍。则得出等式：
     * a+n(b+c)+b=2(a+b),换算得到：a=nb+nc-b=nb+nc-b-c+c=(n-1)(b+c)+c,由于b+c等于环的距离，
     * 所以此公式解释为： 【链表起始点】到[环起点]的距离正好等于slow继续走n-1圈环后加c的距离。
     * 我们定义一个指针pos从【链表起始点】开始一步步走，slow从[fast和slow相遇节点]继续走。
     * 因为此时slow距离环[环起点]的距离正好是c，它们一定会在环[环起点]相遇。
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head, pos = head;
            // 如果fast和slow的下一步不为null,则继续找相遇点，即表示有环，否则没有环。
            while (slow != null && (slow = slow.next) != null && fast.next != null && (fast =
                    fast.next.next) != null) {
                // fast 和 slow相遇，表示有环
                if (slow == fast) {
                    // 挪动pos和slow,相遇点即是[环起点]
                    while (pos != slow) {
                        pos = pos.next;
                        slow = slow.next;
                    }
                    return pos;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
