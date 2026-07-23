/*
LeetCode 1757 - Recyclable and Low Fat Products

Difficulty: Easy

Approach:
- Select the product IDs from the Products table.
- Filter products that are:
  - Low fat (low_fats = 'Y')
  - Recyclable (recyclable = 'Y')
- Return the product IDs of all qualifying products.

Time Complexity: O(n)
Space Complexity: O(1)
*/

SELECT product_id
FROM Products
WHERE low_fats = 'Y'
  AND recyclable = 'Y';
