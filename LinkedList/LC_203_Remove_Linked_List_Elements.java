/*
LeetCode 203 - Remove Linked List Elements

Difficulty: Easy

Approach:
- Use a dummy node before the head to simplify handling cases where
  the head itself needs to be removed.
- Traverse the linked list using a pointer.
- If the next node contains the target value, skip it by updating:
      node.next = node.next.next
- Otherwise, move the pointer forward.
- Return dummy.next as the new head.

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

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1, head);
        ListNode current = dummy;

        while (current.next != null) {

            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
}
