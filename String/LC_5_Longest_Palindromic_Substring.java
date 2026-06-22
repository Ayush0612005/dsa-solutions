/*
LeetCode 5 - Longest Palindromic Substring

Difficulty: Medium

Approach:
- Use the Expand Around Center technique.
- Every character can be the center of an odd-length palindrome.
- Every pair of adjacent characters can be the center of an even-length palindrome.
- Expand outward while the characters match.
- Keep track of the longest palindrome found.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}
