/*
LeetCode 45 - Jump Game II

Difficulty: Medium

Approach:
- Use a greedy approach to track the current jump range.
- currentEnd represents the farthest position reachable with the current number of jumps.
- farthest represents the farthest position reachable from any index within the current range.
- When the current index reaches currentEnd:
  - A jump is required.
  - Update currentEnd to farthest.
- Continue until reaching the last index.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
