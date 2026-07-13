/*
LeetCode 1291 - Sequential Digits

Difficulty: Medium

Approach:
- Store the string "123456789".
- Determine the minimum and maximum number of digits
  required from the given range.
- For every possible length:
  - Generate all consecutive substrings of that length.
  - Convert each substring into an integer.
  - If it lies within the range [low, high],
    add it to the result.
- Since the substrings are generated in increasing order,
  the result is automatically sorted.

Time Complexity: O(1)
- At most 36 sequential numbers are generated.

Space Complexity: O(1)
(excluding the output list)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();

        String digits = "123456789";

        int minLength = String.valueOf(low).length();
        int maxLength = String.valueOf(high).length();

        for (int length = minLength; length <= maxLength; length++) {

            for (int i = 0; i <= 9 - length; i++) {

                String sub = digits.substring(i, i + length);
                int number = Integer.parseInt(sub);

                if (number >= low && number <= high) {
                    result.add(number);
                }
            }
        }

        return result;
    }
}
