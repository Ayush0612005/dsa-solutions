/*
LeetCode 78 - Subsets

Difficulty: Medium

Approach:
- Use Backtracking to generate all possible subsets.
- At every recursive call:
  - Add the current subset to the result.
  - Iterate through the remaining elements.
  - Choose an element.
  - Explore further subsets recursively.
  - Backtrack by removing the chosen element.
- This ensures every possible subset is generated.

Time Complexity: O(n × 2^n)
- There are 2^n subsets.
- Copying each subset takes O(n).

Space Complexity: O(n)
(Recursion stack, excluding the output)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result,
                           List<Integer> current,
                           int[] nums,
                           int start) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            current.add(nums[i]);

            backtrack(result, current, nums, i + 1);

            current.remove(current.size() - 1);
        }
    }
}
