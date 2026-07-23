/*
LeetCode 1148 - Article Views I

Difficulty: Easy

Approach:
- Select the distinct author IDs.
- An author viewed their own article if:
      author_id = viewer_id
- Use DISTINCT to remove duplicate author IDs.
- Sort the result in ascending order by id.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT DISTINCT
    author_id AS id
FROM Views
WHERE author_id = viewer_id
ORDER BY id ASC;
