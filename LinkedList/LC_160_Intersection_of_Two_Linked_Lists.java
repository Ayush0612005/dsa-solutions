/*
LeetCode 160 - Intersection of Two Linked Lists

Difficulty: Easy

Approach:
- Use two pointers, one starting from headA and the other from headB.
- When a pointer reaches the end of its list, redirect it to the head of the other list.
- If the lists intersect, both pointers will eventually meet at the intersection node.
- If they do not intersect, both pointers will become null at the same time.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }
}
