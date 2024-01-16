SELECT USER
FROM DUAL;


--�� EMP ���̺�� DEPT ���̺��� ������� 
--   ������ MANAGER �� CLERK �� ����鸸 
--   �μ���ȣ, �μ���, �����, ������, �޿� �׸��� ��ȸ�Ѵ�.

--99 ����
SELECT E.DEPTNO "�μ���ȣ" , DNAME "�μ���" , ENAME "�����" , JOB "������" , SAL "�޿�"
FROM EMP E JOIN DEPT D
ON   E.DEPTNO = D.DEPTNO
WHERE JOB IN ('MANAGER', 'CLERK');
--==>> 
/*
10	ACCOUNTING	CLARK	MANAGER	2450
10	ACCOUNTING	MILLER	CLERK	1300
20	RESEARCH	ADAMS	CLERK	1100
20	RESEARCH	JONES	MANAGER	2975
20	RESEARCH	SMITH	CLERK	 800
30	SALES	    BLAKE	MANAGER	2850
30	SALES	    JAMES	CLERK	 950
*/

--92 ����
SELECT D.DEPTNO "�μ���ȣ" , DNAME "�μ���" , ENAME "�����" , JOB "������" , SAL "�޿�"
FROM EMP E , DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND JOB IN ('MANAGER', 'CLERK'); 


SELECT DEPTNO "�μ���ȣ" , DNAME "�μ���" , ENAME "�����" , JOB "������" , SAL "�޿�"
FROM EMP E , DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND JOB IN ('MANAGER', 'CLERK'); 
--==>> ���� �߻� 
--     ORA-00918: column ambiguously defined
-->    �� ���̺� �� �ߺ��Ǵ� �÷��� ���� 
--     �Ҽ� ���̺��� �������(��������) �Ѵ�.


--�� �� ���̺� �� �ߺ��Ǵ� Į���� ���� �Ҽ� ���̺��� ����ϴ� ��� 
--   �θ� ���̺��� �÷��� ������ �� �ֵ��� ó���ؾ� �Ѵ�.

SELECT *
FROM EMP;       -- �ڽ� ���̺�

SELECT *
FROM DEPT;      -- �θ� ���̺�


SELECT D.DEPTNO , DNAME, ENAME , JOB , SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO; 

-- �� ���̺� ��� ���ԵǾ� �ִ� �ߺ��� �÷��� �ƴϴ���
-- �÷��� �Ҽ� ���̺��� ����� �� �� �ֱ⸦ �����Ѵ�.

SELECT E.DEPTNO , D.DNAME, E.ENAME , E.JOB , E.SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO; 
--==>>
/*
10	    ACCOUNTING	CLARK	MANAGER	    2450
10	    ACCOUNTING	KING	PRESIDENT	5000
10	    ACCOUNTING	MILLER	CLERK	    1300
20	    RESEARCH	JONES	MANAGER	    2975
20	    RESEARCH	FORD	ANALYST	    3000
20	    RESEARCH	ADAMS	CLERK	    1100
20	    RESEARCH	SMITH	CLERK	    800
20	    RESEARCH	SCOTT	ANALYST	    3000
30	    SALES	    WARD	SALESMAN	1250
30	    SALES	    TURNER	SALESMAN	1500
30	    SALES	    ALLEN	SALESMAN	1600
30	    SALES	    JAMES	CLERK	    950
30	    SALES	    BLAKE	MANAGER	    2850
30	    SALES	    MARTIN	SALESMAN	1250
(NULL)	OPERATIONS			                    �� check~~!!! (E.DEPTNO)
*/

SELECT D.DEPTNO , D.DNAME, E.ENAME , E.JOB , E.SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO; 
--==>>
/*
10	ACCOUNTING	CLARK	MANAGER	    2450
10	ACCOUNTING	KING	PRESIDENT	5000
10	ACCOUNTING	MILLER	CLERK	    1300
20	RESEARCH	JONES	MANAGER	    2975
20	RESEARCH	FORD	ANALYST	    3000
20	RESEARCH	ADAMS	CLERK	    1100
20	RESEARCH	SMITH	CLERK	    800
20	RESEARCH	SCOTT	ANALYST	    3000
30	SALES	    WARD	SALESMAN	1250
30	SALES	    TURNER	SALESMAN	1500
30	SALES	    ALLEN	SALESMAN	1600
30	SALES	    JAMES	CLERK	    950
30	SALES	    BLAKE	MANAGER	    2850
30	SALES	    MARTIN	SALESMAN	1250
40	OPERATIONS			                  �� check~~!!! (D.DEPTNO)
*/

--> �ڽ����̺��� ������ ������ ���� ���� ���� �θ����̺��� ������ �� ����.
--  ���� 40�� �μ��� ���� EMP ���̺��� 40�� �μ� ��ȣ�� NULL�� ǥ�� 
--  �θ����̺��� �翬�� ������ ���� �ִ� �Ŵϱ� ǥ��~~!! 
--  �׷��� �θ����̺�� �ϴ� ���� �°���?^^*


--�� SELF JOIN (�ڱ� ����)

-- EMP ���̺��� �����͸� ������ ���� ��ȸ �� �� �ֵ��� �������� �����Ѵ�.
/*
--------------------------------------------------------------------------------
�����ȣ    �����    ������    �����ڹ�ȣ   �����ڸ�   ������ ������ 
--------------------------------------------------------------------------------
  EMPNO     ENAME      JOB         MGR             
  ------------------------------------------- E1
                                  EMPNO       ENAME       JOB
                                  ----------------------------------E2
  7369      SMITH     CLARK       7902        FORD        ANALYST
                            
--------------------------------------------------------------------------------
*/

SELECT E1.EMPNO "�����ȣ" , E1.ENAME "�����" , E1.JOB "������" , E1.MGR "�����ڹ�ȣ"
     ,  CASE WHEN E1.MGR = E2.EMPNO THEN E2.ENAME 
        ELSE '������ ����'
        END "�����ڸ�" -- E2.JOB "������ ������"
FROM EMP E1 JOIN EMP E2
ON E1.MGR = E2.MGR; 

SELECT E1.EMPNO "�����ȣ" , E1.ENAME "�����" , E1.JOB "������" , E1.MGR "�����ڹ�ȣ"
      , E2.ENAME , E2.JOB
FROM EMP E1 JOIN EMP E2
ON E1.ENAME = E2.ENAME
WHERE E1.MGR = E2.EMPNO;


-- 92 CODE
SELECT E.EMPNO "�����ȣ" , E.ENAME "�����" , E.JOB "������" , E.MGR "�����ڹ�ȣ"
     , D.ENAME "�����ڸ�", D.JOB "������ ������"
FROM EMP E , EMP D
WHERE D.EMPNO(+) = E.MGR
ORDER BY 1;

-- 99 CODE
SELECT E.EMPNO "�����ȣ" , E.ENAME "�����" , E.JOB "������" , E.MGR "�����ڹ�ȣ", D.ENAME "�����ڸ�", D.JOB "������ ������"
FROM EMP E LEFT JOIN EMP D
ON D.EMPNO = E.MGR
ORDER BY 1;
--==>>
/*
7369	SMITH	CLERK	    7902	FORD	ANALYST
7499	ALLEN	SALESMAN	7698	BLAKE	MANAGER
7521	WARD	SALESMAN	7698	BLAKE	MANAGER
7566	JONES	MANAGER	    7839	KING	PRESIDENT
7654	MARTIN	SALESMAN	7698	BLAKE	MANAGER
7698	BLAKE	MANAGER	    7839	KING	PRESIDENT
7782	CLARK	MANAGER	    7839	KING	PRESIDENT
7788	SCOTT	ANALYST	    7566	JONES	MANAGER
7839	KING	PRESIDENT			
7844	TURNER	SALESMAN	7698	BLAKE	MANAGER
7876	ADAMS	CLERK	    7788	SCOTT	ANALYST
7900	JAMES	CLERK	    7698	BLAKE	MANAGER
7902	FORD	ANALYST 	7566	JONES	MANAGER
7934	MILLER	CLERK	    7782	CLARK	MANAGER
*/

-- ���� Ǯ��------------------------------------------------------

SELECT �����ȣ    �����    ������    �����ڹ�ȣ   �����ڸ�   ������ ������ 
FROM EMP;

SELECT EMPNO �����ȣ ENAME �����  JOB ������ EMPNO �����ڹ� ENAME �����ڸ� JOB ������ ������ 
FROM EMP;

SELECT E1.EMPNO �����ȣ , E1.ENAME ����� , E1.JOB ������ , E2.EMPNO �����ڹ�ȣ , E2.ENAME �����ڸ�, E2.JOB ������������ 
FROM EMP E1 LEFT JOIN EMP E2
ON E1.MGR = E2.EMPNO;


















