/*
LeetCode 1406 - Stone Game III

Difficulty: Hard

Approach:
- Use Dynamic Programming.
- Let dp[i] represent the maximum score difference the current player
  can achieve over the opponent starting from index i.
- At each position, the player can take:
  - 1 stone
  - 2 stones
  - 3 stones
- For each choice:
  - Add the value of the chosen stones.
  - Subtract the opponent's best score difference.
- Store the maximum possible score difference in dp[i].
- Finally:
  - If dp[0] > 0, Alice wins.
  - If dp[0] < 0, Bob wins.
  - Otherwise, it is a tie.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = stoneValue[i] - dp[i + 1];

            if (i + 2 <= n) {
                dp[i] = Math.max(
                        dp[i],
                        stoneValue[i] + stoneValue[i + 1] - dp[i + 2]
                );
            }

            if (i + 3 <= n) {
                dp[i] = Math.max(
                        dp[i],
                        stoneValue[i]
                        + stoneValue[i + 1]
                        + stoneValue[i + 2]
                        - dp[i + 3]
                );
            }
        }

        if (dp[0] > 0) {
            return "Alice";
        }

        if (dp[0] < 0) {
            return "Bob";
        }

        return "Tie";
    }
}
