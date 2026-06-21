/*
LeetCode 1833 - Maximum Ice Cream Bars

Difficulty: Medium

Approach:
- Sort the costs array using Count Sort.
- Buy ice cream bars from the cheapest to the most expensive.
- Stop when there are not enough coins remaining.
- Count the maximum number of bars that can be purchased.

Time Complexity: O(n + k)
where:
- n = costs.length
- k = maximum cost value

Space Complexity: O(k)
*/

class Solution {

    public int maxIceCream(int[] costs, int coins) {

        countSort(costs);

        int count = 0;

        for (int cost : costs) {

            if (coins < cost) {
                break;
            }

            coins -= cost;
            count++;
        }

        return count;
    }

    private void countSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        int[] countArray = new int[max + 1];

        for (int num : arr) {
            countArray[num]++;
        }

        int index = 0;

        for (int i = 0; i <= max; i++) {

            while (countArray[i] > 0) {
                arr[index++] = i;
                countArray[i]--;
            }
        }
    }
}
