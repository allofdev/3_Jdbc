-- 사용자의 요청에 따라 실행해야될 sql문

-- 회원가입 요청시 실행해야될 sql문
INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'XX', 'XX', 'XX', 'X', XX, 'XX', 'XX', 'XX', 'XX', SYSDATE);

INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE);


-- 회원 전체 조회 요청시 실행해야될 sql문
SELECT * FROM MEMBER;


-- 회원 아이디로 검색 요청시 실행해야될 sql문 (조회가 된다면 무조건 한 행)
SELECT * FROM MEMBER WHERE USERID = 'XXX';

SELECT * FROM MEMBER WHERE USERID = ?;


-- 회원 이름으로 키워드 검색 요청시 실행해야될 sql문
SELECT * FROM MEMBER WHERE USERNAME LIKE '%XX%';

SELECT * FROM MEMBER WHERE USERNAME LIKE %?%;

-- 회원 정보 변경(비밀번호, 이메일, 전화번호, 주소) 요청시 실행해야될 sql문
UPDATE MEMBER
SET USERPWD = 'XX',
    EMAIL = 'XXX',
    PHONE = 'XXX',
    ADDRESS = 'XXX'
WHERE USERID = 'XXX';

UPDATE MEMBER
SET USERPWD = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE USERID = ?;

-- 회원 탈퇴 요청시 실행해야될 sql문
DELETE FROM MEMBER WHERE USERID = 'xxx';

DELETE FROM MEMBER WHERE USERID = ?;



-- 사용자가 로그인 요청시 실행해야될 sql문
SELECT USERNAME FROM MEMBER WHERE USERID = ? AND USERPWD = ?;













