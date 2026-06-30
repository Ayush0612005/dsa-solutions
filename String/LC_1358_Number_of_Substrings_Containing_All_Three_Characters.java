/*
LeetCode 1358 - Number of Substrings Containing All Three Characters

Difficulty: Medium

Approach:
- Use the Sliding Window technique.
- Maintain a window using two pointers (left and right).
- Keep the frequency of 'a', 'b', and 'c' in the current window.
- Expand the window by moving the right pointer.
- While the window contains at least one of each character:
  - Every substring starting at the current left index and ending
    at right or any later index is valid.
  - Add (s.length() - right) to the answer.
  - Shrink the window by moving the left pointer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int numberOfSubstrings(String s) {

        int[] count = new int[3];
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {

            count[s.charAt(right) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {

                result += s.length() - right;

                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return result;
    }
}
