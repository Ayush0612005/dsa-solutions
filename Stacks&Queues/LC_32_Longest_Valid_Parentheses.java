/*
LeetCode 32 - Longest Valid Parentheses

Difficulty: Hard

Approach:
- Use a stack to store indices instead of characters.
- Push -1 initially as a base index for calculating lengths.
- Traverse the string:
  - If the current character is '(', push its index.
  - Otherwise, pop the top index.
- If the stack becomes empty after popping:
  - Push the current index as the new base.
- Otherwise:
  - The current valid substring length is
    current index - stack.peek().
  - Update the maximum length.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Stack;

class Solution {

    public int longestValidParentheses(String s) {

        int maxLen = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                stack.push(i);

            } else {

                stack.pop();

                if (stack.isEmpty()) {

                    stack.push(i);

                } else {

                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}
