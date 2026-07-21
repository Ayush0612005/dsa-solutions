/*
LeetCode 180 - Consecutive Numbers

Difficulty: Medium

Approach:
- Use a Common Table Expression (CTE).
- Apply the LEAD() window function to retrieve the next one and next two values.
- Compare the current number with the next two numbers.
- If all three are equal, the number appears at least three consecutive times.
- Use DISTINCT to avoid duplicate results.

Time Complexity: O(n)
Space Complexity: O(n)
*/

WITH RankedLogs AS (
    SELECT
        num,
        LEAD(num, 1) OVER (ORDER BY id) AS next_num,
        LEAD(num, 2) OVER (ORDER BY id) AS next_next_num
    FROM Logs
)

SELECT DISTINCT
    num AS ConsecutiveNums
FROM RankedLogs
WHERE num = next_num
  AND num = next_next_num;
