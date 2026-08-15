/*
LeetCode - Longest Subsequence With Non-Zero Bitwise XOR

Approach:
- Calculate the XOR of all elements.
- If the total XOR is non-zero, the entire array is a valid subsequence.
- If the total XOR is zero but at least one element is non-zero,
  remove one non-zero element. The remaining XOR becomes non-zero.
- If every element is zero, no non-empty subsequence can have a non-zero XOR.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int longestSubsequence(int[] nums) {

        int totalXor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {

            totalXor ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }

        // Entire array already has a non-zero XOR.
        if (totalXor != 0) {
            return nums.length;
        }

        // Remove one non-zero element.
        if (hasNonZero) {
            return nums.length - 1;
        }

        // All elements are zero.
        return 0;
    }
}
