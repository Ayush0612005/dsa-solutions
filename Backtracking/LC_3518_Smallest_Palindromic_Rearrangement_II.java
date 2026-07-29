/*
LeetCode 3518 - Smallest Palindromic Rearrangement II

Difficulty: Hard

Approach:
- Count the frequency of each character.
- Verify that a palindromic rearrangement is possible.
- Extract the character counts for the left half of the palindrome.
- Count the number of distinct permutations of the remaining characters
  using combinatorics.
- Greedily construct the left half:
  - Try placing each possible character in lexicographical order.
  - Compute how many valid palindromes can be formed after choosing it.
  - If k is larger than that count, skip those permutations.
  - Otherwise, keep the character and continue.
- Build the final palindrome by appending:
  - left half
  - middle character (if any)
  - reverse of the left half.

Time Complexity: O(26 × n)

where n is the length of the palindrome.

Space Complexity: O(26)
*/

class Solution {

    private static final long LIMIT = 1_000_005;

    public String smallestPalindrome(String s, int k) {

        int[] totalCount = new int[26];

        for (char ch : s.toCharArray()) {
            totalCount[ch - 'a']++;
        }

        int oddCount = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {

            if ((totalCount[i] & 1) == 1) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int[] halfCount = new int[26];
        int halfLength = 0;

        for (int i = 0; i < 26; i++) {
            halfCount[i] = totalCount[i] / 2;
            halfLength += halfCount[i];
        }

        long totalWays = countWays(halfCount, halfLength);

        if (k > totalWays) {
            return "";
        }

        long currentK = k;
        StringBuilder leftHalf = new StringBuilder();

        for (int position = 0; position < halfLength; position++) {

            boolean chosen = false;

            for (int ch = 0; ch < 26; ch++) {

                if (halfCount[ch] == 0) {
                    continue;
                }

                halfCount[ch]--;

                long ways = countWays(
                        halfCount,
                        halfLength - position - 1
                );

                if (currentK <= ways) {

                    leftHalf.append((char) ('a' + ch));
                    chosen = true;
                    break;

                } else {

                    currentK -= ways;
                    halfCount[ch]++;
                }
            }

            if (!chosen) {
                return "";
            }
        }

        String left = leftHalf.toString();
        String right = new StringBuilder(left).reverse().toString();

        if (oddCount == 1) {
            return left + middle + right;
        }

        return left + right;
    }

    private long countWays(int[] count, int remaining) {

        long ways = 1;

        int items = remaining;

        for (int value : count) {

            if (value == 0) {
                continue;
            }

            ways = multiplyCapped(ways, nCr(items, value));

            if (ways >= LIMIT) {
                return LIMIT;
            }

            items -= value;
        }

        return ways;
    }

    private long nCr(int n, int r) {

        if (r > n) {
            return 0;
        }

        if (r == 0 || r == n) {
            return 1;
        }

        r = Math.min(r, n - r);

        long result = 1;

        for (int i = 1; i <= r; i++) {

            result = result * (n - i + 1) / i;

            if (result >= LIMIT) {
                return LIMIT;
            }
        }

        return result;
    }

    private long multiplyCapped(long a, long b) {

        if (b == 0) {
            return 0;
        }

        if (a >= LIMIT || b >= LIMIT) {
            return LIMIT;
        }

        if (a > LIMIT / b) {
            return LIMIT;
        }

        return a * b;
    }
}
