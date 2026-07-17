/*
LeetCode 3312 - Sorted GCD Pair Queries

Difficulty: Hard

Approach:
- Count the frequency of every value in the array.
- For each possible GCD g:
  - Count how many numbers are divisible by g.
- Use Inclusion-Exclusion:
  - Compute the number of pairs whose GCD is exactly g.
  - Subtract the pairs already counted for multiples of g.
- Build a prefix sum over the GCD pair counts.
- For each query:
  - Use Binary Search on the prefix sum to find the smallest
    GCD whose cumulative pair count exceeds the query index.

Time Complexity: O(M log M + Q log M)

where:
- M = maximum value in nums
- Q = number of queries

Space Complexity: O(M)
*/

class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int maxValue = 0;

        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        int[] frequency = new int[maxValue + 1];

        for (int num : nums) {
            frequency[num]++;
        }

        int[] divisibleCount = new int[maxValue + 1];

        for (int gcd = 1; gcd <= maxValue; gcd++) {

            for (int multiple = gcd;
                 multiple <= maxValue;
                 multiple += gcd) {

                divisibleCount[gcd] += frequency[multiple];
            }
        }

        long[] gcdPairCount = new long[maxValue + 1];

        for (int gcd = maxValue; gcd >= 1; gcd--) {

            long pairs =
                    (long) divisibleCount[gcd] *
                    (divisibleCount[gcd] - 1) / 2;

            for (int multiple = gcd * 2;
                 multiple <= maxValue;
                 multiple += gcd) {

                pairs -= gcdPairCount[multiple];
            }

            gcdPairCount[gcd] = pairs;
        }

        long[] prefix = new long[maxValue + 1];

        for (int i = 1; i <= maxValue; i++) {
            prefix[i] = prefix[i - 1] + gcdPairCount[i];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long query = queries[i];

            int left = 1;
            int right = maxValue;
            int result = 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (prefix[mid] > query) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            answer[i] = result;
        }

        return answer;
    }
}
