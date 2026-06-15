/*
LeetCode 225 - Implement Stack using Queues

Difficulty: Easy

Approach:
- Use a single queue to simulate stack behavior.
- On each push:
  1. Add the new element to the queue.
  2. Rotate all previous elements behind it.
- This ensures the most recently added element is always at the front.
- pop() removes the front element.
- top() returns the front element.
- empty() checks whether the queue is empty.

Time Complexity:
- push() : O(n)
- pop()  : O(1)
- top()  : O(1)
- empty(): O(1)

Space Complexity: O(n)
*/

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {

        queue.add(x);

        int size = queue.size();

        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
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
