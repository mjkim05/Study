SELECT USER
FROM DUAL;
--==>> SCOTT


--���� UNION / UNION ALL ����--

--�� �ǽ� ���̺� ����(���̺��� : TBL_JUMUN)
CREATE TABLE TBL_JUMUN                  -- �ֹ� ���̺� ����
( JUNO      NUMBER                      -- �ֹ� ��ȣ
, JECODE    VARCHAR2(30)                -- ��ǰ �ڵ�
, JUSU      NUMBER                      -- �ֹ� ����
, JUDAY     DATE    DEFAULT SYSDATE     -- �ֹ� ����
);
--==>> Table TBL_JUMUN��(��) �����Ǿ����ϴ�.
-- ������ �ֹ��� �߻�(����)�Ǿ��� ���
-- �ֹ� ���뿡 ���� �����Ͱ� �Էµ� �� �ֵ��� ó���ϴ� ���̺�

-- �ǽ� ���� �� ��ǰ �ڵ�(JECODE)���� 
-- ���ǻ� ��ǰ�� �ڵ带 �����Ѵٰ� �����ϰ� ��ǰ�� �̸��� �Է��Ѵ�.


--�� ������ �Է� �� ������ �ֹ� �߻�(����)
INSERT INTO TBL_JUMUN
VALUES(1, '����ƽ', 20, TO_DATE('2001-11-01 09:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(2, '������', 10, TO_DATE('2001-11-01 10:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(3, '��ǹ�', 30, TO_DATE('2001-11-01 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(4, '��īĨ', 20, TO_DATE('2001-11-02 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(5, '��īĨ', 30, TO_DATE('2001-11-03 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(6, '������', 20, TO_DATE('2001-11-04 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(7, 'Ȩ����', 10, TO_DATE('2001-11-05 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(8, 'Ȩ����', 10, TO_DATE('2001-11-06 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(9, '������', 20, TO_DATE('2001-11-07 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(10, '��ǹ�', 10, TO_DATE('2001-11-08 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(11, '������', 20, TO_DATE('2001-11-09 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(12, '���ڱ�', 10, TO_DATE('2001-11-10 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(13, '������', 20, TO_DATE('2001-11-11 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(14, 'Ȩ����', 20, TO_DATE('2001-11-12 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(15, '��īĨ', 10, TO_DATE('2001-11-13 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(16, '��īĨ', 20, TO_DATE('2001-11-16 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(17, '������', 20, TO_DATE('2001-11-17 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(18, '������', 30, TO_DATE('2001-11-18 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(19, '������', 20, TO_DATE('2001-11-19 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN
VALUES(20, '����Ĩ', 30, TO_DATE('2001-11-20 11:10:10', 'YYYY-MM-DD HH24:MI:SS'));
--==>> 1 �� ��(��) ���ԵǾ����ϴ�. * 20

--�� Ȯ��
SELECT *
FROM TBL_JUMUN;
--==>>
/*
1	����ƽ	20	2001/11/01
2	������	10	2001/11/01
3	��ǹ�	30	2001/11/01
4	��īĨ	20	2001/11/02
5	��īĨ	30	2001/11/03
6	������	20	2001/11/04
7	Ȩ����	10	2001/11/05
8	Ȩ����	10	2001/11/06
9	������	20	2001/11/07
10	��ǹ�	10	2001/11/08
11	������	20	2001/11/09
12	���ڱ�	10	2001/11/10
13	������	20	2001/11/11
14	Ȩ����	20	2001/11/12
15	��īĨ	10	2001/11/13
16	��īĨ	20	2001/11/16
17	������	20	2001/11/17
18	������	30	2001/11/18
19	������	20	2001/11/19
20	����Ĩ	30	2001/11/20
*/

--�� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.


--�� ��¥�� ���� ���� ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--==>> Session��(��) ����Ǿ����ϴ�.

--�� Ȯ��
SELECT *
FROM TBL_JUMUN;
--==>>
/*
1	����ƽ	20	2001-11-01 09:10:10
2	������	10	2001-11-01 10:10:10
3	��ǹ�	30	2001-11-01 11:10:10
4	��īĨ	20	2001-11-02 11:10:10
5	��īĨ	30	2001-11-03 11:10:10
6	������	20	2001-11-04 11:10:10
7	Ȩ����	10	2001-11-05 11:10:10
8	Ȩ����	10	2001-11-06 11:10:10
9	������	20	2001-11-07 11:10:10
10	��ǹ�	10	2001-11-08 11:10:10
11	������	20	2001-11-09 11:10:10
12	���ڱ�	10	2001-11-10 11:10:10
13	������	20	2001-11-11 11:10:10
14	Ȩ����	20	2001-11-12 11:10:10
15	��īĨ	10	2001-11-13 11:10:10
16	��īĨ	20	2001-11-16 11:10:10
17	������	20	2001-11-17 11:10:10
18	������	30	2001-11-18 11:10:10
19	������	20	2001-11-19 11:10:10
20	����Ĩ	30	2001-11-20 11:10:10
*/


--�� �߰� ������ �Է� �� 2001 �� ���� ���۵� �ֹ��� ����(2023��) ���� ��� �߻�~!!! ������~!!!
INSERT INTO TBL_JUMUN VALUES(98764, '����Ĩ', 10, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98765, '������', 30, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98766, '������', 20, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98767, '���̽�', 40, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98768, 'Ȩ����', 10, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98769, '���ڱ�', 20, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98770, '������', 10, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98771, '���Ͻ�', 20, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98772, '������', 30, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98773, '������', 20, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98774, '������', 50, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_JUMUN VALUES(98775, '������', 10, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.


--�� Ȯ��
SELECT *
FROM TBL_JUMUN;
--==>>
/*
1	    ����ƽ	20	2001-11-01 09:10:10
2	    ������	10	2001-11-01 10:10:10
3	    ��ǹ�	30	2001-11-01 11:10:10
4	    ��īĨ	20	2001-11-02 11:10:10
5	    ��īĨ	30	2001-11-03 11:10:10
6	    ������	20	2001-11-04 11:10:10
7	    Ȩ����	10	2001-11-05 11:10:10
8	    Ȩ����	10	2001-11-06 11:10:10
9	    ������	20	2001-11-07 11:10:10
10	    ��ǹ�	10	2001-11-08 11:10:10
11	    ������	20	2001-11-09 11:10:10
12	    ���ڱ�	10	2001-11-10 11:10:10
13	    ������	20	2001-11-11 11:10:10
14	    Ȩ����	20	2001-11-12 11:10:10
15	    ��īĨ	10	2001-11-13 11:10:10
16	    ��īĨ	20	2001-11-16 11:10:10
17	    ������	20	2001-11-17 11:10:10
18	    ������	30	2001-11-18 11:10:10
19	    ������	20	2001-11-19 11:10:10
20	    ����Ĩ	30	2001-11-20 11:10:10

                :

98764	����Ĩ	10	2023-10-26 12:46:08
98765	������	30	2023-10-26 12:46:54
98766	������	20	2023-10-26 12:47:23
98767	���̽�	40	2023-10-26 12:47:53
98768	Ȩ����	10	2023-10-26 12:48:14
98769	���ڱ�	20	2023-10-26 12:48:37
98770	������	10	2023-10-26 12:49:01
98771	���Ͻ�	20	2023-10-26 12:49:26
98772	������	30	2023-10-26 12:49:44
98773	������	20	2023-10-26 12:50:07
98774	������	50	2023-10-26 12:50:30
98775	������	10	2023-10-26 12:50:53
*/

--�� �����̰� ���� ���θ� � ��...
--   TBL_JUMUN ���̺��� ���ſ��� ��Ȳ
--   ���ø����̼ǰ��� �������� ���� �ֹ� ������ 
--   �����δ� �ٸ� ���̺��� ����� �� �ֵ��� ����� ���� ���� �Ұ����� ��Ȳ.
--   ������ ��� �����͸� ������� ����� �͵� �Ұ����� ��Ȳ
--   �� ���������...
--      ������� ������ �ֹ� ������ ��
--      ���� �߻��� �ֹ� ������ �����ϰ�
--      ������ �����͸� �ٸ� ���̺�(�� TBL_JUMUNBACKUP)��
--      �����͸� �̰��Ͽ� ����� ������ ��ȹ


CREATE TABLE TBL_JUMUNBACKUP             
( JUNO      NUMBER                      -- �ֹ� ��ȣ
, JECODE    VARCHAR2(30)                -- ��ǰ �ڵ�
, JUSU      NUMBER                      -- �ֹ� ����
, JUDAY     DATE    DEFAULT SYSDATE     -- �ֹ� ����
);
--==>> Table TBL_JUMUNBACKUP��(��) �����Ǿ����ϴ�.

DROP TABLE TBL_JUMUNBACKUP;

CREATE TABLE TBL_JUMUNBACKUP
AS
SELECT *
FROM TBL_JUMUN
WHERE TO_CHAR(JUDAY, 'YYYY-MM-DD') != TO_CHAR(SYSDATE, 'YYYY-MM-DD');

SELECT *
FROM TBL_JUMUNBACKUP;

--------------------------------------------------------------------------
-- ���� Ǯ��
CREATE TABLE TBL_JUMUNBACKUP
AS
SELECT *
FROM TBL_JUMUN
WHERE ���Ϲ߻��� �ֹ��̾ƴѰ�

CREATE TABLE TBL_JUMUNBACKUP
AS
SELECT *
FROM TBL_JUMUN
WHERE TO_CHAR(JUDAY, 'YYYY-MM-DD') != TO_CHAR(SYSDATE, 'YYYY-MM-DD');
                                      ------------------------------
                                                --2023-10-26
                                                
--==>> Ȯ��
SELECT *
FROM TBL_JUMUNBACKUP
--==>>
/*
1	����ƽ	20	2001-11-01 09:10:10
2	������	10	2001-11-01 10:10:10
3	��ǹ�	30	2001-11-01 11:10:10
4	��īĨ	20	2001-11-02 11:10:10
5	��īĨ	30	2001-11-03 11:10:10
6	������	20	2001-11-04 11:10:10
7	Ȩ����	10	2001-11-05 11:10:10
8	Ȩ����	10	2001-11-06 11:10:10
9	������	20	2001-11-07 11:10:10
10	��ǹ�	10	2001-11-08 11:10:10
11	������	20	2001-11-09 11:10:10
12	���ڱ�	10	2001-11-10 11:10:10
13	������	20	2001-11-11 11:10:10
14	Ȩ����	20	2001-11-12 11:10:10
15	��īĨ	10	2001-11-13 11:10:10
16	��īĨ	20	2001-11-16 11:10:10
17	������	20	2001-11-17 11:10:10
18	������	30	2001-11-18 11:10:10
19	������	20	2001-11-19 11:10:10
20	����Ĩ	30	2001-11-20 11:10:10
*/
--> TBL_JUMUN ���̺��� �����͸� ��
--  ���� �ֹ� ���� �̿��� �����ʹ� ��� TBL_JUMUNBACKUP���̺���
--  ����� ��ģ ����~!!!

--  TBL_JUMUN ���̺��� �����͵� ��
--  ����� ��ģ �����͵�... ��, ���� �߻��� �ֹ� ������ �ƴ� �����͵�
--  ����

DELETE
FROM TBL_JUMUN
WHERE TO_CHAR(JUDAY, 'YYYY-MM-DD') != TO_CHAR(SYSDATE, 'YYYY-MM-DD');


-----------------------------------------------------------------------------
--���� Ǯ��
SELECT *
FROM TBL_JUMUN
WHERE TO_CHAR(JUDAY, 'YYYY-MM-DD') != TO_CHAR(SYSDATE, 'YYYY-MM-DD');

DELETE
FROM TBL_JUMUN
WHERE TO_CHAR(JUDAY, 'YYYY-MM-DD') != TO_CHAR(SYSDATE, 'YYYY-MM-DD');
--==>> 20�� �� ��(��) �����Ǿ����ϴ�.
--     (�� 93763�� ���� ������ ��Ȳ)


-- Ȯ��
SELECT *
FROM TBL_JUMUN;
--==>>
/*
98764	����Ĩ	10	2023-10-26 12:46:08
98765	������	30	2023-10-26 12:46:54
98766	������	20	2023-10-26 12:47:23
98767	���̽�	40	2023-10-26 12:47:53
98768	Ȩ����	10	2023-10-26 12:48:14
98769	���ڱ�	20	2023-10-26 12:48:37
98770	������	10	2023-10-26 12:49:01
98771	���Ͻ�	20	2023-10-26 12:49:26
98772	������	30	2023-10-26 12:49:44
98773	������	20	2023-10-26 12:50:07
98774	������	50	2023-10-26 12:50:30
98775	������	10	2023-10-26 12:50:53
*/

-- Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.

--�� ���� ��ǰ �߼��� �̷������ ���� ���� �ֹ������͸� �����ϰ�
--   ������ ��� �ֹ� �����͵��� ������ ��Ȳ�̹Ƿ�
--   ���̺��� ��(���ڵ�)�� ������ �پ��� �ſ� �������� ��Ȳ�̴�.


-- �׷���, ���ݱ��� �ֹ����� ������ ���� ������
-- ��ǰ�� �� �ֹ������� ��Ÿ����� �� ��Ȳ�� �߻��ϰ� �Ǿ���.
-- �׷��ٸ�, TBL_JUMUNBACKUP ���̺��� ���ڵ�(��)��
-- TBL_JUMUN ���̺��� ���ڵ�(��)�� ��� ����
-- �ϳ��� ���̺��� ��ȸ�ϴ� �Ͱ� ���� ����� Ȯ���� �� �ֵ���
-- ��ȸ�� �̷������ �Ѵ�.


--�� �÷��� �÷��� ���踦 �����Ͽ� ���̺��� �����ϰ��� �ϴ°��
--   JOIN �� ���������
--   ���ڵ�� ���ڵ带 �����ϰ��� �ϴ� ���
--   UNION / UNION ALL �� ����� �� �ִ�.

SELECT *
FROM TBL_JUMUNBACKUP
UNION
SELECT *
FROM TBL_JUMUN;


SELECT *
FROM TBL_JUMUNBACKUP
UNION ALL
SELECT *
FROM TBL_JUMUN;

-------------------------

SELECT *
FROM TBL_JUMUN
UNION
SELECT *
FROM TBL_JUMUNBACKUP;


SELECT *
FROM TBL_JUMUN
UNION ALL
SELECT *
FROM TBL_JUMUNBACKUP;


--�� UNION �� �׻� ������� ù ��° �÷��� ��������
--   �������� ������ �����Ѵ�.
--   �ݸ�, UNION ALL �� ���յ� ����(���������� ���̺��� ������ ����)���
--   ��ȸ�� ����� �ִ� �״�� ��ȯ�Ѵ�.(�� ���� ����)
--   �̷� ���� UNON �� ���ϰ� �� ũ��. (�� ���ҽ� �Ҹ� �� ũ��)
--   ����, UNION �� ������� ���� �ߺ��� ���ڵ�(��)�� ������ ���
--   �ߺ��� �����ϰ� 1�� �ุ ��ȸ�� ����� ��ȯ�ϰ� �ȴ�.



--�� ���ݱ��� �ֹ� ���� �����͸� ����
--    ��ǰ�� �� �ֹ����� ��ȸ�� �� �ִ� �������� �����Ѵ�.

SELECT T.JECODE, SUM(T.JUSU)
FROM
(
    SELECT *
    FROM TBL_JUMUN
    UNION ALL
    SELECT *
    FROM TBL_JUMUNBACKUP
) T
GROUP BY T.JECODE;
--==>>
/*
����Ĩ	40
������	90
���Ͻ�	20
������	20
���̽�	40
������	10
��īĨ	80
������	30
��ǹ�	40
������	140
Ȩ����	50
���ڱ�	30
������	20
������	20
����ƽ	20
*/
----------------------------------------------------
-- ���� Ǯ��

SELECT T.JECODE "��ǰ�ڵ�", SUM(T.JUSU) "�ֹ�����"
FROM
(
    SELECT JECODE, JUSU
    FROM TBL_JUMUN
    UNION ALL
    SELECT JECODE, JUSU
    FROM TBL_JUMUNBACKUP
)T
GROUP BY T.JECODE;


--�� INTERSECT / MINUS (������ / ������)

-- TBL_JUMUNBACKUP ���̺��� TBL_JUMUN ���̺�����
-- ��ǰ�ڵ�� �ֹ������� ���� �Ȱ��� �ุ �����ؼ� ��ȸ�ϰ��� �Ѵ�.
SELECT JECODE, JUSU
FROM TBL_JUMUNBACKUP
INTERSECT
SELECT JECODE, JUSU
FROM TBL_JUMUN;
--==>>
/*
������	30
������	20
Ȩ����	10
*/

SELECT JECODE, JUSU
FROM TBL_JUMUNBACKUP
MINUS
SELECT JECODE, JUSU
FROM TBL_JUMUN;
--==>>
/*
���ڱ�	10
����Ĩ	30
������	20
������	20
������	10
������	20
��ǹ�	10
��ǹ�	30
������	20
����ƽ	20
��īĨ	10
��īĨ	20
��īĨ	30
Ȩ����	20
*/

--�� TBL_JUMUNBACKUP ���̺��� TBL_JUMUN ���̺��� �������
--   ��ǰ�ڵ�� �ֹ����� ���� �Ȱ��� ���� ������
--   �ֹ���ȣ, ��ǰ�ڵ�, �ֹ���, �ֹ����� �׸����� ��ȸ�Ѵ�.
-- ��� 1.
SELECT *
FROM
(
    SELECT *
    FROM TBL_JUMUN
    UNION ALL
    SELECT *
    FROM TBL_JUMUNBACKUP
)T
WHERE (T.JECODE,T.JUSU ) IN   ----- �̷��� �־������
    (
    SELECT JECODE, JUSU
    FROM TBL_JUMUNBACKUP
    INTERSECT
    SELECT JECODE, JUSU
    FROM TBL_JUMUN
    );

-- ��� 2.
SELECT T1.JUNO, T1.JECODE, T1.JUSU, T1.JUDAY
FROM
(
    SELECT *
    FROM TBL_JUMUN
    UNION ALL
    SELECT *
    FROM TBL_JUMUNBACKUP
)T1
JOIN
(
    SELECT JECODE, JUSU
    FROM TBL_JUMUNBACKUP
    INTERSECT
    SELECT JECODE, JUSU
    FROM TBL_JUMUN
)T2
ON T1.JECODE = T2.JECODE
AND T1.JUSU = T2.JUSU;
--==>>
/*
98766	������	20	2023-10-26 12:47:23
98768	Ȩ����	10	2023-10-26 12:48:14
98772	������	30	2023-10-26 12:49:44
    7	Ȩ����	10	2001-11-05 11:10:10
    8	Ȩ����	10	2001-11-06 11:10:10
   11	������	20	2001-11-09 11:10:10
   13	������	20	2001-11-11 11:10:10
   18	������	30	2001-11-18 11:10:10
*/
-----------------------------------------------------------
-- ���� Ǯ��
SELECT T.*
FROM
(
    SELECT *
    FROM TBL_JUMUN
    UNION ALL
    SELECT *
    FROM TBL_JUMUNBACKUP
)T
WHERE CONCAT(T.JECODE, T.JUSU) IN  (SELECT CONCAT(JECODE, JUSU)
                                    FROM TBL_JUMUNBACKUP
                                    INTERSECT
                                    SELECT CONCAT(JECODE, JUSU)
                                    FROM TBL_JUMUN);
--==>>
/*
98766	������	20	2023-10-26 12:47:23
98768	Ȩ����	10	2023-10-26 12:48:14
98772	������	30	2023-10-26 12:49:44
    7	Ȩ����	10	2001-11-05 11:10:10
    8	Ȩ����	10	2001-11-06 11:10:10
   11	������	20	2001-11-09 11:10:10
   13	������	20	2001-11-11 11:10:10
   18	������	30	2001-11-18 11:10:10
*/
SELECT D.DEPTNO, D.DNAME, E.ENAME, E.SAL
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D. DEPTNO;
--==>>
/*
10	ACCOUNTING	CLARK	2450
10	ACCOUNTING	KING	5000
10	ACCOUNTING	MILLER	1300
20	RESEARCH	JONES	2975
20	RESEARCH	FORD	3000
20	RESEARCH	ADAMS	1100
20	RESEARCH	SMITH	800
20	RESEARCH	SCOTT	3000
30	SALES	    WARD	1250
30	SALES	    TURNER	1500
30	SALES	    ALLEN	1600
30	SALES	    JAMES	950
30	SALES	    BLAKE	2850
30	SALES	    MARTIN	1250
*/

SELECT DEPTNO, DNAME, ENAME, SAL
FROM EMP E JOIN DEPT D;
--==>> ���� �߻�
-- (ORA-00905: missing keyword)

SELECT DEPTNO, DNAME, ENAME, SAL
FROM EMP E NATURAL JOIN DEPT D;
--==>>
/*
10	ACCOUNTING	CLARK	2450
10	ACCOUNTING	KING	5000
10	ACCOUNTING	MILLER	1300
20	RESEARCH	JONES	2975
20	RESEARCH	FORD	3000
20	RESEARCH	ADAMS	1100
20	RESEARCH	SMITH	800
20	RESEARCH	SCOTT	3000
30	SALES	    WARD	1250
30	SALES	    TURNER	1500
30	SALES	    ALLEN	1600
30	SALES	    JAMES	950
30	SALES	    BLAKE	2850
30	SALES	    MARTIN	1250
*/

SELECT DEPTNO, DNAME, ENAME, SAL
FROM EMP E JOIN DEPT D
USING(DEPTNO);
--==>>
/*
10	ACCOUNTING	CLARK	2450
10	ACCOUNTING	KING	5000
10	ACCOUNTING	MILLER	1300
20	RESEARCH	JONES	2975
20	RESEARCH	FORD	3000
20	RESEARCH	ADAMS	1100
20	RESEARCH	SMITH	800
20	RESEARCH	SCOTT	3000
30	SALES	WARD	1250
30	SALES	TURNER	1500
30	SALES	ALLEN	1600
30	SALES	JAMES	950
30	SALES	BLAKE	2850
30	SALES	MARTIN	1250
*/



--------------------------------------------------------------------------------

--�� TBL_EMP ���̺����� �޿��� ���帹�� �����
--   �����ȣ, �����, ������, �޿� �׸��� ��ȸ�Ѵ�.
SELECT E.EMPNO �����ȣ, E.ENAME �����, E.JOB ������, E.SAL �޿� 
FROM TBL_EMP E
WHERE E.SAL = (SELECT MAX(SAL)
               FROM TBL_EMP);
--==>>
/*
�����ȣ	�����	������	    �޿�
7839	    KING	PRESIDENT	5000
*/


-- �޿��� ���� ���� �޴� ����� �޿�
SELECT MAX(SAL)
FROM TBL_EMP;
--==>> 5000

SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE �޿� = (�޿��� ���� ���� �޴� ����� �޿�);

SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL = (SELECT MAX(SAL)
             FROM TBL_EMP);
--==>> 7839	KING	PRESIDENT	5000


-- ��=ANY��   ~ �� �ϳ�

-- ��=ALL��   ��� ��

SELECT SAL
FROM TBL_EMP;
--==>>
/*
800
1600
1250
2975
1250
2850
2450
3000
5000
1500
1100
950
3000
1300
1500
2000
1700
2500
1000
*/

SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL = ANY (800, 1600, 1250, 2975, 1250, 2850, 2450, 3000, 5000, 1500, 1100, 950, 3000, 1300, 1500, 2000, 1700, 2500, 1000);

SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL >= ALL (800, 1600, 1250, 2975, 1250, 2850, 2450, 3000, 5000, 1500, 1100, 950, 3000, 1300, 1500, 2000, 1700, 2500, 1000);

SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL >= ALL (SELECT SAL
                  FROM TBL_EMP);
--==>> 7839	KING	PRESIDENT	5000

--�� TBL_EMP ���̺����� 20�� �μ��� �ٹ��ϴ� ����� �� �޿��� ���� ���� �����
--   �����ȣ, �����, ������, �޿� �׸��� ��ȸ�ϴ� �������� �����Ѵ�.

SELECT EMPNO �����ȣ, ENAME �����, JOB ������, SAL �޿�
FROM TBL_EMP
WHERE DEPTNO = 20 AND SAL >= ALL (SELECT SAL
                                  FROM TBL_EMP
                                  WHERE DEPTNO = 20);
--==>>
/*
7902	FORD	ANALYST	3000
7788	SCOTT	ANALYST	3000
*/

------------------------------------------------------------------------------
--���� Ǯ��
SELECT �����ȣ, �����, ������, �޿�
FROM TBL_EMP
WHERE SAL = (���帹���޿�)
      DEPTNO = 20;
      
SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL = (SELECT MAX(SAL)
             FROM TBL_EMP)
  AND DEPTNO = 20;
--==>> ��ȸ ��� ����

SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL = (SELECT MAX(SAL)
             FROM TBL_EMP
             WHERE DEPTNO = 20)
  AND DEPTNO = 20;
--==>
/*
7788	SCOTT	ANALYST	3000
7902	FORD	ANALYST	3000
*/

SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL >= ALL (SELECT SAL
                  FROM TBL_EMP
                  WHERE DEPTNO = 20) -- 800 2975 3000 1100 3000
  AND DEPTNO = 20;
  
SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL >= ALL (800 2975 3000 1100 3000) 
  AND DEPTNO = 20;

