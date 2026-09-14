/*
 * LeetCode 238 - Product of Array Except Self
 * Difficulty: Medium
 *
 * Approach:
 * 1. First pass: Store the product of all elements to the left
 *    of each index in result[].
 * 2. Second pass from right to left: Multiply result[i] by
 *    the product of all elements to the right.
 *
 * This avoids division and handles zeroes automatically.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) auxiliary space
 *                  (excluding the result array)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int product = 1;

        // Store prefix products
        for (int i = 0; i < n; i++) {
            result[i] = product;
            product *= nums[i];
        }

        product = 1;

        // Multiply by suffix products
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }
}
