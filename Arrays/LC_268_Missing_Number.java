import java.util.Arrays;

/*
 * LeetCode 268 - Missing Number
 * Difficulty: Easy
 *
 * Approach:
 * 1. Sort the array.
 * 2. After sorting, nums[i] should be equal to i.
 * 3. If nums[i] != i, then i is the missing number.
 * 4. If no mismatch is found, the missing number is nums.length.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 */

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
