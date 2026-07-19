/*
LeetCode 177 - Nth Highest Salary

Difficulty: Medium

Approach:
- Create a MySQL function that returns the Nth highest distinct salary.
- Convert N into a zero-based offset:
      OFFSET = N - 1
- Select distinct salaries to ignore duplicates.
- Sort the salaries in descending order.
- Use LIMIT 1 OFFSET M to retrieve the Nth highest salary.
- If the Nth highest salary does not exist, the function returns NULL.

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE M INT;

    SET M = N - 1;

    RETURN (
        SELECT DISTINCT salary
        FROM Employee
        ORDER BY salary DESC
        LIMIT 1 OFFSET M
    );
END;
