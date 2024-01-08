SELECT USER
FROM DUAL;
--==> SCOTT

-- ���� ��ȣȭ �� ��ȣȭ 03 ����

-- ���̺� ����
CREATE TABLE TBL_PACKAGETEST
( ID    NUMBER
, KEY   VARCHAR2(40)
, PW    VARCHAR2(40)
);
--==>> Table TBL_PACKAGETEST��(��) �����Ǿ����ϴ�.

--�� ������ �Է� (�� ��ȣȭ)
INSERT INTO TBL_PACKAGETEST(ID,PW) VALUES(1,'abcd1234'); 
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� Ȯ��
SELECT *
FROM TBL_PACKAGETEST;
--===>> 1	(null)	abcd1234

--�� �ѹ�
ROLLBACK;


--�� �ٽ� ������ �Է� (��ȣȭ)
INSERT INTO TBL_PACKAGETEST(ID,KEY,PW) 
VALUES(1,'abcd1234',CRYPTPACK.ENCRYPT('abcd1234','abcd1234'));
-- 'abcd1234' (�н�����)�� 
-- 'abcd1234' (Ű)�� ��ȣȭó��
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� Ȯ�� (�溹ȣȭ ������ �������� �ʰ� �Ϲ����� ��ȸ�� ����)
SELECT *
FROM TBL_PACKAGETEST;
--==>> 1	abcd1234	c":5?

--�� ������ ��ȸ (��ȣȭ �� ��ȣȭ �������� ������ KEY �� �ƴ� �߸��� KEY �� ���� ��ȣȭ)
SELECT ID, CRYPTPACK.DECRYPT(PW,'1111') "��� Ȯ��"
FROM TBL_PACKAGETEST;
--==>> 1	?f+??

SELECT ID, CRYPTPACK.DECRYPT(PW,'abcd') "��� Ȯ��"
FROM TBL_PACKAGETEST;
--==>> 1	G?"!?

--�� ������ ��ȸ (��ȣȭ �� ��ȣȭ �������� ������ KEY�� ���� ��ȣȭ)
SELECT ID, CRYPTPACK.DECRYPT(PW,'abcd1234') "��� Ȯ��"
FROM TBL_PACKAGETEST;
--==>> 1	abcd1234





