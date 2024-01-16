SELECT USER
FROM DUAL;
--==>> TEAM2

-- 2.3
-- 자신이 강의한 과목에 대한 성적을 최종적으로 출력하여 볼 수 있어야 한다.
-- 출력 정보는 과목명, 과목기간(시작, 끝), 교재명, 학생명, 출결, 실기, 필기, 총점, 등수 출력
-- 모든 학생의 정보가 출력 
-- 단, 중도 탈락을 했더라도 수강한 과목은 출력 되도록 해야한다. (과목 끝난일 이후 탈락)
-- 중도 탈락한 학생은 중도 탈락으로 보여주기

    
CREATE OR REPLACE VIEW VIEW_PROFESSORS_SCORES
AS
SELECT TT.*
FROM
(
    SELECT T.* , T.출결 + T.실기 + T.필기 "총점" , RANK() OVER(PARTITION BY T.과목명 ORDER BY (T.출결 + T.실기 + T.필기) DESC) "등수"
    FROM 
    (
        SELECT J.SUB_NAME "과목명", O.SUB_START_DATE "과목시작", O.SUB_END_DATE "과목끝", B.BK_NAME "교재명", ST.ST_NAME "학생명", S.ATTENDANCE_SCORE "출결", S.PRACTICAL_SCORE "실기", S.WRITTEN_SCORE "필기"
            ,CASE WHEN D.DO_CODE IS NOT NULL THEN '중도탈락'
                  WHEN P.END_DATE < SYSDATE THEN '수료완료'
                  WHEN P.END_DATE > SYSDATE THEN '수료중'             
             ELSE '오류'
             END "중도탈락여부"
             ,PP.PF_ID  "아이디"
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


--==>> View VIEW_STUDENTS_SCORES이(가) 생성되었습니다.

-- 3.2
-- 수강이 이미 끝난 과목만 출력되게 해야한다.
-- 출력 정보는 학생명, 과정명, 과목명, 교육기간, 교재명, 출결, 실기, 필기, 총점, 등수 출력
-- 본인의 성적 정보만 출력되어야 한다.
-- 여러개의 과목이 끝난 경우 통합적으로 성적 정보를 출력 
--  → 평균, 등급

CREATE OR REPLACE VIEW VIEW_STUDENTS_SCORES
AS
SELECT TT.학생명, TT.과정명, TT.과목명, TT.교육기간, TT.교재명, TT.출결, TT.실기, TT.필기, TT.총점, TT.등수, TT.아이디
FROM 
(
    SELECT T.* , T.출결 + T.실기 + T.필기 "총점" , RANK() OVER(PARTITION BY T.과목명 ORDER BY (T.출결 + T.실기 + T.필기) DESC) "등수"
    FROM 
    (
            SELECT J.SUB_NAME "과목명",CR.CRS_NAME "과정명", START_DATE || '~' || END_DATE "교육기간" , B.BK_NAME "교재명", ST.ST_NAME "학생명", S.ATTENDANCE_SCORE "출결", S.PRACTICAL_SCORE "실기", S.WRITTEN_SCORE "필기"
                ,CASE WHEN D.DO_CODE IS NOT NULL THEN '중도탈락'
                      WHEN P.END_DATE < SYSDATE THEN '수료완료'
                      WHEN P.END_DATE > SYSDATE THEN '수료중'             
                 ELSE '오류'
                 END "중도탈락여부"
                 ,ST.ST_ID "아이디"
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
SELECT 과목명, 과목시작, 과목끝, 교재명, 학생명, 출결, 실기, 필기, 총점, 등수, 중도탈락여부
FROM VIEW_PROFESSORS_SCORES
WHERE 아이디 = 'MANGGOM';

-- 3.2
SELECT 과목명, 교육기간, 교재명, 학생명, 출결, 실기, 필기, 총점, 등수
FROM VIEW_STUDENTS_SCORES
WHERE 아이디 = 'OHOH';


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

