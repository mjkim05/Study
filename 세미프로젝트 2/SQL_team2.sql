SELECT USER
FROM DUAL;
--==>> TEAM2

-- 2.3
-- �ڽ��� ������ ���� ���� ������ ���������� ����Ͽ� �� �� �־�� �Ѵ�.
-- ��� ������ �����, ����Ⱓ(����, ��), �����, �л���, ���, �Ǳ�, �ʱ�, ����, ��� ���
-- ��� �л��� ������ ��� 
-- ��, �ߵ� Ż���� �ߴ��� ������ ������ ��� �ǵ��� �ؾ��Ѵ�. (���� ������ ���� Ż��)
-- �ߵ� Ż���� �л��� �ߵ� Ż������ �����ֱ�

    
CREATE OR REPLACE VIEW VIEW_PROFESSORS_SCORES
AS
SELECT TT.*
FROM
(
    SELECT T.* , T.��� + T.�Ǳ� + T.�ʱ� "����" , RANK() OVER(PARTITION BY T.����� ORDER BY (T.��� + T.�Ǳ� + T.�ʱ�) DESC) "���"
    FROM 
    (
        SELECT J.SUB_NAME "�����", O.SUB_START_DATE "�������", O.SUB_END_DATE "����", B.BK_NAME "�����", ST.ST_NAME "�л���", S.ATTENDANCE_SCORE "���", S.PRACTICAL_SCORE "�Ǳ�", S.WRITTEN_SCORE "�ʱ�"
            ,CASE WHEN D.DO_CODE IS NOT NULL THEN '�ߵ�Ż��'
                  WHEN P.END_DATE < SYSDATE THEN '����Ϸ�'
                  WHEN P.END_DATE > SYSDATE THEN '������'             
             ELSE '����'
             END "�ߵ�Ż������"
             ,PP.PF_ID  "���̵�"
        FROM SCORES S JOIN OPEN_SUBJECTS O
          ON S.OSUB_CODE = O.OSUB_CODE
             JOIN SUBJECTS J
             ON J.SUB_CODE = O.SUB_CODE
             JOIN BOOKS B
             ON B.BK_CODE = O.BK_CODE
             JOIN COURSE_REGISTRATIONS C
             ON S.REG_CODE  = C.REG_CODE
             JOIN STUDENTS ST
             ON ST.ST_CODE = C.ST_CODE
             LEFT JOIN DROP_OUT_LISTS D
             ON D.REG_CODE = C.REG_CODE
             JOIN OPEN_COURSES P
             ON P.OCRS_CODE = C.OCRS_CODE
             JOIN PROFESSORS PP
             ON PP.PF_CODE = P.PF_CODE
             
    )T
)TT;


--==>> View VIEW_STUDENTS_SCORES��(��) �����Ǿ����ϴ�.

-- 3.2
-- ������ �̹� ���� ���� ��µǰ� �ؾ��Ѵ�.
-- ��� ������ �л���, ������, �����, �����Ⱓ, �����, ���, �Ǳ�, �ʱ�, ����, ��� ���
-- ������ ���� ������ ��µǾ�� �Ѵ�.
-- �������� ������ ���� ��� ���������� ���� ������ ��� 
--  �� ���, ���

CREATE OR REPLACE VIEW VIEW_STUDENTS_SCORES
AS
SELECT TT.�л���, TT.������, TT.�����, TT.�����Ⱓ, TT.�����, TT.���, TT.�Ǳ�, TT.�ʱ�, TT.����, TT.���, TT.���̵�
FROM 
(
    SELECT T.* , T.��� + T.�Ǳ� + T.�ʱ� "����" , RANK() OVER(PARTITION BY T.����� ORDER BY (T.��� + T.�Ǳ� + T.�ʱ�) DESC) "���"
    FROM 
    (
            SELECT J.SUB_NAME "�����",CR.CRS_NAME "������", START_DATE || '~' || END_DATE "�����Ⱓ" , B.BK_NAME "�����", ST.ST_NAME "�л���", S.ATTENDANCE_SCORE "���", S.PRACTICAL_SCORE "�Ǳ�", S.WRITTEN_SCORE "�ʱ�"
                ,CASE WHEN D.DO_CODE IS NOT NULL THEN '�ߵ�Ż��'
                      WHEN P.END_DATE < SYSDATE THEN '����Ϸ�'
                      WHEN P.END_DATE > SYSDATE THEN '������'             
                 ELSE '����'
                 END "�ߵ�Ż������"
                 ,ST.ST_ID "���̵�"
            FROM SCORES S JOIN OPEN_SUBJECTS O
              ON S.OSUB_CODE = O.OSUB_CODE
                 JOIN SUBJECTS J
                 ON J.SUB_CODE = O.SUB_CODE
                 JOIN BOOKS B
                 ON B.BK_CODE = O.BK_CODE
                 JOIN COURSE_REGISTRATIONS C
                 ON S.REG_CODE  = C.REG_CODE
                 JOIN STUDENTS ST
                 ON ST.ST_CODE = C.ST_CODE
                 LEFT JOIN DROP_OUT_LISTS D
                 ON D.REG_CODE = C.REG_CODE
                 JOIN OPEN_COURSES P
                 ON P.OCRS_CODE = C.OCRS_CODE
                 JOIN COURSES CR
                 ON CR.CRS_CODE = P.CRS_CODE 
                
                 
    )T
)TT;


-- 2.3
SELECT �����, �������, ����, �����, �л���, ���, �Ǳ�, �ʱ�, ����, ���, �ߵ�Ż������
FROM VIEW_PROFESSORS_SCORES
WHERE ���̵� = 'MANGGOM';

-- 3.2
SELECT �����, �����Ⱓ, �����, �л���, ���, �Ǳ�, �ʱ�, ����, ���
FROM VIEW_STUDENTS_SCORES
WHERE ���̵� = 'OHOH';


SELECT *
FROM PROFESSORS;

SELECT *
FROM OPEN_COURSES;

SELECT *
FROM SCORES S JOIN OPEN_SUBJECTS O
  ON S.OSUB_CODE = O.OSUB_CODE
     JOIN SUBJECTS J
     ON J.SUB_CODE = O.SUB_CODE
     JOIN BOOKS B
     ON B.BK_CODE = O.BK_CODE
     JOIN COURSE_REGISTRATIONS C
     ON S.REG_CODE  = C.REG_CODE
     JOIN STUDENTS ST
     ON ST.ST_CODE = C.ST_CODE;
  

SELECT *
FROM  OPEN_SUBJECTS;

COMMIT;

