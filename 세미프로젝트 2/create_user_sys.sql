SELECT * FROM all_users; 	-- 모든 계정 정보 조회

CREATE USER TEAM2 IDENTIFIED BY java006$;	-- 계정 생성

GRANT CREATE SESSION TO team2;              -- 세션에 대한 권한부여

--○ 사용자 계정에 권한(롤) 부여
GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO TEAM2;
--==>> Grant을(를) 성공했습니다.

--○ 사용자 계정에 권한(롤) 부여
GRANT CREATE ANY TABLE TO TEAM2;
--==>> Grant을(를) 성공했습니다.


--○ 사용자 계정에 권한(롤) 부여
GRANT CREATE ANY VIEW TO TEAM2;
--==>> Grant을(를) 성공했습니다.


--○ TEAM2 사용자 계정의 기본 테이블스페이스를 USERS 로 지정(설정)
ALTER USER TEAM2 DEFAULT TABLESPACE USERS;
--==>> User TEAM2이(가) 변경되었습니다.

--○ TEAM2 사용자 계정의 임시 테이블스페이스를 TEMP 로 지정(설정)
ALTER USER TEAM2 TEMPORARY TABLESPACE TEMP;
--==>> User TEAM2이(가) 변경되었습니다.

--○ 각자 생성한 오라클 사용자 계정에 
--   테이블 스페이스(USER)에서 사용할 수 잇는 공간(할당량) 지정.
ALTER USER TEAM2
QUOTA UNLIMITED ON USERS;
--==>> User TEAM2이(가) 변경되었습니다.

