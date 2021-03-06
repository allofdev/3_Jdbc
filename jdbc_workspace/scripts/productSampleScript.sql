CREATE TABLE PRODUCT(
    PRODUCT_ID VARCHAR2(20) CONSTRAINT PRODUCT_ID_PK PRIMARY KEY,
    P_NAME VARCHAR2(20) CONSTRAINT PRODUCT_P_NAME_NN NOT NULL,
    PRICE NUMBER CONSTRAINT PRODUCT_PRICE_NN NOT NULL,
    DESCRIPTION VARCHAR2(20),
    STOCK NUMBER CONSTRAINT PRODUCT_STOCK_NN NOT NULL
);

COMMENT ON COLUMN PRODUCT.PRODUCT_ID IS '상품아이디';
COMMENT ON COLUMN PRODUCT.P_NAME IS '상품명';
COMMENT ON COLUMN PRODUCT.PRICE IS '상품가격';
COMMENT ON COLUMN PRODUCT.DESCRIPTION IS '상품상세정보';
COMMENT ON COLUMN PRODUCT.STOCK IS '재고';

