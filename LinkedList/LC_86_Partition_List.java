/*
LeetCode 86 - Partition List

Difficulty: Medium

Approach:
- Create two separate linked lists:
  - One for nodes with values less than x.
  - One for nodes with values greater than or equal to x.
- Traverse the original list once:
  - Append each node to the appropriate list.
- Connect the end of the smaller list to the beginning of the larger list.
- Set the end of the larger list to null to avoid cycles.
- Return the head of the merged list.

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

    public ListNode partition(ListNode head, int x) {

        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        ListNode less = lessHead;
        ListNode greater = greaterHead;

        while (head != null) {

            if (head.val < x) {

                less.next = head;
                less = less.next;

            } else {

                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        greater.next = null;
        less.next = greaterHead.next;

        return lessHead.next;
    }
}
