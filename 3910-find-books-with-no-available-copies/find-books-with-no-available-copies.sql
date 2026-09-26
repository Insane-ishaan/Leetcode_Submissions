# Write your MySQL query statement below
WITH t1 AS(
    SELECT 
    l.book_id AS book_id ,
    l.title AS title,
    l.author AS author,
    l.genre AS genre,
    l.publication_year AS pb_year,
    l.total_copies AS total_cp,
    b.record_id As r_id,
    b.borrower_name,
    b.borrow_date,
    b.return_date  AS return_date
    FROM library_books l JOIN borrowing_records b
    ON l.book_id = b.book_id
),
t2 AS(
    SELECT
    book_id,
    title,
    author,
    genre,
    pb_year,
    total_cp,
    ROW_NUMBER() OVER(
        PARTITION BY book_id
        ORDER BY r_id
    ) AS borrow_count
    FROM t1
    WHERE return_date IS NULL
),
t3 AS(
    SELECT
    book_id,
    title,
    author,
    genre,
    total_cp,
    pb_year
    FROM t2
    GROUP BY book_id
    HAVING COUNT(borrow_count) = total_cp
)
SELECT 
    book_id,
    title,
    author,
    genre,
    pb_year AS publication_year,
    total_cp AS current_borrowers
FROM t3
ORDER BY current_borrowers DESC,title ASC;