/*
LeetCode 183 - Customers Who Never Order

Difficulty: Easy

Approach:
- Use a LEFT JOIN to combine the Customers and Orders tables.
- Every customer is included, even if they have no matching order.
- Customers with no orders will have NULL values in the Orders columns.
- Filter those rows using:
      o.customerId IS NULL
- Return the names of customers who never placed an order.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT c.name AS Customers
FROM Customers c
LEFT JOIN Orders o
ON c.id = o.customerId
WHERE o.customerId IS NULL;
