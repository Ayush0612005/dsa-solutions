import java.util.Arrays;

/*
 * LeetCode 128 - Longest Consecutive Sequence
 * Difficulty: Medium
 *
 * Approach:
 * 1. Sort the array.
 * 2. Traverse the sorted array and count consecutive elements.
 * 3. Ignore duplicate elements.
 * 4. Reset the count when a break in the sequence is found.
 * 5. Keep track of the longest consecutive sequence.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 1;
        int longest = 1;

        for (int i = 1; i < nums.length; i++) {
            // Ignore duplicates
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            // Continue the consecutive sequence
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
}
