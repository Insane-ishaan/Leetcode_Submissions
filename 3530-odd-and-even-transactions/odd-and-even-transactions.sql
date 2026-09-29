# Write your MySQL query statement below
WITH t1 AS(
    SELECT 
    transaction_date,
    SUM(CASE WHEN MOD(amount,2) = 0 THEN amount END) OVER(
        PARTITION BY transaction_date
        ORDER BY transaction_id
    ) AS evn_sum,
    SUM(CASE WHEN MOD(amount,2) = 1 THEN amount END) OVER(
        PARTITION BY transaction_date
        ORDER BY transaction_id
    ) AS odd_sum
    FROM transactions
)

SELECT 
transaction_date,
IFNULL(MAX(odd_sum),0) AS odd_sum,
IFNULL(MAX(evn_sum),0) AS even_sum 
FROM t1
GROUP BY transaction_date
ORDER BY transaction_date ASC;