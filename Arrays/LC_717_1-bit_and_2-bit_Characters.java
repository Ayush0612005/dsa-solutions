/*
LeetCode 717 - 1-bit and 2-bit Characters

Difficulty: Easy

Approach:
- Traverse the array from left to right.
- If the current bit is:
  - 0: it represents a one-bit character, so move one step.
  - 1: it represents the start of a two-bit character, so move two steps.
- Stop before the last bit.
- If the pointer ends exactly at the last index, the final character
  is a one-bit character.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isOneBitCharacter(int[] bits) {

        int i = 0;

        while (i < bits.length - 1) {

            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }

        return i == bits.length - 1;
    }
}
