/*
LeetCode 2496 - Maximum Value of a String in an Array

Difficulty: Easy

Approach:
- Traverse each string in the array.
- Check whether the string contains only digits.
- If it contains only digits:
  - Convert it to an integer using Integer.parseInt().
- Otherwise:
  - Its value is its length.
- Keep track of the maximum value encountered.

Time Complexity: O(n × m)
where:
- n = number of strings
- m = average length of a string

Space Complexity: O(1)
*/

class Solution {

    public int maximumValue(String[] strs) {

        int maxValue = 0;

        for (String s : strs) {

            int currentValue = 0;
            boolean isOnlyDigits = true;

            for (char c : s.toCharArray()) {

                if (!Character.isDigit(c)) {
                    isOnlyDigits = false;
                    break;
                }
            }

            if (isOnlyDigits) {
                currentValue = Integer.parseInt(s);
            } else {
                currentValue = s.length();
            }

            maxValue = Math.max(maxValue, currentValue);
        }

        return maxValue;
    }
}
