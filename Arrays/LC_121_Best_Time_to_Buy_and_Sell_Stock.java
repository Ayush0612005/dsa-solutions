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



// Another way of solving the same question:

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;

        for(int i = 1; i < prices.length; i++){

            int profit = prices[i] - min;

            max = Math.max(max, profit);
            min = Math.min(min,prices[i]);

        }
        return max;
    }
}


//same method as above 2 but writing style is different:

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;

        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - min;

            if(profit > max){
                max = profit;
            }
            if(prices[i] < min){
                min = prices[i];
            }
        }
        return max;
    }
}
//this code is easier to understand and more humanable
