/*
 * LeetCode 3498 - Reverse Degree of a String
 * Difficulty: Easy
 *
 * Approach:
 * For each character:
 * 1. Calculate its reverse alphabetical value.
 * 2. Multiply it by its 1-based position in the string.
 * 3. Add the result to the total sum.
 *
 * Reverse alphabetical value:
 * a -> 26
 * b -> 25
 * ...
 * z -> 1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int position = i + 1;
            int value = 26 - (s.charAt(i) - 'a');

            sum += value * position;
        }

        return sum;
    }
}
