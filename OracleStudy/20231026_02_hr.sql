
SELECT USER
FROM DUAL;
--==>> HR


--○ 세 개 이상의 테이블 조인(JOIN, 결합)

-- 형식 1. (SQL 1992 CODE)

SELECT 테이블명1.컬럼명 , 테이블명2.컬럼명, 테이블명3.컬럼명
FROM  테이블명1, 테이블명2, 테이블명3
WHERE 테이블명1.컬럼명1 = 테이블명2.컬럼명1 
  AND 테이블명2.컬럼명2 = 테이블명3.컬럼명2;


-- 형식 2. (SQL 1999 CODE)

SELECT 테이블명1.컬럼명 , 테이블명2.컬럼명, 테이블명3.컬럼명
FROM 테이블명1 JOIN 테이블명2 
ON 테이블명1.컬럼명1 = 테이블명2.컬럼명1
   JOIN 테이블명 3
   ON 테이블명2.컬럼명2 = 테이블명3.컬럼명2;


--○ HR 계정 소유의 테이블 또는 뷰 목록 조회
SELECT *
FROM TAB;
--==>>
/*
COUNTRIES	        TABLE	
DEPARTMENTS	        TABLE	
EMPLOYEES	        TABLE	
EMP_DETAILS_VIEW	VIEW	
JOBS	            TABLE	
JOB_HISTORY	        TABLE	
LOCATIONS	        TABLE	
REGIONS	            TABLE	
*/


--○ HR.JOBS, HR.EMPLOYEES, HR.DEPARTMENTS 테이블을 대상으로 
--   직원들의 데이터를 
--   FIRST_NAME , LAST_NAME, JOB_TITLE , DEPARTMENT_NAME
--      E           E           J               D

SELECT *
FROM JOBS; 
-- JOB_ID               -- 관계 컬럼
SELECT *
FROM EMPLOYEES; 
-- DEPTARTMENT_ID       --- 관계 컬럼
SELECT *
FROM DEPARTMENTS; 


-- 1992 버전 
SELECT E.FIRST_NAME "이름", E.LAST_NAME "성", J.JOB_TITLE "직업", D.DEPARTMENT_NAME "부서명"
FROM   JOBS J , EMPLOYEES E, DEPARTMENTS D
WHERE  J.JOB_ID = E.JOB_ID 
  AND  E.DEPARTMENT_ID = D.DEPARTMENT_ID(+);

-- 1999 버전
SELECT E.FIRST_NAME "이름", E.LAST_NAME "성", J.JOB_TITLE "직업", D.DEPARTMENT_NAME "부서명"
FROM JOBS J JOIN EMPLOYEES E 
ON J.JOB_ID = E.JOB_ID
   LEFT JOIN DEPARTMENTS D
   ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
   
SELECT E.FIRST_NAME "이름", E.LAST_NAME "성", J.JOB_TITLE "직업", D.DEPARTMENT_NAME "부서명"
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D 
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
   JOIN JOBS J
   ON E.JOB_ID = J.JOB_ID;
   
--> 주인공은 EMPLOYEES 모두 주목!!
   
--==>>
/*

이름                   성                         직업                                  부서명                           
-------------------- ------------------------- ----------------------------------- ------------------------------
Jennifer             Whalen                    Administration Assistant            Administration                
Pat                  Fay                       Marketing Representative            Marketing                     
Michael              Hartstein                 Marketing Manager                   Marketing                     
Den                  Raphaely                  Purchasing Manager                  Purchasing                    
Karen                Colmenares                Purchasing Clerk                    Purchasing    
                                        :
William              Gietz                     Public Accountant                   Accounting                                         
---------------------------------------------  ----------------------------------- ----------------------------------
*/

--○ EMPLOYEES , DEPARTMENTS, JOBS, LOCATIONS, COUNTRIES, REGIONS	테이블을 대상으로 
--   직원들의 데이터를 다음과 같이 조회한다.
--   FIRST_NAME , LAST_NAME , JOB_TITLE, DEPARTMENT_NAME , CITY , COUNTRY_NAME , REGION_NAME
--      E           E              J            D            L          C               R

SELECT *
FROM JOBS;
--JOB_ID
SELECT *
FROM EMPLOYEES;
-- DEPARTMENT_ID
SELECT *
FROM DEPARTMENTS;
--LOCATION_ID
SELECT *
FROM LOCATIONS;
-- COOUNTRY_ID
SELECT *
FROM COUNTRIES;
-- REGION_ID 
SELECT *
FROM REGIONS;



-- 1999 CODE 
SELECT FIRST_NAME "이름" , LAST_NAME "성" , JOB_TITLE "직종명" , DEPARTMENT_NAME "부서명" , CITY "도시" , COUNTRY_NAME "나라" , REGION_NAME "대륙"
FROM JOBS J JOIN EMPLOYEES E
ON   J.JOB_ID = E.JOB_ID
     LEFT JOIN DEPARTMENTS D
     ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
         LEFT JOIN LOCATIONS L 
         ON D.LOCATION_ID = L.LOCATION_ID
             LEFT JOIN COUNTRIES C 
             ON L.COUNTRY_ID = C.COUNTRY_ID
                 LEFT JOIN REGIONS R
                 ON C.REGION_ID = R.REGION_ID;

-- 버전 ②
SELECT FIRST_NAME "이름" , LAST_NAME "성" , JOB_TITLE "직종명" , DEPARTMENT_NAME "부서명" , CITY "도시" , COUNTRY_NAME "나라" , REGION_NAME "대륙"
FROM REGIONS R JOIN COUNTRIES C 
ON   R.REGION_ID = C.REGION_ID
     JOIN LOCATIONS L 
     ON C.COUNTRY_ID = L.COUNTRY_ID
         JOIN DEPARTMENTS D
         ON L.LOCATION_ID = D.LOCATION_ID
             RIGHT JOIN EMPLOYEES E
             ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
                 JOIN JOBS J
                 ON E.JOB_ID = J.JOB_ID;

-- 1992 .....  도...전..........

SELECT FIRST_NAME "이름" , LAST_NAME "성" , JOB_TITLE "직종명" , DEPARTMENT_NAME "부서명" , CITY "도시" , COUNTRY_NAME "나라" , REGION_NAME "대륙"
FROM EMPLOYEES E , JOBS J, DEPARTMENTS D, LOCATIONS L, COUNTRIES C, REGIONS R
WHERE R.REGION_ID(+) = C.REGION_ID 
  AND C.COUNTRY_ID(+) = L.COUNTRY_ID 
  AND L.LOCATION_ID = D.LOCATION_ID
  AND D.DEPARTMENT_ID(+) = E.DEPARTMENT_ID 
  AND E.JOB_ID = J.JOB_ID(+);

























