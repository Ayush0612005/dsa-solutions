/*
LeetCode 1068 - Product Sales Analysis I

Difficulty: Easy

Approach:
- Perform an INNER JOIN between the Sales and Product tables.
- Match records using product_id.
- Retrieve the product name from the Product table.
- Retrieve the year and price from the Sales table.
- Return the required columns.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT
    p.product_name,
    s.year,
    s.price
FROM Sales s
INNER JOIN Product p
ON s.product_id = p.product_id;
