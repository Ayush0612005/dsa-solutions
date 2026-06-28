/*
LeetCode 62 - Unique Paths

Difficulty: Medium

Approach:
- Use Dynamic Programming with space optimization.
- Let dp[j] represent the number of unique paths to the current cell
  in the current row.
- Initialize dp[0] = 1 because there is only one way to reach
  the first column.
- For each cell:
  dp[j] = dp[j] + dp[j - 1]
  where:
  - dp[j] represents the path count from the top.
  - dp[j - 1] represents the path count from the left.
- The last element of the dp array contains the answer.

Time Complexity: O(m × n)
Space Complexity: O(n)
*/

class Solution {

    public int uniquePaths(int m, int n) {

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
