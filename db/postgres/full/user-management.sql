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

select setval('naresh.user_seq', (select max(id)+1 from naresh.user), false);
