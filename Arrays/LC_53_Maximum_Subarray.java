/*
LeetCode 53 - Maximum Subarray

Difficulty: Medium

Approach:
- Use Kadane's Algorithm.
- Maintain:
  - currentSum: maximum subarray sum ending at the current index.
  - maxSum: maximum subarray sum found so far.
- For each element:
  - Either start a new subarray from the current element.
  - Or extend the existing subarray.
- Update the overall maximum after each iteration.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
