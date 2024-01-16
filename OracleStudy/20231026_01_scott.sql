SELECT USER
FROM DUAL;


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


--※ 두 테이블 간 중복되는 칼럼에 대해 소속 테이블을 명시하는 경우 
--   부모 테이블의 컬럼을 참조할 수 있도록 처리해야 한다.

SELECT *
FROM EMP;       -- 자식 테이블

SELECT *
FROM DEPT;      -- 부모 테이블


SELECT D.DEPTNO , DNAME, ENAME , JOB , SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO; 

-- 두 테이블에 모두 포함되어 있는 중복된 컬럼이 아니더라도
-- 컬럼의 소속 테이블을 명시해 줄 수 있기를 권장한다.

SELECT E.DEPTNO , D.DNAME, E.ENAME , E.JOB , E.SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO; 
--==>>
/*
10	    ACCOUNTING	CLARK	MANAGER	    2450
10	    ACCOUNTING	KING	PRESIDENT	5000
10	    ACCOUNTING	MILLER	CLERK	    1300
20	    RESEARCH	JONES	MANAGER	    2975
20	    RESEARCH	FORD	ANALYST	    3000
20	    RESEARCH	ADAMS	CLERK	    1100
20	    RESEARCH	SMITH	CLERK	    800
20	    RESEARCH	SCOTT	ANALYST	    3000
30	    SALES	    WARD	SALESMAN	1250
30	    SALES	    TURNER	SALESMAN	1500
30	    SALES	    ALLEN	SALESMAN	1600
30	    SALES	    JAMES	CLERK	    950
30	    SALES	    BLAKE	MANAGER	    2850
30	    SALES	    MARTIN	SALESMAN	1250
(NULL)	OPERATIONS			                    ← check~~!!! (E.DEPTNO)
*/

SELECT D.DEPTNO , D.DNAME, E.ENAME , E.JOB , E.SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO; 
--==>>
/*
10	ACCOUNTING	CLARK	MANAGER	    2450
10	ACCOUNTING	KING	PRESIDENT	5000
10	ACCOUNTING	MILLER	CLERK	    1300
20	RESEARCH	JONES	MANAGER	    2975
20	RESEARCH	FORD	ANALYST	    3000
20	RESEARCH	ADAMS	CLERK	    1100
20	RESEARCH	SMITH	CLERK	    800
20	RESEARCH	SCOTT	ANALYST	    3000
30	SALES	    WARD	SALESMAN	1250
30	SALES	    TURNER	SALESMAN	1500
30	SALES	    ALLEN	SALESMAN	1600
30	SALES	    JAMES	CLERK	    950
30	SALES	    BLAKE	MANAGER	    2850
30	SALES	    MARTIN	SALESMAN	1250
40	OPERATIONS			                  ← check~~!!! (D.DEPTNO)
*/

--> 자식테이블은 본인이 가지고 있지 않은 값을 부모테이블에서 가져올 수 없다.
--  따라서 40번 부서가 없는 EMP 테이블은 40번 부서 번호를 NULL로 표시 
--  부모테이블은 당연히 본인이 갖구 있는 거니까 표시~~!! 
--  그러면 부모테이블로 하는 것이 맞겠죠?^^*


--○ SELF JOIN (자기 조인)

-- EMP 테이블의 데이터를 다음과 같이 조회 할 수 있도록 쿼리문을 구성한다.
/*
--------------------------------------------------------------------------------
사원번호    사원명    직종명    관리자번호   관리자명   관리자 직종명 
--------------------------------------------------------------------------------
  EMPNO     ENAME      JOB         MGR             
  ------------------------------------------- E1
                                  EMPNO       ENAME       JOB
                                  ----------------------------------E2
  7369      SMITH     CLARK       7902        FORD        ANALYST
                            
--------------------------------------------------------------------------------
*/

SELECT E1.EMPNO "사원번호" , E1.ENAME "사원명" , E1.JOB "직종명" , E1.MGR "관리자번호"
     ,  CASE WHEN E1.MGR = E2.EMPNO THEN E2.ENAME 
        ELSE '관리자 없음'
        END "관리자명" -- E2.JOB "관리자 직종명"
FROM EMP E1 JOIN EMP E2
ON E1.MGR = E2.MGR; 

SELECT E1.EMPNO "사원번호" , E1.ENAME "사원명" , E1.JOB "직종명" , E1.MGR "관리자번호"
      , E2.ENAME , E2.JOB
FROM EMP E1 JOIN EMP E2
ON E1.ENAME = E2.ENAME
WHERE E1.MGR = E2.EMPNO;


-- 92 CODE
SELECT E.EMPNO "사원번호" , E.ENAME "사원명" , E.JOB "직종명" , E.MGR "관리자번호"
     , D.ENAME "관리자명", D.JOB "관리자 직종명"
FROM EMP E , EMP D
WHERE D.EMPNO(+) = E.MGR
ORDER BY 1;

-- 99 CODE
SELECT E.EMPNO "사원번호" , E.ENAME "사원명" , E.JOB "직종명" , E.MGR "관리자번호", D.ENAME "관리자명", D.JOB "관리자 직종명"
FROM EMP E LEFT JOIN EMP D
ON D.EMPNO = E.MGR
ORDER BY 1;
--==>>
/*
7369	SMITH	CLERK	    7902	FORD	ANALYST
7499	ALLEN	SALESMAN	7698	BLAKE	MANAGER
7521	WARD	SALESMAN	7698	BLAKE	MANAGER
7566	JONES	MANAGER	    7839	KING	PRESIDENT
7654	MARTIN	SALESMAN	7698	BLAKE	MANAGER
7698	BLAKE	MANAGER	    7839	KING	PRESIDENT
7782	CLARK	MANAGER	    7839	KING	PRESIDENT
7788	SCOTT	ANALYST	    7566	JONES	MANAGER
7839	KING	PRESIDENT			
7844	TURNER	SALESMAN	7698	BLAKE	MANAGER
7876	ADAMS	CLERK	    7788	SCOTT	ANALYST
7900	JAMES	CLERK	    7698	BLAKE	MANAGER
7902	FORD	ANALYST 	7566	JONES	MANAGER
7934	MILLER	CLERK	    7782	CLARK	MANAGER
*/

-- 수업 풀이------------------------------------------------------

SELECT 사원번호    사원명    직종명    관리자번호   관리자명   관리자 직종명 
FROM EMP;

SELECT EMPNO 사원번호 ENAME 사원명  JOB 직종명 EMPNO 관리자번 ENAME 관리자명 JOB 관리자 직종명 
FROM EMP;

SELECT E1.EMPNO 사원번호 , E1.ENAME 사원명 , E1.JOB 직종명 , E2.EMPNO 관리자번호 , E2.ENAME 관리자명, E2.JOB 관리자직종명 
FROM EMP E1 LEFT JOIN EMP E2
ON E1.MGR = E2.EMPNO;


















