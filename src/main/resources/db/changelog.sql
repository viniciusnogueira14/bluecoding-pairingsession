-- liquibase formatted sql

-- changeset vinicius:1
-- comment: Table to store the URLs requested to be shortened.
CREATE TABLE shortener (
    ID_URL BIGINT PRIMARY KEY,
    BASE_URL VARCHAR(255) UNIQUE NOT NULL,
    SHORT_URL VARCHAR(255) UNIQUE NOT NULL,
    WEBSITE_NAME VARCHAR(100),
    URL_HITS BIGINT
);
-- rollback: DROP TABLE shortener;

-- changeset vinicius:2
-- comment: Sequence for store the incremental ID of URL Short.
CREATE SEQUENCE sq_shortener START WITH 1 INCREMENT BY 1;
-- rollback: DROP SEQUENCE sq_shortener;