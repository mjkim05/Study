
select user
from dual;

SELECT *
FROM TAB;


DROP TABLE TBL_MEMBER;
--==>> Table TBL_MEMBER이(가) 삭제되었습니다.

--○ 실습 테이블 생성
CREATE TABLE TBL_MEMBER
( SID NUMBER
, NAME VARCHAR2(30)
, TEL VARCHAR2(60)
, CONSTRAINT MEMBER_SID_PK PRIMARY KEY(SID)
);
--==>> Table TBL_MEMBER이(가) 생성되었습니다.

--○ 샘플 데이터 입력
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(1, '홍길동', '010-1111-1111');
--==>> 1 행 이(가) 삽입되었습니다.

--○ 확인
SELECT *
FROM TBL_MEMBER;

-- 커밋
COMMIT;
--==>> 커밋 완료.

--○ 자바에서 Test003.java 실행 후 다시 확인
SELECT *
FROM TBL_MEMBER;
--==>>
/*
1	홍길동	010-1111-1111
2	김민지	010-2222-2222
*/

--○ 자바에서 Test004.java 실행 후 다시 확인
SELECT *
FROM TBL_MEMBER;
--==>>
/*
1	홍길동	010-1111-1111
2	김민지	010-2222-2222
3	이주형	010-3333-3333
4	노은하	010-4444-4444
5	이윤수	010-5555-5555
6	박나영	010-6666-6666
*/


--○ 자바 TEST005.java 에서 실행할 조회 쿼리문 조회

SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--> 한줄 구성
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID
;
--==>> 
/*
1	홍길동	010-1111-1111
2	김민지	010-2222-2222
3	이주형	010-3333-3333
4	노은하	010-4444-4444
5	이윤수	010-5555-5555
6	박나영	010-6666-6666
*/

SELECT EMPNO, ENAME, JOB, SAL FROM EMP
;
commit;


