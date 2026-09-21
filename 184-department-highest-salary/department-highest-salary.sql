-- Write your PostgreSQL query statement below
SELECT 
t.dept AS Department,
t.EmpName AS Employee,
t.slry AS Salary
FROM
(
    SELECT
    d.name AS dept,
    e.name As EmpName,
    e.salary AS slry,
    DENSE_RANK() OVER(
        PARTITION BY e.departmentId 
        ORDER BY salary DESC) AS rank
    FROM
    Employee e JOIN Department d
    ON e.departmentId  = d.id
) AS t
WHERE t.rank = 1;