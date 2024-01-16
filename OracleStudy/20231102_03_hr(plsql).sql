SELECT USER
FROM DUAL;
--==>> HR

--�� %TYPE 

-- 1. Ư�� ���̺��� ���ԵǾ� �ִ� �÷��� ������Ÿ��(�ڷ���)�� �����ϴ� ������Ÿ��

-- 2. ���� �� ����
-- ������ ���̺�.�÷���%TYPE [:= �ʱⰪ];

SET SERVEROUTPUT ON;                    -- ���� �ٲܶ����� ����Ǵ� ���� ���������!!!

-- HR.EMPLOYEES ���̺��� Ư�� �����͸� ������ ����

DECLARE
    --V_NAME VARCHAR2(20);
    V_NAME EMPLOYEES.FIRST_NAME%TYPE;
BEGIN 
    SELECT FIRST_NAME INTO V_NAME
    FROM EMPLOYEES 
    WHERE EMPLOYEE_ID = 103;
    
    DBMS_OUTPUT.PUT_LINE(V_NAME);
END;
--==>>
/*
Alexander


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/

--�� EMPLOYEES ���̺��� ������� 108�� ���(Nancy)�� 
--   SALARY�� ������ ��� ����ϴ� PL/SQL ������ �ۼ��Ѵ�.


DECLARE
    SAL EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT SALARY INTO SAL
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 108;
    
    DBMS_OUTPUT.PUT_LINE(SAL);
END;
--==>>
/*
12008


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/

--�� EMPLOYEES ���̺��� Ư�� ���ڵ� �׸� ���� ���� ������ ����
--   103�� ����� FIRST_NAME PHONE NUMBER, EMAIL �׺��� ������ �����Ͽ� ���
--   Alexander,	590.423.4567, AHUNOLD

DECLARE
    V_NAME EMPLOYEES.FIRST_NAME%TYPE;
    V_TEL EMPLOYEES.PHONE_NUMBER%TYPE;
    V_EMAIL EMPLOYEES.EMAIL%TYPE;
BEGIN
    SELECT FIRST_NAME, PHONE_NUMBER , EMAIL INTO V_NAME , V_TEL ,V_EMAIL
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 103;
    
    DBMS_OUTPUT.PUT_LINE(V_NAME ||', ' || V_TEL || ', ' || V_EMAIL);

END;
--==>>
/*
Alexander, 590.423.4567, AHUNOLD


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.

*/

SELECT *
FROM EMPLOYEES;


--�� %ROWTYPE

-- 1. ���̺��� ���ڵ�� ���� ������ ����ü ������ ����(�������� Į��)

-- 2. ���� �� ����
-- ������ ���̺��%ROWTYPE;

DECLARE
    --V_FIRST_NAME    EMPLOYEES.FIRST_NAME%TYPE;
    --V_PHONE_NUMBER  EMPLOYEES.PHONE_NUMBER%TYPE;
    --V_EMAIL         EMPLOYEES.EMAIL%TYPE;
    
    V_EMP EMPLOYEES%ROWTYPE;
BEGIN 
    SELECT FIRST_NAME, PHONE_NUMBER , EMAIL 
           INTO V_EMP.FIRST_NAME ,V_EMP.PHONE_NUMBER , V_EMP.EMAIL
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 103;
    --  DBMS_OUTPUT.PUT_LINE(V_FIRST_NAME ||', ' || V_PHONE_NUMBER || ', ' || V_EMAIL);
    DBMS_OUTPUT.PUT_LINE(V_EMP.FIRST_NAME ||', ' || V_EMP.PHONE_NUMBER || ', ' || V_EMP.EMAIL);
END;
--==>>
/*
Alexander, 590.423.4567, AHUNOLD


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/

--�� EMPLOYEES ���̺��� ��ü ���ڵ� �׸� ���� ���� ������ ����
--   ��� ����� FIRST_NAME , PHONE_NUMBER, EMAIL �׸��� ������ �����Ͽ� ���

DECLARE
    V_EMP EMPLOYEES%ROWTYPE;
BEGIN
    SELECT FIRST_NAME, PHONE_NUMBER, EMAIL 
           INTO V_EMP.FIRST_NAME , V_EMP.PHONE_NUMBER, V_EMP.EMAIL
    FROM EMPLOYEES;
    
    DBMS_OUTPUT.PUT_LINE( V_EMP.FIRST_NAME ||' , '|| V_EMP.PHONE_NUMBER ||' , '|| V_EMP.EMAIL);
END;
--==>> ���� �߻�
-- (ORA-01422: exact fetch returns more than requested number of rows)

--> ���� ���� ��(ROWS) ������ ���� �������� �ϸ�
--  ���� ������ �����ϴ� �� ��ü�� �Ұ���������.






