SELECT USER
FROM DUAL;
--==>> SCOTT

--○ TBL_출고 테이블의 데이터 입력, 수정, 삭제 시
--   TBL_상품 테이블의 해당 상품에 대한 재고수량 변동 트리거 작성
--   트리거명 : TRG_CHULGO
--   제출 파일명 : 오라클_트리거_김민지.sql
--   재고 부족 관련 예외처리할것

CREATE OR REPLACE TRIGGER TRG_CHULGO
       AFTER 
       INSERT OR UPDATE OR DELETE ON TBL_출고
       FOR EACH ROW
DECLARE 
    --선언부 
     T_재고수량 TBL_상품.재고수량%TYPE;
BEGIN
        -- 선언한 변수에 값 넣기
        IF (INSERTING OR UPDATING)
         THEN SELECT 재고수량 INTO T_재고수량
              FROM TBL_상품
              WHERE 상품코드 = :NEW.상품코드;
        END IF;
        
        -- 조건에 따른 분기 설정하기!
        IF (T_재고수량 < :NEW.출고수량)
           THEN RAISE_APPLICATION_ERROR(-20002,'재고부족~~!!');
        ELSIF (INSERTING)
            THEN UPDATE TBL_상품
                 SET 재고수량 = 재고수량 - :NEW.출고수량
                 WHERE 상품코드 = :NEW.상품코드;
        ELSIF (UPDATING)
            THEN UPDATE TBL_상품
                 SET 재고수량 = 재고수량 + :OLD.출고수량 - :NEW.출고수량
                 WHERE 상품코드 = :OLD.상품코드;
        END IF;         
       
        IF (DELETING)
            THEN UPDATE TBL_상품
                 SET 재고수량 = 재고수량 + :OLD.출고수량
                 WHERE 상품코드 = :OLD.상품코드;
        END IF;  
END;
---==>> Trigger TRG_CHULGO이(가) 컴파일되었습니다.





