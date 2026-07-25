/*
LeetCode 1464 - Maximum Product of Two Elements in an Array

Difficulty: Easy

Approach:
- Traverse the digits of the given number.
- Keep track of the largest and second-largest digits.
- Update the two maximum values while iterating.
- Return the product of the two largest digits.

Time Complexity: O(d)

where d is the number of digits in n.

Space Complexity: O(1)
*/

class Solution {

    public int maxProduct(int n) {

        int largest = 0;
        int secondLargest = 0;

        while (n > 0) {

            int digit = n % 10;

            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest) {
                secondLargest = digit;
            }

            n /= 10;
        }

        return largest * secondLargest;
    }
}
