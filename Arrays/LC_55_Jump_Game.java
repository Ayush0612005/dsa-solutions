/*
LeetCode 55 - Jump Game

Difficulty: Medium

Approach:
- Maintain the farthest index that can be reached.
- Traverse the array:
  - If the current index is beyond the farthest reachable index,
    the end cannot be reached.
  - Update the farthest reachable index.
  - If the farthest reachable index reaches or exceeds the last index,
    return true.
- If the traversal completes, the end is reachable.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
