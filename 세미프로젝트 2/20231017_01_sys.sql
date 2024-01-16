/*
수강신청 테이블에서 수강신청한 과정의 끝나는 날짜가
지금 신청할려고 하는 과정의 시작한 날짜와 겹치면 안됨 

그러면 입력한 학생 코드가 수강신청 테이블에 있는지 확인를 해야함
만약 수강신청한 경력이 있으면 그 과정이 진행중인지 확인 해야함
그 과정이 현재 진행중이면 수강신청 날짜가 겹쳐서 수강신청이 되면 안됨 

그러면 
수강신청 테이블에 현재 진행중인 과정의 끝나는 날짜를 뽑아서 
입력 받은 과정코드의 시작날짜와 비교하면 끝남 


 1. 입력한 과정이 없을 경우 예외처리
 2. 학생 ID가 없을 경우 예외처리 
 3. 학생 등록일 보다 수강신청일이 빠를경우
 4. 이미 신청한 과정일 경우 예외처리 
 5. 이미 과정이 시작 되었을경우 예외처리
 6. 현재 학생이 수강신청한 과정 종료일보다 수강신청 할 과정 시작일이 더 빠를경우
*/


SELECT *
FROM COURSE_REGISTRATIONS;

DROP SEQUENCE COURSE_REGISTRAIONS_SEQ;

CREATE SEQUENCE COURSE_REGISTRAIONS_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 9999
NOCYCLE
NOCACHE;

CREATE OR REPLACE PROCEDURE PRC_COURSES_REG
( V_ST_CODE     IN COURSE_REGISTRATIONS.ST_CODE%TYPE
, V_OCRS_CODE   IN COURSE_REGISTRATIONS.OCRS_CODE%TYPE
)
IS
    OCRS_COUNT NUMBER;      -- 개설 과정 변수
    USER_DEFINE_ERROR1 EXCEPTION;
    
    ST_COUNT NUMBER;        -- 학생 변수
    USER_DEFINE_ERROR2 EXCEPTION;
    
    V_OCRS_START  OPEN_COURSES.START_DATE%TYPE;  -- 개설과정 시작일
    V_ST_DATE STUDENTS.ST_DATE%TYPE;            -- 학생 등록일 
    USER_DEFINE_ERROR3 EXCEPTION;   
    
    ST_OCRS NUMBER;    -- 학생이 신청한 수강신청
    USER_DEFINE_ERROR4 EXCEPTION;
    
    V_ST_OCRS COURSE_REGISTRATIONS.OCRS_CODE%TYPE;
    USER_DEFINE_ERROR5 EXCEPTION;
    
    ST_END_DATE OPEN_COURSES.END_DATE%TYPE;
    USER_DEFINE_ERROR6 EXCEPTION;
    
    OCRS_START  OPEN_COURSES.END_DATE%TYPE;
    OCRS_END    OPEN_COURSES.START_DATE%TYPE;
    
    V_OCRS_START  OPEN_COURSES.END_DATE%TYPE;
    V_OCRS_END    OPEN_COURSES.START_DATE%TYPE;
    
    CURSOR CUR_CRG_INSERT
    IS 
    SELECT OCRS_CODE
    FROM COURSE_REGISTRATIONS
    WHERE ST_CODE = V_ST_CODE;
    
    
BEGIN

    -- 1. 입력한 과정이 없을 경우 예외처리
    SELECT COUNT(*) INTO OCRS_COUNT
    FROM OPEN_COURSES 
    WHERE OCRS_CODE = V_OCRS_CODE; 

    IF (OCRS_COUNT != 1)
        THEN RAISE USER_DEFINE_ERROR1;
    END IF;    

     --2. 학생 ID가 없을 경우 예외처리 / 학생 등록일
     SELECT COUNT(*) INTO ST_COUNT
     FROM STUDENTS
     WHERE ST_CODE = V_ST_CODE;
    
    IF (ST_COUNT = 0)
        THEN RAISE USER_DEFINE_ERROR2;
    END IF;
    
    --4. 이미 신청한 과정일 경우 예외처리  
    SELECT COUNT(*) INTO ST_OCRS 
    FROM COURSE_REGISTRATIONS
    WHERE OCRS_CODE = V_OCRS_CODE
      AND ST_CODE = V_ST_CODE;
      
    IF (ST_OCRS != 0)
        THEN RAISE USER_DEFINE_ERROR4;
    END IF;
    
    -- 5. 이미 과정이 시작 되었을경우 예외처리
    IF (V_OCRS_START < SYSDATE)
        THEN RAISE USER_DEFINE_ERROR5;
    END IF;
    
    -- 6. 현재 학생이 수강신청한 과정 종료일보다 수강신청 할 과정 시작일이 더 빠를경우 -- 커서 써보기

--    OCRS_START  OPEN_COURSES.END_DATE%TYPE;
--    OCRS_END    OPEN_COURSES.START_DATE%TYPE;
--    
--    V_OCRS_START  OPEN_COURSES.END_DATE%TYPE;
--    V_OCRS_END    OPEN_COURSES.START_DATE%TYPE; 
    
    SELECT OPEN_DATE , END_DATE INTO V_OCRS_START , V_OCRS_END
    FROM OPEN_COURSES
    WHERE OCRS_CODE = V_OCRS_CODE;
    
    OPEN CURSOR;
    
    LOOP
    FETCH CURSOR INTO OCRS_CODE
        
        SELECT OCRS_START, OCRS_END INTO OCRS_START , OCRS_END
        FROM OPEN_COURSES
        WHERE OCRS_CODE IN (SELECT OCRS_CODE
                            FROM COURSE_REGISTRATIONS
                            WHERE ST_CODE = V_ST_CODE);
                            
        IF ((V_OCRS_START BETWEEN OCRS_START AND OCRS_END) OR (V_OCRS_END BETWEEN OCRS_START AND OCRS_END) OR 
             (OCRS_START BETWEEN V_OCRS_START AND V_OCRS_END) OR (OCRS_END BETWEEN V_OCRS_START AND V_OCRS_END))
            THEN RAISE USER_DEFINE_ERROR6;   
        END IF;
        
         EXIT WHEN CURSOR%NOTFOUND;
        
    END LOOP;
    
    CLOSE CURSOR;
      
    /*
    IF (ST_COUNT != 0)
    THEN SELECT END_DATE INTO ST_END_DATE  
        FROM
        (
            SELECT RANK() OVER(ORDER BY END_DATE DESC) "순위" , END_DATE
            FROM OPEN_COURSES
            WHERE OCRS_CODE IN (SELECT OCRS_CODE --INTO V_ST_OCRS 
                                FROM COURSE_REGISTRATIONS
                                WHERE ST_CODE = V_ST_CODE)
        )T  
        WHERE T.순위 = 1;    
    END IF;
    */
    
     --3. 학생 등록일 보다 과정 시작일이 빠를경우 / 과정 시작일 변수
    SELECT ST_DATE INTO V_ST_DATE
    FROM STUDENTS
    WHERE ST_CODE = V_ST_CODE;

    SELECT START_DATE INTO V_OCRS_START    
    FROM OPEN_COURSES
    WHERE OCRS_CODE = V_OCRS_CODE;  
    
    IF (V_ST_DATE > V_OCRS_START )
        THEN RAISE USER_DEFINE_ERROR3;
    END IF;
    
    IF (V_OCRS_START < ST_END_DATE OR )
        THEN RAISE USER_DEFINE_ERROR6;
    END IF;

    -- 수강신청 INSERT
    INSERT INTO COURSE_REGISTRATIONS (ST_CODE, OCRS_CODE, REG_CODE, REG_DATE)
    VALUES (V_ST_CODE, V_OCRS_CODE, 'RE' || LPAD(TO_CHAR(COURSE_REGISTRAIONS_SEQ.NEXTVAL),3,'0'),SYSDATE);
    
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR1
            THEN RAISE_APPLICATION_ERROR(-20004,'입력한 과정이 없습니다.');
                 ROLLBACK;
                 
        WHEN USER_DEFINE_ERROR2 
            THEN RAISE_APPLICATION_ERROR(-20004,'학생~~ 과목 찾았어요~~!!');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR3    
            THEN RAISE_APPLICATION_ERROR(-20005,'학생 등록일이 수강신청 날짜보다 더 늦습니다.');
                ROLLBACK;
                                
        WHEN USER_DEFINE_ERROR4
            THEN RAISE_APPLICATION_ERROR(-20006,'이미 등록한 과정입니다.');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR5
            THEN RAISE_APPLICATION_ERROR(-20005,'이미 시작된 과정입니다.');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR6
            THEN RAISE_APPLICATION_ERROR(-20006,'기간이 같은 과정은 신청이 불가합니다.');
                ROLLBACK;         
--        WHEN OTHERS
--            THEN ROLLBACK;
END;

EXEC PRC_COURSES_REG('ST001','OC001');

EXEC PRC_COURSES_REG('ST001','OC005');

EXEC PRC_COURSES_REG('ST001','OC006');

EXEC PRC_COURSES_REG('ST001','OC003'); 

SELECT *
FROM STUDENTS;

ROLLBACK;

SELECT *
FROM OPEN_COURSES;

SELECT *
FROM COURSE_REGISTRATIONS;

ROLLBACK;

COMMIT;

DELETE 
FROM COURSE_REGISTRATIONS;

--ST001	OC004	RG3	2019-12-16
--ST001	OC002	RG1	2019-12-16

COMMIT;



-- OC004	CO002	PF001	CR002	2023-04-25	2024-01-15
-- OC014	CO001	PF003	CR001	2023-08-25	2024-01-15

--ST001	OC004	RG3	2019-12-16
--ST001	OC002	RG1	2019-12-16
--ST002	OC002	RG2	2019-12-16
--ST005	OC003	RG4	2021-11-16

V_ST_CODE     IN COURSE_REGISTRATIONS.ST_CODE%TYPE
, V_OCRS_CODE 

SELECT *
FROM OPEN_COURSES

--==============================================================================

CREATE OR REPLACE PROCEDURE PRC_COURSES_REG
( V_ST_CODE     IN COURSE_REGISTRATIONS.ST_CODE%TYPE
, V_OCRS_CODE   IN COURSE_REGISTRATIONS.OCRS_CODE%TYPE
)
IS
    OCRS_COUNT NUMBER;      -- 개설 과정 변수
    USER_DEFINE_ERROR1 EXCEPTION;
    
    ST_COUNT NUMBER;        -- 학생 변수
    USER_DEFINE_ERROR2 EXCEPTION;
    
    V_OCRS_START  OPEN_COURSES.START_DATE%TYPE;  -- 개설과정 시작일
    V_ST_DATE STUDENTS.ST_DATE%TYPE;            -- 학생 등록일 
    USER_DEFINE_ERROR3 EXCEPTION;   
    
    ST_OCRS NUMBER;    -- 학생이 신청한 수강신청
    USER_DEFINE_ERROR4 EXCEPTION;
    
    V_ST_OCRS COURSE_REGISTRATIONS.OCRS_CODE%TYPE;
    USER_DEFINE_ERROR5 EXCEPTION;
    
    ST_END_DATE OPEN_COURSES.END_DATE%TYPE;
    USER_DEFINE_ERROR6 EXCEPTION;
    
    OCRS_START  OPEN_COURSES.END_DATE%TYPE;
    OCRS_END    OPEN_COURSES.START_DATE%TYPE;
    
    C_OCRS_START  OPEN_COURSES.END_DATE%TYPE;
    C_OCRS_END    OPEN_COURSES.START_DATE%TYPE;
    
    A_OCRS_CODE OPEN_COURSES.OCRS_CODE%TYPE;
    
    CURSOR CUR_RG_INSERT
    IS 
    SELECT START_DATE, END_DATE
    FROM OPEN_COURSES
    WHERE OCRS_CODE IN (SELECT OCRS_CODE
                         FROM COURSE_REGISTRATIONS
                         WHERE ST_CODE = V_ST_CODE);           
BEGIN

    -- 1. 입력한 과정이 없을 경우 예외처리
    SELECT COUNT(*) INTO OCRS_COUNT
    FROM OPEN_COURSES 
    WHERE OCRS_CODE = V_OCRS_CODE; 

    IF (OCRS_COUNT != 1)
        THEN RAISE USER_DEFINE_ERROR1;
    END IF;    

     --2. 학생 ID가 없을 경우 예외처리 / 학생 등록일
     SELECT COUNT(*) INTO ST_COUNT
     FROM STUDENTS
     WHERE ST_CODE = V_ST_CODE;
    
    IF (ST_COUNT = 0)
        THEN RAISE USER_DEFINE_ERROR2;
    END IF;
    
    --4. 이미 신청한 과정일 경우 예외처리  
    SELECT COUNT(*) INTO ST_OCRS 
    FROM COURSE_REGISTRATIONS
    WHERE OCRS_CODE = V_OCRS_CODE
      AND ST_CODE = V_ST_CODE;
      
    IF (ST_OCRS != 0)
        THEN RAISE USER_DEFINE_ERROR4;
    END IF;

    
    -- 6. 현재 학생이 수강신청한 과정 종료일보다 수강신청 할 과정 시작일이 더 빠를경우 -- 커서 써보기
    
    
    SELECT START_DATE, END_DATE INTO C_OCRS_START, C_OCRS_END
    FROM OPEN_COURSES
    WHERE OCRS_CODE = V_OCRS_CODE;
    
    OPEN CUR_RG_INSERT;
    
    LOOP
    FETCH CUR_RG_INSERT INTO OCRS_START, OCRS_END;
                            
        IF ((C_OCRS_START BETWEEN OCRS_START AND OCRS_END) OR (C_OCRS_END BETWEEN OCRS_START AND OCRS_END) OR 
             (OCRS_START BETWEEN C_OCRS_START AND C_OCRS_END) OR (OCRS_END BETWEEN C_OCRS_START AND C_OCRS_END))
            THEN RAISE USER_DEFINE_ERROR6;   
        END IF;
        
         EXIT WHEN CUR_RG_INSERT%NOTFOUND;
   
    END LOOP;
    
    CLOSE CUR_RG_INSERT;
    
     --3. 학생 등록일 보다 과정 시작일이 빠를경우 / 과정 시작일 변수
    SELECT ST_DATE INTO V_ST_DATE
    FROM STUDENTS
    WHERE ST_CODE = V_ST_CODE;

    SELECT START_DATE INTO V_OCRS_START    
    FROM OPEN_COURSES
    WHERE OCRS_CODE = V_OCRS_CODE;  
    
    IF (V_ST_DATE > V_OCRS_START )
        THEN RAISE USER_DEFINE_ERROR3;
    END IF;
    
     -- 5. 이미 과정이 시작 되었을경우 예외처리
    IF (V_OCRS_START < SYSDATE)
        THEN RAISE USER_DEFINE_ERROR5;
    END IF;

    -- 수강신청 INSERT
    INSERT INTO COURSE_REGISTRATIONS (ST_CODE, OCRS_CODE, REG_CODE, REG_DATE)
    VALUES (V_ST_CODE, V_OCRS_CODE, 'RE' || LPAD(TO_CHAR(COURSE_REGISTRAIONS_SEQ.NEXTVAL),3,'0'),SYSDATE);
    
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR1
            THEN RAISE_APPLICATION_ERROR(-20004,'입력한 과정이 없습니다.');
                 ROLLBACK;
                 
        WHEN USER_DEFINE_ERROR2 
            THEN RAISE_APPLICATION_ERROR(-20004,'입력한 학생은 없습니다.');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR3    
            THEN RAISE_APPLICATION_ERROR(-20005,'학생 등록일이 수강신청 날짜보다 더 늦습니다.');
                ROLLBACK;
                                
        WHEN USER_DEFINE_ERROR4
            THEN RAISE_APPLICATION_ERROR(-20006,'이미 등록한 과정입니다.');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR5
            THEN RAISE_APPLICATION_ERROR(-20005,'이미 시작 및 종료된 과정입니다.');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR6
            THEN RAISE_APPLICATION_ERROR(-20006,'기간이 같은 과정은 신청이 불가합니다.');
                ROLLBACK;         
--        WHEN OTHERS
--            THEN ROLLBACK;
END;
--==>> Procedure PRC_COURSES_REG이(가) 컴파일되었습니다.

EXEC PRC_COURSES_REG('ST003','OC003');

SELECT *
FROM STUDENTS;


UPDATE STUDENTS
SET ST_DATE = TO_DATE('2023-08-12','YYYY-MM-DD')
WHERE ST_CODE = 'ST003';

SELECT *
FROM OPEN_COURSES;

SELECT *
FROM COURSE_REGISTRATIONS;

ROLLBACK;

--ST001	OC005	RE005	2012-11-16
--ST001	OC001	RE002	2012-11-16






















