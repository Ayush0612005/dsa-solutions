/*
LeetCode 65 - Valid Number

Difficulty: Hard

Approach:
- Traverse the string once while keeping track of:
  - seenDigit: whether at least one digit has been encountered.
  - seenDot: whether a decimal point has been encountered.
  - seenExponent: whether an exponent ('e' or 'E') has been encountered.
- Rules:
  - A digit is always valid.
  - A decimal point can appear only once and only before an exponent.
  - An exponent can appear only once and must follow at least one digit.
  - A sign ('+' or '-') is valid only at the beginning of the string
    or immediately after an exponent.
- After an exponent, require at least one digit before accepting the number.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isNumber(String s) {

        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {

                seenDigit = true;

            } else if (c == '.') {

                if (seenDot || seenExponent) {
                    return false;
                }

                seenDot = true;

            } else if (c == 'e' || c == 'E') {

                if (seenExponent || !seenDigit) {
                    return false;
                }

                seenExponent = true;
                seenDigit = false;

            } else if (c == '+' || c == '-') {

                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {
                    return false;
                }

            } else {

                return false;
            }
        }

        return seenDigit;
    }
}
