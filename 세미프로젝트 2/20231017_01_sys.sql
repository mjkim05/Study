/*
������û ���̺��� ������û�� ������ ������ ��¥��
���� ��û�ҷ��� �ϴ� ������ ������ ��¥�� ��ġ�� �ȵ� 

�׷��� �Է��� �л� �ڵ尡 ������û ���̺� �ִ��� Ȯ�θ� �ؾ���
���� ������û�� ����� ������ �� ������ ���������� Ȯ�� �ؾ���
�� ������ ���� �������̸� ������û ��¥�� ���ļ� ������û�� �Ǹ� �ȵ� 

�׷��� 
������û ���̺� ���� �������� ������ ������ ��¥�� �̾Ƽ� 
�Է� ���� �����ڵ��� ���۳�¥�� ���ϸ� ���� 


 1. �Է��� ������ ���� ��� ����ó��
 2. �л� ID�� ���� ��� ����ó�� 
 3. �л� ����� ���� ������û���� �������
 4. �̹� ��û�� ������ ��� ����ó�� 
 5. �̹� ������ ���� �Ǿ������ ����ó��
 6. ���� �л��� ������û�� ���� �����Ϻ��� ������û �� ���� �������� �� �������
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
    OCRS_COUNT NUMBER;      -- ���� ���� ����
    USER_DEFINE_ERROR1 EXCEPTION;
    
    ST_COUNT NUMBER;        -- �л� ����
    USER_DEFINE_ERROR2 EXCEPTION;
    
    V_OCRS_START  OPEN_COURSES.START_DATE%TYPE;  -- �������� ������
    V_ST_DATE STUDENTS.ST_DATE%TYPE;            -- �л� ����� 
    USER_DEFINE_ERROR3 EXCEPTION;   
    
    ST_OCRS NUMBER;    -- �л��� ��û�� ������û
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

    -- 1. �Է��� ������ ���� ��� ����ó��
    SELECT COUNT(*) INTO OCRS_COUNT
    FROM OPEN_COURSES 
    WHERE OCRS_CODE = V_OCRS_CODE; 

    IF (OCRS_COUNT != 1)
        THEN RAISE USER_DEFINE_ERROR1;
    END IF;    

     --2. �л� ID�� ���� ��� ����ó�� / �л� �����
     SELECT COUNT(*) INTO ST_COUNT
     FROM STUDENTS
     WHERE ST_CODE = V_ST_CODE;
    
    IF (ST_COUNT = 0)
        THEN RAISE USER_DEFINE_ERROR2;
    END IF;
    
    --4. �̹� ��û�� ������ ��� ����ó��  
    SELECT COUNT(*) INTO ST_OCRS 
    FROM COURSE_REGISTRATIONS
    WHERE OCRS_CODE = V_OCRS_CODE
      AND ST_CODE = V_ST_CODE;
      
    IF (ST_OCRS != 0)
        THEN RAISE USER_DEFINE_ERROR4;
    END IF;
    
    -- 5. �̹� ������ ���� �Ǿ������ ����ó��
    IF (V_OCRS_START < SYSDATE)
        THEN RAISE USER_DEFINE_ERROR5;
    END IF;
    
    -- 6. ���� �л��� ������û�� ���� �����Ϻ��� ������û �� ���� �������� �� ������� -- Ŀ�� �Ẹ��

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
            SELECT RANK() OVER(ORDER BY END_DATE DESC) "����" , END_DATE
            FROM OPEN_COURSES
            WHERE OCRS_CODE IN (SELECT OCRS_CODE --INTO V_ST_OCRS 
                                FROM COURSE_REGISTRATIONS
                                WHERE ST_CODE = V_ST_CODE)
        )T  
        WHERE T.���� = 1;    
    END IF;
    */
    
     --3. �л� ����� ���� ���� �������� ������� / ���� ������ ����
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

    -- ������û INSERT
    INSERT INTO COURSE_REGISTRATIONS (ST_CODE, OCRS_CODE, REG_CODE, REG_DATE)
    VALUES (V_ST_CODE, V_OCRS_CODE, 'RE' || LPAD(TO_CHAR(COURSE_REGISTRAIONS_SEQ.NEXTVAL),3,'0'),SYSDATE);
    
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR1
            THEN RAISE_APPLICATION_ERROR(-20004,'�Է��� ������ �����ϴ�.');
                 ROLLBACK;
                 
        WHEN USER_DEFINE_ERROR2 
            THEN RAISE_APPLICATION_ERROR(-20004,'�л�~~ ���� ã�Ҿ��~~!!');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR3    
            THEN RAISE_APPLICATION_ERROR(-20005,'�л� ������� ������û ��¥���� �� �ʽ��ϴ�.');
                ROLLBACK;
                                
        WHEN USER_DEFINE_ERROR4
            THEN RAISE_APPLICATION_ERROR(-20006,'�̹� ����� �����Դϴ�.');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR5
            THEN RAISE_APPLICATION_ERROR(-20005,'�̹� ���۵� �����Դϴ�.');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR6
            THEN RAISE_APPLICATION_ERROR(-20006,'�Ⱓ�� ���� ������ ��û�� �Ұ��մϴ�.');
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
    OCRS_COUNT NUMBER;      -- ���� ���� ����
    USER_DEFINE_ERROR1 EXCEPTION;
    
    ST_COUNT NUMBER;        -- �л� ����
    USER_DEFINE_ERROR2 EXCEPTION;
    
    V_OCRS_START  OPEN_COURSES.START_DATE%TYPE;  -- �������� ������
    V_ST_DATE STUDENTS.ST_DATE%TYPE;            -- �л� ����� 
    USER_DEFINE_ERROR3 EXCEPTION;   
    
    ST_OCRS NUMBER;    -- �л��� ��û�� ������û
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

    -- 1. �Է��� ������ ���� ��� ����ó��
    SELECT COUNT(*) INTO OCRS_COUNT
    FROM OPEN_COURSES 
    WHERE OCRS_CODE = V_OCRS_CODE; 

    IF (OCRS_COUNT != 1)
        THEN RAISE USER_DEFINE_ERROR1;
    END IF;    

     --2. �л� ID�� ���� ��� ����ó�� / �л� �����
     SELECT COUNT(*) INTO ST_COUNT
     FROM STUDENTS
     WHERE ST_CODE = V_ST_CODE;
    
    IF (ST_COUNT = 0)
        THEN RAISE USER_DEFINE_ERROR2;
    END IF;
    
    --4. �̹� ��û�� ������ ��� ����ó��  
    SELECT COUNT(*) INTO ST_OCRS 
    FROM COURSE_REGISTRATIONS
    WHERE OCRS_CODE = V_OCRS_CODE
      AND ST_CODE = V_ST_CODE;
      
    IF (ST_OCRS != 0)
        THEN RAISE USER_DEFINE_ERROR4;
    END IF;

    
    -- 6. ���� �л��� ������û�� ���� �����Ϻ��� ������û �� ���� �������� �� ������� -- Ŀ�� �Ẹ��
    
    
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
    
     --3. �л� ����� ���� ���� �������� ������� / ���� ������ ����
    SELECT ST_DATE INTO V_ST_DATE
    FROM STUDENTS
    WHERE ST_CODE = V_ST_CODE;

    SELECT START_DATE INTO V_OCRS_START    
    FROM OPEN_COURSES
    WHERE OCRS_CODE = V_OCRS_CODE;  
    
    IF (V_ST_DATE > V_OCRS_START )
        THEN RAISE USER_DEFINE_ERROR3;
    END IF;
    
     -- 5. �̹� ������ ���� �Ǿ������ ����ó��
    IF (V_OCRS_START < SYSDATE)
        THEN RAISE USER_DEFINE_ERROR5;
    END IF;

    -- ������û INSERT
    INSERT INTO COURSE_REGISTRATIONS (ST_CODE, OCRS_CODE, REG_CODE, REG_DATE)
    VALUES (V_ST_CODE, V_OCRS_CODE, 'RE' || LPAD(TO_CHAR(COURSE_REGISTRAIONS_SEQ.NEXTVAL),3,'0'),SYSDATE);
    
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR1
            THEN RAISE_APPLICATION_ERROR(-20004,'�Է��� ������ �����ϴ�.');
                 ROLLBACK;
                 
        WHEN USER_DEFINE_ERROR2 
            THEN RAISE_APPLICATION_ERROR(-20004,'�Է��� �л��� �����ϴ�.');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR3    
            THEN RAISE_APPLICATION_ERROR(-20005,'�л� ������� ������û ��¥���� �� �ʽ��ϴ�.');
                ROLLBACK;
                                
        WHEN USER_DEFINE_ERROR4
            THEN RAISE_APPLICATION_ERROR(-20006,'�̹� ����� �����Դϴ�.');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR5
            THEN RAISE_APPLICATION_ERROR(-20005,'�̹� ���� �� ����� �����Դϴ�.');
                ROLLBACK;
                
        WHEN USER_DEFINE_ERROR6
            THEN RAISE_APPLICATION_ERROR(-20006,'�Ⱓ�� ���� ������ ��û�� �Ұ��մϴ�.');
                ROLLBACK;         
--        WHEN OTHERS
--            THEN ROLLBACK;
END;
--==>> Procedure PRC_COURSES_REG��(��) �����ϵǾ����ϴ�.

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






















