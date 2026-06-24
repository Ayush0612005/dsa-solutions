/*
LeetCode 26 - Remove Duplicates from Sorted Array

Difficulty: Easy

Approach:
- Use two pointers:
  - i tracks the position of the last unique element.
  - j scans through the array.
- When a new unique element is found:
  - Move i forward.
  - Copy nums[j] to nums[i].
- The first (i + 1) elements of the array will contain all unique values.
- Return the count of unique elements.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
