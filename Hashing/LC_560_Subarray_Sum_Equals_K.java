/*
LeetCode 560 - Subarray Sum Equals K

Difficulty: Medium

Approach:
- Use Prefix Sum with a HashMap.
- Maintain the cumulative sum while traversing the array.
- Store the frequency of each prefix sum in the HashMap.
- For the current prefix sum:
  - If (currentSum - k) exists in the map,
    then there are subarrays ending at the current index whose sum is k.
- Update the frequency of the current prefix sum.
- Return the total count of such subarrays.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;

class Solution {

    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int currentSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int num : nums) {

            currentSum += num;

            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            map.put(currentSum,
                    map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
