
SELECT USER
FROM DUAL;

TRUNCATE TABLE TBL_MEMBER;
--==>> Table TBL_MEMBER��(��) �߷Ƚ��ϴ�.

--�� ������ ����
CREATE SEQUENCE MEMBERSEQ
NOCACHE;
--==>> Sequence MEMBERSEQ��(��) �����Ǿ����ϴ�.

--�� ������ �Է� ������ ����
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES (MEMBERSEQ.NEXTVAL , '������' , '010-1111-1111')
;
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� Ȯ�� 
SELECT *
FROM TBL_MEMBER;
--==>> 1	������	010-1111-1111

--�� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.

--�� �ο��� Ȯ�� ������ ����
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBER;
--> ���� ����
SELECT COUNT(*) AS COUNT FROM TBL_MEMBER;
--==>> 1

--�� ��ü ����Ʈ ��ȸ ������ ����
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--> ���� ����
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID
;
--==>> 1	������	010-1111-1111
UPDATE TBL_MEMBER 
SET NAME = '�����'
WHERE SID = '3';

COMMIT;

DELETE
FROM TBL_MEMBER
WHERE SID = '4';
