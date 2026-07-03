/*
LeetCode 38 - Count and Say

Difficulty: Medium

Approach:
- Start with the first term: "1".
- Iteratively generate each subsequent term.
- For every term:
  - Traverse the current string.
  - Count consecutive occurrences of the same character.
  - Append the count followed by the character to a StringBuilder.
- Repeat until the nth term is generated.

Time Complexity: O(m)
where m is the total number of characters processed across all generated terms.

Space Complexity: O(m)
*/

class Solution {

    public String countAndSay(int n) {

        String result = "1";

        for (int i = 2; i <= n; i++) {

            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = 0; j < result.length(); j++) {

                if (j == result.length() - 1 ||
                    result.charAt(j) != result.charAt(j + 1)) {

                    sb.append(count).append(result.charAt(j));
                    count = 1;

                } else {

                    count++;
                }
            }

            result = sb.toString();
        }

        return result;
    }
}
