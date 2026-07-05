/*
LeetCode 1301 - Number of Paths with Max Score

Difficulty: Hard

Approach:
- Use Dynamic Programming with two matrices:
  - maxScores[r][c] stores the maximum score that can be obtained
    when reaching cell (r, c).
  - paths[r][c] stores the number of ways to achieve that maximum score.
- Traverse the board from the bottom-right (Start) to the top-left (End).
- From each valid cell, move in the reverse directions:
  - Right
  - Down
  - Down-Right
- For every reachable cell:
  - Update the maximum score if a better path is found.
  - If another path gives the same maximum score, add the number
    of ways modulo 1,000,000,007.
- If the destination cannot be reached, return {0, 0}.

Time Complexity: O(n²)
Space Complexity: O(n²)
*/

import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();
        int mod = 1_000_000_007;

        int[][] maxScores = new int[n][n];
        int[][] paths = new int[n][n];

        for (int[] row : maxScores) {
            Arrays.fill(row, -1);
        }

        maxScores[n - 1][n - 1] = 0;
        paths[n - 1][n - 1] = 1;

        // Right, Down, Down-Right (reverse traversal)
        int[] dr = {0, 1, 1};
        int[] dc = {1, 0, 1};

        for (int r = n - 1; r >= 0; r--) {

            for (int c = n - 1; c >= 0; c--) {

                if (board.get(r).charAt(c) == 'X' || paths[r][c] == 0) {
                    continue;
                }

                for (int k = 0; k < 3; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr < n &&
                        nc < n &&
                        board.get(nr).charAt(nc) != 'X') {

                        int currentValue = 0;

                        if (board.get(nr).charAt(nc) != 'E') {
                            currentValue = board.get(nr).charAt(nc) - '0';
                        }

                        int newScore = maxScores[r][c] + currentValue;

                        if (newScore > maxScores[nr][nc]) {

                            maxScores[nr][nc] = newScore;
                            paths[nr][nc] = paths[r][c];

                        } else if (newScore == maxScores[nr][nc]) {

                            paths[nr][nc] =
                                (paths[nr][nc] + paths[r][c]) % mod;
                        }
                    }
                }
            }
        }

        if (maxScores[0][0] == -1) {
            return new int[]{0, 0};
        }

        return new int[]{maxScores[0][0], paths[0][0]};
    }
}
