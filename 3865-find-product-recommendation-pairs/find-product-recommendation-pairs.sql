# Write your MySQL query statement below
WITH t1 AS(
    SELECT
    p1.user_id,
    p1.product_id AS product1_id ,
    p2.product_id AS product2_id 
    FROM ProductPurchases p1 JOIN ProductPurchases p2
    ON p1.user_id = p2.user_id
    WHERE p1.product_id < p2.product_id
),
t2 AS(
    SELECT
    t1.product1_id,
    t1.product2_id,
    pi1.category AS product1_category,
    pi2.category AS product2_category,
    COUNT(t1.user_id) AS customer_count 
    FROM t1
    JOIN ProductInfo pi1
        ON t1.product1_id = pi1.product_id 
    JOIN ProductInfo pi2
        ON t1.product2_id = pi2.product_id
    GROUP BY  t1.product1_id,t1.product2_id
)

SELECT 
product1_id,product2_id,
product1_category,product2_category,
customer_count
FROM t2
WHERE customer_count >= 3
ORDER BY customer_count DESC,product1_id ASC,product2_id ASC;