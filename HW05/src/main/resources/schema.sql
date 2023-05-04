DROP TABLE IF EXISTS BOOKS;
DROP TABLE IF EXISTS AUTHORS;
DROP TABLE IF EXISTS STYLES;

CREATE TABLE AUTHORS
(
    ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(255)
);

CREATE TABLE STYLES
(
    ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(255)
);

CREATE TABLE BOOKS
(
    ID        BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME      VARCHAR(255),
    ID_AUTHOR BIGINT,
    ID_STYLE  BIGINT,
    FOREIGN KEY (ID_AUTHOR) REFERENCES AUTHORS (ID) ON DELETE SET NULL,
    FOREIGN KEY (ID_STYLE) REFERENCES STYLES (ID) ON DELETE SET NULL
);

-- DROP TABLE IF EXISTS TMP_ONE;
-- DROP TABLE IF EXISTS TMP_TWO;
--
-- CREATE TABLE TMP_ONE
-- (
--     ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
--     NAME VARCHAR(255)
-- );
--
-- CREATE TABLE TMP_TWO
-- (
--     ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
--     ID_TMP_ONE BIGINT,
--     NAME VARCHAR(255),
--     FOREIGN KEY (ID_TMP_ONE) REFERENCES TMP_ONE (ID) ON DELETE SET NULL
-- );