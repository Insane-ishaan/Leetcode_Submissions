WITH t1 AS(
    SELECT 
    user_id,
    activity_date,
    activity_type,
    activity_duration 
    FROM UserActivity
),
t2 AS(
    SELECT
    user_id,
    ROUND(AVG(CASE WHEN activity_type='free_trial' THEN activity_duration END),2) AS trial_avg_duration,
    ROUND(AVG(CASE WHEN activity_type='paid' THEN activity_duration END),2) AS paid_avg_duration 
    FROM t1
    GROUP BY user_id
)

SELECT user_id,trial_avg_duration,paid_avg_duration
FROM t2
WHERE trial_avg_duration IS NOT NULL AND paid_avg_duration IS NOT NULL
ORDER BY user_id;