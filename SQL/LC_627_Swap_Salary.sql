/*
LeetCode 627 - Swap Salary

Difficulty: Easy

Approach:
- Update every row in the Salary table.
- Use the CASE expression to swap the values:
  - 'm' becomes 'f'
  - 'f' becomes 'm'
- Perform the update in a single SQL statement without using a temporary table.

Time Complexity: O(n)
Space Complexity: O(1)
*/

UPDATE Salary
SET sex = CASE
    WHEN sex = 'm' THEN 'f'
    ELSE 'm'
END;
