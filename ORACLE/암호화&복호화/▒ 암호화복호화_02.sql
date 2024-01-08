SELECT USER
FROM DUAL;
--==>> SCOTT

-- (���� SCOTT���� ����� ����)

-- ���� ��ȣȭ �� ��ȣȭ 02 ����

--�� ��Ű�� ����(CRYPTPACK) 
CREATE OR REPLACE PACKAGE CRYPTPACK
AS

    FUNCTION ENCRYPT(STR VARCHAR2, HASH VARCHAR2)
    RETURN VARCHAR2;
    
    FUNCTION DECRYPT(XCRYPT VARCHAR2, HASH VARCHAR2)
    RETURN VARCHAR2;

END CRYPTPACK;
--==>> Package CRYPTPACK��(��) �����ϵǾ����ϴ�.

--�� ��Ű�� ��ü(CRYPTPACK)
CREATE OR REPLACE PACKAGE BODY CRYPTPACK
IS
    -- ���� ����(�Ӽ�)
    CRYPTED_STRING VARCHAR2(100);
    
    -- �Լ�(��ȣȭ)
    FUNCTION ENCRYPT(STR VARCHAR2, HASH VARCHAR2)
    RETURN VARCHAR2
    IS
        PIECES_OF_EIGHT NUMBER := ((FLOOR(LENGTH(STR)/8+.9)) * 8);
    BEGIN 
        DBMS_OBFUSCATION_TOOLKIT.DESENCRYPT
        ( INPUT_STRING      => RPAD(STR, PIECES_OF_EIGHT)
        , KEY_STRING        => RPAD(HASH,8,'#')
        , ENCRYPTED_STRING  => CRYPTED_STRING
        );
        RETURN CRYPTED_STRING;
    END;
    
    -- �Լ�(��ȣȭ)
    FUNCTION DECRYPT(XCRYPT VARCHAR2, HASH VARCHAR2)
    RETURN VARCHAR2
    IS
    BEGIN
        DBMS_OBFUSCATION_TOOLKIT.DESDECRYPT
        ( INPUT_STRING      => XCRYPT
        , KEY_STRING        => RPAD(HASH,8,'#')
        , DECRYPTED_STRING  => CRYPTED_STRING
        );
        RETURN TRIM(CRYPTED_STRING);
    END;
    
END CRYPTPACK;
--==>> Package Body CRYPTPACK��(��) �����ϵǾ����ϴ�.




