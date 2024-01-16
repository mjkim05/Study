
SELECT USER
FROM DUAL;

TRUNCATE TABLE TBL_MEMBER;
--==>> Table TBL_MEMBER이(가) 잘렸습니다.

--○ 시퀀스 생성
CREATE SEQUENCE MEMBERSEQ
NOCACHE;
--==>> Sequence MEMBERSEQ이(가) 생성되었습니다.

--○ 데이터 입력 쿼리문 구성
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES (MEMBERSEQ.NEXTVAL , '이윤수' , '010-1111-1111')
;
--==>> 1 행 이(가) 삽입되었습니다.

--○ 확인 
SELECT *
FROM TBL_MEMBER;
--==>> 1	이윤수	010-1111-1111

--○ 커밋
COMMIT;
--==>> 커밋 완료.

--○ 인원수 확인 쿼리문 구성
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBER;
--> 한줄 구성
SELECT COUNT(*) AS COUNT FROM TBL_MEMBER;
--==>> 1

--○ 전체 리스트 조회 쿼리문 구성
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--> 한줄 구성
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID
;
--==>> 1	이윤수	010-1111-1111
UPDATE TBL_MEMBER 
SET NAME = '김민지'
WHERE SID = '3';

COMMIT;

DELETE
FROM TBL_MEMBER
WHERE SID = '4';

