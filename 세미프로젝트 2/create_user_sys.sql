SELECT * FROM all_users; 	-- ��� ���� ���� ��ȸ

CREATE USER TEAM2 IDENTIFIED BY java006$;	-- ���� ����

GRANT CREATE SESSION TO team2;              -- ���ǿ� ���� ���Ѻο�

--�� ����� ������ ����(��) �ο�
GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO TEAM2;
--==>> Grant��(��) �����߽��ϴ�.

--�� ����� ������ ����(��) �ο�
GRANT CREATE ANY TABLE TO TEAM2;
--==>> Grant��(��) �����߽��ϴ�.


--�� ����� ������ ����(��) �ο�
GRANT CREATE ANY VIEW TO TEAM2;
--==>> Grant��(��) �����߽��ϴ�.


--�� TEAM2 ����� ������ �⺻ ���̺����̽��� USERS �� ����(����)
ALTER USER TEAM2 DEFAULT TABLESPACE USERS;
--==>> User TEAM2��(��) ����Ǿ����ϴ�.

--�� TEAM2 ����� ������ �ӽ� ���̺����̽��� TEMP �� ����(����)
ALTER USER TEAM2 TEMPORARY TABLESPACE TEMP;
--==>> User TEAM2��(��) ����Ǿ����ϴ�.

--�� ���� ������ ����Ŭ ����� ������ 
--   ���̺� �����̽�(USER)���� ����� �� �մ� ����(�Ҵ緮) ����.
ALTER USER TEAM2
QUOTA UNLIMITED ON USERS;
--==>> User TEAM2��(��) ����Ǿ����ϴ�.

