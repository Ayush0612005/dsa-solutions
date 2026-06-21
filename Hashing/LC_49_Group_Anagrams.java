/*
LeetCode 49 - Group Anagrams

Difficulty: Medium

Approach:
- Two strings are anagrams if their sorted character sequences are identical.
- For each string:
  1. Convert it to a character array.
  2. Sort the array.
  3. Use the sorted string as a key in a HashMap.
- Store all strings with the same sorted key in the same list.
- Return all grouped lists from the HashMap.

Time Complexity: O(n * k log k)
where:
- n = number of strings
- k = average length of a string

Space Complexity: O(n * k)
*/

import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
