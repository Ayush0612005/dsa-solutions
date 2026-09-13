/*
 * LeetCode 283 - Move Zeroes
 * Difficulty: Easy
 *
 * Approach:
 * 1. Use k to track the position where the next non-zero element should go.
 * 2. Traverse the array and move every non-zero element to index k.
 * 3. Fill the remaining positions with zeroes.
 *
 * This keeps all non-zero elements in their original relative order.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }

        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }
}
