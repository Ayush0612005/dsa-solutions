/*
 * LeetCode - Subarray Products by Remainder
 * Difficulty: Medium
 *
 * Approach:
 * dp[r] stores the number of subarrays ending at the previous
 * position whose product has remainder r when divided by k.
 *
 * For each number:
 * 1. Start a new subarray containing only the current number.
 * 2. Extend every previous subarray.
 * 3. Update the product remainder using:
 *      newRemainder = (oldRemainder * value) % k
 * 4. Add all subarrays ending at the current position to result[].
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(k)
 */

class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            int value = num % k;

            // Subarray containing only the current number
            next[value]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                int newRemainder = (r * value) % k;
                next[newRemainder] += dp[r];
            }

            // Add all subarrays ending at the current index
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}
