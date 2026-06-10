/*
LeetCode 141 - Linked List Cycle

Difficulty: Easy

Approach:
- Use Floyd's Cycle Detection Algorithm (Tortoise and Hare).
- Maintain two pointers:
  - slow moves one step at a time.
  - fast moves two steps at a time.
- If a cycle exists, the two pointers will eventually meet.
- If fast reaches the end of the list, no cycle exists.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
