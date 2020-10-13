-- ������� ��û�� ���� �����ؾߵ� sql��

-- ȸ������ ��û�� �����ؾߵ� sql��
INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'XX', 'XX', 'XX', 'X', XX, 'XX', 'XX', 'XX', 'XX', SYSDATE);

INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE);


-- ȸ�� ��ü ��ȸ ��û�� �����ؾߵ� sql��
SELECT * FROM MEMBER;


-- ȸ�� ���̵�� �˻� ��û�� �����ؾߵ� sql�� (��ȸ�� �ȴٸ� ������ �� ��)
SELECT * FROM MEMBER WHERE USERID = 'XXX';

SELECT * FROM MEMBER WHERE USERID = ?;


-- ȸ�� �̸����� Ű���� �˻� ��û�� �����ؾߵ� sql��
SELECT * FROM MEMBER WHERE USERNAME LIKE '%XX%';

SELECT * FROM MEMBER WHERE USERNAME LIKE %?%;

-- ȸ�� ���� ����(��й�ȣ, �̸���, ��ȭ��ȣ, �ּ�) ��û�� �����ؾߵ� sql��
UPDATE MEMBER
SET USERPWD = 'XX',
    EMAIL = 'XXX',
    PHONE = 'XXX',
    ADDRESS = 'XXX'
WHERE USERID = 'XXX';

UPDATE MEMBER
SET USERPWD = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE USERID = ?;

-- ȸ�� Ż�� ��û�� �����ؾߵ� sql��
DELETE FROM MEMBER WHERE USERID = 'xxx';

DELETE FROM MEMBER WHERE USERID = ?;



-- ����ڰ� �α��� ��û�� �����ؾߵ� sql��
SELECT USERNAME FROM MEMBER WHERE USERID = ? AND USERPWD = ?;













