/*
LeetCode 3272 - Find the Lexicographically Smallest Valid Palindrome

Difficulty: Medium

Approach:
- Count the frequency of each character.
- Build the left half of the palindrome by adding half of each character's frequency
  in increasing alphabetical order.
- If a character has an odd frequency, place it in the middle.
- Append the reverse of the left half to complete the palindrome.
- Constructing the left half in sorted order guarantees the lexicographically smallest palindrome.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public String smallestPalindrome(String s) {

        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        StringBuilder leftHalf = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {

            if (frequency[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }

            for (int j = 0; j < frequency[i] / 2; j++) {
                leftHalf.append((char) ('a' + i));
            }
        }

        StringBuilder palindrome = new StringBuilder(leftHalf);

        if (middle != 0) {
            palindrome.append(middle);
        }

        palindrome.append(new StringBuilder(leftHalf).reverse());

        return palindrome.toString();
    }
}
