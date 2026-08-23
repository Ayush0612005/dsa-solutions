/*
LeetCode 1927 - Sum Game

Difficulty: Medium

Approach:
- Divide the string into two halves.
- Calculate the sum of known digits in each half.
- Count the number of '?' characters in each half.
- If the total number of '?' characters is odd, Alice wins immediately
  because the players cannot make the two sums equal.
- Otherwise, Alice wins if the current difference cannot be balanced by
  the remaining '?' characters.
- Each pair of '?' characters can change the difference by at most 9.

Condition:
    leftSum - rightSum != 9 * (rightQuestionMarks - leftQuestionMarks) / 2

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean sumGame(String num) {

        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;

        int leftQuestions = 0;
        int rightQuestions = 0;

        for (int i = 0; i < n; i++) {

            char ch = num.charAt(i);

            if (i < n / 2) {

                if (ch == '?') {
                    leftQuestions++;
                } else {
                    leftSum += ch - '0';
                }

            } else {

                if (ch == '?') {
                    rightQuestions++;
                } else {
                    rightSum += ch - '0';
                }
            }
        }

        // Odd number of '?' means Alice can always force a win.
        if ((leftQuestions + rightQuestions) % 2 != 0) {
            return true;
        }

        return (leftSum - rightSum)
                != 9 * (rightQuestions - leftQuestions) / 2;
    }
}
