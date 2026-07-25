/*
LeetCode 1581 - Customer Who Visited but Did Not Make Any Transactions

Difficulty: Easy

Approach:
- Perform a LEFT JOIN between the Visits and Transactions tables.
- Match records using visit_id.
- Visits without a matching transaction will have NULL in transaction_id.
- Filter those visits using:
      transaction_id IS NULL
- Group the remaining records by customer_id.
- Count the number of such visits for each customer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT
    v.customer_id,
    COUNT(*) AS count_no_trans
FROM Visits v
LEFT JOIN Transactions t
ON v.visit_id = t.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;
