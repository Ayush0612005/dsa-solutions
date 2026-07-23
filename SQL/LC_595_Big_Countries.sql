/*
LeetCode 595 - Big Countries

Difficulty: Easy

Approach:
- Select the country name, population, and area.
- A country is considered "big" if:
  - Its area is at least 3,000,000, or
  - Its population is at least 25,000,000.
- Use the OR operator to filter countries satisfying either condition.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT
    name,
    population,
    area
FROM World
WHERE area >= 3000000
   OR population >= 25000000;
