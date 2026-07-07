/*
LeetCode 3754 - Concatenate Non-Zero Digits and Multiply

Difficulty: Easy

Approach:
- Convert the number to a string.
- Traverse each character:
  - Ignore '0'.
  - Convert the character to its digit value.
  - Add the digit to the running sum.
  - Append the digit to form the new number.
- Multiply the concatenated number by the sum of its digits.
- Return the result.

Time Complexity: O(d)
Space Complexity: O(d)

where d is the number of digits.
*/

class Solution {

    public long sumAndMultiply(int n) {

        long number = 0;
        long digitSum = 0;

        String s = String.valueOf(n);

        for (char ch : s.toCharArray()) {

            if (ch != '0') {

                int digit = ch - '0';

                digitSum += digit;
                number = number * 10 + digit;
            }
        }

        return number * digitSum;
    }
}
