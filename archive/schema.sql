BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || skill;
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

CREATE TABLE skill (
id varchar2(255 char) not null,
the_category varchar2(255 char) not null,
domain varchar2(255 char) not null,
name_plotly varchar2(255 char),
-- experience_id number(19,0) not null,
-- focus_id number(19,0) not null,
primary key (id)
);

-- alter table skill add constraint cexp foreign key (experience_id) references datapoint;
-- alter table skill add constraint cfoc foreign key (focus_id) references datapoint;


BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || hibernate_sequence;
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;
CREATE SEQUENCE hibernate_sequence start with 1 increment by  1;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || datapoint;
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

CREATE TABLE datapoint (
datapoint_type varchar2(1 char) not null,
id number(19,0) not null,
correction double precision,
value number(1,0) not null check (value<=3 AND value>=1),
skill_id varchar2(255 char),
primary key (id)
);
ALTER TABLE datapoint add constraint cskill foreign key (skill_id) references skill


