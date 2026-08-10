/*
LeetCode 1510 - Stone Game IV

Difficulty: Medium

Approach:
- Use Dynamic Programming.
- dp[i] represents whether the current player can win when there are
  exactly i stones remaining.
- For every i, try removing every possible perfect square:
      1², 2², 3², ...
- If removing a square leaves the opponent in a losing state,
  then the current state is winning.
- Therefore:
      dp[i] = true
  if there exists a square j² such that dp[i - j²] == false.
- If no such move exists, dp[i] remains false.

Time Complexity: O(n√n)
Space Complexity: O(n)
*/

class Solution {

    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                // If removing j² leaves the opponent in a losing state,
                // the current player can force a win.
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
