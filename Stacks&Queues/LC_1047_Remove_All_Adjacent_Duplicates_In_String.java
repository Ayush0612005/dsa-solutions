/*
LeetCode 1047 - Remove All Adjacent Duplicates In String

Difficulty: Easy

Approach:
- Use a StringBuilder as a stack.
- Traverse the string character by character.
- If the current character matches the last character in the StringBuilder:
  - Remove the last character.
- Otherwise:
  - Append the current character.
- The remaining characters form the final string.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            int len = sb.length();

            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
