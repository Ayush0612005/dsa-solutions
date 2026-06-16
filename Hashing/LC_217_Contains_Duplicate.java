/*
LeetCode 217 - Contains Duplicate

Difficulty: Easy

Approach:
- Use a HashSet to keep track of elements seen so far.
- Traverse the array:
  - If the current element already exists in the set,
    a duplicate is found, so return true.
  - Otherwise, add the element to the set.
- If the traversal completes, no duplicates exist.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;

class Solution {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }
}
