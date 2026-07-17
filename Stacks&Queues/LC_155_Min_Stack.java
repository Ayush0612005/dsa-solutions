/*
LeetCode 155 - Min Stack

Difficulty: Medium

Approach:
- Use two stacks:
  - stack: stores all the elements.
  - minStack: stores the minimum element at each stage.
- During push:
  - Push the value onto stack.
  - Push it onto minStack if it is smaller than or equal to the current minimum.
- During pop:
  - If the popped value equals the current minimum, pop from minStack as well.
- top() returns the top element of stack.
- getMin() returns the top of minStack, which is the current minimum.

Time Complexity:
- push()   : O(1)
- pop()    : O(1)
- top()    : O(1)
- getMin() : O(1)

Space Complexity: O(n)
*/

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        stack.pop();
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {

        return minStack.peek();
    }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
