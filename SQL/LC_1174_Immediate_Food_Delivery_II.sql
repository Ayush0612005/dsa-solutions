/*
LeetCode 1174 - Immediate Food Delivery II

Difficulty: Medium

Approach:
- Find the first order placed by each customer using the minimum order_date.
- Filter the Delivery table to include only those first orders.
- Count how many first orders were delivered on the customer's preferred date.
- Divide the number of immediate first orders by the total number of first orders.
- Multiply by 100 and round the result to two decimal places.

Time Complexity: O(n)
Space Complexity: O(n)
*/

SELECT
    ROUND(
        SUM(order_date = customer_pref_delivery_date) * 100.0 / COUNT(*),
        2
    ) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN (
    SELECT
        customer_id,
        MIN(order_date)
    FROM Delivery
    GROUP BY customer_id
);
