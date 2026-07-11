/*
LeetCode 39 - Combination Sum

Difficulty: Medium

Approach:
- Use Backtracking to generate all possible combinations.
- At each recursive call:
  - If the remaining target becomes 0, a valid combination is found.
  - If the remaining target becomes negative, stop exploring that path.
- Iterate through the candidates starting from the current index.
- Include the current candidate and recurse with the reduced target.
- Pass the same index again to allow reusing the same number.
- Backtrack by removing the last added element.

Time Complexity: O(2^t)
where t is the target value (approximate, depends on input).

Space Complexity: O(target)
(Recursion stack, excluding the output)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result,
                           List<Integer> current,
                           int[] candidates,
                           int remaining,
                           int start) {

        if (remaining < 0) {
            return;
        }

        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            current.add(candidates[i]);

            backtrack(result,
                      current,
                      candidates,
                      remaining - candidates[i],
                      i);

            current.remove(current.size() - 1);
        }
    }
}
