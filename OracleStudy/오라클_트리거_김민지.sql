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





