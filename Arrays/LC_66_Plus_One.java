/*
LeetCode 66 - Plus One

Difficulty: Easy

Approach:
- Traverse the digits array from right to left.
- If the current digit is less than 9:
  - Increment it and return the array.
- Otherwise:
  - Set the current digit to 0 and continue.
- If all digits were 9, create a new array with one extra digit.
- Set the first element to 1 and return the new array.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;

        return newDigits;
    }
}
