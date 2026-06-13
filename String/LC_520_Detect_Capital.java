/*
LeetCode 520 - Detect Capital

Difficulty: Easy

Approach:
- Count the number of uppercase letters in the word.
- A word uses capitals correctly if:
  1. All letters are uppercase (e.g., "USA")
  2. All letters are lowercase (e.g., "leetcode")
  3. Only the first letter is uppercase (e.g., "Google")
- Return true if any of these conditions are satisfied.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean detectCapitalUse(String word) {

        int count = 0;
        int letters = word.length();

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (Character.isUpperCase(ch)) {
                count++;
            }
        }

        return count == letters ||
               count == 0 ||
               (count == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
