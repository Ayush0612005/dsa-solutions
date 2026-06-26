/*
LeetCode 17 - Letter Combinations of a Phone Number

Difficulty: Medium

Approach:
- Use Backtracking to generate all possible letter combinations.
- Map each digit to its corresponding characters on a phone keypad.
- Start from the first digit and recursively:
  - Choose one character.
  - Move to the next digit.
  - Backtrack by removing the chosen character.
- When the current combination length equals the number of digits,
  add it to the result.

Time Complexity: O(4^n * n)
where:
- n = number of digits
- Each digit has at most 4 possible letters.

Space Complexity: O(n)
(excluding the output list)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, new StringBuilder(), digits, 0);

        return result;
    }

    private void backtrack(List<String> result,
                           StringBuilder current,
                           String digits,
                           int index) {

        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }

        String possibleLetters = KEYPAD[digits.charAt(index) - '0'];

        for (char c : possibleLetters.toCharArray()) {

            current.append(c);

            backtrack(result, current, digits, index + 1);

            current.deleteCharAt(current.length() - 1);
        }
    }
}
