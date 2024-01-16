select user
from dual;
-->from dual;

--�� �����ǽ��� �̿��ߴ� �����͵� ����
truncate table tbl_score;
-->Table TBL_SCORE��(��) �߷Ƚ��ϴ�.


--�� ���� �ǽ��� �̿��ߴ� ������ ����
drop sequence scoreseq;
-->Sequence SCORESEQ��(��) �����Ǿ����ϴ�.

--�� ������ �ٽ� ����
create sequence scoreseq
NOCACHE;
-->Sequence SCORESEQ��(��) �����Ǿ����ϴ�.



--�� ������ �غ�

-- 1. ������ �Է� ������ ����
INSERT INTO TBL_SCORE(SID,NAME,KOR,ENG,MAT)
VALUES(SCORESEQ.NEXTVAL,'������',90,80,70);
---> ���ٷ� ����

INSERT INTO TBL_SCORE(SID,NAME,KOR,ENG,MAT) VALUES(SCORESEQ.NEXTVAL,'������',90,80,70)
;
--> 1 �� ��(��) ���ԵǾ����ϴ�.

SELECT *
FROM TBL_SCORE;
--> 1   ������   90   80   70

--�� Ŀ��
COMMIT;
-->Ŀ�� �Ϸ�.


--2. ����Ʈ ��� ������ ����(����, ���, ����)
SELECT  SID, NAME, KOR,ENG,MAT 
      ,(KOR + ENG + MAT) AS TOT
      ,(KOR + ENG + MAT) /3 AS AVG
      ,RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK
FROM TBL_SCORE
ORDER BY SID ASC;
--> ���ٷ� ����
SELECT  SID, NAME, KOR,ENG,MAT ,(KOR + ENG + MAT) AS TOT ,(KOR + ENG + MAT) /3 AS AVG ,RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK FROM TBL_SCORE ORDER BY SID ASC
;
--> 1   ������   90   80   70   240   80   1

--3. �ο��� ��ȸ�ϴ� ������ ����
SELECT COUNT(*) AS COUNT
FROM TBL_SCORE;
-->���ٷ� ����
SELECT COUNT(*) AS COUNT FROM TBL_SCORE
;
--> 1

-- 4. �̸� �˻� ������ ����(����,���,������ ���Ե� ����Ʈ ���·� ��ȸ)

SELECT SID, NAME,KOR,ENG,MAT,TOT,AVG,RANK
FROM 
(
    SELECT SID, NAME, KOR, ENG, MAT
        , (KOR+ENG+MAT) AS TOT 
        , (KOR+ENG+MAT)/3 AS AVG
        , RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK
    FROM TBL_SCORE
)
WHERE NAME = '������';


SELECT SID, NAME,KOR,ENG,MAT,TOT,AVG,RANK FROM(SELECT SID, NAME, KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT, (KOR+ENG+MAT)/3 AS AVG, RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK FROM TBL_SCORE) WHERE NAME = '������'
;

SELECT SID, NAME,KOR,ENG,MAT,TOT,AVG,RANK
FROM 
(
    SELECT SID, NAME, KOR, ENG, MAT
    , (KOR+ENG+MAT) AS TOT, (KOR+ENG+MAT)/3 AS AVG
    , RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK
    FROM TBL_SCORE
)
WHERE SID = 1;

SELECT SID, NAME,KOR,ENG,MAT,TOT,AVG,RANK FROM (SELECT SID, NAME, KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT  (KOR+ENG+MAT)/3 AS AVG, RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK FROM TBL_SCORE) WHERE SID = 1
;
--==>> ���� ����

--6. ������ ���� ������ ����
UPDATE TBL_SCORE
SET NAME = '�����', KOR =100, ENG=90,MAT=8
WHERE SID = 1;

UPDATE TBL_SCORE SET NAME = '�����', KOR =100, ENG=90,MAT=8 WHERE SID = 1
;

SELECT *
FROM TBL_SCORE;

COMMIT;

-- 7. ������ ���� ������ ����
DELETE
FROM TBL_SCORE
WHERE SID =1;
--==> ���� ����
DELETE FROM TBL_SCORE WHERE SID =1
;

ROLLBACK;