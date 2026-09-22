# Write your MySQL query statement below
SELECT
DISTINCT t.user_id,
t.prompt_count,
ROUND(t.avg_tokens,2) AS avg_tokens
FROM
(
    SELECT
    user_id,
    tokens,
    COUNT(tokens) OVER (
        PARTITION BY user_id
        ORDER BY user_id 
        ) AS prompt_count,
    AVG(tokens) OVER (
        PARTITION BY user_id
        ORDER BY user_id
    ) AS avg_tokens
    FROM prompts
) As t
WHERE t.tokens > t.avg_tokens AND prompt_count > 2
ORDER BY t.avg_tokens DESC,user_id;