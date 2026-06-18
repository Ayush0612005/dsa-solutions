/*
LeetCode 2011 - Final Value of Variable After Performing Operations

Difficulty: Easy

Approach:
- Initialize a variable x = 0.
- Traverse the operations array.
- If the middle character is '+', increment x.
- Otherwise, decrement x.
- Return the final value of x.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int finalValueAfterOperations(String[] operations) {

        int x = 0;

        for (String operation : operations) {

            if (operation.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }

        return x;
    }
}
