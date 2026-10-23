# Write your MySQL query statement below
WITH t1 AS(
    SELECT
    actor_id,
    director_id
    FROM ActorDirector
    GROUP BY actor_id,director_id
    HAVING COUNT(actor_id) >= 3 AND  COUNT(director_id) >= 3
)

SELECT * FROM t1;