/*
LeetCode 89 - Gray Code

Difficulty: Medium

Approach:
- Gray Code can be generated using the formula:
      gray = i ^ (i >> 1)
- Generate all numbers from 0 to (2^n - 1).
- For each number:
  - Right shift it by one bit.
  - XOR it with the original number.
- Store the resulting Gray Code sequence.

Time Complexity: O(2^n)
Space Complexity: O(2^n)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();

        int totalNumbers = 1 << n;

        for (int i = 0; i < totalNumbers; i++) {

            result.add(i ^ (i >> 1));
        }

        return result;
    }
}
