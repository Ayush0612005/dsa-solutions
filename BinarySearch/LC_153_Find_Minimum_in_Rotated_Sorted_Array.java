/*
LeetCode 153 - Find Minimum in Rotated Sorted Array

Difficulty: Medium

Approach:
- The array was originally sorted in ascending order and then rotated.
- If the first element is less than or equal to the last element,
  the array is already sorted, so the first element is the minimum.
- Use Binary Search to find the pivot point where the rotation occurred.
- The element immediately after the pivot is the minimum.
- Handle edge cases by checking neighboring elements.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        if (nums[start] <= nums[end]) {
            return nums[start];
        }

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (mid > start && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return nums[start];
    }
}
