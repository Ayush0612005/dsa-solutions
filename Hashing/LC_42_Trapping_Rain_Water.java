/*
LeetCode 42 - Trapping Rain Water

Difficulty: Hard

Approach:
- Use the Two Pointers technique.
- Maintain two pointers:
  - left starting from the beginning.
  - right starting from the end.
- Keep track of:
  - leftMax: the maximum height seen from the left.
  - rightMax: the maximum height seen from the right.
- The side with the smaller maximum determines how much water can
  be trapped at that position.
- Move the corresponding pointer inward until both pointers meet.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int trap(int[] height) {

        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int trappedWater = 0;

        while (left < right) {

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {

                trappedWater += leftMax - height[left];
                left++;

            } else {

                trappedWater += rightMax - height[right];
                right--;
            }
        }

        return trappedWater;
    }
}
