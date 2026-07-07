/*
LeetCode 79 - Word Search

Difficulty: Medium

Approach:
- Traverse every cell of the board.
- If a cell matches the first character of the word,
  start a DFS from that cell.
- During DFS:
  - Check if the current character matches.
  - Mark the current cell as visited.
  - Explore all four directions:
      - Up
      - Down
      - Left
      - Right
  - Restore the cell while backtracking.
- If all characters are matched, return true.

Time Complexity: O(m × n × 4^L)
where:
- m = number of rows
- n = number of columns
- L = length of the word

Space Complexity: O(L)
(Recursion stack)
*/

class Solution {

    public boolean exist(char[][] board, String word) {

        if (board == null ||
            board.length == 0 ||
            word == null ||
            word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (board[r][c] == word.charAt(0) &&
                    dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board,
                        String word,
                        int r,
                        int c,
                        int index) {

        if (index == word.length()) {
            return true;
        }

        if (r < 0 ||
            r >= board.length ||
            c < 0 ||
            c >= board[0].length ||
            board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '*';

        boolean found =
                dfs(board, word, r + 1, c, index + 1) ||
                dfs(board, word, r - 1, c, index + 1) ||
                dfs(board, word, r, c + 1, index + 1) ||
                dfs(board, word, r, c - 1, index + 1);

        board[r][c] = temp;

        return found;
    }
}
