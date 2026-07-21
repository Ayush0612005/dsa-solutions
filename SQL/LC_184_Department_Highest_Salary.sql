/*
LeetCode 184 - Department Highest Salary

Difficulty: Medium

Approach:
- Join the Employee and Department tables using departmentId.
- Find the maximum salary for each department using GROUP BY.
- Filter employees whose (departmentId, salary) matches the maximum salary
  of their department.
- Return the department name, employee name, and salary.
- If multiple employees have the highest salary in a department,
  all of them are returned.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Employee e
JOIN Department d
ON e.departmentId = d.id
WHERE (e.departmentId, e.salary) IN (
    SELECT
        departmentId,
        MAX(salary)
    FROM Employee
    GROUP BY departmentId
);
