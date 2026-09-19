# Write your MySQL query statement below
SELECT DISTINCT
t.student_id,
t.subject,
t.prev_scores AS first_score,
t.latest_scores AS latest_score
FROM
(
    SELECT
    student_id,
    subject, 
    FIRST_VALUE(score) OVER(PARTITION BY student_id,subject ORDER BY exam_date) AS prev_scores,
    LAST_VALUE(score) OVER(PARTITION BY student_id,subject 
    ORDER BY exam_date 
    ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
    ) AS latest_scores
    FROM
    Scores
) AS t
WHERE t.latest_scores > t.prev_scores
ORDER BY t.student_id,t.subject;