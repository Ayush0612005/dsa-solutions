/*
LeetCode 2996 - Smallest Missing Integer Greater Than Sequential Prefix Sum

Difficulty: Easy

Approach:
- Store all numbers in a HashSet for O(1) average-time lookup.
- Find the longest sequential prefix starting from nums[0].
- Calculate the sum of this sequential prefix.
- Starting from that sum, keep increasing the value until we find
  an integer that does not exist in the array.
- Return that missing integer.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int missingInteger(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}
