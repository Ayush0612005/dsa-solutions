/*
LeetCode 1907 - Count Salary Categories

Difficulty: Medium

Approach:
- Divide accounts into three salary categories:
  - Low Salary: income < 20000
  - Average Salary: income between 20000 and 50000 (inclusive)
  - High Salary: income > 50000
- Count the number of accounts in each category using conditional aggregation.
- Use UNION to combine the three category counts into a single result set.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT
    'Low Salary' AS category,
    SUM(income < 20000) AS accounts_count
FROM Accounts

UNION

SELECT
    'Average Salary' AS category,
    SUM(income BETWEEN 20000 AND 50000) AS accounts_count
FROM Accounts

UNION

SELECT
    'High Salary' AS category,
    SUM(income > 50000) AS accounts_count
FROM Accounts;
