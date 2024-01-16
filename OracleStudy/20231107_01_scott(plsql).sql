SELECT USER
FROM DUAL;
--==>> SCOTT


--○ TBL_출고 테이블에서 출고수량을 수정(변경)하는 프로시저를 작성한다.
--   프로시저명 : PRC_출고_UPDATE()

/*
실행 예)
EXEC PRC_출고_UPDATE(출고번호, 변경할수량);
*/

--재고수량 - (수정 출고수량  - 출고수량 )
-- 상품 재고 수량 업데이트, 출고수량 업데이트 , 원래 가지고 있던 수량보다 업데이트되는 수량이 더 많을 경우 오류!


CREATE OR REPLACE PROCEDURE PRC_출고_UPDATE
( V_출고번호   IN TBL_출고.출고번호%TYPE
, V_변경수량   IN TBL_출고.출고수량%TYPE
)
IS
        V_상품코드 TBL_상품.상품코드%TYPE;
        V_재고수량 TBL_상품.재고수량%TYPE;
        V_출고수량 TBL_출고.출고수량%TYPE;
        USER_DEFINE_ERROR EXCEPTION;
BEGIN
        -- 상품코드 쿼리문 구성
        SELECT 상품코드 INTO V_상품코드
        FROM TBL_출고
        WHERE 출고번호 = V_출고번호;
        
        -- 재고수량 쿼리문 구성        
        SELECT 재고수량 INTO V_재고수량
        FROM TBL_상품
        WHERE 상품코드 = V_상품코드;
        
        --출고수량 쿼리문 구성
        SELECT 출고수량 INTO V_출고수량
        FROM TBL_출고
        WHERE 출고번호 = V_출고번호;
        
        -- 에러 코드 1
        IF (V_재고수량 + V_출고수량 < V_변경수량)
            THEN RAISE USER_DEFINE_ERROR;
        END IF;

        -- 쿼리문 구성 UPDAET 
        UPDATE TBL_출고
        SET 출고수량 = V_변경수량
        WHERE 출고번호 = V_출고번호;
        

        --쿼리문 구성 UPDATE
        UPDATE TBL_상품
        SET 재고수량 = 재고수량 - (V_변경수량 - V_출고수량)
        WHERE 상품코드 = V_상품코드;

        -- 예외처리 2
        EXCEPTION 
            WHEN USER_DEFINE_ERROR
                THEN RAISE_APPLICATION_ERROR(-20002, '재고 부족~!!!');
                ROLLBACK;
            WHEN OTHERS
                THEN ROLLBACK;
        -- 커밋 
        COMMIT;
END;
--==>> Procedure PRC_출고_UPDATE이(가) 컴파일되었습니다.

-- 수업 ------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE PRC_출고_UPDATE
(   
    --① 매개변수 구성
  V_출고번호    IN TBL_출고.출고번호%TYPE
, V_출고수량    IN TBL_출고.출고수량%TYPE
)
IS 
    -- ③ 필요한 변수 선언
    V_상품코드      TBL_상품.상품코드%TYPE;
    V_이전출고수량  TBL_출고.출고수량%TYPE;
    V_재고수량      TBL_상품.재고수량%TYPE;
    
    USER_DEFINE_ERROR EXCEPTION;
BEGIN
    
    --④ 선언한 변수에 값 담아내기
    --⑥
    SELECT 상품코드,출고수량 INTO V_상품코드, V_이전출고수량
    FROM TBL_출고
    WHERE 출고번호 = V_출고번호;
    
    --⑧ 출고 정상수행여부 판단 필요
    --   변경 이전의 출고수량 및 현재의 재고수량 확인
    SELECT 재고수량 INTO V_재고수량
    FROM TBL_상품
    WHERE 상품코드 = V_상품코드;
    
    --⑨ 파악한 재고수량에 따라 데이터변경 실시 여부 판단
    --   (『재고수량+이전출고수량 < 현재출고수량』인 상황이라면... 사용자정의예외 발생 )
    IF (V_재고수량+ V_이전출고수량 < V_출고수량)
        -- THEN 사용자정의 예외 발생
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    
    --② 수행될 쿼리문 체크(UPDATE → TBL_출고 / UPDATE → TBL_상품 )
    UPDATE TBL_출고
    SET 출고수량 = V_출고수량
    WHERE 출고번호 = V_출고번호;
    
    --⑤
    UPDATE TBL_상품
    SET 재고수량 = 재고수량 + (V_이전출고수량 - V_출고수량)
    WHERE 상품코드 = V_상품코드;
    
    --⑩ 에외처리 
    EXCEPTION 
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002 , '재고부족~~!!');
            ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
      
    --⑦ 커밋
    --COMMIT;
    
END;
--==>> Procedure PRC_출고_UPDATE이(가) 컴파일되었습니다.

--------------------------------------------------------------------------------

/*
1. PRC_입고_UPDATE (입고번흐, 입고수량)
2. PRC_입고_DELETE (입고번호)
3. PRC_출고_DELETE (출고번호)
*/

-- 1. PRC_입고_UPDATE (입고번흐, 입고수량)
CREATE OR REPLACE PROCEDURE PRC_입고_UPDATE
( -- 매개변수 선언
  V_입고번호    IN TBL_입고.입고번호%TYPE
, V_입고수량    IN TBL_입고.입고수량%TYPE
)
IS
    -- 변수 선언부 
    V_상품코드 TBL_상품.상품코드%TYPE;
    V_기존입고수량 TBL_입고.입고수량%TYPE;
    V_재고수량 TBL_상품.재고수량%TYPE;
    
    -- 예외처리 변수 선언
    USER_DEFINE_ERROR EXCEPTION;
    
BEGIN   

    -- 선언한 변수에 값 넣기 
    SELECT 상품코드, 입고수량 INTO V_상품코드 , V_기존입고수량
    FROM TBL_입고
    WHERE 입고번호 = V_입고번호;
    
    SELECT 재고수량 INTO V_재고수량
    FROM TBL_상품 
    WHERE 상품코드 = V_상품코드;

    IF ( V_재고수량 + (V_입고수량 - V_기존입고수량) < 0)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
       
    -- UPDATE 쿼리문 구성 → TBL_입고 , TBL_상품
    UPDATE TBL_입고
    SET 입고수량 = V_입고수량
    WHERE 입고번호 = V_입고번호;
    
    UPDATE TBL_상품
    SET 재고수량 = 재고수량 - (V_기존입고수량-V_입고수량)
    WHERE 상품코드 = V_상품코드;
    
    -- 예외처리
    EXCEPTION 
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '재고부족~~!!');
            ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
   
    -- 커밋
    COMMIT;
END;
--==>> Procedure PRC_입고_UPDATE이(가) 컴파일되었습니다.

-- 2. PRC_입고_DELETE (입고번호)
CREATE OR REPLACE PROCEDURE PRC_입고_DELETE
(   -- 매개변수 선언
    V_입고번호 IN TBL_입고.입고번호%TYPE
)
IS  
    -- 선언부 
    -- 필요한 변수를 선언
    V_상품코드 TBL_상품.상품코드%TYPE;
    V_입고수량 TBL_입고.입고수량%TYPE;
    V_재고수량 TBL_상품.재고수량%TYPE;
    
    -- 예외처리 변수 선언 
    USER_DEFINE_ERROR EXCEPTION; 
BEGIN 
    -- 선언한 변수에 값 넣기
    SELECT 상품코드, 입고수량 INTO V_상품코드, V_입고수량
    FROM TBL_입고
    WHERE 입고번호 = V_입고번호;
    
    SELECT 재고수량 INTO V_재고수량
    FROM TBL_상품
    WHERE 상품코드 = V_상품코드;
    
    IF (V_재고수량 - V_입고수량  < 0)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;

    -- DELETE 쿼리문 구성 → TBL_입고
    DELETE 
    FROM TBL_입고
    WHERE 입고번호 = V_입고번호;
       
    -- UPDATE 쿼리문 구성 → TBL_상품
    UPDATE TBL_상품
    SET 재고수량 = 재고수량 - V_입고수량
    WHERE 상품코드 = V_상품코드;
    
    -- 예외처리 쿼리문 구성   
    EXCEPTION 
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '재고부족~~!!!');
            ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
    --커밋
    --COMMIT;   
END;
--==>> Procedure PRC_입고_DELETE이(가) 컴파일되었습니다.

-- 3. PRC_출고_DELETE (출고번호)
CREATE OR REPLACE PROCEDURE PRC_출고_DELETE
(   
    -- 매개변수 선언
    V_출고번호 IN TBL_출고.출고번호%TYPE
)
IS
    -- 선언부
    -- 필요한 변수 선언
    V_상품코드 TBL_상품.상품코드%TYPE;
    V_출고수량 TBL_출고.출고수량%TYPE;
BEGIN
    
    -- 선언한 변수에 값을 넣기
    SELECT 상품코드, 출고수량 INTO V_상품코드 , V_출고수량
    FROM TBL_출고
    WHERE 출고번호 = V_출고번호;

    -- DELETE 쿼리문 구성 → TBL_출고 
    DELETE 
    FROM TBL_출고
    WHERE 출고번호 = V_출고번호;
    
    -- UPDATE 쿼리문 구성 → TBL_상품
    UPDATE TBL_상품
    SET 재고수량 = 재고수량 + V_출고수량
    WHERE 상품코드 = V_상품코드;
   
     --커밋
     -- COMMIT;
END;
--==>> Procedure PRC_출고_DELETE이(가) 컴파일되었습니다.

--------------------------------------------------------------------------------

--■■■ CURSOR (커서) ■■■--  깜짝 놀이 상자~.~

-- 1. 오라클에서는 하나의 레코드가 아닌 여러개의 레코드로 구성된 
--    작업 영역에서 SQL문을 실행하고 그과정에서 발생한 정보를 
--    저장하기 위해 커서(CURSOR)를 사용하며
--    커서에는 암시적인 커서와 명시적인 커서가 있다.
--    암시적 커서는 모든 SQL 구문에 존재하며
--    SQL 문 실행 후 오직 하나의 행(ROW)만 출력하게 된다.
--    그러나 SQL문 실행한 결과물(RESULT SET)이 
--    여러 행(ROW)으로 구성된 경우 
--    커서(CURSOR)를 명시적으로 선언해야 여러 행(ROW)을 다룰 수 있다.

--○ 커서 이용 전 상황 (단일 행 접근 시)

SET SERVEROUTPUT ON; 
--==>> 작업이 완료되었습니다. (0.039초)

DECLARE 
      V_NAME  TBL_INSA.NAME%TYPE; 
      V_TEL   TBL_INSA.TEL%TYPE;
BEGIN
    SELECT NAME , TEL INTO V_NAME, V_TEL
    FROM TBL_INSA
    WHERE NUM = 1001;
    
    DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);
    
END;
--==>> 홍길동 -- 011-2356-4528

DECLARE 
      V_NAME  TBL_INSA.NAME%TYPE; 
      V_TEL   TBL_INSA.TEL%TYPE;
BEGIN
    SELECT NAME , TEL INTO V_NAME, V_TEL
    FROM TBL_INSA;
    
    DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);
    
END;
--==>> 에러발생 
--     (ORA-01422: exact fetch returns more than requested number of rows)

--○ 커서 이용 전 상황(다중행 접근 시 - 반복문 활용)
DECLARE 
      V_NAME  TBL_INSA.NAME%TYPE; 
      V_TEL   TBL_INSA.TEL%TYPE;    
      V_NUM   TBL_INSA.NUM%TYPE;      
BEGIN
    
   FOR V_NUM IN 1001.. 1062 LOOP 
   
        SELECT NAME , TEL INTO V_NAME, V_TEL
        FROM TBL_INSA
        WHERE NUM = V_NUM;
        
        DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);    
        
        V_NUM := V_NUM + 1;            
   END LOOP;
END;

--------------------------------------------------------------------------------

DECLARE 
      V_NAME  TBL_INSA.NAME%TYPE; 
      V_TEL   TBL_INSA.TEL%TYPE;    
      V_NUM   TBL_INSA.NUM%TYPE := 1001;      
BEGIN
   
    LOOP
        SELECT NAME ,TEL INTO V_NAME, V_TEL
        FROM TBL_INSA
        WHERE NUM = V_NUM;
        
        DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);    
        
        V_NUM := V_NUM + 1;
        
        EXIT WHEN V_NUM >= 1062;
        
    END LOOP;
            
END;

-- 커서 정의 구문
/*
일반변수 → 선언
예외변수 → 선언

변수명 자료형
V_NUM  NUMBER;
U_ERR  EXCEPTION;
커서명 CURSOR;  → Ⅹ
*/

/*
커서 → 정의

TABLE 테이블명
INDEX 인덱스명
USER 유저명

CURSOR 커서명   → (○) ★★★

*/

--○ 커서 이용 후 상황
DECLARE
    --주요 변수 선언
    V_NAME  TBL_INSA.NAME%TYPE;
    V_TEL   TBL_INSA.TEL%TYPE;
    
    -- 커서 이용을 위한 커서 정의      CHECEK~!!
    CURSOR CUR_INSA_SELECT
    IS 
    SELECT NAME, TEL
    FROM TBL_INSA;
    
BEGIN
    -- 오픈 커서
    OPEN CUR_INSA_SELECT;
    
    -- 커서 오픈 시 (와~~!!!)쏟아져나오는 데이터 처리(반복문을 활용하여 처리) 
    LOOP
        -- 한 행 한 행 받아다가 처리하는 행위 → 가져오다(데려오다) → 『FETCH』
        FETCH CUR_INSA_SELECT INTO V_NAME , V_TEL;
        
        -- 언제까지???? (EXIT WHEN )
        -- → 커서에서 더 이상 데이터가 쏟아져 나오지 않는 상태... → 『NOTFOUND』
        EXIT WHEN CUR_INSA_SELECT%NOTFOUND;
        
        -- 출력
         DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);    
        
    END LOOP;
    
    -- 클로즈 커서   
    -- 오라클이 정의해주는 커서는 클로즈를 안쓰기도 한다.
    -- 따라서 클로즈 구문을 사용했는데 오류가 날 경우 클로즈를 주석처리하거나 지우면 해결 되기도 한다!!
    CLOSE CUR_INSA_SELECT;
END;

--------------------------------------------------------------------------------

--■■■ TRIGGER(트리거) ■■■--

-- 사전적인 의미 : 방아쇠, 촉발시키다, 야기하다, 유발하다.

--1. TRIGGER(트리거)란 DML 작업 즉, INSERT, UPDATE, DELETE 작업이 일어날 때 
--   자동으로 실행되는(유발되는, 촉발되는) 객체로
--   이와 같은 특징을 강조하여 DML TRIGGER 라고 부르기도 한다.
--   TRIGGER 는 무결성 뿐 아니라
--   다음과 같은 작업에도 널리 사용된다.

-- 자동으로 파생된 열 값 생성 
-- 잘못된 트랙잭션 방지
-- 복잡한 보안 권한 강제 수행 
-- 분산 데이터베이스 노드 상에서 참조 무결성 강제 수행
-- 복잡한 업무 규칙 강제 적용 
-- 투명한 이벤트 로깅 제공 
-- 복잡한 감사 제공 
-- 동기 테이블 복제 유지 관리 
-- 테이블 액세스 통계 수집

--2. TRIGGER 트리거 내에서는 COMMIT, ROLLBACK 문을 사용할 수 없다.

--3. 특징 및 종류 
--   - BEFORE STATEMENT ┐(맞기전에 주먹막아!) 단일 값에 대한 처리라면
--   - BEFORE ROW       ┘ 사전에 해야하는 것! 테이블 각각의 행들을 살펴봐야 하는 거면 
--   - AFTER STATEMENT  ┐(떠드는 사람! 이름 적어!) 단일 값에 대한 처리라면
--   - AFTER ROW        ┘ 사후에 해야하는 것! 테이블 각각의 행들을 살펴봐야 하는 거면 

--4. 형식 및 구조 
/*
CREATE [OR REPLACE] TRIGGER 트리거명 
    [BEFORE | AFTER]
    이벤트 1 [OR 이벤트2[OR 이벤트3]] ON 테이블명
    [FOR EACH ROW [WHEN TRIGGER 조건]]
    (위해 각각의 행) (ROW 트리거 쓸때 사용! STATEMENT 트리거는 생략!)
[DECLARE]
    -- 선언 구문;
BEGIN
    -- 실행 구문;
END;
*/

--■■■ AFTER STATEMENT TRIGGER 상황 실습 ■■■-- 
-- ※ DML 작업에 대한 이벤트 기록 (떠든 사람 이름 적어~ ㅡㅡ^)

--○ TRIGGER(트리거) 생성

CREATE OR REPLACE TRIGGER TRG_EVENTLOG
        AFTER 
        INSERT OR UPDATE OR DELETE ON TBL_TEST1
BEGIN
    -- 이벤트 종류 구분 (조건문을 통한 분기)
    IF (INSERTING)  -- ING 로 사용 ★
        THEN INSERT INTO TBL_EVENTLOG(MEMO)
            VALUES('INSERT 쿼리가 실행되었습니다.');
    ELSIF (UPDATING)
        THEN INSERT INTO TBL_EVENTLOG(MEMO)
            VALUES('UPDATE 쿼리가 실행되었습니다.');
    ELSIF (DELETING)
        THEN INSERT INTO TBL_EVENTLOG(MEMO)
            VALUES('DELETE 쿼리가 실행되었습니다.');
    END IF;
    
    -- COMMIT;
    -- ※ TRIGGER 내에서는 COMMIT / ROLLBACK 구문 사용 불가~~!! CHECK~~!!
END;
--==>> Trigger TRG_EVENTLOG이(가) 컴파일되었습니다.

--■■■ BEFORE STATEMENT TRIGGER 상황 실습 ■■■--
-- ※ DML 작업 수행 전에 작업에 대한 가능여부 확인 

--○ TRIGGER(트리거) 생성 → TRG_TEST1_DML
CREATE OR REPLACE TRIGGER TRG_TEST1_DML
        BEFORE 
        INSERT OR UPDATE OR DELETE ON TBL_TEST1
BEGIN
    IF (작업시간이 오전 9시 이전이거나... 오후 6시 이후라면...)
        THEN 작업을 수행하지 못하도록 처리하겠다.
    END IF;
END;

CREATE OR REPLACE TRIGGER TRG_TEST1_DML
        BEFORE 
        INSERT OR UPDATE OR DELETE ON TBL_TEST1
BEGIN
    IF ( TO_NUMBER(TO_CHAR(SYSDATE,'HH24')) < 9 OR TO_NUMBER(TO_CHAR(SYSDATE,'HH24')) > 17 )    -- 시간계산 신경쓰기!
        THEN RAISE_APPLICATION_ERROR(-20003 , '작업시간은 09:00 ~ 18:00 까지만 가능합니다.');
    END IF;
END;

--==>> Trigger TRG_TEST1_DML이(가) 컴파일되었습니다.

--■■■ BEFORE ROW TRIGGER 상황 실습 ■■■--
-- ※ 참조 관계가 설정된 데이터(자식) 삭제를 먼저 수행하는 모델

--○ TRIGGER(트리거) 생성 → TRG_TEST2_DELETE

CREATE OR REPLACE TRIGGER TRG_TEST2_DELETE
        BEFORE 
        DELETE ON TBL_TEST2
        FOR EACH ROW                    -- CHECK~~!!
BEGIN 
    DELETE 
    FROM TBL_TEST3 
    WHERE CODE = :OLD.CODE;
END;
--==>> Trigger TRG_TEST2_DELETE이(가) 컴파일되었습니다.

--※ 『:OLD』
--    참조 전 열의 값
--    - INSERT : 입력하기 이전 자료 즉, 입력할 자료
--    - DELETE : 삭제하기 이전 자료 즉, 삭제할 자료

--※ UPDATE 
--   내부적으로 DELETE 그리고 INSERT 가 결합된 형태
--   UPDATE 하기 이전 데이터는 『:OLD』
--   UPDATE 수행한 이후의 데이터는 『:NEW』


--■■■ AFTER ROW TRIGGER 상황 실습 ■■■--
-- ※ 참조 테이블 관련 트랜잭션 처리
-- 하나의 행위가 여러 레코드의 영향을 미치는 경우는 주로 ROW 트리거 사용

CREATE OR REPLACE TRIGGER TRG_IBGO
        AFTER 
        INSERT ON TBL_입고
        FOR EACH ROW
BEGIN
    IF (INSERTING)
        THEN UPDATE TBL_상품 
             SET 재고수량 = 재고수량 + 새로입고되는수량
             WHERE 상품코드 = 새로입고되는상품코드;
             
    END IF;
END;
        

CREATE OR REPLACE TRIGGER TRG_IBGO
        AFTER 
        INSERT ON TBL_입고
        FOR EACH ROW
BEGIN
    IF (INSERTING)
        THEN UPDATE TBL_상품 
             SET 재고수량 = 재고수량 + :NEW.입고수량
             WHERE 상품코드 = :NEW.상품코드;
             
    END IF;
END;
--==>> Trigger TRG_IBGO이(가) 컴파일되었습니다.      
        

--○ TBL_입고 테이블의 입력, 수정, 삭제 시 
--   TBL_상품테이블의 재고 수량 트리거 작성
--   트리거명 : TRG_IBGO 

CREATE OR REPLACE TRIGGER TRG_IBGO
        AFTER
        INSERT OR UPDATE OR DELETE ON TBL_입고
        FOR EACH ROW
BEGIN  
    IF (INSERTING)
        THEN UPDATE TBL_상품
             SET 재고수량 = 재고수량 + :NEW.입고수량
             WHERE 상품코드 = :NEW.상품코드;
    ELSIF (UPDATING)
        THEN UPDATE TBL_상품
             SET 재고수량 = 재고수량 - :OLD.입고수량 + :NEW.입고수량
             WHERE 상품코드 = :OLD.상품코드;       
    ELSIF (DELETING)
        THEN UPDATE TBL_상품
             SET 재고수량 = 재고수량 - :OLD.입고수량
             WHERE 상품코드 = :OLD.상품코드;
    END IF;
END;
--==>> Trigger TRG_IBGO이(가) 컴파일되었습니다.



SELECT *
FROM TAB;







