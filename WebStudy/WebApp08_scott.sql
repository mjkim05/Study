SELECT USER
FROM DUAL;

SELECT *
FROM TAB;

-- ������ ����
PURGE RECYCLEBIN;

SELECT *
FROM TAB;

-- ���� ���̺� ����
DROP TABLE TBL_MEMBER;
--==>> Table TBL_MEMBER��(��) �����Ǿ����ϴ�.

DROP SEQUENCE MEMBERSEQ;

--------------------------------------------------------------------------------
--�� �ǽ� ���̺� ���� (TBL_MEMBER)
CREATE TABLE TBL_MEMBER
( SID   NUMBER
, NAME  VARCHAR2(30)
, TEL   VARCHAR2(40)
, CONSTRAINT MEMBER_SID_PK PRIMARY KEY(SID)
);
--==>> Table TBL_MEMBER��(��) �����Ǿ����ϴ�.

--�� ������ ����
CREATE SEQUENCE MEMBERSEQ
NOCACHE;
--==>> Sequence MEMBERSEQ��(��) �����Ǿ����ϴ�.

--�� ������ �Է� ������ ����
INSERT INTO TBL_MEMBER(SID,NAME,TEL)
VALUES(MEMBERSEQ.NEXTVAL,'����ȯ','010-1111-1111');
--> ���� ����
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(MEMBERSEQ.NEXTVAL,'����ȯ','010-1111-1111')
;
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(MEMBERSEQ.NEXTVAL,'���ѿ�','010-1111-1111')
;
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(MEMBERSEQ.NEXTVAL,'������','010-3333-3333')
;
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(MEMBERSEQ.NEXTVAL,'������','010-4444-4444')
;

--�� ���̺� ��ȸ ������ ����(����Ʈ Ȯ��)
SELECT *
FROM TBL_MEMBER
ORDER BY SID;

--> ���ٷ� ����
SELECT * FROM TBL_MEMBER ORDER BY SID
;
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID;

--==>> 
/*
1	����ȯ	010-1111-1111
2	���ѿ�	010-1111-1111
3	������	010-3333-3333
4	������	010-4444-4444
*/

--�� �ο� �� Ȯ�� ������ ����
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBER;

-- ���� ����
SELECT COUNT(*) AS COUNT FROM TBL_MEMBER
;

COMMIT;
