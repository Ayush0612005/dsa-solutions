/*
LeetCode 19 - Remove Nth Node From End of List

Difficulty: Medium

Approach:
- Use the Two Pointer technique with a dummy node.
- Create two pointers:
  - first
  - second
- Move the first pointer (n + 1) steps ahead to maintain a gap of n nodes.
- Move both pointers together until the first pointer reaches the end.
- The second pointer will be just before the node to remove.
- Update the next pointer to skip the target node.
- Return the new head using dummy.next.

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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}
