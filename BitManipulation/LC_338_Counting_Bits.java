/*
LeetCode 338 - Counting Bits

Difficulty: Easy

Approach:
- Use Dynamic Programming with Bit Manipulation.
- For any number i:
    bits(i) = bits(i / 2) + (i % 2)
- Using bit operators:
    bits(i) = bits(i >> 1) + (i & 1)
- i >> 1 removes the last bit.
- i & 1 checks whether the last bit is set.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public int[] countBits(int n) {

        int[] ans = new int[n + 1];
        ans[0] = 0;

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}
