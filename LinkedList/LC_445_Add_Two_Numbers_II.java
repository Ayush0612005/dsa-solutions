/*
LeetCode 445 - Add Two Numbers II

Difficulty: Medium

Approach:
- Use two stacks to store the digits of both linked lists.
- Push all digits from both lists into their respective stacks.
- Pop elements from the stacks to simulate addition from least significant digit.
- Maintain a carry while adding the digits.
- Create new nodes and insert them at the front of the resulting linked list.
- Continue until both stacks are empty and there is no remaining carry.

Time Complexity: O(m + n)

where:
- m = length of l1
- n = length of l2

Space Complexity: O(m + n)
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

import java.util.Stack;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();

        while (l1 != null) {
            firstStack.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            secondStack.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while (!firstStack.isEmpty() ||
               !secondStack.isEmpty() ||
               carry != 0) {

            int sum = carry;

            if (!firstStack.isEmpty()) {
                sum += firstStack.pop();
            }

            if (!secondStack.isEmpty()) {
                sum += secondStack.pop();
            }

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;

            carry = sum / 10;
        }

        return head;
    }
}
