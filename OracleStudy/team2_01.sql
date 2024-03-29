SELECT USER
FROM DUAL;
--==>> HR

-- REGIONS2 테이블 생성
CREATE TABLE REGIONS2
( REGION_ID     NUMBER
, REGION_NAME   VARCHAR2(25)
, CONSTRAINT REG2_ID_PK PRIMARY KEY(REGION_ID)
);
--==>> Table REGIONS2이(가) 생성되었습니다.

ALTER TABLE REGIONS2
MODIFY REGION_ID NUMBER CONSTRAINT REGION2_ID_NN NOT NULL;
--==>> Table REGIONS2이(가) 변경되었습니다.

--커밋
COMMIT;
--==>> 커밋 완료.


-- JOB_HISTORY2 테이블 생성
CREATE TABLE JOB_HISTORY2
( EMPLOYEE_ID       NUMBER(6)   
, START_DATE        DATE
, END_DATE          DATE
, JOB_ID            VARCHAR2(10)
, DEPARTMENT_ID     NUMBER(4)
, CONSTRAINT JHIST2_EMP_ID_ST_DATE_PK PRIMARY KEY(EMPLOYEE_ID, START_DATE)
);
--==>> Table JOB_HISTORY2이(가) 생성되었습니다.

ALTER TABLE JOB_HISTORY2
MODIFY EMPLOYEE_ID NUMBER(6) CONSTRAINT JHIST2_EMPLOYEE_NN NOT NULL;
ALTER TABLE JOB_HISTORY2
MODIFY START_DATE DATE CONSTRAINT JHIST2_START_DATE_NN NOT NULL;
ALTER TABLE JOB_HISTORY2
MODIFY END_DATE DATE CONSTRAINT JHIST2_END_DATE_NN NOT NULL;
ALTER TABLE JOB_HISTORY2
MODIFY JOB_ID VARCHAR2(10) CONSTRAINT JHIST2_JOB_NN NOT NULL;
ALTER TABLE JOB_HISTORY2
ADD ( CONSTRAINT JHIST2_DATE_INTERVAL CHECK(END_DATE > START_DATE));
--==>> Table JOB_HISTORY2이(가) 변경되었습니다.                                     
-- 커밋
COMMIT;


INSERT INTO REGIONS2 (REGION_ID, REGION_NAME) VALUES(1, 'Europe');
INSERT INTO REGIONS2 (REGION_ID, REGION_NAME) VALUES(2, 'Americas');
INSERT INTO REGIONS2 (REGION_ID, REGION_NAME) VALUES(3, 'Asia');
INSERT INTO REGIONS2 (REGION_ID, REGION_NAME) VALUES(4, 'Middle East and Africa');

-- 커밋
COMMIT;

--------------------------------------------------------------------------------

CREATE TABLE LOCATIONS2
( LOCATION_ID       NUMBER(4)
, STREET_ADDRESS    VARCHAR2(40)
, POSTAL_CODE       VARCHAR2(12)
, CITY              VARCHAR2(30) 
, STATE_PROVINCE    VARCHAR2(25)
, COUNTRY_ID        CHAR(2)
, CONSTRAINT LOC2_ID_PK PRIMARY KEY(LOCATION_ID)
);

ALTER TABLE LOCATIONS2 MODIFY CITY VARCHAR2(30) CONSTRAINT LOC2_CITY_NN NOT NULL;

------------------------------------------------------------------여기 까지 완료

ALTER TABLE LOCATIONS2
ADD ( CONSTRAINT LOC2_C_ID_FK FOREIGN KEY(COUNTRY_ID) 
                  REFERENCES COUNTRIES2(COUNTRY_ID) );

CREATE SEQUENCE LOCATION2S_SEQ
INCREMENT BY 100
START WITH 1000
MINVALUE 1
MAXVALUE 9900
NOCYCLE
NOCACHE;

SELECT *
FROM USER_SEQUENCES;

DELETE 
FROM LOCATIONS2;

DROP SEQUENCE LOCATION2S_SEQ;


------------------------------------------------------------------------------------

ALTER TABLE JOB_HISTORY2
ADD (CONSTRAINT JHIST2_JOB_FK FOREIGN KEY(JOB_ID)
                REFERENCES JOBS2(JOB_ID));
ALTER TABLE JOB_HISTORY2
ADD (CONSTRAINT JHIST2_EMP_FK FOREIGN KEY(EMPLOYEE_ID)
                REFERENCES EMPLOYEES2(EMPLOYEE_ID));
ALTER TABLE JOB_HISTORY2
ADD (CONSTRAINT JHIST2_DEPT_FK FOREIGN KEY(DEPARTMENT_ID)
                REFERENCES DEPARTMENTS2(DEPARTMENT_ID));   
COMMIT;                        
---------------------------------------------------------여기까지 넣어주기 완료

--JOB_HISTORY2 데이터 생성
INSERT INTO JOB_HISTORY2(EMPLOYEE_ID, START_DATE, END_DATE, JOB_ID, DEPARTMENT_ID) VALUES(102, TO_DATE('2001-01-13', 'YYYY-MM-DD'), TO_DATE('2006-07-24', 'YYYY-MM-DD'), 'IT_PROG', 60);


/*
102	2001-01-13	2006-07-24	IT_PROG	    60
101	1997-09-21	2001-10-27	AC_ACCOUNT	110
101	2001-10-28	2005-03-15	AC_MGR	    110
201	2004-02-17	2007-12-19	MK_REP	    20
114	2006-03-24	2007-12-31	ST_CLERK	50
122	2007-01-01	2007-12-31	ST_CLERK	50
200	1995-09-17	2001-06-17	AD_ASST	    90
176	2006-03-24	2006-12-31	SA_REP	    80
176	2007-01-01	2007-12-31	SA_MAN	    80
200	2002-07-01	2006-12-31	AC_ACCOUNT	90
*/


SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'JOB_HISTORY2';

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'DEPARTMENTS2';

DESC JOBS2;

DESC JOB_HISTORY2;

DESC COUNTRIES2;

DESC LOCATIONS2;

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'COUNTRIES2';


SELECT *
FROM EMPLOYEES;

--------------------------------------------------------------------------------

CREATE TABLE COUNTRIES2
(COUNTRY_ID    CHAR(2) 
,COUNTRY_NAME  VARCHAR(40)
,REGION_ID     NUMBER
,CONSTRAINT COUNTRY2_C_ID_PK PRIMARY KEY(COUNTRY_ID)
,CONSTRAINT COUNTR2_REG_FK   FOREIGN KEY (REGION_ID)
                             REFERENCES REGIONS2 (REGION_ID)
);

-- 널 조건 넣기
ALTER TABLE COUNTRIES2
MODIFY COUNTRY_ID CHAR(2) CONSTRAINT COUNTRY2_ID_NN  NOT NULL;


--------------------------------------------------------------------------------

-- DEPARTMENTS2 테이블

CREATE TABLE DEPARTMENTS2
( DEPARTMENT_ID   NUMBER(4)   
, DEPARTMENT_NAME VARCHAR2(30) CONSTRAINT DEPT2_NAME_NN NOT NULL
, MANAGER_ID      NUMBER(6)
, LOCATION_ID     NUMBER(4)
, CONSTRAINT DEPT2_ID_PK PRIMARY KEY(DEPARTMENT_ID)
);

ALTER TABLE DEPARTMENTS2
ADD CONSTRAINT DEPT2_LOC_FK FOREIGN KEY(LOCATION_ID) REFERENCES LOCATIONS2(LOCATION_ID);

ALTER TABLE DEPARTMENTS2
ADD CONSTRAINT DEPT2_MGR_FK FOREIGN KEY(MANAGER_ID) REFERENCES EMPLOYEES2(EMPLOYEE_ID);


--------------------------------------------------------------------------------
-- 테이블 생성
CREATE TABLE JOBS2
( JOB_ID    VARCHAR2(10)
, JOB_TITLE VARCHAR2(35) 
, MIN_SALARY NUMBER(6)
, MAX_SALARY NUMBER(6)
, CONSTRAINT JOBS2_JOB_ID_PK PRIMARY KEY(JOB_ID)
);

--------------------------------------------------------------------------------

CREATE TABLE EMPLOYEES2
( EMPLOYEE_ID     NUMBER(6)
, FIRST_NAME      VARCHAR2(20)
, LAST_NAME       VARCHAR2(25) CONSTRAINT EMP2_LAST_NAME_NN NOT NULL
, EMAIL           VARCHAR2(25) CONSTRAINT EMP2_EMAIL_NN NOT NULL
, PHONE_NUMBER    VARCHAR2(20) 
, HIRE_DATE       DATE         CONSTRAINT EMP2_HIRE_DATE_NN NOT NULL
, JOB_ID          VARCHAR2(10) CONSTRAINT EMP2_JOB_NN NOT NULL
, SALARY          NUMBER(8,2)
, COMMISSION_PCT  NUMBER(2,2) 
, MANAGER_ID      NUMBER(6)
, DEPARTMENT_ID   NUMBER(4)
, CONSTRAINT EMP2_EMP_ID_PK PRIMARY KEY(EMPLOYEE_ID)
, CONSTRAINT EMP2_SALARY_MIN CHECK(salary > 0)
, CONSTRAINT EMP2_EMAIL_UK UNIQUE(EMAIL)
);

COMMIT;

ALTER TABLE EMPLOYEES2
ADD CONSTRAINT EMP2_DEPT_FK FOREIGN KEY(DEPARTMENT_ID) REFERENCES DEPARTMENTS2(DEPARTMENT_ID);

ALTER TABLE EMPLOYEES2
ADD CONSTRAINT EMP2_JOB_FK FOREIGN KEY(JOB_ID) REFERENCES JOBS2(JOB_ID);

ALTER TABLE EMPLOYEES2
ADD CONSTRAINT EMP2_MANAGER_FK FOREIGN KEY(MANAGER_ID) REFERENCES EMPLOYEES2(EMPLOYEE_ID);

----------------------------------------------------------------------------------------------

UPDATE DEPARTMENTS2
SET MANAGER_ID = 200
WHERE DEPARTMENT_ID = 10;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 10;

UPDATE DEPARTMENTS2
SET MANAGER_ID = 201
WHERE DEPARTMENT_ID = 20;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1800
WHERE DEPARTMENT_ID = 20;

UPDATE DEPARTMENTS2
SET MANAGER_ID = 114
WHERE DEPARTMENT_ID = 30;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 30;

UPDATE DEPARTMENTS2
SET MANAGER_ID = 203
WHERE DEPARTMENT_ID = 40;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 2400
WHERE DEPARTMENT_ID = 40;

UPDATE DEPARTMENTS2
SET MANAGER_ID = 121
WHERE DEPARTMENT_ID = 50;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1500
WHERE DEPARTMENT_ID = 50;

UPDATE DEPARTMENTS2
SET MANAGER_ID = 103
WHERE DEPARTMENT_ID = 60;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1400
WHERE DEPARTMENT_ID = 60;

UPDATE DEPARTMENTS2
SET MANAGER_ID = 204
WHERE DEPARTMENT_ID = 70;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 2700
WHERE DEPARTMENT_ID = 70;

UPDATE DEPARTMENTS2
SET MANAGER_ID = 145
WHERE DEPARTMENT_ID = 80;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 2500
WHERE DEPARTMENT_ID = 80;

UPDATE DEPARTMENTS2
SET MANAGER_ID = 100
WHERE DEPARTMENT_ID = 90;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 90;

UPDATE DEPARTMENTS2
SET MANAGER_ID = 108
WHERE DEPARTMENT_ID = 100;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 100;

UPDATE DEPARTMENTS2
SET MANAGER_ID = 205
WHERE DEPARTMENT_ID = 110;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 110;


UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 120;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 120;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 130;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 140;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 150;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 160;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 170;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 180;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 190;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 200;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 210;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 220;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 230;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 240;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 250;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 260;

UPDATE DEPARTMENTS2
SET LOCATION_ID = 1700
WHERE DEPARTMENT_ID = 270;


-- COUNTRIES2 / DEPARTMENTS2 / EMPLOYEES2 / JOBS2 / JOB_HISTORY2 / LOCATIONS2 / REGIONS2

SELECT *
FROM COUNTRIES2;

SELECT *
FROM DEPARTMENTS2;

SELECT *
FROM EMPLOYEES2;

SELECT *
FROM JOBS2;

SELECT *
FROM JOB_HISTORY2;

SELECT *
FROM LOCATIONS2;

SELECT *
FROM REGIONS2;



