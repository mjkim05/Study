
SELECT USER
FROM DUAL;
--==>> HR


--�� �� �� �̻��� ���̺� ����(JOIN, ����)

-- ���� 1. (SQL 1992 CODE)

SELECT ���̺��1.�÷��� , ���̺��2.�÷���, ���̺��3.�÷���
FROM  ���̺��1, ���̺��2, ���̺��3
WHERE ���̺��1.�÷���1 = ���̺��2.�÷���1 
  AND ���̺��2.�÷���2 = ���̺��3.�÷���2;


-- ���� 2. (SQL 1999 CODE)

SELECT ���̺��1.�÷��� , ���̺��2.�÷���, ���̺��3.�÷���
FROM ���̺��1 JOIN ���̺��2 
ON ���̺��1.�÷���1 = ���̺��2.�÷���1
   JOIN ���̺�� 3
   ON ���̺��2.�÷���2 = ���̺��3.�÷���2;


--�� HR ���� ������ ���̺� �Ǵ� �� ��� ��ȸ
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


--�� HR.JOBS, HR.EMPLOYEES, HR.DEPARTMENTS ���̺��� ������� 
--   �������� �����͸� 
--   FIRST_NAME , LAST_NAME, JOB_TITLE , DEPARTMENT_NAME
--      E           E           J               D

SELECT *
FROM JOBS; 
-- JOB_ID               -- ���� �÷�
SELECT *
FROM EMPLOYEES; 
-- DEPTARTMENT_ID       --- ���� �÷�
SELECT *
FROM DEPARTMENTS; 


-- 1992 ���� 
SELECT E.FIRST_NAME "�̸�", E.LAST_NAME "��", J.JOB_TITLE "����", D.DEPARTMENT_NAME "�μ���"
FROM   JOBS J , EMPLOYEES E, DEPARTMENTS D
WHERE  J.JOB_ID = E.JOB_ID 
  AND  E.DEPARTMENT_ID = D.DEPARTMENT_ID(+);

-- 1999 ����
SELECT E.FIRST_NAME "�̸�", E.LAST_NAME "��", J.JOB_TITLE "����", D.DEPARTMENT_NAME "�μ���"
FROM JOBS J JOIN EMPLOYEES E 
ON J.JOB_ID = E.JOB_ID
   LEFT JOIN DEPARTMENTS D
   ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
   
SELECT E.FIRST_NAME "�̸�", E.LAST_NAME "��", J.JOB_TITLE "����", D.DEPARTMENT_NAME "�μ���"
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D 
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
   JOIN JOBS J
   ON E.JOB_ID = J.JOB_ID;
   
--> ���ΰ��� EMPLOYEES ��� �ָ�!!
   
--==>>
/*

�̸�                   ��                         ����                                  �μ���                           
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

--�� EMPLOYEES , DEPARTMENTS, JOBS, LOCATIONS, COUNTRIES, REGIONS	���̺��� ������� 
--   �������� �����͸� ������ ���� ��ȸ�Ѵ�.
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
SELECT FIRST_NAME "�̸�" , LAST_NAME "��" , JOB_TITLE "������" , DEPARTMENT_NAME "�μ���" , CITY "����" , COUNTRY_NAME "����" , REGION_NAME "���"
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

-- ���� ��
SELECT FIRST_NAME "�̸�" , LAST_NAME "��" , JOB_TITLE "������" , DEPARTMENT_NAME "�μ���" , CITY "����" , COUNTRY_NAME "����" , REGION_NAME "���"
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

-- 1992 .....  ��...��..........

SELECT FIRST_NAME "�̸�" , LAST_NAME "��" , JOB_TITLE "������" , DEPARTMENT_NAME "�μ���" , CITY "����" , COUNTRY_NAME "����" , REGION_NAME "���"
FROM EMPLOYEES E , JOBS J, DEPARTMENTS D, LOCATIONS L, COUNTRIES C, REGIONS R
WHERE R.REGION_ID(+) = C.REGION_ID 
  AND C.COUNTRY_ID(+) = L.COUNTRY_ID 
  AND L.LOCATION_ID = D.LOCATION_ID
  AND D.DEPARTMENT_ID(+) = E.DEPARTMENT_ID 
  AND E.JOB_ID = J.JOB_ID(+);

























