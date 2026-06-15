/*
LeetCode 496 - Next Greater Element I

Difficulty: Easy

Approach:
- Use a Monotonic Decreasing Stack to find the next greater element
  for every number in nums2.
- When the current number is greater than the stack's top element,
  it becomes the next greater element for all smaller elements on top.
- Store these mappings in a HashMap.
- For each element in nums1, retrieve its next greater element from
  the map, or return -1 if none exists.

Time Complexity: O(n + m)
where:
- n = nums1.length
- m = nums2.length

Space Complexity: O(m)
*/

import java.util.HashMap;
import java.util.Stack;

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {

            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
