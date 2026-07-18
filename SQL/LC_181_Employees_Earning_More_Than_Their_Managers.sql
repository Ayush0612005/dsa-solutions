/*
LeetCode 181 - Employees Earning More Than Their Managers

Difficulty: Easy

Approach:
- Perform a self join on the Employee table.
- Match each employee with their manager using:
      employee.managerId = manager.id
- Filter employees whose salary is greater than their manager's salary.
- Return the employee's name.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT e1.name AS Employee
FROM Employee e1
JOIN Employee e2
ON e1.managerId = e2.id
WHERE e1.salary > e2.salary;
