-- 코드를 입력하세요
SELECT B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE * S.TOTAL) AS TOTAL_SALES
FROM BOOK B
JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
JOIN (SELECT BOOK_ID, SUM(SALES) AS TOTAL
      FROM BOOK_SALES
      WHERE DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-01'
      GROUP BY BOOK_ID) S ON B.BOOK_ID = S.BOOK_ID
GROUP BY AUTHOR_ID, CATEGORY
ORDER BY AUTHOR_ID, CATEGORY DESC;