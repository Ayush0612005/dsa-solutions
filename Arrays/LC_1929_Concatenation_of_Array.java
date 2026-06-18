/*
LeetCode 1929 - Concatenation of Array

Difficulty: Easy

Approach:
- Create a new array of size 2 * n.
- Copy each element of nums into:
  - ans[i]
  - ans[i + n]
- This effectively concatenates the array with itself.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public int[] getConcatenation(int[] nums) {

        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }
}
