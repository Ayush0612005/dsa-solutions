/*
LeetCode 232 - Implement Queue using Stacks

Difficulty: Easy

Approach:
- Use two stacks:
  1. input  - stores newly added elements.
  2. output - provides queue order for removal.
- push(x):
  Add the element to the input stack.
- peek()/pop():
  If output is empty, transfer all elements from input to output.
  This reverses the order and makes the oldest element accessible.
- empty():
  The queue is empty only when both stacks are empty.

Time Complexity:
- push()  : O(1)
- pop()   : Amortized O(1)
- peek()  : Amortized O(1)
- empty() : O(1)

Space Complexity: O(n)
*/

import java.util.Stack;

class MyQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {

        if (output.isEmpty()) {

            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
