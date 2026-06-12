/*
LeetCode 237 - Delete Node in a Linked List

Difficulty: Easy

Approach:
- We are not given access to the head of the linked list.
- Copy the value of the next node into the current node.
- Skip the next node by updating the current node's next pointer.
- This effectively deletes the given node.

Time Complexity: O(1)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *     }
 * }
 */

class Solution {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
