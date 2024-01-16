SELECT USER
FROM DUAL;
--==>> HR

--■■■ 뷰(VIEW) ■■■-- 

--1. 뷰(VIEW)란 이미 특정한 데이터베이스 내에 존재하는 
--   하나 이상의 테이블에서 사용자가 얻기 원하는 데이터들만을
--   정확하고 편하게 가져오기 위해서 사전에 원하는 컬럼들만을 모아서 
--   만들어놓은 가상의 테이블로 편의성 및 보안에 목적이 있다.
    
--   가상의 테이블이란... 뷰가 실제로 존재하는 테이블(객체)가 아니라
--   하나 이상의 테이블에서 파생된 또 다른 정보를 볼 수 있는 방법이라는 의미이며,
--   그 정보를 추출해내는 SQL 문장이라고 볼 수 있다.

--   사용자가 뷰를 만들때 사용했던 『쿼리문』을 다시 불러 온다고 생각하면 된다! 
--   따라서 데이터가 추가 되거나 삭제 되는 등 데이터가 변해도 변한 데이터 값으로 나온다.
--   뷰를 생성하는 권환도 따로 있음~ 권환이 없으면 설정해줘야함

--2. 형식 및 구조
--   CREATE[OR REPLACE] VIEW 뷰 이름
--   [(ALIAS[,ALIAS..])]
--   AS 
--   서브쿼리(SUBQUERY)
--   [WITH CHECK OPTION]
--   [WITH READ ONLY]

--○ 뷰(VIEW) 생성
SELECT E.FIRST_NAME, E.LAST_NAME, D.DEPARTMENT_NAME, L.CITY
      ,C.COUNTRY_NAME , R.REGION_NAME
FROM EMPLOYEES E, DEPARTMENTS D , LOCATIONS L, COUNTRIES C, REGIONS R
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
  AND D.LOCATION_ID = L.LOCATION_ID
  AND L.COUNTRY_ID = C.COUNTRY_ID
  AND C.REGION_ID = R.REGION_ID;

CREATE OR REPLACE VIEW VIEW_EMPLOYEES
AS
SELECT E.FIRST_NAME, E.LAST_NAME, D.DEPARTMENT_NAME, L.CITY
      ,C.COUNTRY_NAME , R.REGION_NAME
FROM EMPLOYEES E, DEPARTMENTS D , LOCATIONS L, COUNTRIES C, REGIONS R
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
  AND D.LOCATION_ID = L.LOCATION_ID
  AND L.COUNTRY_ID = C.COUNTRY_ID
  AND C.REGION_ID = R.REGION_ID;
--==>> View VIEW_EMPLOYEES이(가) 생성되었습니다

--○ 뷰(VIEW) 조회
SELECT *
FROM VIEW_EMPLOYEES;

--○ 뷰(VIEW)의 구조 조회
DESC VIEW_EMPLOYEES;
--==>>
/*
이름              널?       유형           
--------------- -------- ------------ 
FIRST_NAME               VARCHAR2(20) 
LAST_NAME       NOT NULL VARCHAR2(25) 
DEPARTMENT_NAME          VARCHAR2(30) 
CITY            NOT NULL VARCHAR2(30) 
COUNTRY_NAME             VARCHAR2(40) 
REGION_NAME              VARCHAR2(25) 
*/

--○ 뷰(VIEW) 소스 확인           CHECK~~ 당분간은 잘 기억하고 있자!
SELECT VIEW_NAME , TEXT
FROM USER_VIEWS
WHERE VIEW_NAME =  'VIEW_EMPLOYEES';
--==>>
/*
"SELECT E.FIRST_NAME, E.LAST_NAME, D.DEPARTMENT_NAME, L.CITY
      ,C.COUNTRY_NAME , R.REGION_NAME
FROM EMPLOYEES E, DEPARTMENTS D , LOCATIONS L, COUNTRIES C, REGIONS R
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
  AND D.LOCATION_ID = L.LOCATION_ID
  AND L.COUNTRY_ID = C.COUNTRY_ID
  AND C.REGION_ID = R.REGION_ID"

TEXT - 우리가 뷰를 생성할때 작성한 쿼리문이 보여진다!
*/








