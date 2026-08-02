/*
LeetCode 91 - Decode Ways

Difficulty: Medium

Approach:
- Use Dynamic Programming.
- Let dp[i] represent the number of ways to decode the first i characters.
- Initialize:
  - dp[0] = 1 (empty string)
  - dp[1] = 1 if the first character is not '0', otherwise 0.
- For each position:
  - If the current digit is between 1 and 9, add dp[i - 1].
  - If the last two digits form a valid number between 10 and 26,
    add dp[i - 2].
- The final answer is stored in dp[n].

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {

            int oneDigit = Integer.parseInt(s.substring(i - 1, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
