/*
Find Missing Elements In Range

Difficulty: Easy

Approach:
- Traverse the array to find the minimum and maximum values.
- Store every element in a HashSet for O(1) lookups.
- Iterate from (min + 1) to (max - 1).
- Add every integer that is not present in the HashSet to the answer list.

Time Complexity: O(n + (max - min))
Space Complexity: O(n)
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public List<Integer> findMissingElements(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        List<Integer> missing = new ArrayList<>();

        for (int value = min + 1; value < max; value++) {

            if (!set.contains(value)) {
                missing.add(value);
            }
        }

        return missing;
    }
}
