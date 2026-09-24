# Write your MySQL query statement below
WITH t1 AS (
    SELECT 
    e.employee_id AS empId,
    e.name AS name,
    p.review_id AS reviewId,
    p.review_date AS reviewDate,
    p.rating AS rating
    FROM
    employees e JOIN performance_reviews p
    ON e.employee_id = p.employee_id
), t2 AS (
    SELECT 
    empId,
    name,
    rating,
    DENSE_RANK() OVER(
        PARTITION BY empId
        ORDER BY reviewDate DESC
    ) AS performance_rnk
    FROM t1
),t3 AS (
    SELECT 
    empId AS employee_id,
    name,
    MAX(CASE WHEN performance_rnk = 1 THEN rating END) AS maxRating,
    MAX(CASE WHEN performance_rnk = 2 THEN rating END) AS midRating,
    MIN(CASE WHEN performance_rnk = 3 THEN rating END) AS minRating
    FROM t2 
    GROUP BY empId
    HAVING COUNT(*) >= 3
)

SELECT 
employee_id,
name,
(maxRating-minRating) AS improvement_score 
FROM t3
WHERE maxRating > midRating AND midRating > minRating
ORDER BY improvement_score DESC,name ASC;