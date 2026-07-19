/*
LeetCode 620 - Not Boring Movies

Difficulty: Easy

Approach:
- Select movies with an odd ID.
- Exclude movies whose description is "boring".
- Sort the remaining movies by rating in descending order.
- Return all columns of the qualifying movies.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT *
FROM Cinema
WHERE id % 2 = 1
  AND description != 'boring'
ORDER BY rating DESC;
