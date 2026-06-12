/*
LeetCode 206 - Reverse Linked List

Difficulty: Easy

Approach:
- Traverse the linked list while maintaining two pointers:
  - prev: points to the previous node.
  - current: points to the current node.
- Reverse the link of each node to point to its previous node.
- Move both pointers forward until the end of the list.
- Return prev, which becomes the new head of the reversed list.

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

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode node = head;

        while (node != null) {

            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        return prev;
    }
}
