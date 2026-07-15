/*
LeetCode 84 - Largest Rectangle in Histogram

Difficulty: Hard

Approach:
- Use a Monotonic Increasing Stack to store indices of bars.
- Traverse all bars and add a virtual bar of height 0 at the end.
- While the current bar is shorter than the bar on the top of the stack:
  - Pop the top index.
  - The popped bar is the height of the rectangle.
  - The current index is the right boundary.
  - The new top of the stack is the left boundary.
  - Compute the width and update the maximum area.
- Push the current index onto the stack.
- The virtual bar ensures all remaining bars are processed.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Stack;

class Solution {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() &&
                   currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftBoundary - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
