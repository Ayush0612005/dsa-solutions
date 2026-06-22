/*
LeetCode 14 - Longest Common Prefix

Difficulty: Easy

Approach:
- Assume the first string is the common prefix.
- Compare it with every other string.
- While the current string does not start with the prefix:
  - Remove the last character from the prefix.
- If the prefix becomes empty, no common prefix exists.
- Return the remaining prefix.

Time Complexity: O(n * m)
where:
- n = number of strings
- m = length of the shortest string

Space Complexity: O(1)
*/

class Solution {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
