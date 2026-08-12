/*
LeetCode 2958 - Length of Longest Subarray With at Most K Frequency

Difficulty: Medium

Approach:
- Use the Sliding Window technique with a HashMap.
- The window is represented by [left, right].
- Store the frequency of each number inside the current window.
- Expand the window by moving right.
- If the frequency of nums[right] becomes greater than k,
  shrink the window from the left until the frequency becomes valid again.
- At every valid window, update the maximum length.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        int left = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {

            count.put(
                nums[right],
                count.getOrDefault(nums[right], 0) + 1
            );

            while (count.get(nums[right]) > k) {

                count.put(
                    nums[left],
                    count.get(nums[left]) - 1
                );

                left++;
            }

            answer = Math.max(
                answer,
                right - left + 1
            );
        }

        return answer;
    }
}
