DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    USERNO NUMBER PRIMARY KEY,
    USERID VARCHAR2(15) NOT NULL UNIQUE,
    USERPWD VARCHAR2(20) NOT NULL,
    USERNAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(1) CHECK(GENDER IN ('M', 'F')),
    AGE NUMBER,
    EMAIL VARCHAR2(30),
    PHONE CHAR(11),
    ADDRESS VARCHAR2(100),
    HOBBY VARCHAR2(50),
    ENROLLDATE DATE DEFAULT SYSDATE NOT NULL
);

SELECT * FROM MEMBER;

DROP SEQUENCE SEQ_USERNO;
CREATE SEQUENCE SEQ_USERNO
NOCACHE;

INSERT INTO MEMBER 
VALUES(SEQ_USERNO.NEXTVAL, 'admin', '1234', '관리자', 'M', 45,
        'admin@naver.com', '01012341111', '서울시 양천구', '잠자기', '2020/06/20');


INSERT INTO MEMBER
VALUES(SEQ_USERNO.NEXTVAL, 'user01', 'pass01', '홍길동', 'M', 23,
       NULL, 01011112222, NULL, '영화보기', '2020/07/01' );

SELECT * FROM MEMBER ORDER BY USERNO;
COMMIT;


