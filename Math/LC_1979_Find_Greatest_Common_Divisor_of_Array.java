/*
LeetCode 1979 - Find Greatest Common Divisor of Array

Difficulty: Easy

Approach:
- Traverse the array to find the minimum and maximum elements.
- The GCD of the array is the GCD of its minimum and maximum values.
- Use the Euclidean Algorithm to efficiently compute the GCD.

Time Complexity: O(n + log(min))
Space Complexity: O(log(min))
*/

class Solution {

    public int findGCD(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(max, min);
    }

    private int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
