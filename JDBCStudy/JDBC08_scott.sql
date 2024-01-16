SELECT USER
FROM DUAL;
--==>> SCOTT

SELECT *
FROM TBL_MEMBER
ORDER BY SID;
--==>>
/*
1	이윤수	010-1111-1111
2	임하성	010-3333-3333
3	김민지	010-4444-4444
5	문정환	010-5555-5555
6	정한울	010-6666-6666
7	이윤수	010-7777-7777
8	길현욱	010-8888-8888
*/

TRUNCATE TABLE TBL_MEMBER;
--==>> Table TBL_MEMBER이(가) 잘렸습니다.

SELECT *
FROM TBL_MEMBER
ORDER BY SID;
--==>> 조회결과 없음

DROP SEQUENCE MEMBERSEQ;
--==>> Sequence MEMBERSEQ이(가) 삭제되었습니다.

--○ CallableStatement 실습을 위한 프로시저 작성
--   프로시저 명   : PRC_MEMBERINSERT
--   프로시저 가능 : TBL_MEMBER 테이블에 데이터를 입력하는 프로시저 (이름 전화번호) 

CREATE OR REPLACE PROCEDURE PRC_MEMBERINSERT
(V_NAME  IN   TBL_MEMBER.NAME%TYPE
,V_TEL   IN   TBL_MEMBER.TEL%TYPE
)
IS
    V_SID TBL_MEMBER.SID%TYPE;
BEGIN

    SELECT NVL(MAX(SID),0) + 1 INTO V_SID
    FROM TBL_MEMBER;
    
    -- INSERT 문 작성
    INSERT INTO TBL_MEMBER (SID, NAME, TEL) 
    VALUES (V_SID, V_NAME, V_TEL);
    
    -- 커밋 
    COMMIT;
END;
--==>> Procedure PRC_MEMBERINSERT이(가) 컴파일되었습니다.

-- 대장장이 파이팅^^.... 교대로 잘 다녀옵시다^^....


SELECT *
FROM TBL_MEMBER
ORDER BY SID;


--○ CallableStatement 실습을 위한 프로시저 생성
--   Test002.java 실습
--   프로시저 명   : PRC_MEMBERSELECT
--   프로시저 기능 : TBL_MEMBER 테이블의 데이터를 읽어오는 프로시저 
--   ※ 『SYS_REFCURSOR』 자료형을 이용하여 커서 다루기
CREATE OR REPLACE PROCEDURE PRC_MEMBERSELECT
( VRESULT OUT SYS_REFCURSOR
)
IS 
    -- 주요 변수 선언
    -- 커서 정의 → 출력용 매개변수로 대체
BEGIN 
    OPEN VRESULT FOR          -- 빈 커서에 아래와 같은 내용을 담겠다!
        SELECT SID , NAME , TEL
        FROM TBL_MEMBER
        ORDER BY SID;
        
    -- CLOSE VRESULT; 참조 형태 커서는 닫지 않는다!! 

    -- COMMIT;                -- SELECT 문이기 때문에 커밋 쓰면 안됨!    
END;
--==>> Procedure PRC_MEMBERSELECT이(가) 컴파일되었습니다.




