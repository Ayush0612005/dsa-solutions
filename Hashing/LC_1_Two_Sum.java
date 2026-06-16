/*
LeetCode 1 - Two Sum

Difficulty: Easy

Approach:
- Use a HashMap to store each number and its index.
- For every element, calculate the complement:
      complement = target - nums[i]
- Check if the complement already exists in the HashMap.
- If it exists, return the indices of the complement and the current element.
- Otherwise, store the current number and its index in the HashMap.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
