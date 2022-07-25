DROP TABLE CLIENT IF EXISTS;
CREATE TABLE CLIENT (id bigint NOT NULL auto_increment, first_name varchar(50), last_name varchar(50), birthday DATE, PRIMARY KEY (id));
INSERT INTO CLIENT(first_name, last_name, birthday) VALUES('Jorge', 'Callisya', '2018-10-20');
