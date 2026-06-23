/*
LeetCode 739 - Daily Temperatures

Difficulty: Medium

Approach:
- Use a Monotonic Decreasing Stack to store indices of temperatures.
- Traverse the array from left to right.
- While the current temperature is greater than the temperature at
  the index on top of the stack:
  - Pop the index.
  - Calculate the number of days waited for a warmer temperature.
- Push the current index onto the stack.
- Any indices remaining in the stack do not have a warmer future day,
  so their answer remains 0.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return result;
    }
}
