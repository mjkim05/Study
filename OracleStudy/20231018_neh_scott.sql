
COMMIT;

INSERT INTO EMP2 VALUES (7389, 'KING', 'PRESIDENT',NULL,to_date('1981-11-17','YYYY-MM-DD'),5000,NULL,10);
INSERT INTO EMP2 VALUES (7844, 'TURNER', 'SALESMAN',7698,TO_DATE('1987-07-13','YYYY-MM-DD'),1500,0,30);
INSERT INTO EMP2 VALUES (7876, 'ADMAS','CLERK',7788,TO_DATE('1987-07-13','YYYY-MM-DD'),1100,NULL,20);

SELECT *
FROM EMP2;

DELETE FROM EMP2 WHERE ENAME = 'KING';
DELETE FROM EMP2 WHERE ENAME = 'TURNER';
DELETE FROM EMP2 WHERE ENAME = 'ADMAS';

-- @}--^---