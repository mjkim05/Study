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








