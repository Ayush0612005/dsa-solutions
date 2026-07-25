/*
LeetCode 1378 - Replace Employee ID With The Unique Identifier

Difficulty: Easy

Approach:
- Perform a LEFT JOIN between the Employees and EmployeeUNI tables.
- Match records using the employee ID.
- Use a LEFT JOIN so that all employees are included, even if they do not
  have a unique identifier.
- Return the unique_id and employee name.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT
    eu.unique_id,
    e.name
FROM Employees e
LEFT JOIN EmployeeUNI eu
ON e.id = eu.id;
