/*
LeetCode 3658 - GCD of Odd and Even Sums

Difficulty: Easy

Approach:
- The sum of the first n odd numbers is:
      oddSum = n²
- The sum of the first n even numbers is:
      evenSum = n(n + 1)
- Therefore:
      gcd(n², n(n + 1))
    = n × gcd(n, n + 1)
- Since consecutive integers are always coprime:
      gcd(n, n + 1) = 1
- Hence, the answer is simply n.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    public int gcdOfOddEvenSums(int n) {

        return n;
    }
}
