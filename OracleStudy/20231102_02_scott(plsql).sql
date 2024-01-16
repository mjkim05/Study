
SELECT USER
FROM DUAL;
--==>> SCOTT

--���� PL/SQL ����-- 

-- 1. PL/SQL(Procedural Language extension to SQL) ��
--    ���α׷��� ����� Ư���� ������ SQL�� Ȯ���̸� 
--    ������ ���۰� ���� ������ PL/SQL�� ������ �ڵ� �ȿ� ���Եȴ�.
--    ���� PL/SQL �� ����ϸ� SQL �� �� �� ���� ������ �۾��� �����ϴ�.
--    ���⿡�� ���������� �̶�� �ܾ ������ �ǹ̴� 
--    � ���� � ������ ���� ��� �Ϸ�Ǵ���
--    �� ����� ��Ȯ�ϰ� �ڵ忡 ��� �Ѵٴ� ���� �ǹ��Ѵ�.

-- 2. PL/SQL�� ���������� ǥ���ϱ� ���� 
--    ������ ������ �� �ִ� ���, 
--    ���� ������ ������ �� �ִ� ���, 
---   �����帧�� ��Ʈ�� �� �� �ִ� ��� ���� �����Ѵ�.

-- 3. PL/SQL �� �� ������ �Ǿ� ������,
--    ���� ���� �κ�, ����κ�, ���� ó�� �κ���
--    �� �κ����� �����Ǿ� �ִ�.
--    ����, �ݵ�� ���� �κ��� �����ؾ� �ϸ�, ������ ������ ����.

-- 4. ���� �� ���� 
/*
[DECLARE]
    -- ���� (DECLARATIONS)
BEGIN 
    -- ���๮ (STATEMENTS)
    
    [EXCEPTION]
        -- ���� ó����(EXCEPTION HANDLERS)
END;        

*/


-- 5. ���� ����
/*
DECLARE
    ������ �ڷ���;
    ������ �ڷ��� := �ʱⰪ;
BEGIN
END;
*/

--�� ��(����)�� ���(�����Ͽ�) ����~!!      CHECK~!!

--�� ��DBMS_OUTPUT.PUT_LINE()�� �� ���� 
--   ȭ�鿡 ����� ����ϱ� ���� ȯ�溯�� ����
SET SERVEROUTPUT ON;
--==>> �۾��� �Ϸ�Ǿ����ϴ�.


--�� ������ ������ ���� �����ϰ� ����ϴ� ���� �ۼ�
DECLARE
    -- �����
    V1 NUMBER := 10;
    V2 VARCHAR2(30) := 'HELLO';
    V3 VARCHAR2(30) := 'Oracle';
BEGIN
    -- �����
    --System.out.println(v1)
    DBMS_OUTPUT.PUT_LINE(V1);
    DBMS_OUTPUT.PUT_LINE(V2);
    DBMS_OUTPUT.PUT_LINE(V3);
END;
--==>>
/*
10
HELLO
Oracle


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/

--�� ������ ������ ���� �����ϰ� ����ϴ� ���� �ۼ�
DECLARE
    -- ����� 
    V1  NUMBER := 10;
    V2  VARCHAR2(30) := 'HELLO';
    V3  VARCHAR2(30) := 'Oracle';
BEGIN
    -- ����� 
    -- (���� �� ó��)
    V1 := V1 + 20;          -- NUM1 = NUM1 + 20; �� NUM1 += 20; ����Ŭ�� �̷� ���� ������ �ȵ�!��
    V2 := V2 || ' ���ѿ�';
    V3 := V3 || ' World~!!';
    -- (������)
    DBMS_OUTPUT.PUT_LINE(V1);
    DBMS_OUTPUT.PUT_LINE(V2);
    DBMS_OUTPUT.PUT_LINE(V3);
END;
--==>>
/*
30
HELLO ���ѿ�
Oracle World~!!


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/


--�� IF ��(���ǹ�)
-- IF ~THEN ~ELSE ~ END IF;     

-- 1. PL/SQL �� IF ������ �ٸ� ����� IF ���ǹ��� ���� �����ϴ�.
--    ��ġ�ϴ� ���ǿ� ���� ���������� �۾��� ������ �� �ֵ��� �Ѵ�.
--    TRUE �̸� THEN�� ELSE ���̿� ������ �����ϰ� 
--    FALSE �� NULL �̸� ELSE �� END IF; ������ ������ �����ϰ� �ȴ�.

-- 2. ���� �� ����
/*
IF ���� 
   THEN ó����;
END IF;
*/

/*
IF ���� 
    THEN ó����;
ELSE 
    ó����;
END IF;
*/

/*
IF ����
    THEN ó����;
ELSIF ����
    THEN ó����;
ELSIF ����
    THEN ó����;
ELSE 
    ó����;
END IF;
*/

--�� ������ ������ ���� �����ϰ� ����ϴ� ���� �ۼ�

-- GRADE NUMBER;            -- NUMBER�� �ִ밪�� ������.
-- GRADE CHAR;              -- CHAR�� �ּҰ��� ��´�. �� �ѱ��ڸ� ��´�.
DECLARE
    GRADE CHAR;   
BEGIN
    GRADE := 'B';
    
    --DBMS_OUTPUT.PUT_LINE(GRADE);
    
    IF GRADE = 'A'
        THEN DBMS_OUTPUT.PUT_LINE('EXCELLENT');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('FAIL');
    END IF;
END;
--==>>
/*
FAIL


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.T
*/
DECLARE
    GRADE CHAR;   
BEGIN
    GRADE := 'B';
    
    --DBMS_OUTPUT.PUT_LINE(GRADE);
    
    IF GRADE = 'A'
        THEN DBMS_OUTPUT.PUT_LINE('EXCELLENT');
    ELSIF GRADE = 'B'
          THEN DBMS_OUTPUT.PUT_LINE('BEST');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('FAIL');
    END IF;
END;
--==>>
/*
BEST


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/

DECLARE
    GRADE CHAR;   
BEGIN
    GRADE := 'B';
    
    --DBMS_OUTPUT.PUT_LINE(GRADE);
    
    IF GRADE = 'A'
        THEN DBMS_OUTPUT.PUT_LINE('EXCELLENT');
    ELSIF GRADE = 'B'
          THEN DBMS_OUTPUT.PUT_LINE('BEST');
    ELSIF GRADE = 'C'
          THEN DBMS_OUTPUT.PUT_LINE('GOOD');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('FAIL');
    END IF;
END;
--==>>
/*
BEST


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/

DECLARE
    GRADE CHAR;   
BEGIN
    GRADE := 'B';
    
    --DBMS_OUTPUT.PUT_LINE(GRADE);
    
    IF GRADE = 'A'
        THEN DBMS_OUTPUT.PUT_LINE('EXCELLENT');
    ELSIF GRADE = 'B'
          THEN DBMS_OUTPUT.PUT_LINE('BEST');
    ELSIF GRADE = 'B'
          THEN DBMS_OUTPUT.PUT_LINE('GOOD');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('FAIL');
    END IF;
END;
--==>>
/*
BEST


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/

--�� CASE ��(���ǹ�)
-- CASE ~ WHEN ~ THEN ~ ELSE ~ END CASE;

-- 1. ���� �� ����
/*
CASE ����
     WHEN ��1 THEN ���๮;
     WHEN ��2 THEN ���๮;
     ELSE ���๮;
END CASE;
*/

ACCEPT NUM PROMPT '����1 ����2 �Է��ϼ���';

DECLARE
    -- ����� 
    -- (�ֿ� ���� ����)
    SEL NUMBER := &NUM;
    RESULT VARCHAR2(20) := 'Ȯ�κҰ�';
BEGIN 
    -- ����� 
    -- (�׽�Ʈ)
    --DBMS_OUTPUT.PUT_LINE('SEL :' || SEL);
    -- System.out.println("sel : " + sel);
    --DBMS_OUTPUT.PUT_LINE('RESULT : ' || RESULT);
    
    --(���� �� ó��)
    /*
    CASE SEL 
        WHEN 1 
        THEN DBMS_OUTPUT.PUT_LINE('�����Դϴ�.');
        WHEN 2 
        THEN DBMS_OUTPUT.PUT_LINE('�����Դϴ�.');
        ELSE 
            DBMS_OUTPUT.PUT_LINE('Ȯ�κҰ�');
    END CASE;
    */
    CASE SEL
        WHEN 1 THEN RESULT := '����';
        WHEN 2 THEN RESULT := '����';
        ELSE RESULT := 'Ȯ�κҰ�';
    END CASE;

    --(��� ���)
    DBMS_OUTPUT.PUT_LINE('ó������� ' || RESULT || '�Դϴ�');
END;
--==>>
/*
�����Դϴ�.


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/
--==>> 
/*
ó������� �����Դϴ�


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.

*/

--�� �ܺ� �Է� ó�� 
-- ACCEPT ���� 
-- ACCEPT ������ PROMPT '�޼���';
--> �ܺ� �����κ��� �Է� ���� �����͸� ���� ������ ������ ��
-- ��&�ܺκ����� ���·� �����ϰ� �ȴ�.

--�� ������ ���� 2���� �ܺηκ���(����ڷκ���) �Է¹޾�
--   �̵��� ���� ����� ����ϴ� PL/SQL ������ �ۼ��Ѵ�.
--   ���� ��)
--   ù��° ������ �Է��ϼ��� �� 10 
--   �ι�° ������ �Է��ϼ��� �� 20 
--   --==>> 10 + 20 = 30

ACCEPT N1 PROMPT 'ù ��° ������ �Է��ϼ���';
ACCEPT N2 PROMPT '�� ��° ������ �Է��ϼ���';

DECLARE
    -- (���� ����)
    NUM1 NUMBER := &N1;
    NUM2 NUMBER := &N2;
    NUM3 NUMBER := 0;
BEGIN
    
    NUM3 := (NUM1 + NUM2);
    --(��� ���)
    DBMS_OUTPUT.PUT_LINE(NUM1 || '+' || NUM2 || '=' || NUM3);
END;
--==>>
/*
10+80=90


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/


--�� ����ڷκ��� �Է¹��� �ݾ��� ȭ������� �����Ͽ� ����ϴ� ���α׷��� �ۼ��Ѵ�.
--   ��, �Է¿� ���� ��ȯ�ݾ��� ���ǻ� 1õ���̸� 10�� �̻� �����ϴٰ� �����Ѵ�.
/*
���� ��)
���ε� ���� �Է� �� ��ȭâ �ݾ� �Է� : 990

�Է¹��� �ݾ� �Ѿ� : 990��
ȭ����� : ����� 1, ��� 4, ���ʿ� 1, �ʿ� 4
*/

ACCEPT M1 PROMPT '�ݾ� �Է� : ';

DECLARE 
    --(���� ����)
    NUM1 NUMBER := &M1;     -- ���� ���� ����
    
    NUM2 NUMBER := 0;       -- �����
    NUM3 NUMBER := 0;       -- ���  
    NUM4 NUMBER := 0;       -- ���ʿ�
    NUM5 NUMBER := 0;       -- �ʿ� ������ ���� ����
    
BEGIN
    -- ���� �� ó�� 
    NUM2 := TRUNC(NUM1/500);
    NUM3 := TRUNC(MOD(NUM1,500)/100);
    NUM4 := TRUNC(MOD(MOD(NUM1,500),100)/50);
    NUM5 := TRUNC(MOD(MOD(MOD(NUM1,500),100),50)/10);
    
    -- ��� ���
    DBMS_OUTPUT.PUT_LINE('�ݾ� �Ѿ� : ' || NUM1);
    DBMS_OUTPUT.PUT_LINE('����� ' || NUM2 || ',' ||'���' || NUM3 || ',' || '���ʿ�' || NUM4 || ',' || '�ʿ�' || NUM5);
END;

-------------------------------------------------------------------------------------

ACCEPT INPUT PROMPT '�ݾ� �Է�';

-- �ֿ� ���� ���� :3
-- ^����^
--( '��' ) 

DECLARE
    MONEY   NUMBER := &INPUT;   -- ������ ���� �Է°��� ��Ƶ� ����
    MONEY2  NUMBER := &INPUT;   -- ��� ����� ���� �Է°��� ��Ƶ� ����
                                -- (�Ӵ� ������ ������ ó���ϴ� �������� ���� ���ϱ⶧����)
    M500    NUMBER;             -- 500��¥�� ������ ��Ƶ� ����
    M100    NUMBER;             -- 100��¥�� ������ ��Ƶ� ����
    M50     NUMBER;             -- 50��¥�� ������ ��Ƶ� ����
    M10     NUMBER;             -- 10��¥�� ������ ��Ƶ� ����
                                
BEGIN
    --�� ���� �� ó��
    -- MONEY �� 500���� ������ ���� ���ϰ� �������� ������.       �� 500���� ����
       M500 := TRUNC(MONEY / 500); 
       
    -- MONEY �� 500���� ������ ���� ������ �������� ���Ѵ�.       �� 500���� ������ Ȯ���ϰ� ���� �ݾ�
    -- �� �ݾ����� MONEY�� ����
      
       MONEY := MOD(MONEY,500);
    
    -- MONEY �� 100���� ������ ���� ���ϰ� �������� ������.       �� 100���� ����
       M100 := TRUNC(MONEY / 100);
       
    -- MONEY �� 100���� ������ ���� ������ �������� ���Ѵ�.       �� 100���� ������ Ȯ���ϰ� ���� �ݾ�
    -- �� �ݾ����� MONEY ����
       MONEY := MOD(MONEY,100);
       
    -- MONEY �� 50���� ������ ���� ���ϰ� �������� ������         �� 50���� ����
       M50 := TRUNC(MONEY/50);
       
    -- MONEY �� 50���� ������ ���� ������ �������� ���Ѵ�.        �� 50���� ������ Ȯ���ϰ� ���� �ݾ�
    -- �� �ݾ����� MONEY ����                                 
       MONEY := MOD(MONEY,50);
       
    -- MONEY �� 10���� ������ ���� ���ϰ� �������� ������.        �� 10���� ����
       M10 := TRUNC(MONEY/10);
       
    --�� ��� ���
    -- ���յ� ���(ȭ�� ������)
    DBMS_OUTPUT.PUT_LINE('�Է¹��� �ݾ� �ѿ� : ' || MONEY2 || '��');
    DBMS_OUTPUT.PUT_LINE('ȭ�� ���� : ����� '|| M500 || ', ��� ' || M100 || ', ���ʿ� ' || M50 || ', �ʿ� ' || M10);
END;
--==>>
/*
�Է¹��� �ݾ� �ѿ� : 780��
ȭ�� ���� : ����� 1, ��� 2, ���ʿ� 1, �ʿ� 3


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/


--�� �⺻ �ݺ���
-- LOOP ~ END LOOP;

--1. ���ǰ� ������� ������ �ݺ��ϴ� ����.

--2. ���� �� ����
/*
LOOP
    -- ���๮
    
    EXIT WHEN ����;    -- ������ ���� ��� �ݺ����� ����������.
    
END LOOP;

*/

--1���� 10���� �� ���(LOOP�� Ȱ��)

DECLARE
    N NUMBER;
BEGIN
    N := 1;
    
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        
        EXIT WHEN N >=10;
        
        N := N + 1;             -- N++;  N+=1;
        
    END LOOP;
END;
--==>>
/*
1
2
3
4
5
6
7
8
9
10


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/


--�� WHILE �ݺ���
-- WHILE LOOP ~ END LOOP;      

--1. ���� ������ TRUE �� ���� �Ϸ��� ������ �ݺ��ϱ� ����
--   WHILE LOOP ������ ����Ѵ�.
--   ������ �ݺ��� ���۵Ǵ� ������ üũ�ϰ� �Ǿ�
--   LOOP ���� ������ �� ���� ������� �������� �ִ�.
--   LOOP �� ������ �� ������ FALSE �̸�, �ݺ� ������ Ż���ϰ� �ȴ�.

--2. ���� �� ����
/*
WHILE ���� LOOP       -- ������ ���� ��� �ݺ� ����
    -- ���๮;
END LOOP;

*/

-- 1���� 10������ �� ���(WHILE LOOP�� Ȱ��)

DECLARE 
    N NUMBER := 1;
BEGIN 
    WHILE N <= 10 LOOP
    -- WHILE N BETWEEN 1 AND 10 LOOP            -- ��ó ������
    
        DBMS_OUTPUT.PUT_LINE(N);
        N := N +1;
        
    END LOOP;   
END;
--==>>
/*
1
2
3
4
5
6
7
8
9
10


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/

 ^----^
(������)


--�� FOR �ݺ��� 
-- FOR LOOP ~ END LOOP;

--1. �����ۼ������� 1�� �����Ͽ�
--   ������������ �� �� ���� �ݺ� �����Ѵ�.

--2. ���� �� ���� 
/*
FOR ī���� IN [REVERSE] ���ۼ�.. ������ LOOP 
    -- ���๮;
END LOOP;
*/

-- 1���� 10������ �� ���(FOR LOOP �� Ȱ��)
DECLARE
    N NUMBER;
BEGIN
    FOR N IN 1.. 10 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/*
1
2
3
4
5
6
7
8
9
10


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/

-- ����ڷκ��� ������ ��(������)�� �Է� �޾�
-- �ش� �ܼ��� �������� ����ϴ� PL/SQL ������ �ۼ��Ѵ�.
/*
���� ��
���ε� ���� �Է� ��ȭâ �� ���� �Է��ϼ��� : 2

2 * 1   = 2
2 * 2   = 4
      :
2 * 9   = 18      
*/

-- 1. LOOP�� �� ��� 
ACCEPT D PROMPT '���� �Է��ϼ��� : ';

DECLARE
    DAN NUMBER := &D;
    N NUMBER := 1;
    TOTAL NUMBER := 0;
BEGIN 
    LOOP
        TOTAL := DAN * N; 
        DBMS_OUTPUT.PUT_LINE( DAN || ' * ' || N || ' = ' || TOTAL);
        N := N+1; 
        
        EXIT WHEN N >= 10;      
    END LOOP;
END;

-- 2. WHILE LOOP ���� ���
ACCEPT D PROMPT '���� �Է��ϼ��� :';

DECLARE
    DAN NUMBER := &D;
    N NUMBER :=1;
    TOTAL NUMBER :=0;
BEGIN 
    WHILE N < 10 LOOP
        TOTAL := DAN * N;
        DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || N || ' = ' || TOTAL);
        N := N+1;    
    END LOOP;  
END;

-- 3. FOR LOOP���� ���
ACCEPT D PROMPT '���� �Է��ϼ��� : ';

DECLARE
    DAN NUMBER := &D;
    N NUMBER := 1;
    TOTAL NUMBER :=0;
BEGIN
    
    FOR N IN 1..9 LOOP
        TOTAL := DAN * N;
        DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || N || ' = ' || TOTAL); 
    END LOOP;
END;
--==>>
/*
3 * 1 = 3
3 * 2 = 6
3 * 3 = 9
3 * 4 = 12
3 * 5 = 15
3 * 6 = 18
3 * 7 = 21
3 * 8 = 24
3 * 9 = 27


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.
*/


-- ������ ��ü(2�� ~ 9��)�� ����ϴ� PL/SQL ������ �ۼ��Ѵ�.
-- �� ���� �ݺ���(�ݺ����� ��ø) ������ Ȱ���Ѵ�.
/*
���� ��
==[2��]== 
2 * 1 = 2
    :
    
==[3��]== 

3 * 1 = 3
    :

==[9��]== 

9 * 1 = 9
    :         
*/

--1. LOOP ���
DECLARE
    DAN NUMBER := 2;
    N NUMBER := 1;
BEGIN 
    LOOP 
        DBMS_OUTPUT.PUT_LINE('===['||DAN||'��'||']===');
        LOOP 
            DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || N || ' = '||(DAN*N));
            N := N + 1;
            EXIT WHEN N >= 10;
        END LOOP;  
        DBMS_OUTPUT.PUT_LINE(' ');
        N := 1;
        DAN := DAN +1;
        
        EXIT WHEN DAN >= 10;       
    END LOOP;
END;

--2. WHILE LOOP �ݺ��� 

DECLARE
    DAN NUMBER := 2;
    N NUMBER := 1;
BEGIN
    WHILE DAN < 10 LOOP
       DBMS_OUTPUT.PUT_LINE('===['||DAN||'��'||']===');
       WHILE N < 10 LOOP
         DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || N || ' = '||(DAN*N));
         N := N + 1;
       END LOOP;
       DBMS_OUTPUT.PUT_LINE(' ');
       N :=1;
       DAN := DAN +1;
    END LOOP;
END;

--3. FOR LOOP
DECLARE 
    DAN NUMBER :=2;
    N NUMBER := 1;
BEGIN 
    FOR DAN IN 2..9 LOOP
        DBMS_OUTPUT.PUT_LINE('===['||DAN||'��'||']===');
        FOR N IN 1..9 LOOP
            DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || N || ' = '||(DAN*N));
        END LOOP;
        DBMS_OUTPUT.PUT_LINE(' ');
        N :=1;
    END LOOP;
END;













