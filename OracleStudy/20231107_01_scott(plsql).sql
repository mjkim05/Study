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

--------------------------------------------------------------------------------

--���� CURSOR (Ŀ��) ����--  ��¦ ���� ����~.~

-- 1. ����Ŭ������ �ϳ��� ���ڵ尡 �ƴ� �������� ���ڵ�� ������ 
--    �۾� �������� SQL���� �����ϰ� �װ������� �߻��� ������ 
--    �����ϱ� ���� Ŀ��(CURSOR)�� ����ϸ�
--    Ŀ������ �Ͻ����� Ŀ���� ������� Ŀ���� �ִ�.
--    �Ͻ��� Ŀ���� ��� SQL ������ �����ϸ�
--    SQL �� ���� �� ���� �ϳ��� ��(ROW)�� ����ϰ� �ȴ�.
--    �׷��� SQL�� ������ �����(RESULT SET)�� 
--    ���� ��(ROW)���� ������ ��� 
--    Ŀ��(CURSOR)�� ��������� �����ؾ� ���� ��(ROW)�� �ٷ� �� �ִ�.

--�� Ŀ�� �̿� �� ��Ȳ (���� �� ���� ��)

SET SERVEROUTPUT ON; 
--==>> �۾��� �Ϸ�Ǿ����ϴ�. (0.039��)

DECLARE 
      V_NAME  TBL_INSA.NAME%TYPE; 
      V_TEL   TBL_INSA.TEL%TYPE;
BEGIN
    SELECT NAME , TEL INTO V_NAME, V_TEL
    FROM TBL_INSA
    WHERE NUM = 1001;
    
    DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);
    
END;
--==>> ȫ�浿 -- 011-2356-4528

DECLARE 
      V_NAME  TBL_INSA.NAME%TYPE; 
      V_TEL   TBL_INSA.TEL%TYPE;
BEGIN
    SELECT NAME , TEL INTO V_NAME, V_TEL
    FROM TBL_INSA;
    
    DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);
    
END;
--==>> �����߻� 
--     (ORA-01422: exact fetch returns more than requested number of rows)

--�� Ŀ�� �̿� �� ��Ȳ(������ ���� �� - �ݺ��� Ȱ��)
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

-- Ŀ�� ���� ����
/*
�Ϲݺ��� �� ����
���ܺ��� �� ����

������ �ڷ���
V_NUM  NUMBER;
U_ERR  EXCEPTION;
Ŀ���� CURSOR;  �� ��
*/

/*
Ŀ�� �� ����

TABLE ���̺��
INDEX �ε�����
USER ������

CURSOR Ŀ����   �� (��) �ڡڡ�

*/

--�� Ŀ�� �̿� �� ��Ȳ
DECLARE
    --�ֿ� ���� ����
    V_NAME  TBL_INSA.NAME%TYPE;
    V_TEL   TBL_INSA.TEL%TYPE;
    
    -- Ŀ�� �̿��� ���� Ŀ�� ����      CHECEK~!!
    CURSOR CUR_INSA_SELECT
    IS 
    SELECT NAME, TEL
    FROM TBL_INSA;
    
BEGIN
    -- ���� Ŀ��
    OPEN CUR_INSA_SELECT;
    
    -- Ŀ�� ���� �� (��~~!!!)����������� ������ ó��(�ݺ����� Ȱ���Ͽ� ó��) 
    LOOP
        -- �� �� �� �� �޾ƴٰ� ó���ϴ� ���� �� ��������(��������) �� ��FETCH��
        FETCH CUR_INSA_SELECT INTO V_NAME , V_TEL;
        
        -- ��������???? (EXIT WHEN )
        -- �� Ŀ������ �� �̻� �����Ͱ� ����� ������ �ʴ� ����... �� ��NOTFOUND��
        EXIT WHEN CUR_INSA_SELECT%NOTFOUND;
        
        -- ���
         DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);    
        
    END LOOP;
    
    -- Ŭ���� Ŀ��   
    -- ����Ŭ�� �������ִ� Ŀ���� Ŭ��� �Ⱦ��⵵ �Ѵ�.
    -- ���� Ŭ���� ������ ����ߴµ� ������ �� ��� Ŭ��� �ּ�ó���ϰų� ����� �ذ� �Ǳ⵵ �Ѵ�!!
    CLOSE CUR_INSA_SELECT;
END;

--------------------------------------------------------------------------------

--���� TRIGGER(Ʈ����) ����--

-- �������� �ǹ� : ��Ƽ�, �˹߽�Ű��, �߱��ϴ�, �����ϴ�.

--1. TRIGGER(Ʈ����)�� DML �۾� ��, INSERT, UPDATE, DELETE �۾��� �Ͼ �� 
--   �ڵ����� ����Ǵ�(���ߵǴ�, �˹ߵǴ�) ��ü��
--   �̿� ���� Ư¡�� �����Ͽ� DML TRIGGER ��� �θ��⵵ �Ѵ�.
--   TRIGGER �� ���Ἲ �� �ƴ϶�
--   ������ ���� �۾����� �θ� ���ȴ�.

-- �ڵ����� �Ļ��� �� �� ���� 
-- �߸��� Ʈ����� ����
-- ������ ���� ���� ���� ���� 
-- �л� �����ͺ��̽� ��� �󿡼� ���� ���Ἲ ���� ����
-- ������ ���� ��Ģ ���� ���� 
-- ������ �̺�Ʈ �α� ���� 
-- ������ ���� ���� 
-- ���� ���̺� ���� ���� ���� 
-- ���̺� �׼��� ��� ����

--2. TRIGGER Ʈ���� �������� COMMIT, ROLLBACK ���� ����� �� ����.

--3. Ư¡ �� ���� 
--   - BEFORE STATEMENT ��(�±����� �ָԸ���!) ���� ���� ���� ó�����
--   - BEFORE ROW       �� ������ �ؾ��ϴ� ��! ���̺� ������ ����� ������� �ϴ� �Ÿ� 
--   - AFTER STATEMENT  ��(����� ���! �̸� ����!) ���� ���� ���� ó�����
--   - AFTER ROW        �� ���Ŀ� �ؾ��ϴ� ��! ���̺� ������ ����� ������� �ϴ� �Ÿ� 

--4. ���� �� ���� 
/*
CREATE [OR REPLACE] TRIGGER Ʈ���Ÿ� 
    [BEFORE | AFTER]
    �̺�Ʈ 1 [OR �̺�Ʈ2[OR �̺�Ʈ3]] ON ���̺��
    [FOR EACH ROW [WHEN TRIGGER ����]]
    (���� ������ ��) (ROW Ʈ���� ���� ���! STATEMENT Ʈ���Ŵ� ����!)
[DECLARE]
    -- ���� ����;
BEGIN
    -- ���� ����;
END;
*/

--���� AFTER STATEMENT TRIGGER ��Ȳ �ǽ� ����-- 
-- �� DML �۾��� ���� �̺�Ʈ ��� (���� ��� �̸� ����~ �Ѥ�^)

--�� TRIGGER(Ʈ����) ����

CREATE OR REPLACE TRIGGER TRG_EVENTLOG
        AFTER 
        INSERT OR UPDATE OR DELETE ON TBL_TEST1
BEGIN
    -- �̺�Ʈ ���� ���� (���ǹ��� ���� �б�)
    IF (INSERTING)  -- ING �� ��� ��
        THEN INSERT INTO TBL_EVENTLOG(MEMO)
            VALUES('INSERT ������ ����Ǿ����ϴ�.');
    ELSIF (UPDATING)
        THEN INSERT INTO TBL_EVENTLOG(MEMO)
            VALUES('UPDATE ������ ����Ǿ����ϴ�.');
    ELSIF (DELETING)
        THEN INSERT INTO TBL_EVENTLOG(MEMO)
            VALUES('DELETE ������ ����Ǿ����ϴ�.');
    END IF;
    
    -- COMMIT;
    -- �� TRIGGER �������� COMMIT / ROLLBACK ���� ��� �Ұ�~~!! CHECK~~!!
END;
--==>> Trigger TRG_EVENTLOG��(��) �����ϵǾ����ϴ�.

--���� BEFORE STATEMENT TRIGGER ��Ȳ �ǽ� ����--
-- �� DML �۾� ���� ���� �۾��� ���� ���ɿ��� Ȯ�� 

--�� TRIGGER(Ʈ����) ���� �� TRG_TEST1_DML
CREATE OR REPLACE TRIGGER TRG_TEST1_DML
        BEFORE 
        INSERT OR UPDATE OR DELETE ON TBL_TEST1
BEGIN
    IF (�۾��ð��� ���� 9�� �����̰ų�... ���� 6�� ���Ķ��...)
        THEN �۾��� �������� ���ϵ��� ó���ϰڴ�.
    END IF;
END;

CREATE OR REPLACE TRIGGER TRG_TEST1_DML
        BEFORE 
        INSERT OR UPDATE OR DELETE ON TBL_TEST1
BEGIN
    IF ( TO_NUMBER(TO_CHAR(SYSDATE,'HH24')) < 9 OR TO_NUMBER(TO_CHAR(SYSDATE,'HH24')) > 17 )    -- �ð���� �Ű澲��!
        THEN RAISE_APPLICATION_ERROR(-20003 , '�۾��ð��� 09:00 ~ 18:00 ������ �����մϴ�.');
    END IF;
END;

--==>> Trigger TRG_TEST1_DML��(��) �����ϵǾ����ϴ�.

--���� BEFORE ROW TRIGGER ��Ȳ �ǽ� ����--
-- �� ���� ���谡 ������ ������(�ڽ�) ������ ���� �����ϴ� ��

--�� TRIGGER(Ʈ����) ���� �� TRG_TEST2_DELETE

CREATE OR REPLACE TRIGGER TRG_TEST2_DELETE
        BEFORE 
        DELETE ON TBL_TEST2
        FOR EACH ROW                    -- CHECK~~!!
BEGIN 
    DELETE 
    FROM TBL_TEST3 
    WHERE CODE = :OLD.CODE;
END;
--==>> Trigger TRG_TEST2_DELETE��(��) �����ϵǾ����ϴ�.

--�� ��:OLD��
--    ���� �� ���� ��
--    - INSERT : �Է��ϱ� ���� �ڷ� ��, �Է��� �ڷ�
--    - DELETE : �����ϱ� ���� �ڷ� ��, ������ �ڷ�

--�� UPDATE 
--   ���������� DELETE �׸��� INSERT �� ���յ� ����
--   UPDATE �ϱ� ���� �����ʹ� ��:OLD��
--   UPDATE ������ ������ �����ʹ� ��:NEW��


--���� AFTER ROW TRIGGER ��Ȳ �ǽ� ����--
-- �� ���� ���̺� ���� Ʈ����� ó��
-- �ϳ��� ������ ���� ���ڵ��� ������ ��ġ�� ���� �ַ� ROW Ʈ���� ���

CREATE OR REPLACE TRIGGER TRG_IBGO
        AFTER 
        INSERT ON TBL_�԰�
        FOR EACH ROW
BEGIN
    IF (INSERTING)
        THEN UPDATE TBL_��ǰ 
             SET ������ = ������ + �����԰�Ǵ¼���
             WHERE ��ǰ�ڵ� = �����԰�Ǵ»�ǰ�ڵ�;
             
    END IF;
END;
        

CREATE OR REPLACE TRIGGER TRG_IBGO
        AFTER 
        INSERT ON TBL_�԰�
        FOR EACH ROW
BEGIN
    IF (INSERTING)
        THEN UPDATE TBL_��ǰ 
             SET ������ = ������ + :NEW.�԰����
             WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
             
    END IF;
END;
--==>> Trigger TRG_IBGO��(��) �����ϵǾ����ϴ�.      
        

--�� TBL_�԰� ���̺��� �Է�, ����, ���� �� 
--   TBL_��ǰ���̺��� ��� ���� Ʈ���� �ۼ�
--   Ʈ���Ÿ� : TRG_IBGO 

CREATE OR REPLACE TRIGGER TRG_IBGO
        AFTER
        INSERT OR UPDATE OR DELETE ON TBL_�԰�
        FOR EACH ROW
BEGIN  
    IF (INSERTING)
        THEN UPDATE TBL_��ǰ
             SET ������ = ������ + :NEW.�԰����
             WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
    ELSIF (UPDATING)
        THEN UPDATE TBL_��ǰ
             SET ������ = ������ - :OLD.�԰���� + :NEW.�԰����
             WHERE ��ǰ�ڵ� = :OLD.��ǰ�ڵ�;       
    ELSIF (DELETING)
        THEN UPDATE TBL_��ǰ
             SET ������ = ������ - :OLD.�԰����
             WHERE ��ǰ�ڵ� = :OLD.��ǰ�ڵ�;
    END IF;
END;
--==>> Trigger TRG_IBGO��(��) �����ϵǾ����ϴ�.



SELECT *
FROM TAB;







