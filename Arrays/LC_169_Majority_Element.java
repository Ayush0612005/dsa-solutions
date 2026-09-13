import java.util.Arrays;

/*
 * LeetCode 169 - Majority Element
 * Difficulty: Easy
 *
 * Approach:
 * 1. Sort the array.
 * 2. The majority element appears more than n/2 times.
 * 3. Therefore, after sorting, the element at index n/2
 *    must be the majority element.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 */

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
}
