DROP TABLE IF EXISTS USER;

CREATE TABLE USER (
  ID INTEGER NOT NULL,
  NAME VARCHAR(255) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  PASSWORD VARCHAR(100) NOT NULL,
  PRIMARY KEY(ID)
);

INSERT INTO USER(ID, NAME, EMAIL, PASSWORD) VALUES(1, 'Sam', 'sam@mail.com', 'sampass');
INSERT INTO USER(ID, NAME, EMAIL, PASSWORD) VALUES(2, 'Ann', 'ann@mail.com', 'annpass');
INSERT INTO USER(ID, NAME, EMAIL, PASSWORD) VALUES(3, 'Fill', 'fill@mail.com', 'fillpass');
INSERT INTO USER(ID, NAME, EMAIL, PASSWORD) VALUES(4, 'Beatrice', 'beatrice@mail.com', 'beatricepass');
INSERT INTO USER(ID, NAME, EMAIL, PASSWORD) VALUES(5, 'Kyle', 'kyle@mail.com', 'kylepass');
INSERT INTO USER(ID, NAME, EMAIL, PASSWORD) VALUES(6, 'Nicole', 'nicole@mail.com', 'nicolepass');
INSERT INTO USER(ID, NAME, EMAIL, PASSWORD) VALUES(7, 'Bob', 'bob@mail.com', 'bobpass');
INSERT INTO USER(ID, NAME, EMAIL, PASSWORD) VALUES(8, 'Alice', 'alice@mail.com', 'alicepass');
