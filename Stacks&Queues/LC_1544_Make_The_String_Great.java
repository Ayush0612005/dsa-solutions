/*
LeetCode 1544 - Make The String Great

Difficulty: Easy

Approach:
- Use a StringBuilder as a stack.
- Traverse each character in the string.
- If the current character and the last character in the stack:
  - Are the same letter ignoring case, and
  - Have different cases,
  then remove the last character from the stack.
- Otherwise, add the current character to the stack.
- The remaining characters form the final "good" string.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public String makeGood(String s) {

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            int len = sb.length();

            if (len > 0 &&
                sb.charAt(len - 1) != c &&
                Character.toLowerCase(sb.charAt(len - 1)) == Character.toLowerCase(c)) {

                sb.deleteCharAt(len - 1);

            } else {

                sb.append(c);
            }
        }

        return sb.toString();
    }
}
