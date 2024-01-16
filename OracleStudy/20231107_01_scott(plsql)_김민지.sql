SELECT USER
FROM DUAL;
--==>> SCOTT


--�� TBL_��� ���̺��� �������� ����(����)�ϴ� ���ν����� �ۼ��Ѵ�.
--   ���ν����� : PRC_���_UPDATE()

/*
���� ��)
EXEC PRC_���_UPDATE(����ȣ, �����Ҽ���);
*/

--������ - (���� ������  - ������ )
-- ��ǰ ��� ���� ������Ʈ, ������ ������Ʈ , ���� ������ �ִ� �������� ������Ʈ�Ǵ� ������ �� ���� ��� ����!


CREATE OR REPLACE PROCEDURE PRC_���_UPDATE
( V_����ȣ   IN TBL_���.����ȣ%TYPE
, V_�������   IN TBL_���.������%TYPE
)
IS
        V_��ǰ�ڵ� TBL_��ǰ.��ǰ�ڵ�%TYPE;
        V_������ TBL_��ǰ.������%TYPE;
        V_������ TBL_���.������%TYPE;
        USER_DEFINE_ERROR EXCEPTION;
BEGIN
        -- ��ǰ�ڵ� ������ ����
        SELECT ��ǰ�ڵ� INTO V_��ǰ�ڵ�
        FROM TBL_���
        WHERE ����ȣ = V_����ȣ;
        
        -- ������ ������ ����        
        SELECT ������ INTO V_������
        FROM TBL_��ǰ
        WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
        
        --������ ������ ����
        SELECT ������ INTO V_������
        FROM TBL_���
        WHERE ����ȣ = V_����ȣ;
        
        -- ���� �ڵ� 1
        IF (V_������ + V_������ < V_�������)
            THEN RAISE USER_DEFINE_ERROR;
        END IF;

        -- ������ ���� UPDAET 
        UPDATE TBL_���
        SET ������ = V_�������
        WHERE ����ȣ = V_����ȣ;
        

        --������ ���� UPDATE
        UPDATE TBL_��ǰ
        SET ������ = ������ - (V_������� - V_������)
        WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;

        -- ����ó�� 2
        EXCEPTION 
            WHEN USER_DEFINE_ERROR
                THEN RAISE_APPLICATION_ERROR(-20002, '��� ����~!!!');
                ROLLBACK;
            WHEN OTHERS
                THEN ROLLBACK;
        -- Ŀ�� 
        COMMIT;
END;
--==>> Procedure PRC_���_UPDATE��(��) �����ϵǾ����ϴ�.

-- ���� ------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE PRC_���_UPDATE
(   
    --�� �Ű����� ����
  V_����ȣ    IN TBL_���.����ȣ%TYPE
, V_������    IN TBL_���.������%TYPE
)
IS 
    -- �� �ʿ��� ���� ����
    V_��ǰ�ڵ�      TBL_��ǰ.��ǰ�ڵ�%TYPE;
    V_����������  TBL_���.������%TYPE;
    V_������      TBL_��ǰ.������%TYPE;
    
    USER_DEFINE_ERROR EXCEPTION;
BEGIN
    
    --�� ������ ������ �� ��Ƴ���
    --��
    SELECT ��ǰ�ڵ�,������ INTO V_��ǰ�ڵ�, V_����������
    FROM TBL_���
    WHERE ����ȣ = V_����ȣ;
    
    --�� ��� ������࿩�� �Ǵ� �ʿ�
    --   ���� ������ ������ �� ������ ������ Ȯ��
    SELECT ������ INTO V_������
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    --�� �ľ��� �������� ���� �����ͺ��� �ǽ� ���� �Ǵ�
    --   (��������+���������� < �������������� ��Ȳ�̶��... ��������ǿ��� �߻� )
    IF (V_������+ V_���������� < V_������)
        -- THEN ��������� ���� �߻�
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    
    --�� ����� ������ üũ(UPDATE �� TBL_��� / UPDATE �� TBL_��ǰ )
    UPDATE TBL_���
    SET ������ = V_������
    WHERE ����ȣ = V_����ȣ;
    
    --��
    UPDATE TBL_��ǰ
    SET ������ = ������ + (V_���������� - V_������)
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    --�� ����ó�� 
    EXCEPTION 
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002 , '������~~!!');
            ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
      
    --�� Ŀ��
    --COMMIT;
    
END;
--==>> Procedure PRC_���_UPDATE��(��) �����ϵǾ����ϴ�.

--------------------------------------------------------------------------------

/*
1. PRC_�԰�_UPDATE (�԰����, �԰����)
2. PRC_�԰�_DELETE (�԰��ȣ)
3. PRC_���_DELETE (����ȣ)
*/

-- 1. PRC_�԰�_UPDATE (�԰����, �԰����)
CREATE OR REPLACE PROCEDURE PRC_�԰�_UPDATE
( -- �Ű����� ����
  V_�԰��ȣ    IN TBL_�԰�.�԰��ȣ%TYPE
, V_�԰����    IN TBL_�԰�.�԰����%TYPE
)
IS
    -- ���� ����� 
    V_��ǰ�ڵ� TBL_��ǰ.��ǰ�ڵ�%TYPE;
    V_�����԰���� TBL_�԰�.�԰����%TYPE;
    V_������ TBL_��ǰ.������%TYPE;
    
    -- ����ó�� ���� ����
    USER_DEFINE_ERROR EXCEPTION;
    
BEGIN   

    -- ������ ������ �� �ֱ� 
    SELECT ��ǰ�ڵ�, �԰���� INTO V_��ǰ�ڵ� , V_�����԰����
    FROM TBL_�԰�
    WHERE �԰��ȣ = V_�԰��ȣ;
    
    SELECT ������ INTO V_������
    FROM TBL_��ǰ 
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;

    IF ( V_������ + (V_�԰���� - V_�����԰����) < 0)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
       
    -- UPDATE ������ ���� �� TBL_�԰� , TBL_��ǰ
    UPDATE TBL_�԰�
    SET �԰���� = V_�԰����
    WHERE �԰��ȣ = V_�԰��ȣ;
    
    UPDATE TBL_��ǰ
    SET ������ = ������ - (V_�����԰����-V_�԰����)
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    -- ����ó��
    EXCEPTION 
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '������~~!!');
            ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
   
    -- Ŀ��
    COMMIT;
END;
--==>> Procedure PRC_�԰�_UPDATE��(��) �����ϵǾ����ϴ�.

-- 2. PRC_�԰�_DELETE (�԰��ȣ)
CREATE OR REPLACE PROCEDURE PRC_�԰�_DELETE
(   -- �Ű����� ����
    V_�԰��ȣ IN TBL_�԰�.�԰��ȣ%TYPE
)
IS  
    -- ����� 
    -- �ʿ��� ������ ����
    V_��ǰ�ڵ� TBL_��ǰ.��ǰ�ڵ�%TYPE;
    V_�԰���� TBL_�԰�.�԰����%TYPE;
    V_������ TBL_��ǰ.������%TYPE;
    
    -- ����ó�� ���� ���� 
    USER_DEFINE_ERROR EXCEPTION; 
BEGIN 
    -- ������ ������ �� �ֱ�
    SELECT ��ǰ�ڵ�, �԰���� INTO V_��ǰ�ڵ�, V_�԰����
    FROM TBL_�԰�
    WHERE �԰��ȣ = V_�԰��ȣ;
    
    SELECT ������ INTO V_������
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    IF (V_������ - V_�԰����  < 0)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;

    -- DELETE ������ ���� �� TBL_�԰�
    DELETE 
    FROM TBL_�԰�
    WHERE �԰��ȣ = V_�԰��ȣ;
       
    -- UPDATE ������ ���� �� TBL_��ǰ
    UPDATE TBL_��ǰ
    SET ������ = ������ - V_�԰����
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    -- ����ó�� ������ ����   
    EXCEPTION 
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '������~~!!!');
            ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
    --Ŀ��
    --COMMIT;   
END;
--==>> Procedure PRC_�԰�_DELETE��(��) �����ϵǾ����ϴ�.

-- 3. PRC_���_DELETE (����ȣ)
CREATE OR REPLACE PROCEDURE PRC_���_DELETE
(   
    -- �Ű����� ����
    V_����ȣ IN TBL_���.����ȣ%TYPE
)
IS
    -- �����
    -- �ʿ��� ���� ����
    V_��ǰ�ڵ� TBL_��ǰ.��ǰ�ڵ�%TYPE;
    V_������ TBL_���.������%TYPE;
BEGIN
    
    -- ������ ������ ���� �ֱ�
    SELECT ��ǰ�ڵ�, ������ INTO V_��ǰ�ڵ� , V_������
    FROM TBL_���
    WHERE ����ȣ = V_����ȣ;

    -- DELETE ������ ���� �� TBL_��� 
    DELETE 
    FROM TBL_���
    WHERE ����ȣ = V_����ȣ;
    
    -- UPDATE ������ ���� �� TBL_��ǰ
    UPDATE TBL_��ǰ
    SET ������ = ������ + V_������
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
   
     --Ŀ��
     -- COMMIT;
END;
--==>> Procedure PRC_���_DELETE��(��) �����ϵǾ����ϴ�.








