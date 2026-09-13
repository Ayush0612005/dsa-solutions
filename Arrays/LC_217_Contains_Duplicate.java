import java.util.Arrays;

/*
 * LeetCode 217 - Contains Duplicate
 * Difficulty: Easy
 *
 * Approach:
 * 1. Sort the array.
 * 2. After sorting, duplicate elements will be adjacent.
 * 3. Compare each element with the previous element.
 * 4. If they are equal, a duplicate exists.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }
}
