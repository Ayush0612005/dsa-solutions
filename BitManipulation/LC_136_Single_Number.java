/*
LeetCode 136 - Single Number

Difficulty: Easy

Approach:
- Use the XOR operator (^).
- XOR of a number with itself is 0.
- XOR of a number with 0 is the number itself.
- Since every element appears twice except one,
  all duplicate numbers cancel out.
- The remaining value is the single number.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
