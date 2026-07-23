/*
LeetCode 584 - Find Customer Referee

Difficulty: Easy

Approach:
- Select the names of customers.
- Exclude customers whose referee_id is 2.
- Include customers whose referee_id is NULL, since they have no referee.
- Use the OR operator to handle NULL values correctly.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT name
FROM Customer
WHERE referee_id != 2
   OR referee_id IS NULL;
