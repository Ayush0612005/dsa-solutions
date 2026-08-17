/*
LeetCode 387 - First Unique Character in a String

Difficulty: Easy

Approach:
- Iterate through all lowercase English letters.
- Find the first occurrence using indexOf().
- Find the last occurrence using lastIndexOf().
- If both indices are the same, the character appears exactly once.
- Track the smallest index among all unique characters.
- Return -1 if no unique character exists.

Time Complexity: O(26 × n) = O(n)
Space Complexity: O(1)
*/

class Solution {

    public int firstUniqChar(String s) {

        int minIndex = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {

            int firstIndex = s.indexOf(c);

            if (firstIndex != -1 &&
                firstIndex == s.lastIndexOf(c)) {

                minIndex = Math.min(minIndex, firstIndex);
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}
