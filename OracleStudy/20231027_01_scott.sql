
SELECT USER
FROM DUAL;


--�� TBL_EMP ���̺��� ����(Ŀ�̼�, COMM)�� ���� ���� ����� 
--   �����ȣ, �����, �μ���ȣ, ������, Ŀ�̼� �׸��� ��ȸ�Ѵ�.

--MAX ���
SELECT EMPNO �����ȣ , ENAME �����, DEPTNO �μ���ȣ, JOB ������, COMM Ŀ�̼�
FROM TBL_EMP
WHERE COMM =  (SELECT MAX(COMM)
               FROM TBL_EMP);
--==>> 7654	MARTIN	30	SALESMAN	1400

--ALL ���
SELECT EMPNO �����ȣ , ENAME �����, DEPTNO �μ���ȣ, JOB ������, COMM Ŀ�̼�
FROM TBL_EMP
WHERE COMM >= ALL(SELECT NVL(COMM , 0)
                  FROM TBL_EMP);
                  
SELECT EMPNO �����ȣ , ENAME �����, DEPTNO �μ���ȣ, JOB ������, COMM Ŀ�̼�
FROM TBL_EMP
WHERE COMM >= ALL(SELECT COMM
                  FROM TBL_EMP
                  WHERE COMM IS NOT NULL);    
--> ó���� �����Ҷ� NULL�� �ƴ� ���� ���� �Ҽ��� �ִ�!                  

--==>> 7654	MARTIN	30	SALESMAN	1400

--RANK ���
SELECT T.EMPNO �����ȣ , T.ENAME �����, T.DEPTNO �μ���ȣ, T.JOB ������, T.COMM Ŀ�̼�
FROM 
(
    SELECT EMPNO , ENAME, DEPTNO, JOB, COMM
         , RANK() OVER(ORDER BY NVL(COMM,0) DESC) "����"
    FROM TBL_EMP
)T
WHERE T.���� = 1;
--==>> 7654	MARTIN	30	SALESMAN	1400

--�� DISTINCT() �ߺ� ��(���ڵ�)�� �����ϴ� �Լ�

-- TBL_EMP ���̺��� �����ڷ� ��ϵ� ����� 
-- �����ȣ, �����, �������� ��ȸ�Ѵ�.

SELECT EMPNO �����ȣ, ENAME �����, JOB ������
FROM TBL_EMP
WHERE EMPNO  IN (SELECT MGR
                 FROM TBL_EMP
                 WHERE MGR IS NOT NULL);
                 
SELECT EMPNO �����ȣ, ENAME �����, JOB ������
FROM TBL_EMP
WHERE EMPNO  IN (SELECT MGR
                 FROM TBL_EMP);
--> ������ �ƴϱ� ������ NULL�� �־ ����

--==>>
/*
7902	FORD	ANALYST
7698	BLAKE	MANAGER
7839	KING	PRESIDENT
7566	JONES	MANAGER
7788	SCOTT	ANALYST
7782	CLARK	MANAGER
*/

SELECT DISTINCT(MGR)
FROM TBL_EMP;
--==>>
/*
7839
(NULL)
7782
7698
7902
7566
7788
*/

SELECT  EMPNO �����ȣ, ENAME �����, JOB ������
FROM TBL_EMP
WHERE EMPNO IN (SELECT DISTINCT(MGR)
                FROM TBL_EMP);

SELECT DISTINCT(JOB)
FROM TBL_EMP;

SELECT DISTINCT(DEPTNO)
FROM TBL_EMP;

--------------------------------------------------------------------------------

SELECT *
FROM TBL_SAWON;
--==>>
/*
1001	������	    9710171234567	2005-01-03	3000
1002	�ڰ���	    9511182234567	1999-11-23	4000
1003	�ڳ���	    9902082234567	2006-08-10	4000
1004	������	    9708112234567	2010-05-06	5000
1005	������	    0502034234567	2015-10-09	1000
1006	������	    0609304234567	2012-06-17	1000
1007	�μ���	    6510102234567	1999-08-22	2000
1008	������	    6909101234567	1998-01-10	2000
1009	���̰�	    0505053234567	2011-05-06	1500
1010	������	6611112234567	2000-01-16	1300
1011	������	    9501061234567	2009-09-19	4000
1012	���켱	    0606064234567	2011-11-11	2000
1013	����	    6511111234567	1999-11-11	2000
1014	������	    9904171234567	2009-11-11	2000
1015	���ù�	    0202023234567	2010-10-10	2300

*/

--�� TBL_SAWON ���̺� ��� (������ ����) �� �� ���̺� ���� ���質 ���� ���� ���� ������ ����

CREATE TABLE TBL_SAWONBACKUP
AS
SELECT *
FROM TBL_SAWON;
--==>> Table TBL_SAWONBACKUP��(��) �����Ǿ����ϴ�.
-- TBL_SAWON ���̺��� �����͵鸸 ����� ����
-- ��, �ٸ� �̸��� ���̺�� ������ �� ��Ȳ


--�� ������ ����
UPDATE TBL_SAWON
SET SANAME = '�ʶ���';
COMMIT;
--==>> 15�� �� ��(��) ������Ʈ�Ǿ����ϴ�.
-- Ŀ�� �Ϸ�.


SELECT *
FROM TBL_SAWON;
--==>>
/*
1001	�ʶ���	9710171234567	2005-01-03	3000
1002	�ʶ���	9511182234567	1999-11-23	4000
1003	�ʶ���	9902082234567	2006-08-10	4000
1004	�ʶ���	9708112234567	2010-05-06	5000
1005	�ʶ���	0502034234567	2015-10-09	1000
1006	�ʶ���	0609304234567	2012-06-17	1000
1007	�ʶ���	6510102234567	1999-08-22	2000
1008	�ʶ���	6909101234567	1998-01-10	2000
1009	�ʶ���	0505053234567	2011-05-06	1500
1010	�ʶ���	6611112234567	2000-01-16	1300
1011	�ʶ���	9501061234567	2009-09-19	4000
1012	�ʶ���	0606064234567	2011-11-11	2000
1013	�ʶ���	6511111234567	1999-11-11	2000
1014	�ʶ���	9904171234567	2009-11-11	2000
1015	�ʶ���	0202023234567	2010-10-10	2300
*/

SELECT SANAME
FROM TBL_SAWONBACKUP;

-- ����� ���� -----------------------------------------------------------------
UPDATE TBL_SAWON
SET SANAME =  (SELECT SANAME
               FROM TBL_SAWONBACKUP)
WHERE SANO IN (SELECT SANO
               FROM TBL_SAWONBACKUP);


UPDATE TBL_SAWON
SET SANAME  (SELECT SANAME
              FROM TBL_SAWONBACKUP);
               
 
SELECT SANAME
FROM TBL_SAWON            
WHERE SANO IN (SELECT SANO
               FROM TBL_SAWONBACKUP);             
              
UPDATE TBL_SAWON      
SET SANAME = (SELECT SANAME
              FROM TBL_SAWONBACKUP
              WHERE SANO IN (SELECT SANO
                             FROM TBL_SAWONBACKUP)             
WHERE SANO IN (SELECT SANO
               FROM TBL_SAWONBACKUP);               
            

UPDATE TBL_SAWON 
SET SANAME = (SELECT SANAME
              FROM TBL_SAWONBACKUP 
              WHERE SANO IN (SELECT SANO
                             FROM TBL_SAWON));
                             
----------------------------------------------------------------���� ��---------             
 
 
UPDATE TBL_SAWON
SET SANAME = ( SELECT S.SANAME
               FROM TBL_SAWONBACKUP S
               WHERE S.SANO = TBL_SAWON.SANO);
               
                            
SELECT *
FROM TBL_SAWON;    

--�� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�           
----���� Ǯ��-------------------------------------------------------------------               
               
UPDATE TBL_SAWON
SET SANAME = (SELECT SANAME
              FROM TBL_SAWONBACKUP
              WHERE SANO = TBL_SAWON.SANO)
WHERE SANAME = '�ʶ���';
               
               
               
