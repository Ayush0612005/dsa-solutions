/*
LeetCode 1 - Two Sum

Difficulty: Easy

Approach:
- Use two nested loops to check every possible pair of elements.
- For each pair, check whether their sum equals the target.
- If a valid pair is found, return their indices.
- Since the problem guarantees exactly one solution, the pair will be found.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}
