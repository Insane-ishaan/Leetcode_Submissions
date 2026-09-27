-- Write your PostgreSQL query statement below
WITH t1 AS(
    SELECT 
    user_id,
    activity_date,
    activity_type,
    activity_duration 
    FROM UserActivity
),
t2 AS (
    SELECT 
    user_id,
    ROUND(AVG(activity_duration) FILTER(WHERE activity_type = 'free_trial'),2) AS freeTrialAvg,
    ROUND(AVG(activity_duration) FILTER(WHERE activity_type= 'paid'),2) AS paidTrialAvg
    FROM t1
    GROUP BY user_id
)

SELECT 
user_id,
freeTrialAvg AS trial_avg_duration,
paidTrialAvg AS paid_avg_duration 
FROM t2
WHERE freeTrialAvg IS NOT NULL AND paidTrialAvg IS NOT NULL
ORDER BY user_id;