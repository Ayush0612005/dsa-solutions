/*
LeetCode 176 - Second Highest Salary

Difficulty: Medium

Approach:
- Select distinct salaries to avoid duplicate values.
- Sort the salaries in descending order.
- Skip the highest salary using OFFSET 1.
- Retrieve the next salary using LIMIT 1.
- Wrap the query in a subquery and return it as SecondHighestSalary.
- If a second highest salary does not exist, the subquery returns NULL.

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

SELECT (
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;
