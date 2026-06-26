/*
LeetCode 22 - Generate Parentheses

Difficulty: Medium

Approach:
- Use Backtracking to generate all valid combinations.
- Keep track of:
  - open: number of opening parentheses used.
  - close: number of closing parentheses used.
- Add '(' if open < n.
- Add ')' only if close < open to maintain validity.
- When the current string reaches length 2 * n,
  add it to the answer.

Time Complexity: O(4^n / √n)
(Catalan Number complexity)

Space Complexity: O(n)
(Recursion stack, excluding the output)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        backtrack(ans, "", 0, 0, n);

        return ans;
    }

    private void backtrack(List<String> ans,
                           String current,
                           int open,
                           int close,
                           int n) {

        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        if (open < n) {
            backtrack(ans, current + "(", open + 1, close, n);
        }

        if (close < open) {
            backtrack(ans, current + ")", open, close + 1, n);
        }
    }
}
