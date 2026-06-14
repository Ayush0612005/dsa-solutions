/*
LeetCode 367 - Valid Perfect Square

Difficulty: Easy

Approach:
- Use Binary Search to find whether an integer exists whose square equals num.
- Search in the range [0, num].
- To avoid integer overflow, store the square in a long variable.
- If mid * mid equals num, return true.
- Otherwise, adjust the search range accordingly.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isPerfectSquare(int num) {

        int start = 0;
        int end = num;

        while (start <= end) {

            int mid = start + (end - start) / 2;
            long square = (long) mid * mid;

            if (square > num) {
                end = mid - 1;
            } else if (square < num) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
