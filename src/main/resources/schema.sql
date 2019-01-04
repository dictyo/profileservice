BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || SKILL;
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
CREATE TABLE SKILL (name varchar2(255 char) not null, category varchar2(255 char) not null, domain varchar2(255 char) not null, name_plotly varchar2(255 char), primary key (name));

--BEGIN
--  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || hibernate_sequence;
--EXCEPTION
--  WHEN OTHERS THEN
--    IF SQLCODE != -2289 THEN
--      RAISE;
--    END IF;
--END;
--CREATE SEQUENCE hibernate_sequence start with 1 increment by  1;





--

--
--BEGIN
--   EXECUTE IMMEDIATE 'DROP TABLE ' || SKILL;
--EXCEPTION
--   WHEN OTHERS THEN
--      IF SQLCODE != -942 THEN
--         RAISE;
--      END IF;
--END;
--CREATE TABLE PRODUCT (
--ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
--DESCRIPTION VARCHAR2(255) DEFAULT NULL,
--IMAGE_URL VARCHAR2(255) DEFAULT NULL,
--PRICE NUMBER(19,2) DEFAULT NULL,
--PRODUCT_ID VARCHAR2(255) DEFAULT NULL,
--VERSION NUMBER(10, 0) DEFAULT NULL,
--PRIMARY KEY (ID));
--

--create
--CREATE TABLE DATAPOINT (datapoint_type varchar2(31 char) not null, id number(19,0) not null,
--  correction number(10,0), value number(10,0) not null check (value<=3 AND value>=1), primary key (id));

