SELECT USER
FROM DUAL;
--==>> SCOTT

--�� ������ ����(UPDATE �� TBL_DEPT)
UPDATE TBL_DEPT
SET DNAME = '������', LOC = '���'
WHERE DEPTNO = 50;
--==>> 1 �� ��(��) ������Ʈ�Ǿ����ϴ�.


--�� Ȯ��
SELECT *
FROM TBL_DEPT;
--==>>
/*
10   ACCOUNTING   NEW YORK
20   RESEARCH   DALLAS
30   SALES       CHICAGO
40   OPERATIONS   BOSTON
50   ������       ���
*/


--�� �ѹ�
ROLLBACK;
--==>> �ѹ� �Ϸ�.


--�� �ѹ� ���� �ٽ� Ȯ��
SELECT *
FROM TBL_DEPT;
--==>>
/*
10   ACCOUNTING   NEW YORK
20   RESEARCH   DALLAS
30   SALES       CHICAGO
40   OPERATIONS   BOSTON
50   ���ߺ�       ����
*/


--�� ������ ����
UPDATE TBL_DEPT
SET DNAME = '������', LOC = '��õ'
WHERE DEPTNO = 50;
--==>> 1 �� ��(��) ������Ʈ�Ǿ����ϴ�.


--�� Ȯ��
SELECT *
FROM TBL_DEPT;
--==>> 
/*
10   ACCOUNTING   NEW YORK
20   RESEARCH   DALLAS
30   SALES       CHICAGO
40   OPERATIONS   BOSTON
50   ������       ��õ
*/


--�� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.


--�� �ѹ�
ROLLBACK;
--==>> �ѹ� �Ϸ�.


--�� Ȯ��
SELECT *
FROM TBL_DEPT;
--==>>
/*
10   ACCOUNTING   NEW YORK
20   RESEARCH   DALLAS
30   SALES       CHICAGO
40   OPERATIONS   BOSTON
50   ������       ��õ
*/


--�� ������ ����(DELETE �� TBL_DEPT)
DELETE TBL_DEPT
WHERE DEPTNO = 50;

SELECT *
FROM TBL_DEPT
WHERE DEPTNO = 50;

DELETE
FROM TBL_DEPT
WHERE DEPTNO = 50;
--==>> 1 �� ��(��) �����Ǿ����ϴ�.


--�� Ȯ��
SELECT *
FROM TBL_DEPT;

COMMIT;
--==> Ŀ�� �Ϸ�.

--------------------------------------------------------------------------------

--���� ORDER BY �� ����--

SELECT ENAME �����, DEPTNO �μ���ȣ, JOB ����, SAL �޿� , SAL*12 + NVL(COMM,0) ����
FROM EMP;
--==>>
/*
SMITH	20	CLERK	    800	    9600
ALLEN	30	SALESMAN	1600	19500
WARD	30	SALESMAN	1250	15500
JONES	20	MANAGER	    2975	35700
MARTIN	30	SALESMAN	1250	16400
BLAKE	30	MANAGER	    2850	34200
CLARK	10	MANAGER 	2450	29400
SCOTT	20	ANALYST	    3000	36000
KING	10	PRESIDENT	5000	60000
TURNER	30	SALESMAN	1500	18000
ADAMS	20	CLERK	    1100	13200
JAMES	30	CLERK	    950	    11400
FORD	20	ANALYST	    3000	36000
MILLER	10	CLERK	    1300	15600
*/

SELECT ENAME �����, DEPTNO �μ���ȣ, JOB ����, SAL �޿� , SAL*12 + NVL(COMM,0) ����
FROM EMP
ORDER BY DEPTNO ASC;                -- DEPTNO �� ���� ���� : �μ���ȣ
                                    -- ASC    �� ���� ���� : �������� 
--==>>
/*
CLARK	10	MANAGER	    2450	29400
KING	10	PRESIDENT	5000	60000
MILLER	10	CLERK	    1300	15600
JONES	20	MANAGER	    2975	35700
FORD	20	ANALYST	    3000	36000
ADAMS	20	CLERK	    1100	13200
SMITH	20	CLERK	     800 	 9600
SCOTT	20	ANALYST	    3000	36000
WARD	30	SALESMAN	1250	15500
TURNER	30	SALESMAN	1500	18000
ALLEN	30	SALESMAN	1600	19500
JAMES	30	CLERK	     950    11400
BLAKE	30	MANAGER	    2850	34200
MARTIN	30	SALESMAN	1250	16400
*/

SELECT ENAME �����, DEPTNO �μ���ȣ, JOB ����, SAL �޿� , SAL*12 + NVL(COMM,0) ����
FROM EMP
ORDER BY DEPTNO; 
--==>> �������� ��� ���ص� �⺻������ ��������
/*
CLARK	10	MANAGER	    2450	29400
KING	10	PRESIDENT	5000	60000
MILLER	10	CLERK	    1300	15600
JONES	20	MANAGER 	2975	35700
FORD	20	ANALYST	    3000	36000
ADAMS	20	CLERK	    1100	13200
SMITH	20	CLERK	    800	     9600
SCOTT	20	ANALYST	    3000	36000
WARD	30	SALESMAN	1250	15500
TURNER	30	SALESMAN	1500	18000
ALLEN	30	SALESMAN	1600	19500
JAMES	30	CLERK	     950	11400
BLAKE	30	MANAGER	    2850	34200
MARTIN	30	SALESMAN	1250	16400
*/

SELECT ENAME �����, DEPTNO �μ���ȣ, JOB ����, SAL �޿� , SAL*12 + NVL(COMM,0) ����
FROM EMP
ORDER BY DEPTNO DESC;                 -- DEPTNO �� ���� ���� : �μ���ȣ
                                      -- DESC   �� ���� ���� : ��������
--==>>
/*
BLAKE	30	MANAGER	    2850	34200
TURNER	30	SALESMAN	1500	18000
ALLEN	30	SALESMAN	1600	19500
MARTIN	30	SALESMAN	1250	16400
WARD	30	SALESMAN	1250	15500
JAMES	30	CLERK	     950	11400
SCOTT	20	ANALYST 	3000	36000
JONES	20	MANAGER	    2975	35700
SMITH	20	CLERK	     800     9600
ADAMS	20	CLERK	    1100	13200
FORD	20	ANALYST	    3000	36000
KING	10	PRESIDENT	5000	60000
MILLER	10	CLERK	    1300	15600
CLARK	10	MANAGER	    2450	29400
*/

SELECT ENAME �����, DEPTNO �μ���ȣ, JOB ����, SAL �޿� , SAL*12 + NVL(COMM,0) ����
FROM EMP
ORDER BY ���� DESC;       -- ��Ī�� �˰� �ִ� ,  SELECT ������ �ʰ� �Ľ� �Ǵϱ� �������� �� �ȶ���
--==>>
/*
KING	10	PRESIDENT	5000	60000
FORD	20	ANALYST	    3000	36000
SCOTT	20	ANALYST	    3000	36000
JONES	20	MANAGER	    2975	35700
BLAKE	30	MANAGER	    2850	34200
CLARK	10	MANAGER	    2450	29400
ALLEN	30	SALESMAN	1600	19500
TURNER	30	SALESMAN	1500	18000
MARTIN	30	SALESMAN	1250	16400
MILLER	10	CLERK	    1300	15600
WARD	30	SALESMAN	1250	15500
ADAMS	20	CLERK	    1100	13200
JAMES	30	CLERK	     950	11400
SMITH	20	CLERK	     800	 9600
*/

SELECT ENAME �����, DEPTNO �μ���ȣ, JOB ����, SAL �޿� , SAL*12 + NVL(COMM,0) ����
FROM EMP
ORDER BY 2;                               -- ����ڰ� ��ȸ�ϴ� �÷� ���� �� �μ���ȣ ��������
--> EMP ���̺��� �����ִ� ���̺��� ������ �÷� ����(2 �� ENAME)�� �ƴ϶�
--  SELECT ó�� �Ǵ� �� ��° Į��(2: DEPTNO, �μ���ȣ)�� �������� ����
--  ASC�� ������ ���� �� �������� ����
--  ����Ŭ���� �⺻ �ε����� �ڹٿ� �޸� 1���� ����
--  ����������.. ���� ��ORDER BY 2�������� �� ��ORDER BY DEPTNO ASC���̴�.
--==>>
/*
CLARK	10	MANAGER	2450	29400
KING	10	PRESIDENT	5000	60000
MILLER	10	CLERK	1300	15600
JONES	20	MANAGER	2975	35700
FORD	20	ANALYST	3000	36000
ADAMS	20	CLERK	1100	13200
SMITH	20	CLERK	800	9600
SCOTT	20	ANALYST	3000	36000
WARD	30	SALESMAN	1250	15500
TURNER	30	SALESMAN	1500	18000
ALLEN	30	SALESMAN	1600	19500
JAMES	30	CLERK	950	11400
BLAKE	30	MANAGER	2850	34200
MARTIN	30	SALESMAN	1250	16400
*/

SELECT ENAME �����, DEPTNO �μ���ȣ, JOB ����, SAL �޿� , SAL*12 + NVL(COMM,0) ����
FROM EMP
ORDER BY 2, 4; 
-- �μ���ȣ, �޿� ���� �������� ����
--  (1��)      (2��)
--==>>
/*
MILLER	10	CLERK	    1300	15600
CLARK	10	MANAGER 	2450	29400
KING	10	PRESIDENT	5000	60000
SMITH	20	CLERK	     800	 9600
ADAMS	20	CLERK	    1100	13200
JONES	20	MANAGER	    2975	35700
SCOTT	20	ANALYST	    3000	36000
FORD	20	ANALYST	    3000	36000
JAMES	30	CLERK	     950	11400
MARTIN	30	SALESMAN	1250	16400
WARD	30	SALESMAN	1250	15500
TURNER	30	SALESMAN	1500	18000
ALLEN	30	SALESMAN	1600	19500
BLAKE	30	MANAGER	    2850	34200
*/

SELECT ENAME, DEPTNO, JOB, SAL
FROM EMP
ORDER BY 2, 3, 4 DESC;
-- �� 2       �� DEPTNO(�μ���ȣ)���� �������� ����
-- �� 3       �� JOB(������) ���� �������� ����
-- �� 4       �� SAL(�޿�)���� �ڡ� ��������(DESC) ���� �ڡ�
--==>>
/*
MILLER	10	CLERK	    1300
CLARK	10	MANAGER 	2450
KING	10	PRESIDENT	5000
SCOTT	20	ANALYST	    3000
FORD	20	ANALYST	    3000
ADAMS	20	CLERK	    1100
SMITH	20	CLERK	     800
JONES	20	MANAGER	    2975
JAMES	30	CLERK	     950
BLAKE	30	MANAGER	    2850
ALLEN	30	SALESMAN	1600
TURNER	30	SALESMAN	1500
MARTIN	30	SALESMAN	1250
WARD	30	SALESMAN	1250
*/

--------------------------------------------------------------------------------

--�� CONCAT()
SELECT ENAME || JOB "COL1"
       ,CONCAT(ENAME, JOB) "COL2"
FROM EMP;
--==>>
/*
SMITHCLERK	SMITHCLERK
ALLENSALESMAN	ALLENSALESMAN
WARDSALESMAN	WARDSALESMAN
JONESMANAGER	JONESMANAGER
MARTINSALESMAN	MARTINSALESMAN
BLAKEMANAGER	BLAKEMANAGER
CLARKMANAGER	CLARKMANAGER
SCOTTANALYST	SCOTTANALYST
KINGPRESIDENT	KINGPRESIDENT
TURNERSALESMAN	TURNERSALESMAN
ADAMSCLERK	ADAMSCLERK
JAMESCLERK	JAMESCLERK
FORDANALYST	FORDANALYST
MILLERCLERK	MILLERCLERK
*/

-- ���ڿ� ������� ������ ������ �����ϴ� �Լ� CONCAT()
-- ������ 2���� ���ڿ��� ���ս�ų �� �ִ�. 

SELECT '����' || '����ϸ�' || '������' COL1
        , CONCAT('����', '����ϸ�','������') COL2
FROM DUAL;
--==>> �����߻�
--     ORA-00909: invalid number of argument


-- �����, ������, �μ���ȣ

SELECT CONCAT(CONCAT(ENAME,JOB),DEPTNO) COL1
FROM EMP;
--==>>
/*
SMITHCLERK20
ALLENSALESMAN30
WARDSALESMAN30
JONESMANAGER20
MARTINSALESMAN30
BLAKEMANAGER30
CLARKMANAGER10
SCOTTANALYST20
KINGPRESIDENT10
TURNERSALESMAN30
ADAMSCLERK20
JAMESCLERK30
FORDANALYST20
MILLERCLERK10
*/

--> �������� �� ��ȯ�� �Ͼ�� ������ �����ϰ� �ȴ�.
--  CIONCAT()�� ���ڿ��� ���ڿ��� ���ս����ִ� �Լ�������
--  ���������� ���ڳ� ��¥�� ���ڷ� ��ȯ���ִ� ������ ���ԵǾ� �ִ�.

/*
obj.substring()
---
���ڿ� �� ���ڿ�.substring(n,m);
                          -----
                          ���ڿ��� n���� m-1 ����...(�ε����� 0����)
*/

--�� SUBSTR() ���� ��� / SUBSTRB() ����Ʈ ���

SELECT ENAME "COL1"
     , SUBSTR(ENAME, 1, 2) "COL2"
FROM EMP;
--> ���ڿ��� �����ϴ� ����� ���� �Լ�
--  ù ��° �Ķ���� ���� ��� ���ڿ�(������ ���, TARGET)
--  �� ��° �Ķ���� ���� ������ �����ϴ� ��ġ(�ε���. START) �� �ε����� 1���� ����...
--  �� ��° �Ķ���� ���� ������ ���ڿ��� ����(����, COUNT) �� ���� ��...  ���ڿ� ���� ������... 
--==>>
/*
SMITH	SM
ALLEN	AL
WARD	WA
JONES	JO
MARTIN	MA
BLAKE	BL
CLARK	CL
SCOTT	SC
KING	KI
TURNER	TU
ADAMS	AD
JAMES	JA
FORD	FO
MILLER	MI
*/


SELECT ENAME COL1
      ,SUBSTR(ENAME, 3, 2) COL2
      ,SUBSTR(ENAME, 3, 5) COL3
      ,SUBSTR(ENAME, 3 ) COL4
      ,SUBSTR(ENAME, 6, 1) COL5
FROM EMP;
--==>>
/*
SMITH	IT	ITH	    ITH	
ALLEN	LE	LEN	    LEN	
WARD	RD	RD	    RD	
JONES	NE	NES 	NES	
MARTIN	RT	RTIN	RTIN	N
BLAKE	AK	AKE 	AKE	
CLARK	AR	ARK	    ARK	
SCOTT	OT	OTT	    OTT	
KING	NG	NG	    NG	
TURNER	RN	RNER	RNER	R
ADAMS	AM	AMS	    AMS	
JAMES	ME	MES	    MES	
FORD	RD	RD	    RD	
MILLER	LL	LLER	LLER	R
*/

--�� TBL_SAWON ���̺��� ������ ������ �����
--   �����ȣ, �����, �ֹι�ȣ, �޿� �׸��� ��ȸ�Ѵ�.
--   ��, SUBSTR() �Լ��� ����Ͽ� ó�� �� �� �ֵ��� �Ѵ�.

SELECT SANO �����ȣ, SANAME �����, JUBUN �ֹι�ȣ, SAL �޿�
FROM TBL_SAWON
WHERE SUBSTR(JUBUN, 7, 1) = '1' OR SUBSTR(JUBUN, 7, 1) = '3'; 
-- SUBSTR �� ���ڿ��� �����ϱ� ������ ��'�� �������� �ȵ˴ϴ�!><
-- �ڵ� ����ȯ ������..
--==>>
/*
1001	������	9710171234567	3000
1008	������	6909101234567	2000
1009	���̰�	0505053234567	1500
1011	������	9501061234567	4000
1013	����	6511111234567	2000
1014	������	9904171234567	2000
1015	���ù�	0202023234567	2300
*/

SELECT SANO �����ȣ, SANAME �����, JUBUN �ֹι�ȣ, SAL �޿�
FROM TBL_SAWON
WHERE SUBSTR(JUBUN, 7, 1) IN ('1','3');
--==>>
/*
1001	������	9710171234567	3000
1008	������	6909101234567	2000
1009	���̰�	0505053234567	1500
1011	������	9501061234567	4000
1013	����	6511111234567	2000
1014	������	9904171234567	2000
1015	���ù�	0202023234567	2300
*/


--�� LENGTH() ���� ��  / LENGTHB() ����Ʈ ��

SELECT ENAME COL
    ,  LENGTH(ENAME) COL2
    ,  LENGTHB(ENAME) COL3
FROM EMP;
--==>>
/*
SMITH	5	5
ALLEN	5	5
WARD	4	4
JONES	5	5
MARTIN	6	6
BLAKE	5	5
CLARK	5	5
SCOTT	5	5
KING	4	4
TURNER	6	6
ADAMS	5	5
JAMES	5	5
FORD	4	4
MILLER	6	6
*/

--�� INSTR()

SELECT 'ORACLE ORAHOME BIORA' COL1
      , INSTR('ORACLE ORAHOME BIORA', 'ORA',1, 1) COL2          -- 1
      , INSTR('ORACLE ORAHOME BIORA', 'ORA',1, 2) COL3          -- 8
      , INSTR('ORACLE ORAHOME BIORA', 'ORA',2, 1) COL3          -- 8
      , INSTR('ORACLE ORAHOME BIORA', 'ORA',2) COL4             -- 8
      , INSTR('ORACLE ORAHOME BIORA', 'ORA',2, 3) COL5          -- 0
FROM DUAL;
--==>> ORACLE ORAHOME BIORA	1	8	8	8	0
--> ù ��° �Ķ���� ���� �ش��ϴ� ���ڿ�����... (��� ���ڿ�, TARGET)
--  �� ��° �Ķ���� ���� �� ���� ���� �Ѱ��� ���ڿ��� �����ϴ� ��ġ�� ã�ƶ�~!!
--  �� ��° �Ķ���� ���� ã�� �����ϴ�(��ĵ�� �����ϴ�) ��ġ
--  �� ��° �Ķ���� ���� �� ��° �����ϴ� ���� ã�� �������� ���� ���� �� (1�� ��� ���� ����) --COL4, COL5 ���� �����̴�.

SELECT '���ǿ���Ŭ �����ο��� �մϴ�.' COL1
      , INSTR('���ǿ���Ŭ �����ο��� �մϴ�.', '����' ,1) COL2         -- 3
      , INSTR('���ǿ���Ŭ �����ο��� �մϴ�.', '����' ,2) COL3         -- 3
      , INSTR('���ǿ���Ŭ �����ο��� �մϴ�.', '����' ,10) COL4        -- 10
      , INSTR('���ǿ���Ŭ �����ο��� �մϴ�.', '����', 11) COL5        -- 0
FROM DUAL;
--==>> ���ǿ���Ŭ �����ο��� �մϴ�.	3	3	10	0
--> ������ �Ķ���� ���� ������ ���·� ��� �� ������ �Ķ���� �� 1


--�� REVERSE()

SELECT 'ORACLE' COL1
      ,REVERSE('ORACLE') COL2
      ,REVERSE('����Ŭ') COL3
FROM DUAL;
--==>> ORACLE	ELCARO ???
-- ��� ���ڿ��� �Ųٷ� ��ȯ�Ѵ�. (��, �ѱ��� ���� - ��� �Ұ�)

--�� �ǽ� ���̺� ���� (TBL_FILES)
CREATE TABLE TBL_FILES
(FILENO         NUMBER(3)
,FILENAME       VARCHAR2(100)
);
--==>> Table TBL_FILES��(��) �����Ǿ����ϴ�.

--�� ������ �Է� 
INSERT INTO TBL_FILES VALUES (1, 'C:\AAA\BBB\CCC\SALES.DOC');
INSERT INTO TBL_FILES VALUES (2, 'C:\AAA\PANMAE.XXLS');
INSERT INTO TBL_FILES VALUES (3, 'D:\RESEARCH.PPT');
INSERT INTO TBL_FILES VALUES (4, 'C:\DOCUMENTS\STUDY.HWP');
INSERT INTO TBL_FILES VALUES (5, 'D:\DOCUMENTS\TEMP\HOMEWORK\SQL.TXT');
INSERT INTO TBL_FILES VALUES (6, 'C:\SHARE\F\TEST\FLOWER.PNG');
INSERT INTO TBL_FILES VALUES (7, 'E:\STUDY\ORACLE\20231020_01_SCOTT.SQL');
--==>> 1 �� ��(��) ���ԵǾ����ϴ�. * 7

SELECT *
FROM TBL_FILES;
--==>> 
/*
1	C:\AAA\BBB\CCC\SALES.DOC
2	C:\AAA\PANMAE.XXLS
3	D:\RESEARCH.PPT
4	C:\DOCUMENTS\STUDY.HWP
5	D:\DOCUMENTS\TEMP\HOMEWORK\SQL.TXT
6	C:\SHARE\F\TEST\FLOWER.PNG
7	E:\STUDY\ORACLE\20231020_01_SCOTT.SQL
*/

--�� Ŀ�� 
COMMIT;
--==>> Ŀ�� �Ϸ�


SELECT FILENO ���Ϲ�ȣ
      ,FILENAME ���ϸ�
FROM TBL_FILES ;
--==>>
/*
1	C:\AAA\BBB\CCC\SALES.DOC
2	C:\AAA\PANMAE.XXLS
3	D:\RESEARCH.PPT
4	C:\DOCUMENTS\STUDY.HWP
5	D:\DOCUMENTS\TEMP\HOMEWORK\SQL.TXT
6	C:\SHARE\F\TEST\FLOWER.PNG
7	E:\STUDY\ORACLE\20231020_01_SCOTT.SQL
*/

--�� TBL_FILES ���̺��� ��ȸ�Ͽ�
--   ������ ���� ����� ���� �� �յ��� �������� �����Ѵ�.
/*
1	SALES.DOC
2	PANMAE.XXLS
3	RESEARCH.PPT
4	STUDY.HWP
5	SQL.TXT
6	FLOWER.PNG
7	20231020_01_SCOTT.SQL
*/

SELECT FILENO ���Ϲ�ȣ
     , FILENAME "��������� ���ϸ�"
     , SUBSTR(FILENAME, 16,9) "���ϸ�"
FROM TBL_FILES
WHERE FILENO = 1;
-- �ϳ��� ���� ���Ҽ��� ������ �ٸ� ��ȣ�� ��ȸ�ϸ� �̻���!
-- ���� �ذ���?

--��
SELECT FILENO ���Ϲ�ȣ
     , REVERSE(SUBSTR(REVERSE(FILENAME),1,INSTR(REVERSE(FILENAME),'\')-1)) �����̸�
FROM TBL_FILES;

--��
SELECT FILENO ���Ϲ�ȣ
     , SUBSTR(FILENAME,INSTR(FILENAME,'\',-1,1)+1) �����̸�
FROM TBL_FILES;

--��
SELECT FILENO ���Ϲ�ȣ
     , SUBSTR(FILENAME, LENGTH(FILENAME)-INSTR(REVERSE(FILENAME),'\',1)+2 )
FROM TBL_FILES;
--==>>
/*
1	SALES.DOC
2	PANMAE.XXLS
3	RESEARCH.PPT
4	STUDY.HWP
5	SQL.TXT
6	FLOWER.PNG
7	20231020_01_SCOTT.SQL
*/


SELECT  FILENO ���Ϲ�ȣ
      , FILENAME ����������ϸ�
      , REVERSE(FILENAME) "�ŲٷεȰ�����ϸ�"
      , SUBSTR(����ڿ�, ���������ġ, ���� ��\��������ġ -1) "�Ųٷε� ���ϸ�"
FROM TBL_FILES;

SELECT  FILENO ���Ϲ�ȣ
      , FILENAME ����������ϸ�
      , REVERSE(FILENAME) "�ŲٷεȰ�����ϸ�"
      , SUBSTR(REVERSE(FILENAME), 1 , ���� ��\��������ġ -1) "�Ųٷε� ���ϸ�"
FROM TBL_FILES;

-- ���� ��\��������ġ
-- �� INSTR(REVERSE(FILENAME), '\', 1)

SELECT  FILENO ���Ϲ�ȣ
      , FILENAME ����������ϸ�
      , REVERSE(FILENAME) "�ŲٷεȰ�����ϸ�"
      , SUBSTR(REVERSE(FILENAME),1,INSTR(REVERSE(FILENAME),'\')-1) "�Ųٷε� ���ϸ�"
FROM TBL_FILES;

SELECT  FILENO ���Ϲ�ȣ
      , FILENAME ����������ϸ�
      , REVERSE(FILENAME) "�ŲٷεȰ�����ϸ�"
      , REVERSE(SUBSTR(REVERSE(FILENAME),1,INSTR(REVERSE(FILENAME),'\')-1)) "�Ųٷε� ���ϸ�"
FROM TBL_FILES;
--==>>
/*
1	C:\AAA\BBB\CCC\SALES.DOC	COD.SELAS\CCC\BBB\AAA\:C	SALES.DOC
2	C:\AAA\PANMAE.XXLS	SLXX.EAMNAP\AAA\:C	PANMAE.XXLS
3	D:\RESEARCH.PPT	TPP.HCRAESER\:D	RESEARCH.PPT
4	C:\DOCUMENTS\STUDY.HWP	PWH.YDUTS\STNEMUCOD\:C	STUDY.HWP
5	D:\DOCUMENTS\TEMP\HOMEWORK\SQL.TXT	TXT.LQS\KROWEMOH\PMET\STNEMUCOD\:D	SQL.TXT
6	C:\SHARE\F\TEST\FLOWER.PNG	GNP.REWOLF\TSET\F\ERAHS\:C	FLOWER.PNG
7	E:\STUDY\ORACLE\20231020_01_SCOTT.SQL	LQS.TTOCS_10_02013202\ELCARO\YDUTS\:E	20231020_01_SCOTT.SQL
*/

SELECT  FILENO ���Ϲ�ȣ
      , REVERSE(SUBSTR(REVERSE(FILENAME),1,INSTR(REVERSE(FILENAME),'\')-1)) "�Ųٷε� ���ϸ�"
FROM TBL_FILES;
--==>>
/*
1	SALES.DOC
2	PANMAE.XXLS
3	RESEARCH.PPT
4	STUDY.HWP
5	SQL.TXT
6	FLOWER.PNG
7	20231020_01_SCOTT.SQL
*/

--�� LPAD()
-->  Byte �� Ȯ���Ͽ� ���ʺ��� ���ڷ� ä��� ����� ���� �Լ�

SELECT 'ORACLE' COL1
       ,LPAD('ORACLE',10,'*') COL2
FROM DUAL;
--> �� 10Byte ������ Ȯ���Ѵ�.               �� �� ��° �Ķ���� ���� ����...
--  �� Ȯ���� ������ 'ORCLE' ���ڿ��� ��´� �� ù ��° �Ķ���� ���� ����...
--  �� �����ִ� byte ������ ���ʺ��� �� ��° �Ķ���� ������ ä���.
--  �� �̷��� ������ ���� ������� ��ȯ�Ѵ�.
--==>> ORACLE       ****ORACLE


--�� RPAD()
-->  Byte �� Ȯ���Ͽ� �����ʺ��� ���ڷ� ä��� ����� ���� �Լ�
SELECT 'ORACLE' COL1
       ,RPAD('ORACLE',10,'*') COL2
FROM DUAL;
--> �� 10Byte ������ Ȯ���Ѵ�.               �� �� ��° �Ķ���� ���� ����...
--  �� Ȯ���� ������ 'ORCLE' ���ڿ��� ��´� �� ù ��° �Ķ���� ���� ����...
--  �� �����ִ� byte ������ �����ʺ��� �� ��° �Ķ���� ������ ä���.
--  �� �̷��� ������ ���� ������� ��ȯ�Ѵ�.
--==>> ORACLE       ORACLE****


--�� LTRIM()
SELECT 'ORAORAORAORACLEORACLE' "COL1"                       -- ���� ���� ���� ����Ŭ ����Ŭ
       ,LTRIM('ORAORAORAORACLEORACLE' , 'ORA') "COL2"
       ,LTRIM('AAAAAAAAAORACLEORACLE' , 'ORA') "COL3"
       ,LTRIM('ORAORAoRAORACLEORACLE' , 'ORA') "COL4"
       ,LTRIM('ORAORA ORAORACLEORACLE' , 'ORA') "COL5"
       ,LTRIM('                ORACLE' , ' ') "COL6"        -- ���� ���� ����
       ,LTRIM('                ORACLE') "COL7"              -- �� ��° �Ķ���� ����
FROM DUAL;
--==>> 
/*
ORAORAORAORACLEORACLE
CLEORACLE
CLEORACLE
oRAORACLEORACLE
 ORAORACLEORACLE
ORACLE
ORACLE
*/
--> ù ��° �Ķ���� ���� �ش��ϴ� ���ڿ��� �������
--  ���ʺ��� ���������� �����ϴ� �� ��° �Ķ���� ������ ������ ���ڿ� 
--  ���� ���ڰ� ������ ��� �̸� �����ϰ� ���� ������� ��ȯ�Ѵ�.
--  ��, �ϼ������� ó������ �ʴ´�.

SELECT LTRIM('���̽��̱�����̽ű����̱��̱���̱��', '�����') "COL1"
FROM DUAL;
--==>> ���̱��


--�� RTRIM()
--> ù ��° �Ķ���� ���� �ش��ϴ� ���ڿ��� �������
--  �����ʺ��� ���������� �����ϴ� �� ��° �Ķ���� ������ ������ ���ڿ� 
--  ���� ���ڰ� ������ ��� �̸� �����ϰ� ���� ������� ��ȯ�Ѵ�.
--  ��, �ϼ������� ó������ �ʴ´�.


--�� TRANSLATE()
--  1 : 1 �� �ٲ��ش�.

SELECT TRANSLATE('MY ORACLE SERVER', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' ,'abcdefghijklmnopqrstuvwxyz') COL1
FROM DUAL;
--==>> my oracle server

SELECT TRANSLATE('010-9322-9643','0123456789','�����̻�����ĥ�ȱ�') COL1
FROM DUAL;
--==>> ���ϰ�-��������-�������

--�� REPLACE()

SELECT REPLACE('MY ORACLE SEVER ORAHOME','ORA','����') COL1
FROM DUAL;
--==>> MY ����CLE SEVER ����HOME


--���� ���� �Լ� �� ���� �ʿ�� �߰�!
--------------------------------------------------------------------------------

--�� ROUND() �ݿø��� ó���� �ִ� �Լ�
SELECT 48.678 COL1                  -- 48.678
      , ROUND(48.678, 2) COL2       -- 48.68            -- �Ҽ��� ���� ��°�ڸ����� ǥ�� �� �ι��� �Ķ���Ϳ� ���ؼ�...
      , ROUND(48.674, 2) COL3       -- 48.67
      , ROUND(48.674, 1) COL4       -- 48.7 
      , ROUND(48.684, 0) COL5       -- 49
      , ROUND(48.684) COL6          -- 49               -- �ι�° �Ķ���� ���� 0 �� ��� ��������(������ ǥ��)
      , ROUND(48.684, -1) COL7      -- 50               
      , ROUND(48.684, -2) COL8      -- 0
      , ROUND(48.684, -3) COL9      -- 0
FROM DUAL;
      
--�� TRUNC() ������ ó���� �ִ� �Լ�
SELECT 48.678 COL1                  -- 48.678
      , TRUNC(48.678, 2) COL2       -- 48.67            -- �Ҽ��� ���� ��°�ڸ����� ǥ�� �� �ι��� �Ķ���Ϳ� ���ؼ�...
      , TRUNC(48.674, 2) COL3       -- 48.67
      , TRUNC(48.674, 1) COL4       -- 48.6 
      , TRUNC(48.684, 0) COL5       -- 48
      , TRUNC(48.684) COL6          -- 48               -- �ι�° �Ķ���� ���� 0 �� ��� ��������(������ ǥ��)
      , TRUNC(48.684, -1) COL7      -- 40               
      , TRUNC(48.684, -2) COL8      -- 0
      , TRUNC(48.684, -3) COL9      -- 0
FROM DUAL;

--�� MOD() �������� ��ȯ�ϴ� �Լ� �� % 

SELECT MOD(5,2) COL1
FROM DUAL;
--> 5�� 2�� ���� ������ ����� ��ȯ
--==>> 1

--�� POWER() ������ ����� ��ȯ�ϴ� �Լ�

SELECT POWER(5,3) COL1
FROM DUAL;
--> 5�� 3���� ��������� ��ȯ
--==>> 125


--�� SQRT() ��Ʈ ������� ��ȯ�ϴ� �Լ�

SELECT SQRT(2) COL1
FROM DUAL;
--> ��Ʈ2�� ���� ����� ��ȯ
--==>> 1.41421356237309504880168872420969807857

--�� LOG() �α� �Լ�
--   ���α� 
SELECT LOG(10,100) COL1
     , LOG(10,20) COL2
FROM DUAL;
--==>> 2	1.30102999566398119521373889472449302677

--   LN() �ڿ� �α� ������~!! (NETURAL N��)
SELECT LN(95) COL1
FROM DUAL;
--==>> 4.55387689160054083460978676511404117675


--�� �ﰢ�Լ�

SELECT SIN(1), COS(1), TAN(1)
FROM DUAL;
--==>>
/*
0.8414709848078965066525023216302989996233	
0.5403023058681397174009366074429766037354	
1.55740772465490223050697480745836017308
*/
--> ���� ����, �ڽ���, ź��Ʈ ������� ��ȯ�Ѵ�.

--�� �ﰢ�Լ��� ���Լ�(���� : -1 ~ 1)

SELECT ASIN(0.5), ACOS(0.5), ATAN(0.5)
FROM DUAL;
--==>>
/*
0.52359877559829887307710723054658381405	
1.04719755119659774615421446109316762805	
0.4636476090008061162142562314612144020295
*/


--�� SIGN() ����, ��ȣ, Ư¡
-->  ���� ������� ����̸�1, 0�̸� 0, ������ -1 �� ��ȯ�Ѵ�.

SELECT SIGN(5-2) COL1
    ,  SIGN(5-5) COL2
    ,  SIGN(5-7) COL3
FROM DUAL;
--==>> 1	0	-1
--> �����̳� ������ �����Ͽ� ���� �� ������ ������ ��Ÿ�� �� ���� ���ȴ�.

--�� ASCII(), CHR() �� ���� ����(����)�ϴ� �Լ�

SELECT ASCII('A') COL1
     , CHR(65) COL2  
FROM DUAL;
--==>> 65	A
-- ��ASCII()�� : �Ű������� �Ѱܹ��� ������ �ƽ�Ű�ڵ� ���� ��ȯ�Ѵ�.
-- ��CHR()��   : �Ű������� �Ѱܹ��� �ƽ�Ű�ڵ� ������ �ش� ���ڸ� ��ȯ�Ѵ�.

--------------------------------------------------------------------------------

--�� ��¥ ���� ���� ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
-- Session��(��) ����Ǿ����ϴ�.

--�� ��¥ ������ �⺻ ������ �ϼ�(DAY)�̴�~~!! CHECK~~!! 
SELECT SYSDATE COL1
      ,SYSDATE +1 "COL2"
      ,SYSDATE -2 "COL3"
      ,SYSDATE +30 "COL4"
FROM DUAL;
--==>> 
/*
2023-10-20 15:38:49	
2023-10-21 15:38:49	
2023-10-18 15:38:49	
2023-11-19 15:38:49
*/

--�� �ð� ���� ����
SELECT SYSDATE COL1             -- 2023-10-20 15:41:44
      ,SYSDATE + 1/24 COL2      -- 2023-10-20 16:41:44
      ,SYSDATE - 2/24 COL3      -- 2023-10-20 13:41:44
FROM DUAL;

--�� ���� �ð���... ���� �ð� ���� 1��, 2�ð�, 3�� 4�� �ĸ� ��ȸ�Ѵ�.

--��
SELECT SYSDATE "���� �ð�"
      ,SYSDATE + 1 + 2/24 + 3/1440 + 4/86400 "���� �� �ð�"
FROM DUAL;

--�� 
SELECT SYSDATE "���� �ð�"
      ,SYSDATE + 1 + (2/24) + (3/(24*60)) + (4/(24*60*60)) "���� �� �ð�"
FROM DUAL;

--��
SELECT SYSDATE "���� �ð�"
      ,SYSDATE + ((1*24*60*60) + (2*60*60) + (3*60) + 4) / (24*60*60) "���� �� �ð�"
FROM DUAL;
--==>>
/*
2023-10-20 15:48:10	    2023-10-21 17:51:14
*/

--�� ��¥ - ��¥ �� �ϼ�

SELECT TO_DATE('2024-03-19', 'YYYY-MM-DD') - TO_DATE('2023-08-22','YYYY-MM-DD') "COL1"
FROM DUAL;
--==>> 210(��)

--�� ������ Ÿ���� ��ȯ 

SELECT TO_DATE('2023-10-20', 'YYYY-MM-DD') "COL1"
FROM DUAL;
--==>> 2023-10-20 00:00:00

SELECT TO_DATE('2023-10-32','YYYY-MM-DD') "COL1"
FROM DUAL;
--==>> ���� �߻� 
--     (ORA-01847: day of month must be between 1 and last day of month)

SELECT TO_DATE('2023-02-29','YYYY-MM-DD') "COL1"
FROM DUAL;
--==>> ���� �߻� 
--     (ORA-01847: day of month must be between 1 and last day of month)

SELECT TO_DATE('2023-13-20','YYYY-MM-DD') "COL1"
FROM DUAL;
--==>> ���� �߻�
--     (ORA-01843: not a valid month)


--�� TO_DATE() �Լ��� ���� ���� Ÿ���� ��¥ Ÿ������ ��ȯ�� �����ϴ� ��������
--   ���������� �ش� ��¥�� ���� ��ȿ�� �˻簡 �̷������.

--�� ADD_MONTHS() ���� ���� ���ϰų� �� ���ִ� �� �Լ�

SELECT SYSDATE COL1
      , ADD_MONTHS(SYSDATE, 2) COL2
      , ADD_MONTHS(SYSDATE, 3) COL3
      , ADD_MONTHS(SYSDATE, -2) COL4
      , ADD_MONTHS(SYSDATE, -3) COL5
FROM DUAL;
--==>>
/*
2023-10-20 16:19:22	    �� ����
2023-12-20 16:19:22	    �� 2�� �� 
2024-01-20 16:19:22	    �� 3�� ��
2023-08-20 16:19:22	    �� 2���� ��
2023-07-20 16:19:22     �� 3���� ��

*/

--�� MONTHS_BETWEEN()
--   ù ��° ���ڰ����� �� ��° ���ڰ��� �� ���� ���� ��ȯ�Ѵ�.

SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('2002-05-31','YYYY-MM-DD')) COL1
FROM DUAL;
--==>> 256.667167338709677419354838709677419355 (256 ����)

-- ���� ���� ���̸� ��ȯ�ϴ� �Լ�
-- ��� ���� ��ȣ�� ��-��(����)�� ��ȯ�Ǿ��� ��쿡�� 
-- ù ��° ���ڰ��� �ش��ϴ� ��¥����
-- �� ��° ���ڰ��� �ش��ϴ� ��¥�� ���̷������ �ǹ̸� Ȯ�� �� �� �ִ�.


--�� NEXT_DAY()

SELECT NEXT_DAY(SYSDATE, '��') COL1
      ,NEXT_DAY(SYSDATE, '��') COL2
FROM DUAL;
--==>> 2023-10-21 16:25:08	
--     2023-10-23 16:25:08

--�� �߰� ���� ���� ����
ALTER SESSION SET NLS_DATE_LANGUAGE = 'ENGLISH';
--==>> Session��(��) ����Ǿ����ϴ�.

SELECT NEXT_DAY(SYSDATE, 'SAT') COL1
      ,NEXT_DAY(SYSDATE, 'MON') COL2
FROM DUAL;
--==>> 2023-10-21 16:28:23	
--     2023-10-23 16:28:23

ALTER SESSION SET NLS_DATE_LANGUAGE = 'KOREAN';
--==>> Session��(��) ����Ǿ����ϴ�.

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
--==>> Session��(��) ����Ǿ����ϴ�.

--�� LAST_DAY()
-->  �ش� ��¥�� ���ԵǾ� �մ� �� ���� ������ ���� ��ȯ�Ѵ�.

SELECT SYSDATE COL1                                         -- 2023-10-20	
      ,LAST_DAY(SYSDATE) COL2                               -- 2023-10-31
      ,LAST_DAY(TO_DATE('2023-02-12','YYYY-MM-DD')) COL3    -- 2023-02-28
      ,LAST_DAY(TO_DATE('2020-02-12','YYYY-MM-DD')) COL4    -- 2020-02-29
FROM DUAL;

--�� ���úη�... ��ȯ�̰� ���뿡 �ٽ� ��������....
--   ���� �Ⱓ�� 22������ �Ѵ�.

-- 1. ���� ���ڸ� ���Ѵ�.

-- 2. �Ϸ� ���ڲ��� 3�� �Ļ縦 �ؾ� �Ѵٰ� �����ϸ�...
--    ��ȯ�̰� ��� �Ծ�� ���� �����ٱ�...

-- �̰��Դϴ�~~
SELECT ADD_MONTHS(SYSDATE,22) "��������"
     , (ADD_MONTHS(SYSDATE,22)-SYSDATE) * 3 "����Ծ���ұ�"
FROM DUAL;
--==>> 2025-08-20	2010

-- �Ϸ�ġ �� �� ���ص� ��
SELECT ADD_MONTHS(SYSDATE,22) "��������"
      ,((ADD_MONTHS(SYSDATE,22)-SYSDATE+1)*3) "�������"
FROM DUAL;
-- 2025-08-20	2013


--�� ��¥ ���� ���� ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--Session��(��) ����Ǿ����ϴ�.


--�� ���� ��¥ �� �ð����κ���...
--   ������(2024-03-19 18:00) ���� 
--   ���� �Ⱓ��... ������ ���� ���·� ��ȸ�� �� �ֵ��� �������� �����Ѵ�.
/*
-------------------- ---------------------- -------- ------ -------- -----------
 ���� �ð�              ������                  ��    �ð�      ��       ��
-------------------- ----------------------- ------- ------ -------- -----------
2023-10-20 17:09:10     2024-03-19 18:00:00     140    0        49       50
-------------------- ----------------------- ------- ------ -------- -----------
*/

SELECT SYSDATE "���� �ð�"
     , TO_DATE('2024-03-19 18:00:00','YYYY-MM-DD HH24:MI:SS') "������"
     , TRUNC(TO_DATE('2024-03-19 18:00:00','YYYY-MM-DD HH24:MI:SS') - SYSDATE) "��"
     , TRUNC((TO_DATE('2024-03-19 18:00:00','YYYY-MM-DD HH24:MI:SS') - SYSDATE - TRUNC(TO_DATE('2024-03-19 18:00:00','YYYY-MM-DD HH24:MI:SS') - SYSDATE ))*24) "�ð�"
     , TRUNC(MOD((TO_DATE('2024-03-19 18:00:00','YYYY-MM-DD HH24:MI:SS') - SYSDATE - TRUNC(TO_DATE('2024-03-19 18:00:00','YYYY-MM-DD HH24:MI:SS') - SYSDATE ))*24,1),60) "��"
     , TRUNC(MOD((TO_DATE('2024-03-19 18:00:00','YYYY-MM-DD HH24:MI:SS') - SYSDATE - TRUNC(TO_DATE('2024-03-19 18:00:00','YYYY-MM-DD HH24:MI:SS') - SYSDATE ))*24 * 60,1),60) "��"
FROM DUAL;












