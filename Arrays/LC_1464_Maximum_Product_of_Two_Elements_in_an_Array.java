/*
LeetCode 1464 - Maximum Product of Two Elements in an Array

Difficulty: Easy

Approach:
- Traverse the array once while keeping track of the largest and second-largest elements.
- If the current element is greater than the largest, update both largest and second-largest.
- Otherwise, update only the second-largest if needed.
- Compute the maximum product using:
      (largest - 1) × (secondLargest - 1)

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int maxProduct(int[] nums) {

        int largest = 0;
        int secondLargest = 0;

        for (int num : nums) {

            if (num > largest) {

                secondLargest = largest;
                largest = num;

            } else if (num > secondLargest) {

                secondLargest = num;
            }
        }

        return (largest - 1) * (secondLargest - 1);
    }
}
