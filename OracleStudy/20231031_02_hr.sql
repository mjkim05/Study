
SELECT USER
FROM DUAL;
--==>> HR

--���� �� �� �ǽ� ���� ���� ����--

-- ���� ���ϸ�
-- ��20231031_03_hr(2��_������).sql
-- ��20231031_03_hr(2��_������) �����ı�.txt

-- HR ���ý�Ű�� ERD �� �̿��� ���̺� �籸��~!!! 

-- ������... HR ���ý�Ű���� �ִ� �⺻ ���̺�(7��)
-- COUNTRIES / DEPARTMENTS / EMPLOYEES / JOBS �� / JOB_HISTORY / LOCATIONS / REGIONS
-- �� ��~~~~~~ ���� ���� �����Ѵ�.

-- ��, �����ϴ� ���̺��� �̸��� �����̺��+����ȣ��
-- COUNTRIES2 / DEPARTMENTS2 / EMPLOYEES2 / JOBS2 / JOB_HISTORY2 / LOCATIONS2 / REGIONS2

-- 1. ���� ��� ���̺���� ���� ����
-- 2. ���̺� ����(�÷��̸�, �ڷ���, DEFAULTǥ����, NOT NULL ��...)
-- 3. �������� ����(PK, U, FK, CK, ....)
-- 4. ������ �Է�



SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'JOB_HISTORY';


SELECT *
FROM JOB_HISTORY;

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'COUNTRIES';

SELECT *
FROM REGIONS;


SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'EMPLOYEES';

SELECT *
FROM JOB;

DESC JOBS;

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'JOBS';


SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'COUNTRIES';

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'LOCATIONS';



SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'EMPLOYEES';

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'DEPARTMENTS';


SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'JOB_HISTORY';


SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'REGIONS';

