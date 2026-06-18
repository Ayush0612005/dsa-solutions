/*
LeetCode 121 - Best Time to Buy and Sell Stock

Difficulty: Easy

Approach:
- Keep track of the minimum stock price seen so far.
- For each day:
  - Update the minimum price if a lower price is found.
  - Calculate the profit if the stock is sold on the current day.
  - Update the maximum profit accordingly.
- Return the maximum profit obtained.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
