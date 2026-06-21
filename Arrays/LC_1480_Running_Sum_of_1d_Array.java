/*
LeetCode 1480 - Running Sum of 1d Array

Difficulty: Easy

Approach:
- Maintain a running sum while traversing the array.
- Add the current element to the running sum.
- Store the running sum back into the current index.
- Return the modified array.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int[] runningSum(int[] nums) {

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];
            nums[i] = currentSum;
        }

        return nums;
    }
}
