/*
LeetCode 3 - Longest Substring Without Repeating Characters

Difficulty: Medium

Approach:
- Use a Sliding Window with a HashMap.
- The HashMap stores each character and its most recent index.
- Expand the window using the right pointer.
- If a duplicate character is found within the current window:
  - Move the left pointer to one position after the previous occurrence.
- Update the maximum window length during traversal.

Time Complexity: O(n)
Space Complexity: O(min(n, m))
where:
- n = length of string
- m = size of character set
*/

import java.util.HashMap;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }

            map.put(current, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
