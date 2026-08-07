/*
LeetCode 628 - Maximum Product of Three Numbers

Difficulty: Easy

Approach:
- Sort the array in ascending order.
- There are two possible maximum products:
  - Product of the three largest numbers.
  - Product of the two smallest numbers (possibly negative) and the largest number.
- Return the maximum of these two products.

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

import java.util.Arrays;

class Solution {

    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        int product2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(product1, product2);
    }
}
