
SELECT USER
FROM DUAL;


--���� FUNCTION(�Լ�) ����-- 

-- 1. �Լ��� �ϳ� �̻��� PL/SQL ������ ������ �����ƾ����
-- �ڵ带 �ٽ� ����� �� �ֵ��� ĸ��ȭ �ϴµ� ���ȴ�.
-- ����Ŭ������ ����Ŭ�� ���ǵ� �⺻ ���� �Լ��� ����ϰų�
-- ���� ������ �Լ��� ���� �� �ִ�.(�� ����� ���� �Լ�)
-- �� ����� ���� �Լ��� �ý��� �Լ� ó�� �������� ȣ���ϰų�
-- ���� ���ν���ó�� EXECUTE ���� ���� ������ �� �ִ�.

--2. ���� �� ���� 
/*
CREATE [OR REPLACE] FUNCTION �Լ���
[( �Ű������� 1 �ڷ���
 , �Ű������� 2 �ڷ���
 )]
RETURN ������ Ÿ��
IS
    -- �ֿ� ���� ����
BEGIN
    -- ���๮;
    
    ...
    RETURN (��);
    
    [EXCEPTION] 
        -- ����ó�� ����;
END;

*/

--�� ����� ���� �Լ�(������ �Լ�)�� 
--   IN �Ķ����(�Է¸Ű�����)�� ����� �� ������
--   �ݵ�� ��ȯ�� ���� ������Ÿ���� RETURN ���� �����ؾ� �ϰ�.
--   FUNCTION �� �ݵ�� ���� ���� ��ȯ�Ѵ�.


--�� TBL_INSA ���̺� ���� ���� Ȯ�� �Լ� ����(����)
--   --------------------
--    �Ű����� ���� ���� �� '771212-1022432' �� 'YYMMDD-NNNNNNN'
-- �Լ��� : FN_GENDER()
--                   �� �ֹε�Ϲ�ȣ �� '771212-1022432' 

CREATE OR REPLACE FUNCTION FN_GENDER(V_SSN VARCHAR2)    -- �Ű�����     : �ڸ���(����) ���� ����
RETURN VARCHAR2                                         -- ��ȯ�ڷ���   : �ڸ���(����) ���� ����
IS 
    -- ����� �� �ֿ� ���� ����(�� �ʱ�ȭ) 
    V_RESULT VARCHAR2(20);
BEGIN
    -- ����� �� ���� �� ó��(�׸��� ����� ��ȯ)
    IF (SUBSTR(V_SSN,8,1) IN ('1','3'))
    THEN V_RESULT := '����';
    ELSIF (SUBSTR(V_SSN,8,1) IN ('2','4'))
    THEN V_RESULT := '����';
    ELSE 
       V_RESULT := '����Ȯ�κҰ�';
    END IF;
    
    -- ����� ��ȯ CHECK~~~!!
    RETURN V_RESULT;
END;
--==>> Function FN_GENDER��(��) �����ϵǾ����ϴ�.

--�� ������ ���� �� ���� �Ű�����(�Է� �Ķ����)�� �Ѱܹ޾� �� (A,B)
--   A�� B�� ���� ��ȯ�ϴ� ����� ���� �Լ��� �ۼ��Ѵ�.
--   ��, ������ ����Ŭ ���� �Լ��� �̿����� �ʰ�, �ݺ����� ����Ͽ� �ۼ��Ѵ�.
--   �Լ��� : FN_POW()
/*
��� ��) 
SELECT FN_POW(10,3)
FROM DUAL;
--==>> 1000
*/

CREATE OR REPLACE FUNCTION FN_POW(V_NUM1 NUMBER , V_NUM2 NUMBER)
RETURN NUMBER
IS
    -- ����� (�ֿ� ���� ���� �� �ʱ�ȭ)
    V_N1 NUMBER := 0;
    V_TOTAL NUMBER := 1;
BEGIN
    -- ����� 
    WHILE V_NUM2 > V_N1 LOOP

     V_TOTAL := V_TOTAL * V_NUM1;               -- ���ϱ�
     V_N1 := V_N1 +1; 
    END LOOP;    
    
    RETURN V_TOTAL;
END;

SELECT FN_POW(10,3)
FROM DUAL;

CREATE OR REPLACE FUNCTION FN_POW(A NUMBER , B NUMBER)
RETURN NUMBER
IS
    V_RESULT NUMBER := 1;   -- ��ȯ ��� �� ���� �� 1�� �ʱ�ȭ~!! CHECK~!!
    V_NUM NUMBER;           -- ���� ����
BEGIN
    -- �ݺ��� ���� 
    FOR V_NUM IN 1.. B LOOP
        V_RESULT := V_RESULT * A;
    END LOOP;
    
    -- ���� ����� ��ȯ
    RETURN V_RESULT;
END;


--�� TBL_INSA ���̺��� �޿� ��� ���� �Լ��� �����Ѵ�.
--   �޿��� ��(�⺻�� * 12) + ���硻 ������� ������ �����Ѵ�.
--   �Լ��� : FN_PAY(�⺻��, ����)

CREATE OR REPLACE FUNCTION FN_PAY(V_BASIC NUMBER , V_SUDANG NUMBER)
RETURN NUMBER
IS  
    -- ����� 
    V_TOTAL NUMBER := 1;        -- �޿� ����� ���� ����
BEGIN 
    -- ����� 
    V_TOTAL := (NVL(V_BASIC,0) * 12 ) + NVL(V_SUDANG,0);
    
    RETURN V_TOTAL;
END;

SELECT FN_PAY(BASICPAY,SUDANG)
FROM TBL_INSA;


--�� TBL_INSA ���̺���
--   �Ի����� �������� ��������� �ٹ������ ��ȯ�ϴ� �Լ��� �����Ѵ�.
--   ��, �ٹ������ �Ҽ��� ���� ���ڸ����� ����Ѵ�.
--   �Լ��� : FN_WORKYEAR(�Ի���)

CREATE OR REPLACE FUNCTION FN_WORKYEAR(V_YEAR DATE)
RETURN NUMBER
IS
    -- �����
    VRESULT NUMBER;

BEGIN 
    -- ����� 
    VRESULT := TRUNC(MONTHS_BETWEEN(SYSDATE ,V_YEAR)/12,1);
    
    RETURN VRESULT;
    
END;


CREATE OR REPLACE FUNCTION FN_WORKYEAR2 (V_YEAR DATE)
RETURN VARCHAR2
IS
    -- �����
    VMONTH NUMBER;
    VYEAR NUMBER;
    VCHAR VARCHAR(100);
BEGIN 
    -- ����� 
    VYEAR := TRUNC(MONTHS_BETWEEN(SYSDATE ,V_YEAR)/12);   
    VMONTH := TRUNC(MOD(MONTHS_BETWEEN(SYSDATE ,V_YEAR),12));       
    
    VCHAR := VYEAR || '�� ' ||  VMONTH || '����' ;
    
    RETURN VCHAR ;
END;

--------------------------------------------------------------------------------

--�� ���� 

-- 1. INSERT, UPDATE, DELETE,(MERGE)
--==>> DML (Data Main[ulation Language)
-- COMMIT / ROLLBACK �� �ʿ��ϴ�.

-- 2. CREATE , DROP, ALTER ,(TRUNCATE)
--==>> DDL(Date Definition Language)
-- �����ϸ� �ڵ����� COMMIT �ȴ�.

-- 3. GRANT, REVOKE
--==>> DCL (Date Control Language)
-- �����ϸ� �ڵ����� COMMIT �ȴ�.

-- 4. COMMIT , ROLLBACK
--==>> TCL (Transaction Control Language)

-- ���� pl/sql�� �� DML ��, TCL ���� ��� �����ϴ�.
-- ���� pl/sql�� �� DML ��, DDL��, DCL��, TCL�� ��� �����ϴ�.

--------------------------------------------------------------------------------

--���� PROCEDURE (���ν���)����--

-- 1. PL/SQL ���� ���� ��ǥ���� ������ ������ ���ν����� 
--    �����ڰ� ���� �ۼ��ؾ� �ϴ� ������ �帧��
--    �̸� �ۼ��Ͽ� �����ͺ��̽� ���� ������ �ξ��ٰ�
--    �ʿ��� �� ���� ȣ���Ͽ� ������ �� �ֵ��� ó�����ִ� �����̴�.

-- 2. ���� �� ���� 
/*
CREATE [OR REPLACE] PROCEDURE ���ν����� 
[( �Ű����� IN ������ Ÿ��
 , �Ű����� OUT ������ Ÿ��
 , �Ű����� INOUT ������ Ÿ��
 )]
 IS
    [--�ֿ� ���� ����]
 BEGIN 
    -- ���౸��; 
    
    ...
    [EXCEPTION 
        -- ����ó�� ����;]

 END;
*/

-- �� FUNCTION �� �� ������ ��RETURN ��ȯ�ڷ����� �κ��� �������� ������,
--    ��RETURN���� ��ü�� �������� �ʰ�,
--    ���ν��� ����� �Ѱ��ְ� �Ǵ� �Ű������� ������
--    IN(�Է�) , OUT(���) , INOUT(�����) ���� ���еȴ�.

-- 3. ����(ȣ��)
/*
EXE[CUTE] ���ν�����[(�μ�1, �μ�2,...)];
*/

--�� ���ν��� �ǽ��� ���� ���̺� ������...
-- ��20231103_02_scott.sql�� ���� ����~!!


--�� ���ν��� ���� 
-- ���ν����� : PRC_STUDENT_INSERT(���̵�. �н�����, �̸�, ��ȭ, �ּ�)

CREATE OR REPLACE PROCEDURE PRC_STUDENT_INSERT
( ���̵�
, �н�����
, �̸�
, ��ȭ
, �ּ�
)
IS 
BEGIN
END;

CREATE OR REPLACE PROCEDURE PRC_STUDENT_INSERT
( V_ID      IN TBL_IDPW.ID%TYPE
, V_PW      IN TBL_IDPW.PW%TYPE
, V_NAME    IN TBL_STUDENTS.NAME%TYPE
, V_TEL     IN TBL_STUDENTS.TEL%TYPE
, V_ADDR    IN TBL_STUDENTS.ADDR%TYPE
)
IS 
    -- ���� ���� �� �� ������ �׳� ����θ� ��
BEGIN
    -- TBL_IDPW ���̺� ������ �Է� �� INSERT 
    INSERT INTO TBL_IDPW(ID,PW)
    VALUES(V_ID,V_PW);
    -- TBL_STUDENTS ���̺� ������ �Է� �� INSERT
    INSERT INTO TBL_STUDENTS(ID,NAME,TEL,ADDR)
    VALUES(V_ID,V_NAME,V_TEL,V_ADDR);
    -- Ŀ�� 
    COMMIT;
END;
--==>> Procedure PRC_STUDENT_INSERT��(��) �����ϵǾ����ϴ�.

--------------------------------------------------------------------------------
--�� ���ν��� �ǽ��� ���� ���̺� ������...
-- ��20231103_02_scott.sql�� ���� ����~!!

--�� ������ �Է� �� Ư�� �׸��� �����͸� �Է��ϸ�
--   ���������� �ٸ� �߰��׸� ���� ó���� �Բ� �̷���� �� �ֵ��� �ϴ� 
--   ���ν����� �ۼ��Ѵ�.(�����Ѵ�.)
--   ���ν����� : PRC_SUNGJUK_INSERT()
/*
�����ν�) 
���� TBL_SUNGJUK ���̺��� 

HAKBUN ,NAME ,KOR,ENG,MAT,TOT  ,AVG ,GRAED     
(�й�, �̸� , ��������, ��������, ��������, ����, ���, ���)
Į������ �����Ǿ� �ִ�.
�� ���̺��� ������� Ư�� �׸�(�й�, �̸�, ��������, ��������, ��������)�� �Է��ϸ�
�߰� �׸�(����, ���, ���)�� �˾Ƽ� ó�� �� �� �ֵ��� ���ν����� �����϶�� ���̴�.

���� ��)

EXEC PRC_SUNGJUK_INSERT(1,'��ٽ�',90,80,70);

�� �̿� ���� ���ν��� ȣ��� ó���� ���

�й� �̸�   �������� �������� ���� ����  ���� ���  ��� 
1   '��ٽ�' 90       80         70      240   80    B

*/


CREATE OR REPLACE PROCEDURE PRC_SUNGJUK_INSERT
( V_HAK  IN TBL_SUNGJUK.HAKBUN%TYPE
, V_NAME IN TBL_SUNGJUK.NAME%TYPE
, V_KOR  IN TBL_SUNGJUK.KOR%TYPE
, V_ENG  IN TBL_SUNGJUK.ENG%TYPE
, V_MAT  IN TBL_SUNGJUK.MAT%TYPE
)
IS
    -- �����
    -- INSERT �������� �����ϱ� ���� �ʿ��� �߰� ���� ����
    V_TOT TBL_SUNGJUK.TOT%TYPE := 0;
    V_AVG TBL_SUNGJUK.AVG%TYPE := 0;
    V_GRAED TBL_SUNGJUK.GRAED%TYPE;
    
BEGIN
    -- ����� 
    -- ����ο� �߰��� �ֿ� �����鿡 ���� ��Ƴ��� �Ѵ�.
    
    V_TOT   := (V_KOR + V_ENG + V_MAT);
    V_AVG   := TRUNC((V_TOT/3),1);
    
    IF V_AVG >= 90
        THEN V_GRAED := 'A';
    ELSIF V_AVG >= 80
        THEN V_GRAED :='B';  
    ELSIF V_AVG >= 70
        THEN V_GRAED :='C';   
    ELSIF V_AVG >= 60
        THEN V_GRAED :='D'; 
    ELSE V_GRAED :='F';   
    END IF;
    
    -- INSERT ������ ����
    INSERT INTO TBL_SUNGJUK (HAKBUN, NAME, KOR, ENG, MAT, TOT, AVG, GRAED)
    VALUES (V_HAK, V_NAME,V_KOR,V_ENG,V_MAT,V_TOT,V_AVG,V_GRAED);
    
    -- Ŀ�� 
    COMMIT;      
END;
--==>> Procedure PRC_SUNGJUK_INSERT��(��) �����ϵǾ����ϴ�.

--�� TBL_SUNGJUK ���̺��� Ư�� �л��� ����
--   (�й�, ��������, ��������, ��������) ������ ������
--   ����, ���, ��ޱ��� �Բ� �����Ǵ� ���ν����� �����Ѵ�.
--   ���ν����� : PRC_SUNGJUK_UPDATE()

/*
���� ��)
EXEC PRC_SUNGJUCK_UPDATE(2,50,50,50);

--> �̿� ���� ���ν��� ȣ��� ó���� ��� 

�й� �̸�   �������� �������� ���� ����  ���� ���  ��� 
1   '��ٽ�' 90       80         70      240   80    B
2   '������' 50       50         50      150   50    F
*/

CREATE OR REPLACE PROCEDURE PRC_SUNGJUK_UPDATE
( V_HAK  IN   TBL_SUNGJUK.HAKBUN%TYPE
, V_KOR  IN   TBL_SUNGJUK.KOR%TYPE
, V_ENG  IN   TBL_SUNGJUK.ENG%TYPE
, V_MAT  IN   TBL_SUNGJUK.MAT%TYPE
)
IS
    -- �����
    V_TOT   TBL_SUNGJUK.TOT%TYPE;
    V_AVG   TBL_SUNGJUK.AVG%TYPE;
    V_GRAED  TBL_SUNGJUK.GRAED%TYPE;    
BEGIN 
    -- ����� 
    V_TOT := V_KOR + V_MAT + V_ENG;
    V_AVG := V_TOT / 3;
     
    IF V_AVG >= 90
        THEN V_GRAED  :='A';
    ELSIF V_AVG >= 80
        THEN V_GRAED  :='B';  
    ELSIF V_AVG >= 70
        THEN V_GRAED  :='C';   
    ELSIF V_AVG >= 60
        THEN V_GRAED  :='D'; 
    ELSE V_GRAED  :='F';   
    END IF;
    
    -- UPDATE ������ ���� 
    UPDATE TBL_SUNGJUK 
    SET KOR = V_KOR , ENG = V_ENG , MAT = V_MAT , TOT = V_TOT , AVG = V_AVG , GRAED  = V_GRAED 
    WHERE HAKBUN = V_HAK;
    
    -- Ŀ��
    COMMIT;
    
END;
--==>> Procedure PRC_SUNGJUK_UPDATE��(��) �����ϵǾ����ϴ�.

--�� TBL_STUDENTS ���̺��� ��ȭ��ȣ�� �ּ� �����͸� �����ϴ�(�����ϴ�)
--   ���ν����� �ۼ��Ѵ�.
--   ��, ID�� PW�� ��ġ�ϴ� ��쿡�� ������ ������ �� �ֵ��� ó���Ѵ�.
--   ���ν����� : PRC_STUDENT_UPDATE()
/*
���� ��)
EXEC PRC_STUDENT_UPDATE('moon','java000','010-9999-9999','������ Ⱦ��');
--==>> ������ ���� ��

EXEC PRC_STUDENT_UPDATE('moon','java006$','010-9999-9999','������ Ⱦ��');
--==>> ������ ���� ��
*/

CREATE OR REPLACE PROCEDURE PRC_STUDENT_UPDATE
( V_ID   IN TBL_IDPW.ID%TYPE
, V_PW   IN TBL_IDPW.PW%TYPE
, V_TEL  IN TBL_STUDENTS.TEL%TYPE
, V_ADDR IN TBL_STUDENTS.ADDR%TYPE
)
IS
BEGIN
    UPDATE TBL_STUDENTS
    SET TEL = V_TEL , ADDR = V_ADDR
    WHERE ID = V_ID
      AND V_PW = (SELECT PW
                  FROM TBL_IDPW
                  WHERE ID = V_ID);
    COMMIT;              
END;
















