DROP TABLE IF EXISTS USER;

CREATE TABLE USER (
  ID INTEGER NOT NULL,
  NAME VARCHAR(255) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  PASSWORD VARCHAR(100) NOT NULL,
  PRIMARY KEY(ID)
);
