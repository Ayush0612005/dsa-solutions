/*
LeetCode 486 - Predict the Winner

Difficulty: Medium

Approach:
- Use Dynamic Programming with Memoization.
- Define dp(left, right) as the maximum score difference the current player
  can achieve over the opponent using the subarray nums[left...right].
- At each step, the current player has two choices:
  - Pick the left element.
  - Pick the right element.
- Since the opponent also plays optimally, subtract the opponent's best score
  difference from the chosen value.
- Memoize each state (left, right) to avoid repeated computations.
- If the final score difference is non-negative, Player 1 can win or tie.

Time Complexity: O(n²)
Space Complexity: O(n²)
*/

class Solution {

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;

        Integer[][] memo = new Integer[n][n];

        return maxDifference(nums, 0, n - 1, memo) >= 0;
    }

    private int maxDifference(int[] nums,
                              int left,
                              int right,
                              Integer[][] memo) {

        if (left == right) {
            return nums[left];
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int pickLeft =
                nums[left] - maxDifference(nums,
                                           left + 1,
                                           right,
                                           memo);

        int pickRight =
                nums[right] - maxDifference(nums,
                                            left,
                                            right - 1,
                                            memo);

        memo[left][right] = Math.max(pickLeft, pickRight);

        return memo[left][right];
    }
}
