-- =============== User Management Schema =============== 
CREATE SCHEMA IF NOT EXISTS naresh; 

DROP SEQUENCE IF EXISTS naresh.user_seq;
CREATE SEQUENCE naresh.user_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

DROP TABLE IF EXISTS naresh.user;
CREATE TABLE naresh.user
(
  id bigint NOT NULL DEFAULT nextval('naresh.user_seq'::regclass),
  first_name character varying(180) NOT NULL,
  last_name character varying(180) NOT NULL,
  email_id character varying(180) NOT NULL,
  address character varying(180),
  phone_number character varying(30),, 
  created_date timestamp with time zone,
  CONSTRAINT user_pkey PRIMARY KEY (id)
); 

DROP SEQUENCE IF EXISTS naresh.role_seq;
CREATE SEQUENCE naresh.role_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
DROP TABLE IF EXISTS naresh.role;
CREATE TABLE naresh.role
(
  id bigint NOT NULL DEFAULT nextval('naresh.role_seq'::regclass),
  name character varying(180) NOT NULL,
  description character varying(180) NOT NULL,
  created_date timestamp with time zone,
  CONSTRAINT role_pkey PRIMARY KEY (id)
); 

DROP SEQUENCE IF EXISTS naresh.user_role_map_seq;
CREATE SEQUENCE naresh.user_role_map_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

DROP TABLE IF EXISTS naresh.user_role_map;
CREATE TABLE naresh.user_role_map
(
  id bigint NOT NULL DEFAULT nextval('naresh.user_role_map_seq'::regclass),
  user_id bigint NOT NULL,
  role_id bigint NOT NULL,
  created_date timestamp with time zone,
  CONSTRAINT user_fkey FOREIGN KEY (user_id) 
  REFERENCES naresh.user (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT role_fkey FOREIGN KEY (role_id) 
  REFERENCES naresh.role (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_role_map_pkey PRIMARY KEY (id)
); 

select setval('naresh.user_seq', (select max(id)+1 from naresh.user), false);
select setval('naresh.role_seq', (select max(id)+1 from naresh.role), false);
select setval('naresh.user_role_map_seq', (select max(id)+1 from naresh.user_role_map), false);
