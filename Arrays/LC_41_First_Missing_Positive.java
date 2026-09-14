import java.util.Arrays;

/*
 * LeetCode 41 - First Missing Positive
 * Difficulty: Hard
 *
 * Approach:
 * 1. Sort the array.
 * 2. Start with expected = 1.
 * 3. Traverse the sorted array:
 *    - If the current number equals expected, increment expected.
 *    - Ignore negative numbers, zeroes, and duplicates.
 * 4. The first value not found is the smallest missing positive.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int expected = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == expected) {
                expected++;
            }
        }

        return expected;
    }
}
