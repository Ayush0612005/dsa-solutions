/*
 * LeetCode 83 - Remove Duplicates from Sorted List
 * Difficulty: Easy
 *
 * Approach:
 * Traverse the sorted linked list using a current pointer.
 * If the current node and the next node have the same value,
 * skip the next node by updating curr.next.
 *
 * Since the list is sorted, duplicate values will always be adjacent.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}
