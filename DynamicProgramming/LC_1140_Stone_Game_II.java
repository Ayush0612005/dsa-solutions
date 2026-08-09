/*
LeetCode 1140 - Stone Game II

Difficulty: Medium

Approach:
- Use Dynamic Programming with memoization.
- suffixSum[i] stores the total number of stones from index i to the end.
- Define dp(i, m) as the maximum number of stones the current player
  can collect starting from index i when M = m.
- The current player can take X stones where:
      1 <= X <= 2M
- After taking X stones, the opponent starts from i + X with:
      M = max(M, X)
- Instead of separately calculating the current player's remaining score,
  use:
      currentScore = suffixSum[i] - opponentScore
- If the player can take all remaining stones, return suffixSum[i] directly.
- Memoization avoids recomputing the same (i, M) states.

Time Complexity: O(n³)
Space Complexity: O(n²)
*/

class Solution {

    private int[] suffixSum;
    private int[][] memo;
    private int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];

        // Build suffix sums from right to left.
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        memo = new int[n][n + 1];

        return dp(0, 1);
    }

    private int dp(int i, int m) {

        // No stones remain.
        if (i >= n) {
            return 0;
        }

        // Current player can take all remaining stones.
        if (i + 2 * m >= n) {
            return suffixSum[i];
        }

        // Return previously calculated result.
        if (memo[i][m] != 0) {
            return memo[i][m];
        }

        int maxStones = 0;

        // Try taking X stones, where 1 <= X <= 2M.
        for (int x = 1; x <= 2 * m; x++) {

            int opponentScore =
                    dp(i + x, Math.max(m, x));

            int currentScore =
                    suffixSum[i] - opponentScore;

            maxStones = Math.max(maxStones, currentScore);
        }

        memo[i][m] = maxStones;

        return maxStones;
    }
}
