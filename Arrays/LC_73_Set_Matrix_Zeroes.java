 /*
 * LeetCode 73 - Set Matrix Zeroes
 * Difficulty: Medium
 *
 * Approach:
 * 1. Use a boolean array to track rows that contain zero.
 * 2. Use another boolean array to track columns that contain zero.
 * 3. Traverse the matrix and mark the corresponding row and column
 *    whenever a zero is found.
 * 4. Traverse the marked rows and columns and set their elements to zero.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n + m)
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        // Find all rows and columns containing zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Set marked rows to zero
        for (int i = 0; i < n; i++) {
            if (row[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set marked columns to zero
        for (int j = 0; j < m; j++) {
            if (col[j]) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
