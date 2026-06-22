/*
LeetCode 20 - Valid Parentheses

Difficulty: Easy

Approach:
- Use a stack to keep track of opening brackets.
- Traverse the string:
  - If the character is an opening bracket, push it onto the stack.
  - If it is a closing bracket:
    - The stack must not be empty.
    - The top of the stack must contain the matching opening bracket.
- After processing all characters, the stack should be empty.
- If any mismatch occurs, return false.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {

                stack.push(c);

            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                } else if (c == ']' && top != '[') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
