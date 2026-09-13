import java.util.Arrays;

/*
 * LeetCode 977 - Squares of a Sorted Array
 * Difficulty: Easy
 *
 * Approach:
 * 1. Square every element in the array.
 * 2. Sort the resulting array.
 * 3. Return the sorted array.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }
}
