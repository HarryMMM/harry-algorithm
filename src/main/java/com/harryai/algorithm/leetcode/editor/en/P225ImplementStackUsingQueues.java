//Implement a last-in-first-out (LIFO) stack using only two queues. The 
//implemented stack should support all the functions of a normal stack (push, top, pop, 
//and empty). 
//
// Implement the MyStack class: 
//
// 
// void push(int x) Pushes element x to the top of the stack. 
// int pop() Removes the element on the top of the stack and returns it. 
// int top() Returns the element on the top of the stack. 
// boolean empty() Returns true if the stack is empty, false otherwise. 
// 
//
// Notes: 
//
// 
// You must use only standard operations of a queue, which means that only push 
//to back, peek/pop from front, size and is empty operations are valid. 
// Depending on your language, the queue may not be supported natively. You may 
//simulate a queue using a list or deque (double-ended queue) as long as you use 
//only a queue's standard operations. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//Output
//[null, null, null, 2, 2, false]
//
//Explanation
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // return 2
//myStack.pop(); // return 2
//myStack.empty(); // return False
// 
//
// 
// Constraints: 
//
// 
// 1 <= x <= 9 
// At most 100 calls will be made to push, pop, top, and empty. 
// All the calls to pop and top are valid. 
// 
//
// 
// Follow-up: Can you implement the stack using only one queue? 
//
// Related Topics Stack Design Queue 👍 4166 👎 975

package com.harryai.algorithm.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

//java:Implement Stack using Queues
public class P225ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack myStack = new P225ImplementStackUsingQueues().new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        // offer 入队
        // poll 出队
        // peek 从队首检出
        // size 元素数量
        // isEmpty 队列是否为空
        // master 和 salver pop时互相倒元素，每次最后一个丢弃，达到LIFO的目的
        private Queue<Integer> master = new LinkedList<>();
        private Queue<Integer> salver = new LinkedList<>();
        // 记录队尾，以供top,pop使用
        int tail = -1;

        public MyStack() {

        }

        public void push(int x) {
            master.offer(x);
            tail = x;
        }

        public int pop() {
            int tmpTail = tail;
            // 记录本次pop后的队尾
            int newTail = -1;
            while (!master.isEmpty()) {
                Integer poll = master.poll();
                // 出队后判断下队列中是否还有，如果有，继续添加。
                // 如果没有了表示这是最后一个，不添加。
                if (!master.isEmpty()) {
                    salver.offer(poll);
                    newTail = poll;
                } else {
                    // 重置队尾元素
                    tail = newTail;
                }

            }
            // 主从调换
            Queue<Integer> tmp = master;
            master = salver;
            salver = tmp;
            // 返回最后一个元素
            return tmpTail;

        }

        public int top() {
            return tail;
        }

        public boolean empty() {
            return master.isEmpty() && salver.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
