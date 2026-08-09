/*
LeetCode 876 - Middle of the Linked List

Difficulty: Easy

Approach:
- Use the Two Pointer technique (Slow and Fast pointers).
- The slow pointer moves one node at a time.
- The fast pointer moves two nodes at a time.
- When the fast pointer reaches the end, the slow pointer
  will be at the middle of the linked list.
- For an even-sized list, this naturally returns the second
  middle node, as required by the problem.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
