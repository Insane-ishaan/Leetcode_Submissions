# Write your MySQL query statement below
SELECT 
t.user_id,
t.time_stamp AS last_stamp
FROM
(
    SELECT
    user_id,
    time_stamp,
    RANK() OVER (
        PARTITION BY user_id 
        ORDER BY time_stamp DESC) AS rnk
    FROM Logins
    WHERE time_stamp >= '2020-01-01' AND time_stamp < '2021-01-01'
) AS t
WHERE t.rnk = 1;
