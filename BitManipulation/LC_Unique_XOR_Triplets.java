/*
LeetCode - Unique XOR Triplets

Difficulty: Medium

Approach:
- Find the maximum value in the array to determine the range of possible XOR values.
- Compute all possible XOR values of every pair of elements and mark them.
- For every valid pair XOR, XOR it with each array element to generate all possible
  triplet XOR values.
- Store the generated XOR values and count the number of distinct results.

Time Complexity: O(n² + n × M)

where:
- n = number of elements
- M = range of possible XOR values (approximately 2 × max(nums))

Space Complexity: O(M)
*/

class Solution {

    public int uniqueXorTriplets(int[] nums) {

        int maxValue = 0;

        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        maxValue <<= 1;

        boolean[] pairXor = new boolean[maxValue];

        for (int first : nums) {
            for (int second : nums) {
                pairXor[first ^ second] = true;
            }
        }

        int[] tripletXor = new int[maxValue];

        for (int xorValue = 0; xorValue < maxValue; xorValue++) {

            if (pairXor[xorValue]) {

                for (int num : nums) {
                    tripletXor[xorValue ^ num] = 1;
                }
            }
        }

        int count = 0;

        for (int value : tripletXor) {
            count += value;
        }

        return count;
    }
}
