/*
LeetCode 596 - Classes More Than 5 Students

Difficulty: Easy

Approach:
- Group the records by class.
- Count the number of distinct students in each class.
- Keep only the classes having at least 5 students using the HAVING clause.
- Return the class names.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;
