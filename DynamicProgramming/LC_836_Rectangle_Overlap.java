/*
 * LeetCode 836 - Rectangle Overlap
 * Difficulty: Easy
 *
 * Approach:
 * Two rectangles do NOT overlap if one rectangle is completely:
 * - to the left of the other,
 * - to the right of the other,
 * - above the other, or
 * - below the other.
 *
 * If none of these conditions is true, the rectangles overlap
 * with a positive area.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        // rec1 is completely to the left of rec2
        if (rec1[2] <= rec2[0]) {
            return false;
        }

        // rec1 is completely to the right of rec2
        if (rec1[0] >= rec2[2]) {
            return false;
        }

        // rec1 is completely below rec2
        if (rec1[3] <= rec2[1]) {
            return false;
        }

        // rec1 is completely above rec2
        if (rec1[1] >= rec2[3]) {
            return false;
        }

        return true;
    }
}
