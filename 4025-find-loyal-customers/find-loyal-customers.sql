# Write your MySQL query statement below
WITH t1 AS(
    SELECT
    customer_id,
    SUM(CASE WHEN transaction_type = 'purchase' THEN 1 ELSE 0 END) AS purchase_cnt,
    SUM(CASE WHEN transaction_type = 'refund' THEN 1 ELSE 0 END) AS refund_cnt,
    COUNT(transaction_type) AS transaction_cnt
    FROM customer_transactions
    GROUP BY customer_id
),
t2 AS(
    SELECT
    customer_id,
    MAX(transaction_date) AS latestDate,
    MIN(transaction_date) AS intialDate
    FROM customer_transactions 
    GROUP BY customer_id
)

SELECT
t1.customer_id
FROM t1 JOIN t2 
ON t1.customer_id = t2.customer_id
WHERE t1.purchase_cnt >= 3 AND 
DATEDIFF(t2.latestDate,t2.intialDate) >= 30 AND 
(t1.refund_cnt*100.0/t1.transaction_cnt)
 < 20.0
ORDER BY t1.customer_id;