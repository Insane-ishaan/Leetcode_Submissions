# Write your MySQL query statement below
WITH t1 AS (
   SELECT 
   user_id,
   reaction,
   COUNT(reaction) OVER(
        PARTITION BY user_id
        ORDER BY user_id
   ) AS userID_specific_total_reaction_count,
   COUNT(reaction) OVER(
        PARTITION BY user_id,reaction
        ORDER BY user_id
   ) AS userID_reaction_specific_count
    FROM reactions
),
t2 AS(
    SELECT
    user_id,
    reaction,
    ROUND((MAX(userID_reaction_specific_count)/userID_specific_total_reaction_count),2) AS reaction_ratio
    FROM t1
    WHERE userID_specific_total_reaction_count >= 5
    GROUP BY user_id,reaction
)
SELECT 
user_id,
reaction AS dominant_reaction,
reaction_ratio
FROM t2
WHERE reaction_ratio >= 0.60
ORDER BY reaction_ratio DESC,user_id;