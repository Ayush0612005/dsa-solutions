/*
LeetCode 72 - Edit Distance

Difficulty: Medium

Approach:
- Use Dynamic Programming.
- Let dp[i][j] represent the minimum number of operations required
  to convert the first i characters of word1 into the first j
  characters of word2.
- Initialize the first row and first column:
  - dp[i][0] = i (delete all characters)
  - dp[0][j] = j (insert all characters)
- For each character:
  - If they match, no operation is needed.
  - Otherwise, take the minimum among:
      - Insert
      - Delete
      - Replace
    and add one operation.
- The final answer is stored in dp[m][n].

Time Complexity: O(m × n)
Space Complexity: O(m × n)
*/

class Solution {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insert,
                                    Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }
}
