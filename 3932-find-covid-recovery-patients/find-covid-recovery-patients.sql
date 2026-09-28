# Write your MySQL query statement below
WITH positive_report AS(
    SELECT
    c.patient_id,
    p.patient_name,
    p.age,
    MIN(test_date) AS initialDate
    FROM covid_tests c JOIN patients p
    ON c.patient_id = p.patient_id
    WHERE c.result = 'Positive'
    GROUP BY c.patient_id
),
negative_report AS(
    SELECT
    c.patient_id,
    MIN(test_date) AS lastDate
    FROM covid_tests c JOIN positive_report p
    ON c.patient_id = p.patient_id
    WHERE c.test_date > p.initialDate AND c.result = 'Negative'
    GROUP BY c.patient_id
)

SELECT
p.patient_id,
p.patient_name,
p.age,
DATEDIFF(n.lastDate,p.initialDate) AS recovery_time
FROM positive_report p JOIN negative_report n
ON p.patient_id = n.patient_id
ORDER BY recovery_time,p.patient_name;