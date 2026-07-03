/*
LeetCode 48 - Rotate Image

Difficulty: Medium

Approach:
- Rotate the matrix by 90 degrees clockwise in two steps:
  1. Transpose the matrix.
     - Swap matrix[i][j] with matrix[j][i].
  2. Reverse every row.
     - Swap elements from the left and right ends of each row.
- This performs the rotation in-place without using extra space.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
