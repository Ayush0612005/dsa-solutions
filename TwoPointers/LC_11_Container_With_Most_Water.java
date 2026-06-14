/*
LeetCode 11 - Container With Most Water

Difficulty: Medium

Approach:
- Use two pointers:
  - left at the beginning of the array.
  - right at the end of the array.
- Calculate the area formed by the two lines.
- Update the maximum area found so far.
- Move the pointer with the smaller height inward because
  the area is limited by the shorter line.
- Continue until both pointers meet.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {

            int width = right - left;
            int containerHeight = Math.min(height[left], height[right]);
            int area = width * containerHeight;

            maxWater = Math.max(maxWater, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
