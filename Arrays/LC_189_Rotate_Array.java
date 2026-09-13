/*
 * LeetCode 189 - Rotate Array
 * Difficulty: Medium
 *
 * Approach:
 * Use the reversal algorithm:
 * 1. Reverse the entire array.
 * 2. Reverse the first k elements.
 * 3. Reverse the remaining elements.
 *
 * Example:
 * [1,2,3,4,5,6,7], k = 3
 *
 * Reverse all     -> [7,6,5,4,3,2,1]
 * Reverse first 3 -> [5,6,7,4,3,2,1]
 * Reverse rest    -> [5,6,7,1,2,3,4]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
