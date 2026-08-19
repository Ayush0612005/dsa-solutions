/*
LeetCode 61 - Rotate List

Difficulty: Medium

Approach:
- Find the length of the linked list and its tail.
- Connect the tail to the head to form a circular linked list.
- Reduce k using k % length because rotating by the list length
  results in the original list.
- Find the new tail at position:
      length - k
- The node after the new tail becomes the new head.
- Break the circular connection.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int length = 1;

        // Find the tail and length.
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make the list circular.
        tail.next = head;

        k = k % length;

        // Find the new tail.
        int stepsToNewTail = length - k;

        ListNode newTail = head;

        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // The node after newTail becomes the new head.
        ListNode newHead = newTail.next;

        // Break the circular list.
        newTail.next = null;

        return newHead;
    }
}
