import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 54 - Spiral Matrix
 * Difficulty: Medium
 *
 * Approach:
 * Use four boundaries to keep track of the remaining matrix:
 * - top    -> top row
 * - bottom -> bottom row
 * - start  -> left column
 * - end    -> right column
 *
 * Traverse in four directions:
 * 1. Left to right
 * 2. Top to bottom
 * 3. Right to left
 * 4. Bottom to top
 *
 * After each traversal, move the corresponding boundary inward.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1) auxiliary space
 *                    (excluding the result list)
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int start = 0;
        int end = matrix[0].length - 1;

        while (start <= end && top <= bottom) {

            // Left to right
            for (int i = start; i <= end; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][end]);
            }
            end--;

            // Right to left
            if (top <= bottom) {
                for (int i = end; i >= start; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Bottom to top
            if (start <= end) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][start]);
                }
                start++;
            }
        }

        return result;
    }
}
