SELECT USER
FROM DUAL;
--==>> SCOTT

--■■■ HAVING ■■■-- 

--○ EMP 테이블에서 부서번호가 20,30인 부서를 대상으로 
--   부서의 총 급여가 10000보다 적을 경우만 부서별 총 급여를 조회한다.

SELECT DEPTNO "부서번호" , SUM(SAL)
FROM EMP 
WHERE 부서번호가 20,30
GROUP BY 부서번호;

SELECT DEPTNO "부서번호" , SUM(SAL)
FROM EMP 
WHERE DEPTNO IN (20,30)
GROUP BY DEPTNO;
--==>> 
/*
30	9400
20	10875
*/

SELECT DEPTNO "부서번호" , SUM(SAL)
FROM EMP 
WHERE DEPTNO IN (20,30)
  AND SUM(SAL) < 10000
GROUP BY DEPTNO;
--==>> 에러 발생
--     (ORA-00934: group function is not allowed here)

--①
SELECT DEPTNO "부서번호" , SUM(SAL)
FROM EMP 
WHERE DEPTNO IN (20,30)         -- OR
GROUP BY DEPTNO
HAVING SUM(SAL) < 10000;        -- 그룹에 대한 조건

--②
SELECT DEPTNO "부서번호" , SUM(SAL)
FROM EMP 
GROUP BY DEPTNO
HAVING SUM(SAL) < 10000  
   AND DEPTNO IN (20,30);

-- 1번 구문과 2번 구문은 결과적으로는 같지만 실제로는 전혀 다르다.
-- 1번 구문은 1차적으로 EMP 테이블에서 DEPTNO 가 20,30 인 데이터만 메모리에 올리고 
-- 2번 구문은 EMP 테이블 전체를 다 올린다.
-- 코드를 작성할때는 늘 메모리가 적게 소모되는 것을 사용하는 것이 효율적이고 성능이 좋기때문에
-- 1번 구문을 사용하는 것이 훨씬 바람직하다. 

---------------------------------------------------------------------------------------------------

-- ■■■ 중첩 그룹 함수 / 분석 함수 ■■■ -- 

--※ 그룹함수는 2 LEVEL 까지 중첩해서 사용할 수 있다. (오라클만 가능 / MSSQL 은 안됨)

SELECT SUM(SAL)
FROM EMP
GROUP BY DEPTNO;
--==>>
/*
9400
10875
8750
*/
SELECT MAX(SUM(SAL)) COL1               -- MAX 그룹함수 / SUM 그룹함수 중첩
FROM EMP 
GROUP BY DEPTNO;
--==>> 10875

-- RANK() / DENSE RANK()
--> ORACLE 9i 부터 적용.... (MSSQL 2005부터 적용... 확실 Ⅹ)

--> 하위 버전에서는 RANK()나 DENSE RANK()를 사용할 수 없기 떄문에
--  이 함수를 활용하지 않는 다른 방법을 찾아야한다.
--  예를 들어... 급여 순위를 구하고자 한다면...
--  해당 사원의 급여보다 더 큰 값이 몇 개인지 확인한 후
--  그 확인한 숫자에 『+1』을 추가로 연산해주면...
--  그 값이 곧 해당 사원의 등수가 된다.

 
SELECT COUNT(*) + 1 "등수"
FROM EMP
WHERE SAL > 800;        -- SMITH의 급여
--==>> 14               -- SMITH의 급여 등수

SELECT COUNT(*) + 1 "등수"
FROM EMP
WHERE SAL > 1600;       -- ALLEN의 급여 
--==> 7                 -- ALLEN의 급여 등수

--※ 서브 상관 쿼리(상관 서브 쿼리)
--   메인 쿼리가 있는 테이블의 컬럼이
--   서브 쿼리의 조건절(WHERE절, HAVING절)에 사용되는 경우
--   우리는 이 쿼리문을 서브 상관 쿼리(상관 서브 쿼리)라고 부른다.

SELECT ENAME "사원명" , SAL "급여" , (1) 급여등수
FROM EMP;

SELECT ENAME "사원명" , SAL "급여" , (SELECT COUNT(*) + 1 
                                      FROM EMP
                                      WHERE SAL > 800 ) "급여등수"
FROM EMP;
--==>> 급여 등수가 모두 14

SELECT E.ENAME "사원명" , E.SAL "급여" , (SELECT COUNT(*) + 1 
                                          FROM EMP
                                          WHERE SAL > E.SAL ) "급여등수"      --> SAL (사원들의 급여) > E.SAL (각 사원의 급여)
FROM EMP E     -- FROM 테이블의 별칭을 붙인다.
ORDER BY 3;
--==>>
/*
KING	5000	1
FORD	3000	2
SCOTT	3000	2
JONES	2975	4
BLAKE	2850	5
CLARK	2450	6
ALLEN	1600	7
TURNER	1500	8
MILLER	1300	9
WARD	1250	10
MARTIN	1250	10
ADAMS	1100	12
JAMES	950	    13
SMITH	800	    14
*/

--○ EMP 테이블을 대상으로 
--   사원명, 급여, 부서번호, 부서내급여등수, 전체급여등수 항목을 조회한다.
--   단, RANK() 함수를 사용하지 않고, 서브 상관 쿼리를 활용할 수 있도록 한다.

-- SMITH의 부서내급여등수!
SELECT COUNT(*)+1
FROM EMP
WHERE SAL > 800 
  AND DEPTNO = 20;

-- 기본적인 틀
SELECT ENAME 사원명, SAL 급여, DEPTNO 부서번호
     , (1) 부서내급여등수
     , (1) 전체급여등수
FROM EMP;

SELECT E.ENAME 사원명 , E.SAL 급여, E.DEPTNO 부서번호 
, (SELECT COUNT(*) + 1
   FROM EMP 
   WHERE DEPTNO = E.DEPTNO AND SAL> E.SAL) "부서내급여등수"
, (SELECT COUNT(*) + 1 
   FROM EMP
   WHERE SAL > E.SAL) "전체급여등수"
FROM EMP E
ORDER BY 3, 4;      -- 보기 편하게 정렬
--==>> 
/*
KING	5000	10	1	1
CLARK	2450	10	2	6
MILLER	1300	10	3	9
SCOTT	3000	20	1	2
FORD	3000	20	1	2
JONES	2975	20	3	4
ADAMS	1100	20	4	12
SMITH	800	    20	5	14
BLAKE	2850	30	1	5
ALLEN	1600	30	2	7
TURNER	1500	30	3	8
MARTIN	1250	30	4	10
WARD	1250	30	4	10
JAMES	950	    30	6	13
*/

SELECT *
FROM EMP;
--○ EMP 테이블을 대상으로 다음과 같이 조회될 수 있도록 쿼리문을 구성한다.
/*                                      
                                  - 각 부서 내에서 입사일자별로 누적된 급여의 합
--------------------------------------------------------------------------------
 사원명       부서번호         입사일         급여      부서내입사별급여누적  
 -------------------------------------------------------------------------------
 SMITH          20          1980-12-17        800                800
 JONES	        20	        1981-04-02	     2975		        3775
 FROD           20          1981-12-03       3000               6775
--------------------------------------------------------------------------------
*/

SELECT E.ENAME "사원명" , E.DEPTNO "부서번호", E.HIREDATE "입사일", E.SAL "급여"
     , (SELECT SUM(SAL)
        FROM EMP
        WHERE DEPTNO = E.DEPTNO 
          AND HIREDATE <= E.HIREDATE) "부서내입사별급여누적"
FROM EMP E
ORDER BY 2, 3;


SELECT EMP.ENAME "사원명" , EMP.DEPTNO "부서번호", EMP.HIREDATE "입사일", EMP.SAL "급여"
      , (1) "부서내입사별급여누적"
FROM EMP
ORDER BY 2,3;

SELECT E1.ENAME "사원명" , E1.DEPTNO "부서번호", E1.HIREDATE "입사일" , E1.SAL "급여"
      ,(1) "부서내입사별급여누적"
FROM EMP E1
ORDER BY 2,3;

SELECT E1.ENAME "사원명" , E1.DEPTNO "부서번호", E1.HIREDATE "입사일" , E1.SAL "급여"
      , (SELECT SUM(E2.SAL)
         FROM EMP E2
         WHERE E2.DEPTNO = E1.DEPTNO
           AND E2.HIREDATE <= E1.HIREDATE) "부서내입사별급여누적"
FROM EMP E1
ORDER BY 2,3;
--==>>
/*
CLARK	10	1981-06-09	2450	2450
KING	10	1981-11-17	5000	7450
MILLER	10	1982-01-23	1300	8750
SMITH	20	1980-12-17	 800	800
JONES	20	1981-04-02	2975	3775
FORD	20	1981-12-03	3000	6775
SCOTT	20	1987-07-13	3000	10875
ADAMS	20	1987-07-13	1100	10875
ALLEN	30	1981-02-20	1600	1600
WARD	30	1981-02-22	1250	2850
BLAKE	30	1981-05-01	2850	5700
TURNER	30	1981-09-08	1500	7200
MARTIN	30	1981-09-28	1250	8450
JAMES	30	1981-12-03	 950	9400
*/

--○ EMP 테이블을 대상으로 
--   입사한 사원의 수가 가장 많았을 때의
--   입사년월과 인원수를 조회할 수 있도록 쿼리문을 구성한다.


SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월" , COUNT(*) "인원수"
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
HAVING COUNT(*) >= 2;

SELECT T.*
FROM 
(
    SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월" , COUNT(*) "인원수"
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
) T
WHERE T.인원수; 

SELECT COUNT(*)
FROM 
(
    SELECT    
    MAX(COUNT(*)) "인원수" 
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
) T 
GROUP BY T.입사년월;

SELECT A.* T.*
FROM
(
    SELECT MAX(T.인원수) "최대인원"
    FROM
    (
        SELECT 
        TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
       ,COUNT(*) "인원수" 
        FROM EMP
        GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
    ) T
)A;
--WHERE T.인원수 - A.최대인원;



SELECT ((SELECT 
         MAX(COUNT(*) "인원수" 
         FROM EMP
         GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')) - COUNT(*) = 0
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM');





SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월" , COUNT(*) "인원수"
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM');

SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월" , COUNT(*) "인원수"
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
HAVING COUNT(*) - COUNT(*) > 0 ;


SELECT   (  SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월" , COUNT(*) "인원수"
            FROM EMP
            GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
            HAVING COUNT(*) - COUNT(*) > 0 )
FROM EMP E
GROUP BY TO_CHAR(E.HIREDATE,'YYYY-MM');



/*
SELECT TO_CHAR(HIREDATE,'YYYY-MM') 
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
HAVING COUNT(*) >= 2 ;
*/


SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
      ,COUNT(*)
FROM EMP 
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM');
--==>>
/*
1981-05	1
1981-12	2
1982-01	1
1981-09	2
1981-02	2
1981-11	1
1980-12	1
1981-04	1
1987-07	2
1981-06	1

*/


SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
      ,COUNT(*)
FROM EMP 
WHERE COUNT(*) = 2
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM');
--==>> 에러발생
--    ORA-00934: group function is not allowed here

SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
      ,COUNT(*)
FROM EMP 
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
HAVING COUNT(*) = 2;


SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
      ,COUNT(*)
FROM EMP 
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
HAVING COUNT(*) = (입사년월 기준 최대 인원);





SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
      ,COUNT(*)
FROM EMP 
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
HAVING COUNT(*) = (입사년월 기준 최대 인원);

-- 입사년월 기준 최대 인원
SELECT MAX(COUNT(*)) "인원수" 
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM');


SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
      ,COUNT(*)
FROM EMP 
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
HAVING COUNT(*) = (SELECT MAX(COUNT(*)) 
                   FROM EMP
                   GROUP BY TO_CHAR(HIREDATE,'YYYY-MM'));
--==>>
/*
1981-12	2
1981-09	2
1981-02	2
1987-07	2
*/


SELECT T1.입사년월, T1.인원수
FROM 
(
    SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
         , COUNT(*) "인원수"
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
)T1;
WHERE T1.인원수 = (2);


SELECT T1.입사년월, T1.인원수
FROM 
(
    SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
         , COUNT(*) "인원수"
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
)T1
WHERE T1.인원수 = ( SELECT MAX(T2.인원수)
                    FROM
                    (
                       SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
                             , COUNT(*) "인원수"
                       FROM EMP 
                       GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
                     )T2
                   );
--==>>
/*
1981-12	2
1981-09	2
1981-02	2
1987-07	2
*/

SELECT T1.입사년월, T1.인원수
FROM 
(
    SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월"
         , COUNT(*) "인원수"
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
)T1
WHERE T1.인원수 = (SELECT MAX(COUNT(*)) 
                   FROM EMP
                   GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')); 
--==>>
/*
1981-12	2
1981-09	2
1981-02	2
1987-07	2
*/

--------------------------------------------------------------------------------

--■■■ ROW_NUMBER ■■■--

SELECT ENAME "사원명", SAL "급여", HIREDATE "입사일"
FROM EMP;
--==>>
/*
SMITH	800	    1980-12-17
ALLEN	1600	1981-02-20
WARD	1250	1981-02-22
JONES	2975	1981-04-02
MARTIN	1250	1981-09-28
BLAKE	2850	1981-05-01
CLARK	2450	1981-06-09
SCOTT	3000	1987-07-13
KING	5000	1981-11-17
TURNER	1500	1981-09-08
ADAMS	1100	1987-07-13
JAMES	950	    1981-12-03
FORD	3000	1981-12-03
MILLER	1300	1982-01-23
*/



SELECT ROW_NUMBER() OVER(ORDER BY SAL DESC) "관찰"
     , ENAME "사원명", SAL "급여", HIREDATE "입사일"
FROM EMP;
---==>>
/*
1	KING	5000	1981-11-17
2	FORD	3000	1981-12-03
3	SCOTT	3000	1987-07-13
4	JONES	2975	1981-04-02
5	BLAKE	2850	1981-05-01
6	CLARK	2450	1981-06-09
7	ALLEN	1600	1981-02-20
8	TURNER	1500	1981-09-08
9	MILLER	1300	1982-01-23
10	WARD	1250	1981-02-22
11	MARTIN	1250	1981-09-28
12	ADAMS	1100	1987-07-13
13	JAMES	950	    1981-12-03
14	SMITH	800	    1980-12-17
*/

SELECT ROW_NUMBER() OVER(ORDER BY SAL DESC) "관찰"
     , ENAME "사원명", SAL "급여", HIREDATE "입사일"
FROM EMP
ORDER BY ENAME;
/*
12	ADAMS	1100	1987-07-13
7	ALLEN	1600	1981-02-20
5	BLAKE	2850	1981-05-01
6	CLARK	2450	1981-06-09
2	FORD	3000	1981-12-03
13	JAMES	950	    1981-12-03
4	JONES	2975	1981-04-02
1	KING	5000	1981-11-17
11	MARTIN	1250	1981-09-28
9	MILLER	1300	1982-01-23
3	SCOTT	3000	1987-07-13
14	SMITH	800	    1980-12-17
8	TURNER	1500	1981-09-08
10	WARD	1250	1981-02-22
*/

SELECT ROW_NUMBER() OVER(ORDER BY ENAME) "관찰"
     , ENAME "사원명", SAL "급여", HIREDATE "입사일"
FROM EMP
ORDER BY ENAME;
--==>> 
/*
1	ADAMS	1100	1987-07-13
2	ALLEN	1600	1981-02-20
3	BLAKE	2850	1981-05-01
4	CLARK	2450	1981-06-09
5	FORD	3000	1981-12-03
6	JAMES	950	    1981-12-03
7	JONES	2975	1981-04-02
8	KING	5000	1981-11-17
9	MARTIN	1250	1981-09-28
10	MILLER	1300	1982-01-23
11	SCOTT	3000	1987-07-13
12	SMITH	800	    1980-12-17
13	TURNER	1500	1981-09-08
14	WARD	1250	1981-02-22
*/


--※ 게시판의 게시물 번호를 SEQUENCE 나 IDENTITY 를 사용하게 되면
--   게시물을 삭제했을 경우... 삭제한 게시물의 자리에 다음 번호를 가진
--   게시물이 등록되는 상황이 발생하게 된다.
--   이는... 보안성 측면이나 미관상... 바람직하지 않는 상태일 수 있기 때문에
--   ROW_NUMBER()의 사용을 고려해 볼 수 있다.
--   관리의 목적(수정, 삭제)으로 사용할 때에는 SEQUENCE SK IDENTITY를 사용하지만 
--   단순히 게시물을 목록화하여 사용자에게 리스트 형식으로 보여줄 때에는 
--   사용하지 않는 것이 바람직할 수 있다.

--○ SEQUENCE(시퀀스 : 주문번호)
--   → 사전적인 의미 : 1. (일련의) 연속적인 사건들 2. (사건, 행동 등의) 순서


--○ 시퀀스 생성
CREATE SEQUENCE SEQ_BOARD   -- 기본적인 시퀀스 생성 구문
START WITH 1                -- 시작값 설정 옵션
INCREMENT BY 1              -- 증가값 설정 옵션
NOMAXVALUE                  -- 최대값 설정 옵션
NOCACHE;                    -- 캐시 사용 안함 설정 옵션
--==>> Sequence SEQ_BOARD이(가) 생성되었습니다.

--○ 실습 테이블 생성(테이블 명 : TBL_BOARD)
CREATE TABLE TBL_BOARD                  -- TBL_BOARD 테이블 생성 구문 → 게시판 테이블
( NO            NUMBER                  -- 게시물 번호       → Ⅹ
, TITLE         VARCHAR2(50)            -- 게시물 제목       → ○
, CONTENTS      VARCHAR2(1000)          -- 게시물 내용       → ○
, NAME          VARCHAR2(20)            -- 게시물 작성자     → △
, PW            VARCHAR2(20)            -- 게시물 패스워드   → △
, CREATED       DATE DEFAULT SYSDATE    -- 게시물 작성일     → Ⅹ
);
--==>> Table TBL_BOARD이(가) 생성되었습니다.


--○ 데이터 입력 → 게시판에 게시물 작성
INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'아~~~ 힘들다','10분만 쉬었다 올께요', '문정환', 'java006$', DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'아~ 졸리다','10분만 자고 올께요', '정한울', 'java006$', DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'아~ 웃겨','하루하루가 재미있어요', '노은하', 'java006$', DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'보고싶다','범구가 너무너무 보고싶어요', '김수환', 'java006$', DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'배고파요','점심을 먹었는데 배고파요', '김민지', 'java006$', DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'아직 남아있네요','두 시간 반이나 남아있네요', '이윤수', 'java006$', DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'그만하고싶다','그냥 넘어갈까....', '김호진', 'java006$', DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'어~ 배아파','ㅋㅋㅋㅋㅋ', '노은하', 'java006$', DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'소근소근','궁시렁궁시렁', '이윤수', 'java006$', DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'모자라요','아직 잠이 모자라요', '김동민', 'java006$', DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

--○ 세션 설정 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--==>> Session이(가) 변경되었습니다.

SELECT *
FROM TBL_BOARD;

--==>>
/*
1	아~~~ 힘들다	10분만 쉬었다 올께요	    문정환	java006$	2023-10-25 15:47:48
2	아~ 졸리다	    10분만 자고 올께요	        정한울	java006$	2023-10-25 15:47:52
3	아~ 웃겨	    하루하루가 재미있어요	    노은하	java006$	2023-10-25 15:47:55
4	보고싶다	    범구가 너무너무 보고싶어요	김수환	java006$	2023-10-25 15:47:58
5	배고파요	    점심을 먹었는데 배고파요	김민지	java006$	2023-10-25 15:48:02
6	아직 남아있네요	두 시간 반이나 남아있네요	이윤수	java006$	2023-10-25 15:48:05
7	그만하고싶다	그냥 넘어갈까....	        김호진	java006$	2023-10-25 15:48:08
8	어~ 배아파	    ㅋㅋㅋㅋㅋ	                노은하	java006$	2023-10-25 15:48:12
9	소근소근	    궁시렁궁시렁	            이윤수	java006$	2023-10-25 15:48:15
10	모자라요	    아직 잠이 모자라요	        김동민	java006$	2023-10-25 15:48:18
*/

--==>> 커밋
COMMIT;
--==>> 커밋 완료.


--○ 게시물 삭제
DELETE 
FROM TBL_BOARD
WHERE NO = 1;
--==>> 1 행 이(가) 삭제되었습니다.

DELETE  
FROM TBL_BOARD
WHERE NO = 6;
--==>> 1 행 이(가) 삭제되었습니다.

DELETE  
FROM TBL_BOARD
WHERE NO = 8;
--==>> 1 행 이(가) 삭제되었습니다.

DELETE  
FROM TBL_BOARD
WHERE NO = 10;
--==>> 1 행 이(가) 삭제되었습니다.

SELECT *
FROM TBL_BOARD;
--==>>
/*
2	아~ 졸리다	    10분만 자고 올께요	        정한울	java006$	2023-10-25 15:47:52
3	아~ 웃겨	    하루하루가 재미있어요	    노은하	java006$	2023-10-25 15:47:55
4	보고싶다	    범구가 너무너무 보고싶어요	김수환	java006$	2023-10-25 15:47:58
5	배고파요	    점심을 먹었는데 배고파요	김민지	java006$	2023-10-25 15:48:02
7	그만하고싶다	그냥 넘어갈까....	        김호진	java006$	2023-10-25 15:48:08
9	소근소근	    궁시렁궁시렁	            이윤수	java006$	2023-10-25 15:48:15
*/

--○ 게시물 작성
INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL,'집중합시다','저는 전혀 졸리지 않아요', '임하성', 'java006$', DEFAULT);
--==>>1 행 이(가) 삽입되었습니다.

--○ 게시물 삭제

DELETE
FROM TBL_BOARD
WHERE NO = 7;
--==>> 1 행 이(가) 삭제되었습니다.

--○ 확인
SELECT *
FROM TBL_BOARD;
/*
2	아~ 졸리다	10분만 자고 올께요	정한울	java006$	2023-10-25 15:47:52
3	아~ 웃겨	하루하루가 재미있어요	노은하	java006$	2023-10-25 15:47:55
4	보고싶다	범구가 너무너무 보고싶어요	김수환	java006$	2023-10-25 15:47:58
5	배고파요	점심을 먹었는데 배고파요	김민지	java006$	2023-10-25 15:48:02
9	소근소근	궁시렁궁시렁	이윤수	java006$	2023-10-25 15:48:15
11	집중합시다	저는 전혀 졸리지 않아요	임하성	java006$	2023-10-25 16:06:29
*/

--○ 커밋 
COMMIT;
--==>> 커밋 완료.

--○ 게시판의 게시물 리스트 조회


SELECT NO "글번호", TITLE "제목", NAME "작성자", CREATED "작성일"
FROM TBL_BOARD;
--==>>
/*
2	아~ 졸리다	정한울	2023-10-25 15:47:52
3	아~ 웃겨	노은하	2023-10-25 15:47:55
4	보고싶다	김수환	2023-10-25 15:47:58
5	배고파요	김민지	2023-10-25 15:48:02
9	소근소근	이윤수	2023-10-25 15:48:15
11	집중합시다	임하성	2023-10-25 16:06:29
*/

SELECT ROW_NUMBER() OVER(ORDER BY CREATED) "글번호"
      , TITLE "제목" , NAME "작성자" , CREATED "작성일"
FROM TBL_BOARD;
--==>>
/*
1	아~ 졸리다	정한울	2023-10-25 15:47:52
2	아~ 웃겨	노은하	2023-10-25 15:47:55
3	보고싶다	김수환	2023-10-25 15:47:58
4	배고파요	김민지	2023-10-25 15:48:02
5	소근소근	이윤수	2023-10-25 15:48:15
6	집중합시다	임하성	2023-10-25 16:06:29
*/


SELECT ROW_NUMBER() OVER(ORDER BY CREATED) "글번호"
      , TITLE "제목" , NAME "작성자" , CREATED "작성일"
FROM TBL_BOARD
ORDER BY 4 DESC;
--==>>
/*
6	집중합시다	임하성	2023-10-25 16:06:29
5	소근소근	이윤수	2023-10-25 15:48:15
4	배고파요	김민지	2023-10-25 15:48:02
3	보고싶다	김수환	2023-10-25 15:47:58
2	아~ 웃겨	노은하	2023-10-25 15:47:55
1	아~ 졸리다	정한울	2023-10-25 15:47:52
*/
--------------------------------------------------------------------------------

-- ■■■ JOIN(조인) ■■■ --

-- 1. SQL 1992 CODE 

-- CROSS JOIN 

SELECT *
FROM EMP , DEPT;
--> 수학에서 말하는 데카르트 곱(CATERSIAN PRODUCT)
--  두 테이블을 결합한 모든 경우의 수

-- EQUI JOIN : 서로 정확히 일치하는 데이터들끼리 연결하여 결합시키는 결합 방법

SELECT *
FROM EMP,DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;
--==>>
/*
7782	CLARK	MANAGER	    7839	1981-06-09 00:00:00	2450		10	10	ACCOUNTING	NEW YORK
7839	KING	PRESIDENT		    1981-11-17 00:00:00	5000		10	10	ACCOUNTING	NEW YORK
7934	MILLER	CLERK	    7782	1982-01-23 00:00:00	1300		10	10	ACCOUNTING	NEW YORK
7566	JONES	MANAGER	    7839	1981-04-02 00:00:00	2975		20	20	RESEARCH	DALLAS
7902	FORD	ANALYST	    7566	1981-12-03 00:00:00	3000		20	20	RESEARCH	DALLAS
7876	ADAMS	CLERK	    7788	1987-07-13 00:00:00	1100		20	20	RESEARCH	DALLAS
7369	SMITH	CLERK	    7902	1980-12-17 00:00:00	800		    20	20	RESEARCH	DALLAS
7788	SCOTT	ANALYST	    7566	1987-07-13 00:00:00	3000		20	20	RESEARCH	DALLAS
7521	WARD	SALESMAN	7698	1981-02-22 00:00:00	1250	500	30	30	SALES	CHICAGO
7844	TURNER	SALESMAN	7698	1981-09-08 00:00:00	1500	0	30	30	SALES	CHICAGO
7499	ALLEN	SALESMAN	7698	1981-02-20 00:00:00	1600	300	30	30	SALES	CHICAGO
7900	JAMES	CLERK	    7698	1981-12-03 00:00:00	950		    30  30	SALES	CHICAGO
7698	BLAKE	MANAGER	    7839	1981-05-01 00:00:00	2850		 30	30	SALES	CHICAGO
7654	MARTIN	SALESMAN	7698	1981-09-28 00:00:00	1250	1400 30	30	SALES	CHICAGO
*/

SELECT *
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;
--==>>
/*
7782	CLARK	MANAGER	    7839	1981-06-09 00:00:00	2450		10	10	ACCOUNTING	NEW YORK
7839	KING	PRESIDENT		    1981-11-17 00:00:00	5000		10	10	ACCOUNTING	NEW YORK
7934	MILLER	CLERK	    7782	1982-01-23 00:00:00	1300		10	10	ACCOUNTING	NEW YORK
7566	JONES	MANAGER	    7839	1981-04-02 00:00:00	2975		20	20	RESEARCH	DALLAS
7902	FORD	ANALYST	    7566	1981-12-03 00:00:00	3000		20	20	RESEARCH	DALLAS
7876	ADAMS	CLERK	    7788	1987-07-13 00:00:00	1100		20	20	RESEARCH	DALLAS
7369	SMITH	CLERK	    7902	1980-12-17 00:00:00	800		    20	20	RESEARCH	DALLAS
7788	SCOTT	ANALYST	    7566	1987-07-13 00:00:00	3000		20	20	RESEARCH	DALLAS
7521	WARD	SALESMAN	7698	1981-02-22 00:00:00	1250	500	30	30	SALES	CHICAGO
7844	TURNER	SALESMAN	7698	1981-09-08 00:00:00	1500	0	30	30	SALES	CHICAGO
7499	ALLEN	SALESMAN	7698	1981-02-20 00:00:00	1600	300	30	30	SALES	CHICAGO
7900	JAMES	CLERK	    7698	1981-12-03 00:00:00	950		    30	30	SALES	CHICAGO
7698	BLAKE	MANAGER	    7839	1981-05-01 00:00:00	2850		 30	30	SALES	CHICAGO
7654	MARTIN	SALESMAN	7698	1981-09-28 00:00:00	1250	1400 30	30	SALES	CHICAGO
*/




-- NON EQUI JOIN : 범위 안에 적합한 데이터들끼리 연결시키는 결합 방법

SELECT *
FROM EMP, SALGRADE
WHERE EMP.SAL BETWEEN SALGRADE.LOSAL AND SALGRADE.HISAL;

SELECT *
FROM EMP E , SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;
--==>>
/*
7369	SMITH	CLERK	7902	1980-12-17 00:00:00	800		20	1	700	1200
7900	JAMES	CLERK	7698	1981-12-03 00:00:00	950		30	1	700	1200
7876	ADAMS	CLERK	7788	1987-07-13 00:00:00	1100		20	1	700	1200
7521	WARD	SALESMAN	7698	1981-02-22 00:00:00	1250	500	30	2	1201	1400
7654	MARTIN	SALESMAN	7698	1981-09-28 00:00:00	1250	1400	30	2	1201	1400
7934	MILLER	CLERK	7782	1982-01-23 00:00:00	1300		10	2	1201	1400
7844	TURNER	SALESMAN	7698	1981-09-08 00:00:00	1500	0	30	3	1401	2000
7499	ALLEN	SALESMAN	7698	1981-02-20 00:00:00	1600	300	30	3	1401	2000
7782	CLARK	MANAGER	7839	1981-06-09 00:00:00	2450		10	4	2001	3000
7698	BLAKE	MANAGER	7839	1981-05-01 00:00:00	2850		30	4	2001	3000
7566	JONES	MANAGER	7839	1981-04-02 00:00:00	2975		20	4	2001	3000
7788	SCOTT	ANALYST	7566	1987-07-13 00:00:00	3000		20	4	2001	3000
7902	FORD	ANALYST	7566	1981-12-03 00:00:00	3000		20	4	2001	3000
7839	KING	PRESIDENT		1981-11-17 00:00:00	5000		10	5	3001	9999
*/

-- EQUI(이퀴) JOIN 시 (+)를 활용한 결합 방법

SELECT *
FROM TBL_EMP;

SELECT *
FROM TBL_DEPT;

INSERT INTO TBL_DEPT VALUES (50 ,'개발부','서울');
--==>> 1 행 이(가) 삽입되었습니다.

--○ 커밋
COMMIT;
--==>> 커밋 완료.

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO = D.DEPTNO;
--> 총 14건의 데이터가 결합되어 조회된 상황
--  즉, 부서번호를 갖지 못한 사원들(5) 모두 누락
--  또한, 소속사원을 갖지못한 부서(2) 모두 누락



SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO = D.DEPTNO(+);
--> 총 19건의 데이터가 결합되어 조회된 상황
--  소속 사원을 갖지 못한 부서(2) 누락 ---------------------------(+)
--  부서번호를 갖지 못한 사원들(5) 모두 조회 

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO;
--> 총 16건의 데이터가 결합되어 조회된 상황
-- 부서번호를 갖지 못한 사원들(5) 누락 ----------------------------(+)
-- 소속 사원을 갖지 못한 부서(2) 모두 조회

--※ 『(+)』가 없는 쪽 테이블의 데이터를 모두 메모리에 적재한 후             -- 기준
--   『(+)』가 있는 쪽 테이블의 데이터를 하나하나 확인하여 결합시키는 형태로 -- 추가(첨가)
--    JOIN이 이루어진다.

-- 이와 같은 이유로...
SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO(+);
-- 이런 형식의 JOIN은 존재하지 않는다.
-- 기준 없이 추가만 할려고 하니까!

-- 2. SQL 1999 CODE          → 『JOIN』 키워드 등장 → JOIN(결합)의 유형 명시
--                           → 『ON』 키워드 등장   → 결합 조건은 WHERE 대신 ON


-- CROSS JOIN
SELECT *
FROM EMP CROSS JOIN DEPT;

-- INNER JOIN 
SELECT *
FROM EMP INNER JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO;

SELECT *
FROM EMP E INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;

SELECT *
FROM EMP E JOIN DEPT D         
ON E.DEPTNO = D.DEPTNO;
-- INNER JOIN 에서 INNER 는 생략 가능 

-- OUTER JOIN
SELECT *
FROM TBL_EMP E LEFT OUTER JOIN TBL_DEPT D       -- 왼쪽이 기준
ON E.DEPTNO = D.DEPTNO;

SELECT *
FROM TBL_EMP E RIGHT OUTER JOIN TBL_DEPT D      -- 오른쪽이 기준
ON E.DEPTNO = D.DEPTNO;

SELECT *
FROM TBL_EMP E FULL OUTER JOIN TBL_DEPT D       -- 양쪽 모두 기준
ON E.DEPTNO = D.DEPTNO;
-- 양쪽 다 누락되지 않고 모두 조회

-- OUTER JOIN 에서 OUTER 생략 가능
SELECT *
FROM TBL_EMP E LEFT JOIN TBL_DEPT D       -- 왼쪽이 기준
ON E.DEPTNO = D.DEPTNO;

SELECT *
FROM TBL_EMP E RIGHT JOIN TBL_DEPT D      -- 오른쪽이 기준
ON E.DEPTNO = D.DEPTNO;

SELECT *
FROM TBL_EMP E FULL JOIN TBL_DEPT D       -- 양쪽 모두 기준
ON E.DEPTNO = D.DEPTNO;
-- 양쪽 다 누락되지 않고 모두 조회

--※ 참고
SELECT *
FROM TBL_EMP E JOIN TBL_DEPT D
ON   E.DEPTNO = D.DEPTNO
AND  E.JOB = 'CLERK';
--> 이와 같은 방법으로 쿼리문을 구성해도
--  조회 결과를 얻는 과정에는 문제가 없다.
--==>> 
/*
7369	SMITH	CLERK	7902	1980-12-17 00:00:00	800		20	20	RESEARCH	DALLAS
7876	ADAMS	CLERK	7788	1987-07-13 00:00:00	1100	20	20	RESEARCH	DALLAS
7900	JAMES	CLERK	7698	1981-12-03 00:00:00	950		30	30	SALES	    CHICAGO
7934	MILLER	CLERK	7782	1982-01-23 00:00:00	1300	10	10	ACCOUNTING	NEW YORK
*/
--『
SELECT *
FROM TBL_EMP E JOIN TBL_DEPT D
ON   E.DEPTNO = D.DEPTNO
WHERE E.JOB = 'CLERK';
                            --』
--> 하지만, 이와 같이 구성하여
--  조회 하는 것을 권장한다. 
--==>> 
/*
7369	SMITH	CLERK	7902	1980-12-17 00:00:00	800		20	20	RESEARCH	DALLAS
7876	ADAMS	CLERK	7788	1987-07-13 00:00:00	1100	20	20	RESEARCH	DALLAS
7900	JAMES	CLERK	7698	1981-12-03 00:00:00	950		30	30	SALES	    CHICAGO
7934	MILLER	CLERK	7782	1982-01-23 00:00:00	1300	10	10	ACCOUNTING	NEW YORK
*/

--○ EMP 테이블과 DEPT 테이블을 대상으로 
--   직종이 MANAGER 와 CLERK 인 사원들만 
--   부서번호, 부서명, 사원명, 직종명, 급여 항목을 조회한다.

--99 버전
SELECT E.DEPTNO "부서번호" , DNAME "부서명" , ENAME "사원명" , JOB "직종명" , SAL "급여"
FROM EMP E JOIN DEPT D
ON   E.DEPTNO = D.DEPTNO
WHERE JOB IN ('MANAGER', 'CLERK');
--==>> 
/*
10	ACCOUNTING	CLARK	MANAGER	2450
10	ACCOUNTING	MILLER	CLERK	1300
20	RESEARCH	ADAMS	CLERK	1100
20	RESEARCH	JONES	MANAGER	2975
20	RESEARCH	SMITH	CLERK	 800
30	SALES	    BLAKE	MANAGER	2850
30	SALES	    JAMES	CLERK	 950
*/

--92 버전
SELECT D.DEPTNO "부서번호" , DNAME "부서명" , ENAME "사원명" , JOB "직종명" , SAL "급여"
FROM EMP E , DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND JOB IN ('MANAGER', 'CLERK'); 


SELECT DEPTNO "부서번호" , DNAME "부서명" , ENAME "사원명" , JOB "직종명" , SAL "급여"
FROM EMP E , DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND JOB IN ('MANAGER', 'CLERK'); 
--==>> 에러 발생 
--     ORA-00918: column ambiguously defined
-->    두 테이블 간 중복되는 컬럼에 대한 
--     소속 테이블을 정해줘야(명시해줘야) 한다.








