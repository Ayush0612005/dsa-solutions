/*
LeetCode 875 - Koko Eating Bananas

Difficulty: Medium

Approach:
- The answer lies between 1 and the maximum pile size.
- Use Binary Search on the eating speed.
- For a given speed, calculate the total hours required to eat all bananas.
- If Koko can finish within h hours, try a smaller speed.
- Otherwise, increase the speed.
- The smallest valid speed is the answer.

Time Complexity: O(n * log(maxPile))
Space Complexity: O(1)
*/

class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = 0;

        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (canFinish(piles, h, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean canFinish(int[] piles, int h, int speed) {

        long hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; // Ceiling division
        }

        return hours <= h;
    }
}
