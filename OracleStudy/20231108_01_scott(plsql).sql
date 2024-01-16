SELECT USER
FROM DUAL;
--==>> SCOTT

--�� TBL_��� ���̺��� ������ �Է�, ����, ���� ��
--   TBL_��ǰ ���̺��� �ش� ��ǰ�� ���� ������ ���� Ʈ���� �ۼ�
--   Ʈ���Ÿ� : TRG_CHULGO
--   ���� ���ϸ� : ����Ŭ_Ʈ����_�����.sql
--   ��� ���� ���� ����ó���Ұ�

CREATE OR REPLACE TRIGGER TRG_CHULGO
       AFTER 
       INSERT OR UPDATE OR DELETE ON TBL_���
       FOR EACH ROW
DECLARE 
    --����� 
     T_������ TBL_��ǰ.������%TYPE;
BEGIN
        -- ������ ������ �� �ֱ�
        IF (INSERTING OR UPDATING)
         THEN SELECT ������ INTO T_������
              FROM TBL_��ǰ
              WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
        END IF;
        
        -- ���ǿ� ���� �б� �����ϱ�!
        IF (T_������ < :NEW.������)
           THEN RAISE_APPLICATION_ERROR(-20002,'������~~!!');
        ELSIF (INSERTING)
            THEN UPDATE TBL_��ǰ
                 SET ������ = ������ - :NEW.������
                 WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
        ELSIF (UPDATING)
            THEN UPDATE TBL_��ǰ
                 SET ������ = ������ + :OLD.������ - :NEW.������
                 WHERE ��ǰ�ڵ� = :OLD.��ǰ�ڵ�;
        END IF;         
       
        IF (DELETING)
            THEN UPDATE TBL_��ǰ
                 SET ������ = ������ + :OLD.������
                 WHERE ��ǰ�ڵ� = :OLD.��ǰ�ڵ�;
        END IF;  
END;
---==>> Trigger TRG_CHULGO��(��) �����ϵǾ����ϴ�.

/*
    ^---^
   ('��' )
   /     \  ��
 �������� )��
 
  ^------^
(  '(00)'  )

*/

-- =3=33

--------------------------------------------------------------------------------

--���� PACKAGE (��Ű��) ����--
-- 1. PL/SQL �� ��Ű�� ����Ǵ� Ÿ��, ���α׷� ��ü,
-- ���� ���α׷�(PROCEDURE, FUNCTION ��)�� 
-- �ڡ� �������� ������� ���̴�.  �� ���Ǽ� ������ ����!  
-- ����Ŭ���� �����ϴ� ��Ű�� �� �ϳ��� �ٷ� ��DBMS_OUTPUT���̴�.

-- 2. ��Ű���� ���� ������ ������ ���Ǵ� ���� ���� ���ν����� �Լ���
--    �ϳ��� ��Ű���� ����� ���������ν� ���� ���������� ���ϰ�
--    ��ü ���α׷��� ���ȭ �� �� �ִٴ� ������ �ִ�.

-- 3. ��Ű���� ����(PACKAGE SPECIFICATION)��
--    ��ü�� (PACKAGE BODY)�� �����Ǿ� ������
--    �� �κп��� TYPE, CONSTRAINT, VARIABLE, EXCEPTION, CURSOR, SUBPROGRAM(���ν����� �Լ� ��...) �� ����ǰ�
--    ��ü�κп��� �̵��� ���� ������ �����Ѵ�.
--    �׸���, ȣ�� �Ҷ����� ����Ű����, ���ν������� ���� ������ ������ �̿��ؾ��Ѵ�.

-- �� 4,5���� ��Ʈ

-- 4. ���� �� ���� (����)             -- ���� �󺧸�
/*                                      -- ���ο� ��ü�� ��Ű������ �����ؾ��Ѵ�.
CREATE [OR REPLACE] PACKAGE ��Ű����
IS 
    �������� ����;
    Ŀ�� ����;
    ���� ����;
    �Լ� ����;
    ���ν��� ����;
        :
END ��Ű����;    
*/
--5. ���� �� ���� (��ü��)              -- ����
/*
CREATE [OR REPLACE] PACKAGE BODY ��Ű����
IS
    FUNCTION �Լ��� [(�μ�,...)]
    RETURN �ڷ���
    IS
      ���� ����;
    BEGIN
      �Լ� ��ü ���� �ڵ�;
      RETURN ��;
    END;
    
    PROCEDURE ���ν����� [(�μ�,...)]
    IS 
        ��������;
    BEGIN 
        ���ν��� ��ü ���� �ڵ�;
    END;
END ��Ű����;    
*/

-- ��Ű�� ��� �ǽ�

--�� ���� �ۼ�
CREATE OR REPLACE PACKAGE INSA_PACK
IS
    FUNCTION FN_GENDER(V_SSN VARCHAR2)
    RETURN VARCHAR2;
    
END INSA_PACK;
--==>> Package INSA_PACK��(��) �����ϵǾ����ϴ�.

--�� ��ü�� �ۼ�
CREATE OR REPLACE PACKAGE BODY INSA_PACK
IS 
    FUNCTION FN_GENDER(V_SSN VARCHAR2)              -- ���� �Լ� ���� �ϴ� �Ϳ��� CREATE OR REPLACE ���Ŷ� �Ȱ���!!
    RETURN VARCHAR2
    IS
        V_RESULT    VARCHAR2(20);
    BEGIN 
        IF (SUBSTR(V_SSN,8,1) IN ('1','3'))
            THEN V_RESULT := '����';
        ELSIF (SUBSTR(V_SSN,8,1) IN ('2','4'))    
            THEN V_RESULT := '����';
        ELSE V_RESULT := 'Ȯ�� �Ұ�';    
        END IF;
        
        RETURN V_RESULT;
    END;

END INSA_PACK;
--==>> Package Body INSA_PACK��(��) �����ϵǾ����ϴ�.























