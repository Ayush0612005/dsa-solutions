/*
LeetCode 142 - Linked List Cycle II

Difficulty: Medium

Approach:
- Use Floyd's Cycle Detection (Tortoise and Hare) algorithm.
- Move the slow pointer one step and the fast pointer two steps.
- If the two pointers meet, a cycle exists.
- Reset the slow pointer to the head of the list.
- Move both pointers one step at a time until they meet again.
- The meeting point is the node where the cycle begins.
- If the fast pointer reaches the end, there is no cycle.

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
 *         this.next = next;
 *         this.val = val;
 *     }
 * }
 */

public class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
