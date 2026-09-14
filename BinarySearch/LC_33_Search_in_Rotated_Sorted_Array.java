/*
 * LeetCode 33 - Search in Rotated Sorted Array
 * Difficulty: Medium
 *
 * Approach:
 * 1. Use binary search.
 * 2. At every step, one half of the array is guaranteed to be sorted.
 * 3. Check whether the target lies inside the sorted half.
 * 4. Search that half if it does; otherwise, search the other half.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
