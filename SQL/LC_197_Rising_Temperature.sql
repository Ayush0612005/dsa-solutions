/*
LeetCode 197 - Rising Temperature

Difficulty: Easy

Approach:
- Perform a self join on the Weather table.
- Join each record with the previous day's record using:
      DATEDIFF(w1.recordDate, w2.recordDate) = 1
- Compare the temperatures of consecutive days.
- Return the IDs where the current day's temperature is higher than the previous day's.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT w1.id
FROM Weather w1
JOIN Weather w2
ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature;
