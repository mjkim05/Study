SELECT USER
FROM DUAL;
--==>> SCOTT

SELECT NAME
FROM EMPLOYEE WHERE EMPLOYEEID=3
AND SSN2 = CRYPTPACK.ENCRYPT('1234555','1234555');

commit;                
                
--○ 실습 테이블 생성(지역: REGION)
CREATE TABLE REGION
( REGIONID   NUMBER         -- 지역 아이디   -- PK
, REGIONNAME VARCHAR2(30)   -- 지역
, CONSTRAINT REGION_ID_PK PRIMARY KEY(REGIONID)
);
--==>> Table REGION이(가) 생성되었습니다.   

--○ 시퀀스 생성(지역:REGIONSEQ)
CREATE SEQUENCE REGIONSEQ
NOCACHE;
--==>> Sequence REGIONSEQ이(가) 생성되었습니다.

--○ 지역 데이터 입력
INSERT INTO REGION(REGIONID, REGIONNAME) VALUES(REGIONSEQ.NEXTVAL, '서울');
INSERT INTO REGION(REGIONID, REGIONNAME) VALUES(REGIONSEQ.NEXTVAL, '경기');
INSERT INTO REGION(REGIONID, REGIONNAME) VALUES(REGIONSEQ.NEXTVAL, '인천');
INSERT INTO REGION(REGIONID, REGIONNAME) VALUES(REGIONSEQ.NEXTVAL, '대전');
INSERT INTO REGION(REGIONID, REGIONNAME) VALUES(REGIONSEQ.NEXTVAL, '광주');
INSERT INTO REGION(REGIONID, REGIONNAME) VALUES(REGIONSEQ.NEXTVAL, '대구');

--○ 지역 리스트 확인 
SELECT REGIONID, REGIONNAME
FROM REGION;
--> 한줄 구성
SELECT REGIONID, REGIONNAME FROM REGION
;
--==>>
/*
1	서울
2	경기
3	인천
4	대전
5	광주
6	대구

*/

--○ 커밋 
COMMIT;
-- 완

--○ 실습 테이블 생성 (직위: POSITION)
CREATE TABLE POSITION
( POSITIONID   NUMBER           -- 직위 아이디   -- PK
, POSITIONNAME VARCHAR2(30)     -- 직위 명 
, MINBASICPAY  NUMBER           -- 최소 기본급
, CONSTRAINT POSITION_ID_PK PRIMARY KEY(POSITIONID)
);
--==>> Table POSITION이(가) 생성되었습니다.

--○ 시퀀스 생성 (직위: POSITION)
CREATE SEQUENCE POSITIONSEQ
NOCACHE;
--==>> Sequence POSITIONSEQ이(가) 생성되었습니다.

--○ 직위 데이터 입력
INSERT INTO POSITION(POSITIONID,POSITIONNAME, MINBASICPAY)
VALUES (POSITIONSEQ.NEXTVAL, '사원', 1000000);
--> 한줄구성
INSERT INTO POSITION(POSITIONID,POSITIONNAME, MINBASICPAY) VALUES (POSITIONSEQ.NEXTVAL, '사원', 1000000);
INSERT INTO POSITION(POSITIONID,POSITIONNAME, MINBASICPAY) VALUES (POSITIONSEQ.NEXTVAL, '대리', 2000000);
INSERT INTO POSITION(POSITIONID,POSITIONNAME, MINBASICPAY) VALUES (POSITIONSEQ.NEXTVAL, '과장', 3000000);
INSERT INTO POSITION(POSITIONID,POSITIONNAME, MINBASICPAY) VALUES (POSITIONSEQ.NEXTVAL, '부장', 4000000);
--==>> 1 행 이(가) 삽입되었습니다. * 4

--○ 직위 리스트 확인  
SELECT POSITIONID, POSITIONNAME, MINBASICPAY
FROM POSITION;
--> 한줄구성
SELECT POSITIONID, POSITIONNAME, MINBASICPAY FROM POSITION
;
--==>>
/*
1	사원	1000000
2	대리	2000000
3	과장	3000000
4	부장	4000000
*/

--○ 커밋
COMMIT;
--==> 커밋완료.

--○ 실습 테이블 생성(부서: DEPARTMENT)
CREATE TABLE DEPARTMENT 
(DEPARTMENTID   NUMBER             -- 부서 아이디
,DEPARTMENTNAME VARCHAR2(30)       -- 부서 명
,CONSTRAINT DEPARTMENT_ID_PK PRIMARY KEY(DEPARTMENTID)
);
--==>> Table DEPARTMENT이(가) 생성되었습니다.

--○ 시퀀스 생성(부서:DEPARTMENT)
CREATE SEQUENCE DEPARTMENTSEQ
NOCACHE;
--==>> Sequence DEPARTMENTSEQ이(가) 생성되었습니다.

--○부서 데이터 입력
INSERT INTO DEPARTMENT(DEPRATMENTID, DEPARTMENTNAME)
VALUES (DEPARTMENTSEQ.NEXTVAL, '개발부');
--> 한줄 구성
INSERT INTO DEPARTMENT(DEPARTMENTID, DEPARTMENTNAME) VALUES (DEPARTMENTSEQ.NEXTVAL, '개발부')
;
INSERT INTO DEPARTMENT(DEPARTMENTID, DEPARTMENTNAME) VALUES (DEPARTMENTSEQ.NEXTVAL, '기획부')
;
INSERT INTO DEPARTMENT(DEPARTMENTID, DEPARTMENTNAME) VALUES (DEPARTMENTSEQ.NEXTVAL, '영업부')
;
INSERT INTO DEPARTMENT(DEPARTMENTID, DEPARTMENTNAME) VALUES (DEPARTMENTSEQ.NEXTVAL, '자재부')
;

--○ 부서 리스트 확인 
SELECT DEPARTMENTID, DEPARTMENTNAME
FROM DEPARTMENT;
--> 한줄 구성
SELECT DEPARTMENTID, DEPARTMENTNAME FROM DEPARTMENT
;
--==>>
/*
1	개발부
2	기획부
3	영업부
4	자재부

*/

--○ 커밋 
COMMIT;
--==>> 완

--○ 실습 테이블 생성 (직원:EMPLOYEE)
--   사원번호, 사원명, 주민번호, 생년월일, 양음력, 전화번호, 부서, 직위, 지역, 기본급, 수당
CREATE TABLE EMPLOYEE
( EMPLOYEEID    NUMBER                  -- 사원 번호     -- PK
, NAME          VARCHAR2(30)            -- 사원 명
, SSN           VARCHAR2(20)            -- 주민번호      -- 암호화 기능 적용(TYPE CHECK~!!)
, BIRTHDAY      DATE                    -- 생년월일 
, LUNAR         NUMBER(1) DEFAULT 0     -- 양력 음력     -- CK(양력 0 음력 1)
, TELEPHONE     VARCHAR2(40)            -- 전화번호
, DEPARTMENTID  NUMBER                  -- 부서 아이디   -- FK
, POSITIONID    NUMBER                  -- 직위 아이디   -- FK
, REGIONID      NUMBER                  -- 지역 아이디   -- FK
, BASICPAY      NUMBER                  -- 기본급      
, EXTRAPAY      NUMBER                  -- 수당
, CONSTRAINT EMPLOYEE_ID_PK PRIMARY KEY(EMPLOYEEID)
, CONSTRAINT EMPLOYEE_DEPARTMENTID_FK FOREIGN KEY(DEPARTMENTID)
             REFERENCES DEPARTMENT(DEPARTMENTID)
, CONSTRAINT EMPLOYEE_POSITIONID_FK FOREIGN KEY(POSITIONID)
             REFERENCES POSITION(POSITIONID)
, CONSTRAINT EMPLOYEE_REGIONID_FK FOREIGN KEY(REGIONID)
             REFERENCES REGION(REGIONID)
, CONSTRAINT EMPLOYEE_LUNAR_CK CHECK (LUNAR=0 OR LUNAR=1)             
);
--==>>Table EMPLOYEE이(가) 생성되었습니다.

--○ 시퀀스 생성 (직원:EMPLOYEESEQ)
CREATE SEQUENCE EMPLOYEESEQ
NOCACHE;
--==>> Sequence EMPLOYEESEQ이(가) 생성되었습니다.

--○ 직원 데이터 입력 (쿼리문 폐기)
INSERT INTO EMPLOYEE(EMPLOYEEID, NAME, SSN, BIRTHDAY, LUNAR, TELEPHONE, DEPARTMENTID, POSITIONID, REGIONID, BASICPAY, EXTRAPAY)
VALUES (EMPLOYEESEQ.NEXTVAL, '강혜성', CRYPTPACK.ENCRYPT('9710171234567','9710171234567')
      ,TO_DATE('1997-10-17','YYYY-MM-DD'), 0, '010-6380-7047',1,2,1
      ,2500000,1500000);      
--==>>  1 행 이(가) 삽입되었습니다.  
      
--※ 세션 설정
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
--==>> Session이(가) 변경되었습니다.

--○ 확인 
SELECT *
FROM EMPLOYEE;
--==>> 1	강혜성	?o??^????	1997-10-17	0	010-6380-7047	1	2	1	2500000	1500000      

--○ 커밋
COMMIT;
--==>> 커밋 완료.

DESC EMPLOYEE;
--==>>
/*
커밋 완료.
이름           널?       유형           
------------ -------- ------------ 
EMPLOYEEID   NOT NULL NUMBER       
NAME                  VARCHAR2(30) 
SSN                   VARCHAR2(20) 
BIRTHDAY              DATE         
LUNAR                 NUMBER(1)    
TELEPHONE             VARCHAR2(40) 
DEPARTMENTID          NUMBER       
POSITIONID            NUMBER       
REGIONID              NUMBER       
BASICPAY              NUMBER       
EXTRAPAY              NUMBER   
*/

--○ 직원 데이터 조회 쿼리문 구성
SELECT E.EMPLOYEEID
     , E.NAME
     , E.SSN
     , TO_CHAR(E.BIRTHDAY, 'YYYY-MM-DD') AS BIRTHDAY
     , E.LUNAR
     , DECODE (E.LUNAR, 0, '양력', 1, '음력') AS LUNARANAME
     , E.TELEPHONE
     , E.DEPARTMENTID
     , (SELECT DEPARTMENTNAME
        FROM DEPARTMENT
        WHERE DEPARTMENTID = E.DEPARTMENTID) AS DEPARTMENTNAME
    , E.POSITIONID
    , ( SELECT POSITIONNAME
        FROM POSITION
        WHERE POSITIONID = E.POSITIONID) AS POSITIONNAME
    , E.REGIONID
    , ( SELECT REGIONNAME
        FROM REGION
        WHERE REGIONID = E.REGIONID) AS REGIONNAME
    , E.BASICPAY
    , E.EXTRAPAY
    , NVL(E.BASICPAY,0) + NVL(E.EXTRAPAY,0) AS PAY
FROM EMPLOYEE E;
--==>> 1	강혜성	?o??^????	1997-10-17	0	양력	1	개발부	2	대리	1	서울	2500000	1500000	4000000      


--○ 뷰 생성 (EMPLOYEEVIEW) 폐기
CREATE OR REPLACE VIEW EMPLOYEEVIEW
AS
SELECT E.EMPLOYEEID
     , E.NAME
     , E.SSN
     , TO_CHAR(E.BIRTHDAY, 'YYYY-MM-DD') AS BIRTHDAY
     , E.LUNAR
     , DECODE (E.LUNAR, 0, '양력', 1, '음력') AS LUNARANAME
     , E.TELEPHONE
     , E.DEPARTMENTID
     , (SELECT DEPARTMENTNAME
        FROM DEPARTMENT
        WHERE DEPARTMENTID = E.DEPARTMENTID) AS DEPARTMENTNAME
    , E.POSITIONID
    , ( SELECT POSITIONNAME
        FROM POSITION
        WHERE POSITIONID = E.POSITIONID) AS POSITIONNAME
    , E.REGIONID
    , ( SELECT REGIONNAME
        FROM REGION
        WHERE REGIONID = E.REGIONID) AS REGIONNAME
    , E.BASICPAY
    , E.EXTRAPAY
    , NVL(E.BASICPAY,0) + NVL(E.EXTRAPAY,0) AS PAY
FROM EMPLOYEE E;
--==>> View EMPLOYEEVIEW이(가) 생성되었습니다.

--○ 지역 데이터 조회 쿼리문 구성
--   단, 지역 데이터 삭제 가능 여부(DELCHECK) 확인 포함
SELECT R.REGIONID , R.REGIONNAME
     ,(SELECT COUNT(*)
       FROM EMPLOYEE
       WHERE REGIONID = R.REGIONID ) AS DELCHECK 
FROM REGION R;
--==>> 
/*
  REGIONID REGIONNAME                       DELCHECK
---------- ------------------------------ ----------
         1 서울                                    1  → 삭제 불가
         2 경기                                    0  → 삭제 가능
         3 인천                                    0  → 삭제 가능
         4 대전                                    0  → 삭제 가능
         5 광주                                    0  → 삭제 가능
         6 대구                                    0  → 삭제 가능
*/
--> 『서울』의 지역 데이터는 삭제가 불가능한 상황이며
--  『경기』『인천』『대전』『광주』『대구』 의 지역 데이터는
--  삭제가 가능한 상황임을 판별할 수 있는 쿼리문

--○ 뷰 생성 (REGIONVIEW)
CREATE OR REPLACE VIEW REGIONVIEW
AS
SELECT R.REGIONID , R.REGIONNAME
     ,(SELECT COUNT(*)
       FROM EMPLOYEE
       WHERE REGIONID = R.REGIONID ) AS DELCHECK 
FROM REGION R;
--==>> View REGIONVIEW이(가) 생성되었습니다.

--○ 직위 데이터 조회
-- 단, 지역 데이터 삭제 가능 여부(DELCHECK) 확인 포함
SELECT P.POSITIONID , P.POSITIONNAME, P.MINBASICPAY
, (SELECT COUNT(*)
   FROM EMPLOYEE
   WHERE POSITIONID = P.POSITIONID) AS DELCHECK
FROM POSITION P;
--==>> 
/*
POSITIONID POSITIONNAME                   MINBASICPAY   DELCHECK
---------- ------------------------------ ----------- ----------
         1 사원                               1000000          0   → 삭제 가능
         2 대리                               2000000          1   → 삭제 불가
         3 과장                               3000000          0   → 삭제 가능
         4 부장                               4000000          0   → 삭제 가능
*/

--○ 뷰 생성 (POSITIONVIEW)
CREATE OR REPLACE VIEW POSITIONVIEW
AS
SELECT P.POSITIONID , P.POSITIONNAME, P.MINBASICPAY
, (SELECT COUNT(*)
   FROM EMPLOYEE
   WHERE POSITIONID = P.POSITIONID) AS DELCHECK
FROM POSITION P;
--==>> View POSITIONVIEW이(가) 생성되었습니다.


--○ 부서 데이터 조회
-- 단, 부서 데이터 삭제 가능 여부(DELCHECK) 확인 포함 

SELECT D.DEPARTMENTID, D.DEPARTMENTNAME
     , (SELECT COUNT(*)
        FROM EMPLOYEE 
        WHERE DEPARTMENTID = D.DEPARTMENTID) AS DELCHECK
FROM DEPARTMENT D;
--==>> 
/*
DEPARTMENTID DEPARTMENTNAME                   DELCHECK
------------ ------------------------------ ----------
           1 개발부                                  1
           2 기획부                                  0
           3 영업부                                  0
           4 자재부                                  0
*/

--○ 뷰 생성 (DEPARTMENTVIEW)
CREATE OR REPLACE VIEW DEPARTMENTVIEW
AS
SELECT D.DEPARTMENTID, D.DEPARTMENTNAME
     , (SELECT COUNT(*)
        FROM EMPLOYEE 
        WHERE DEPARTMENTID = D.DEPARTMENTID) AS DELCHECK
FROM DEPARTMENT D;
--==>> View DEPARTMENTVIEW이(가) 생성되었습니다.

--○ 직위별 최소 기본급 조회 쿼리문 구성
SELECT MINBASICPAY
FROM POSITION 
WHERE POSITIONID = 1;   -- 사원
--> 한줄 구성
SELECT MINBASICPAY FROM POSITION WHERE POSITIONID = 1
;   -- 사원
--==>> 1000000

--------------------------------------------------------------------------------

--○ 로그인, 로그아웃 과정 추가
-- ID와 PW 칼럼 데이터를 담고 있는 테이블이 별도로 존재하지 않는 상황이다.
-- 이와 관련하여 EMPLOYEEID(사원 아이디와) SSN(주민번호) 뒤 7자리 숫자를
-- 각각 아이디, 패스워드로 이용할 수 있도록 구성한다.

--※ 기존 테이블 구조 변경
--①
-- EMPLOYEE(직원 데이터) 테이블의 SSN(주민번호) 컬럼을 분리한다.
-- SSN --------------------> SSN1, SSN2 
-- SSN1 → 주민번호 앞 6자리
-- SSN2 → 주민번호 뒷 7자리 → 암호화 적용 → PW 활용

--②
-- EMPLOYEE(직원 데이터) 테이블의 GRADE(등급) 컬럼을 추가한다.
-- GRADE → 0:관리자 , 1:일반사원

--○ 컬럼 분할 SSN → SSN1, SSN2

-- 컬럼 추가
ALTER TABLE EMPLOYEE
ADD (SSN1 CHAR(6), SSN2 VARCHAR2(50));
--==>> Table EMPLOYEE이(가) 변경되었습니다.

SELECT *
FROM EMPLOYEE;

-- SSN  → 암호화('9710171234567','9710171234567')

-- SSN1 → SUBSTR(복호화(대상 데이터,'9710171234567'),1,6) → '971017'
-- SSN2 → 암호화(SUBSTR(복호화(대상 데이터,'9710171234567'),7,7)
--               ,SUBSTR(복호화(대상 데이터,'9710171234567'),7,7)) → 암호화된 '1234567'

UPDATE EMPLOYEE
SET SSN1 = SUBSTR(CRYPTPACK.DECRYPT(SSN,'9710171234567'),1,6)
  , SSN2 = CRYPTPACK.ENCRYPT(SUBSTR(CRYPTPACK.DECRYPT(SSN,'9710171234567'),7,7)
                            ,SUBSTR(CRYPTPACK.DECRYPT(SSN,'9710171234567'),7,7));

---==>> 1 행 이(가) 업데이트되었습니다.

--○ 확인 
SELECT *
FROM EMPLOYEE;
--==> 1	강혜성	?o??^????	1997/10/17	0	010-6380-7047	1	2	1	2500000	1500000	971017	=o???

--○ 커밋
COMMIT;
--==>> 커밋 완료.

-- 기존 주민번호(SSN) 컬럼 제거
ALTER TABLE EMPLOYEE
DROP COLUMN SSN;
--==>> Table EMPLOYEE이(가) 변경되었습니다.

DESC EMPLOYEE;
--==>>
/*
이름           널?       유형           
------------ -------- ------------ 
EMPLOYEEID   NOT NULL NUMBER       
NAME                  VARCHAR2(30) 
BIRTHDAY              DATE         
LUNAR                 NUMBER(1)    
TELEPHONE             VARCHAR2(40) 
DEPARTMENTID          NUMBER       
POSITIONID            NUMBER       
REGIONID              NUMBER       
BASICPAY              NUMBER       
EXTRAPAY              NUMBER       
SSN1                  CHAR(6)      
SSN2                  VARCHAR2(50)
*/


-- 컬럼 추가 → GRADE → 기본 값 1을 일반사원으로 구성
--                               0을 관리자로 구성                        
ALTER TABLE EMPLOYEE
ADD GRADE NUMBER(1) DEFAULT 1;
--==>> Table EMPLOYEE이(가) 변경되었습니다.

SELECT *
FROM EMPLOYEE;
--==>> 1	강혜성	1997/10/17	0	010-6380-7047	1	2	1	2500000	1500000	971017	=o???	1


--○ 직원 데이터 입력 
INSERT INTO EMPLOYEE(EMPLOYEEID, NAME, BIRTHDAY, LUNAR
                   , TELEPHONE, DEPARTMENTID, POSITIONID, REGIONID, BASICPAY, EXTRAPAY
                   , SSN1, SSN2)
VALUES (EMPLOYEESEQ.NEXTVAL, '길현욱',TO_DATE('1999-02-11','YYYY-MM-DD'), 1
       ,'010-6678-9867',1,1,1,1500000,1500000
       ,'990211',CRYPTPACK.ENCRYPT('1234567','1234567') ); 
--==>> 1 행 이(가) 삽입되었습니다.
--> 한줄 구성
INSERT INTO EMPLOYEE(EMPLOYEEID, NAME, BIRTHDAY, LUNAR, TELEPHONE, DEPARTMENTID, POSITIONID, REGIONID, BASICPAY, EXTRAPAY, SSN1, SSN2) VALUES (EMPLOYEESEQ.NEXTVAL, '길현욱',TO_DATE('1999-02-11','YYYY-MM-DD'),1,'010-6678-9867',1,1,1,1500000,1500000,'990211',CRYPTPACK.ENCRYPT('1234567','1234567'))
;
SELECT *
FROM EMPLOYEE;
--==>>
/*
1	강혜성	1997/10/17	0	010-6380-7047	1	2	1	2500000	1500000	971017	=o???	1
2	길현욱	1999/02/11	1	010-6678-9867	1	1	1	1500000	1500000	990211	=o???	1
*/

--○ 커밋
COMMIT;
--==> 커밋완료

-- 강혜성 사원을 관리자로 임명
UPDATE EMPLOYEE
SET GRADE = 0
WHERE EMPLOYEEID = 1;
--==>> 1 행 이(가) 업데이트되었습니다.

SELECT *
FROM EMPLOYEE;
--==>>
/*
1	강혜성	1997/10/17	0	010-6380-7047	1	2	1	2500000	1500000	971017	=o???	0
2	길현욱	1999/02/11	1	010-6678-9867	1	1	1	1500000	1500000	990211	=o???	1
*/

--○ 커밋 
COMMIT;
--==>> 커밋 완료.

--※ 테이블의 구조를 변경했기 때문에
--   이를 기반으로 생성항 뷰(VIEW)내용 또한 새로 작성(수정)

--○ 뷰 생성 (EMPLOYEEVIEW)
CREATE OR REPLACE VIEW EMPLOYEEVIEW
AS
SELECT E.EMPLOYEEID AS EMPLOYEEID
     , E.NAME AS NAME
     , E.SSN1 AS SSN
     , TO_CHAR(E.BIRTHDAY, 'YYYY-MM-DD') AS BIRTHDAY
     , E.LUNAR AS LUNAR
     , DECODE (E.LUNAR, 0, '양력', 1, '음력') AS LUNARNAME
     , E.TELEPHONE AS TELEPHONE
     , E.DEPARTMENTID AS DEPARTMENTID
     , (SELECT DEPARTMENTNAME
        FROM DEPARTMENT
        WHERE DEPARTMENTID = E.DEPARTMENTID) AS DEPARTMENTNAME
    , E.POSITIONID  AS POSITIONID
    , ( SELECT POSITIONNAME
        FROM POSITION
        WHERE POSITIONID = E.POSITIONID) AS POSITIONNAME
    , E.REGIONID AS REGIONID
    , ( SELECT REGIONNAME
        FROM REGION
        WHERE REGIONID = E.REGIONID) AS REGIONNAME
    , E.BASICPAY AS BASICPAY
    , E.EXTRAPAY AS EXTRAPAY
    , NVL(E.BASICPAY,0) + NVL(E.EXTRAPAY,0) AS PAY
    , E.GRADE AS GRADE 
FROM EMPLOYEE E;
--==>> View EMPLOYEEVIEW이(가) 생성되었습니다.

DESC EMPLOYEEVIEW;
--==>>
/*
이름             널?       유형           
-------------- -------- ------------ 
EMPLOYEEID     NOT NULL NUMBER       
NAME                    VARCHAR2(30) 
SSN                     CHAR(6)      
BIRTHDAY                VARCHAR2(10) 
LUNAR                   NUMBER(1)    
LUNARANAME              VARCHAR2(6)  
TELEPHONE               VARCHAR2(40) 
DEPARTMENTID            NUMBER       
DEPARTMENTNAME          VARCHAR2(30) 
POSITIONID              NUMBER       
POSITIONNAME            VARCHAR2(30) 
REGIONID                NUMBER       
REGIONNAME              VARCHAR2(30) 
BASICPAY                NUMBER       
EXTRAPAY                NUMBER       
PAY                     NUMBER       
GRADE                   NUMBER(1)    
*/

SELECT *
FROM EMPLOYEE;
--==>>
/*
1	강혜성	1997/10/17	0	010-6380-7047	1	2	1	2500000	1500000	971017	=o???	0
2	길현욱	1999/02/11	1	010-6678-9867	1	1	1	1500000	1500000	990211	=o???	1
*/
SELECT EMPLOYEEID, NAME, SSN, BIRTHDAY, LUNAR,LUNARNAME, TELEPHONE, DEPARTMENTID, DEPARTMENTNAME, POSITIONID, POSITIONNAME, REGIONID, REGIONNAME, BASICPAY,EXTRAPAY,PAY,GRADE FROM EMPLOYEEVIEW
;
--==>>
/*
1	강혜성	971017	1997-10-17	0	양력	010-6380-7047	1	개발부	2	대리	1	서울	2500000	1500000	4000000	0
2	길현욱	990211	1999-02-11	1	음력	010-6678-9867	1	개발부	1	사원	1	서울	1500000	1500000	3000000	1
*/

--○ 일반 사원 로그인 쿼리문
--   (ID → EMPLOYEEID / PW → SSN2)
SELECT NAME
FROM EMPLOYEE
WHERE EMPLOYEEID='입력ID문자열'
  AND SSN2 = (SELECT SSN2
              FROM EMPLOYEE
              WHERE EMPLOYEEID='입력문자열');

SELECT NAME
FROM EMPLOYEE
WHERE EMPLOYEEID=2
  AND SSN2 = (SELECT SSN2
              FROM EMPLOYEE
              WHERE EMPLOYEEID=2);
--==>> 길현욱

SELECT NAME
FROM EMPLOYEE
WHERE EMPLOYEEID=2
  AND (SELECT SSN2
       FROM EMPLOYEE
       WHERE EMPLOYEEID=2) = CRYPTPACK.ENCRYPT('1234568','1234568');
---==>> 조회 결과 없음 → 로그인 실패

SELECT NAME
FROM EMPLOYEE
WHERE EMPLOYEEID=2
  AND (SELECT SSN2
       FROM EMPLOYEE
       WHERE EMPLOYEEID=2) = CRYPTPACK.ENCRYPT('1234567','1234567');
--==>> 길현욱 → 로그인 성공

SELECT NAME
FROM EMPLOYEE
WHERE EMPLOYEEID=[입력ID]
  AND (SELECT SSN2
       FROM EMPLOYEE
       WHERE EMPLOYEEID=[입력ID]) = CRYPTPACK.ENCRYPT([입력PW],[입력PW]);

SELECT NAME
FROM EMPLOYEE
WHERE EMPLOYEEID=2
  AND SSN2 = CRYPTPACK.ENCRYPT('1234567','1234567');
--==>> 길현욱

SELECT NAME
FROM EMPLOYEE
WHERE EMPLOYEEID=[입력ID]
  AND SSN2 = CRYPTPACK.ENCRYPT([입력PW],[입력PW]);
--> 한줄 구성

--※ 일반 사원 로그인 한줄 쿼리문 구성
SELECT NAME FROM EMPLOYEE WHERE EMPLOYEEID=[입력ID] AND SSN2 = CRYPTPACK.ENCRYPT([입력PW],[입력PW])
;

--○ 관리자 로그인 쿼리문
--   (ID → EMPLOYEEID / PW → SSN2 / GRADE → 0)
SELECT NAME
FROM EMPLOYEE
WHERE EMPLOYEEID=2
  AND SSN2 = CRYPTPACK.ENCRYPT('1234567','1234567')
  AND GRADE = 0;
--==>> 조회 결과 없음 → 관리자 로그인 실패

SELECT NAME
FROM EMPLOYEE
WHERE EMPLOYEEID=1
  AND SSN2 = CRYPTPACK.ENCRYPT('1234567','1234567')
  AND GRADE = 0;
--==>> 강혜성 → 관리자 로그인 성공  
  
--※ 관리자 로그인 한줄 쿼리문 구성
SELECT NAME FROM EMPLOYEE WHERE EMPLOYEEID=[입력ID] AND SSN2 = CRYPTPACK.ENCRYPT([입력PW],[입력PW]) AND GRADE = 0
;  
  
  
--○ 직원 데이터 삭제 쿼리문 구성
DELETE
FROM EMPLOYEE
WHERE EMPLOYEEID = 2;
--==>> 한줄 구성
DELETE FROM EMPLOYEE WHERE EMPLOYEEID = 2
;
--==>> 1 행 이(가) 삭제되었습니다.

--○ 롤백
ROLLBACK;
--==>> 롤백 완료.

--○ 직원 데이터 수정 쿼리문 구성
UPDATE EMPLOYEE
SET NAME='길현욱'
   ,BIRTHDAY=TO_DATE('1999-02-11','YYYY-MM-DD')
   ,LUNAR=1
   ,TELEPHONE='010-6678-9867'
   ,DEPARTMENTID =1
   ,POSITIONID =1
   ,REGIONID=2
   ,BASICPAY=1500000
   ,EXTRAPAY=1500000
   ,SSN1='990211'
   ,SSN2=CRYPTPACK.ENCRYPT('1234568','1234568')
WHERE EMPLOYEEID = 2;
--> 한줄 구성
UPDATE EMPLOYEE SET NAME='길현욱',BIRTHDAY=TO_DATE('1999-02-11','YYYY-MM-DD'),LUNAR=1,TELEPHONE='010-6678-9867',DEPARTMENTID =1,POSITIONID =1,REGIONID=2,BASICPAY=1500000,EXTRAPAY=1500000,SSN1='990211',SSN2=CRYPTPACK.ENCRYPT('1234568','1234568'),GRADE=1 WHERE EMPLOYEEID = 2
;
--==>> 1 행 이(가) 업데이트되었습니다.

SELECT *
FROM EMPLOYEEVIEW;
--==>> 
/*
1	강혜성	971017	1997-10-17	0	양력	010-6380-7047	1	개발부	2	대리	1	서울	2500000	1500000	4000000	0
2	길현욱	990211	1999-02-11	1	음력	010-6678-9867	1	개발부	1	사원	2	경기	1500000	1500000	3000000	1
*/

SELECT *
FROM EMPLOYEE;
--==>>
/*
1	강혜성	1997/10/17	0	010-6380-7047	1	2	1	2500000	1500000	971017	=o???	0
2	길현욱	1999/02/11	1	010-6678-9867	1	1	2	1500000	1500000	990211	????	1
*/

--커밋
COMMIT;
--==>> 커밋 완료.


--○ 전체 부서 리스트 조회 쿼리문 구성(DEPARTMENTVIEW)
SELECT DEPARTMENTID, DEPARTMENTNAME, DELCHECK
FROM DEPARTMENTVIEW;
--> 한줄 구성
SELECT DEPARTMENTID, DEPARTMENTNAME, DELCHECK FROM DEPARTMENTVIEW
;
--==>>
/*
1	개발부	2
2	기획부	0
3	영업부	0
4	자재부	0
*/

--○ 부서 데이터 입력 쿼리문 구성(DEPARTMENT)
INSERT INTO DEPARTMENT(DEPARTMENTID,DEPARTMENTNAME) VALUES(DEPARTMENTSEQ.NEXTVAL,'총무부')
;
--==>> 1 행 이(가) 삽입되었습니다.

--○ 커밋
COMMIT;
--==>> 커밋 완료.

--○ 부서 데이터 삭제 쿼리문 구성(DEPARTMENT)
DELETE
FROM DEPARTMENT
WHERE DEPARTMENTID=3;
--> 한줄 구성
DELETE FROM DEPARTMENT WHERE DEPARTMENTID=3
;
--==>> 

--○ 롤백
ROLLBACK;
--==>> 롤백 완료.

--○ 부서 데이터 수정 쿼리문 구성(DEPARTMENT)
UPDATE DEPARTMENT
SET DEPARTMENTNAME = '자원부'
WHERE DEPARTMENTID =2;
--> 한줄 구성
UPDATE DEPARTMENT SET DEPARTMENTNAME = '자원부' WHERE DEPARTMENTID =2
;
--==>> 1 행 이(가) 업데이트되었습니다.

--○ 롤백
ROLLBACK;
--==> 완 

--○ 지역 리스트 조회 쿼리문(REGIONVIEW)
SELECT REGIONID, REGIONNAME, DELCHECK
FROM REGIONVIEW;
--> 한줄 구성
SELECT REGIONID, REGIONNAME, DELCHECK FROM REGIONVIEW
;
--==>>
/*
1	서울	1
2	경기	1
3	인천	0
4	대전	0
5	광주	0
6	대구	0
*/

--○ 지역 데이터 등록 쿼리문 구성(REGION)
INSERT INTO REGION(REGIONID, REGIONNAME) VALUES (REGIONSEQ.NEXTVAL, '강원')
;
--==>> 1 행 이(가) 삽입되었습니다.
SELECT *
FROM REGIONVIEW;
--==>>
/*
1	서울	1
2	경기	1
3	인천	0
4	대전	0
5	광주	0
6	대구	0
7	강원	0
*/

--○ 커밋
COMMIT;
--==>> 완.

--○ 지역 데이터 삭제 쿼리문 구성(REGION)
DELETE
FROM REGION
WHERE REGIONID=3;
--> 한 줄 구성
DELETE FROM REGION WHERE REGIONID =3
;
--==>> 1 행 이(가) 삭제되었습니다

-- 롤백
ROLLBACK;
--==>> 롤백 완료.

--○ 지역 데이터 수정 쿼리문 구성(REGION)
UPDATE REGION
SET REGIONNAME = '제주'
WHERE REGIONID=4;
--> 한줄 구성
UPDATE REGION SET REGIONNAME = '제주' WHERE REGIONID=4
;

-- 커밋
COMMIT;
--==>> 커밋완료

--○ 전체 직위 리스트 조회 쿼리문 구성(POSITIONVIEW)
SELECT POSITIONID, POSITIONNAME, MINBASICPAY, DELCHECK
FROM POSITIONVIEW;
--> 한줄 구성
SELECT POSITIONID, POSITIONNAME,MINBASICPAY, DELCHECK FROM POSITIONVIEW
;
--==>>
/*
1	사원	1000000	1
2	대리	2000000	1
3	과장	3000000	0
4	부장	4000000	0
*/

--○ 직위 데이터 입력 쿼리문 구성(POSITION)
INSERT INTO POSITION(POSITIONID, POSITIONNAME,MINBASICPAY) VALUES(POSITIONSEQ.NEXTVAL, '상무', 5000000)
;

--○ 커밋
COMMIT;
--==> 커밋 완료

--○ 직위 데이터 삭제 쿼리문 구성 (POSITION)
DELETE
FROM POSITION
WHERE POSITIONID = 5;
--> 한줄 구성
DELETE FROM POSITION WHERE POSITIONID = 5
;

-- 롤백
ROLLBACK;
--==> 롤백 완료.

--○ 직위 데이터 수정 쿼리문 구성(POSITION)
UPDATE POSITION
SET POSITIONNAME = '주임', MINBASICPAY=2000000
WHERE POSITIONID =2;
--> 한줄 구성
UPDATE POSITION SET POSITIONNAME = '주임', MINBASICPAY=2000000 WHERE POSITIONID =2
;
--==>> 1 행 이(가) 업데이트되었습니다.

-- 롤백
ROLLBACK;
--==>> 롤백 완료.


--○ 직원 검색 쿼리문 구성(아이디를 활용하여 직원 데이터 검색)
SELECT EMPLOYEEID, NAME, SSN1
      ,TO_CHAR(BIRTHDAY,'YYYY-MM-DD') AS BIRTHDAY
      ,LUNAR, TELEPHONE, DEPARTMENTID, POSITIONID, REGIONID, BASICPAY, EXTRAPAY
FROM EMPLOYEE
WHERE EMPLOYEEID=1;
--> 한줄 구성
SELECT EMPLOYEEID, NAME, SSN1 ,TO_CHAR(BIRTHDAY,'YYYY-MM-DD') AS BIRTHDAY ,LUNAR, TELEPHONE, DEPARTMENTID, POSITIONID, REGIONID, BASICPAY, EXTRAPAY FROM EMPLOYEE WHERE EMPLOYEEID=1
;
--==>> 1	강혜성	971017	1997-10-17	0	010-6380-7047	1	2	1	2500000	1500000


desc employeeview;


