SELECT USER
FROM DUAL;

DESC TBL_BOARD;
--==>> 
/*
NUM      NOT NULL NUMBER(9)      
NAME     NOT NULL VARCHAR2(30)   
PWD      NOT NULL VARCHAR2(20)   
EMAIL             VARCHAR2(50)   
SUBJECT  NOT NULL VARCHAR2(100)  
CONTENT  NOT NULL VARCHAR2(4000) 
IPADDR            VARCHAR2(20)   
HITCOUNT NOT NULL NUMBER         
CREATED  NOT NULL DATE      
*/

DECLARE
    V_NUM       NUMBER(9)       := 1;      
    V_NAME      VARCHAR2(30);
    V_PWD       VARCHAR2(20);   
    V_EMAIL     VARCHAR2(50);  
    V_SUBJECT   VARCHAR2(100); 
    V_CONTENT   VARCHAR2(4000);
    V_IPADDR    VARCHAR2(20);   
    V_HITCOUNT  NUMBER;         
    V_CREATED   DATE          := TO_DATE('2020-12-12','YYYY-MM-DD');
BEGIN
    LOOP
        EXIT WHEN V_NUM > 684;
        
        V_NUM := V_NUM +1;
        
        IF (MOD(V_NUM,5)=0) THEN
            V_PWD := 'java006$';
            V_CONTENT :='��ȭ���� ���빰 �ۼ�';
            V_IPADDR := '211.238.142.160';
            V_NAME := '��';
            V_SUBJECT := '���';
        ELSIF (MOD(V_NUM,3)=0) THEN
            V_PWD := 'java007$';
            V_CONTENT :='�����̰��� ���빰 �ۼ�';
            V_IPADDR := '211.238.142.165';
            V_NAME := '��';
            V_SUBJECT := '����';
        ELSIF (MOD(V_NUM,7)=0) THEN
            V_PWD := 'java008$';
            V_CONTENT :='�౸���� ���빰 �ۼ�';
            V_IPADDR := '211.238.142.170';
            V_NAME := 'ä';
            V_SUBJECT := '�';  
        ELSE 
            V_PWD := 'java002$';
            V_CONTENT :='��������� ���빰 �ۼ�';
            V_IPADDR := '211.238.142.175';
            V_NAME := '��';
            V_SUBJECT := '����';  
        END IF;
        
        V_NAME := V_NAME || '����' || LTRIM(TO_CHAR(V_NUM));
        V_SUBJECT := V_SUBJECT || '�� ���� �ۼ��� �Խù�' || LTRIM(TO_CHAR(V_NUM));
        
        V_CREATED := V_CREATED +1;
        
        IF (MOD(V_NUM, 2)=0) THEN 
            V_EMAIL := 'apple' || V_NUM || 'test@com';
            V_HITCOUNT := 29;
        ELSIF (MOD(V_NUM, 3)=0) THEN 
            V_EMAIL := 'test' || V_NUM || 'test@com';
            V_HITCOUNT := 34;
        ELSIF (MOD(V_NUM, 4)=0) THEN 
            V_EMAIL := 'study' || V_NUM || 'test@com';
            V_HITCOUNT := 47;
        ELSE
            V_EMAIL := 'snow' || V_NUM || 'test@com';
            V_HITCOUNT := 11;     
        END IF;
        
        INSERT INTO TBL_BOARD(NUM, NAME, PWD, EMAIL,SUBJECT,CONTENT,IPADDR,HITCOUNT,CREATED)
        VALUES (V_NUM, V_NAME, V_PWD, V_EMAIL,V_SUBJECT,V_CONTENT,V_IPADDR,V_HITCOUNT,V_CREATED);   
    END LOOP;
END;

COMMIT;
